package com.gura.spring03.cafe.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dao.CafeCommentDao;
import com.gura.spring03.cafe.dao.CafeDao;
import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.dto.CafeDto;
import com.gura.spring03.exception.ForbiddenException;


@Service
public class CafeServiceImpl implements CafeService{
	//한 페이지에 나타낼 로우의 갯수
		private static final int PAGE_ROW_COUNT=5;
		//하단 디스플레이 페이지 갯수
		private static final int PAGE_DISPLAY_COUNT=3;	
		
		@Autowired
		private CafeDao dao;
		
		@Autowired
		private CafeCommentDao cafeCommentDao;
		
		
		@Override
		public void getList(ModelAndView mView, int pageNum, String keyword, String condition) {
		
			
			//CafeDto 객체를 생성해서 
			CafeDto dto=new CafeDto();
			if(keyword != null) {//검색어가 전달된 경우 
				if(condition.equals("titlecontent")) {//제목+내용 검색
					dto.setTitle(keyword);
					dto.setContent(keyword);
				}else if(condition.equals("title")) {//제목 검색
					dto.setTitle(keyword);
				}else if(condition.equals("writer")) {//작성자 검색
					dto.setWriter(keyword);
				}
				//list.jsp 에서 필요한 내용 담기
				
			}
			
			//보여줄 페이지 데이터의 시작 ResultSet row 번호
			int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
			//보여줄 페이지 데이터의 끝 ResultSet row 번호
			int endRowNum=pageNum*PAGE_ROW_COUNT;
			
			//전체 row 의 갯수를 읽어온다.
			int totalRow=dao.getCount(dto);
			//전체 페이지의 갯수 구하기
			int totalPageCount=
					(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
			//시작 페이지 번호
			int startPageNum=
				1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
			//끝 페이지 번호
			int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
			//끝 페이지 번호가 잘못된 값이라면 
			if(totalPageCount < endPageNum){
				endPageNum=totalPageCount; //보정해준다. 
			}
			
			// startRowNum 과 endRowNum을 CafeDto 에 담은 다음 
			dto.setStartRowNum(startRowNum);
			dto.setEndRowNum(endRowNum);
			
			//1. CafeDto 객체를 전달해서 파일 목록을 불러온다 
			List<CafeDto> list=dao.getList(dto);
			
			mView.addObject("keyword", keyword);
			mView.addObject("condition", condition);
			mView.addObject("list",list);
			mView.addObject("pageNum", pageNum);
			mView.addObject("startPageNum", startPageNum);
			mView.addObject("endPageNum", endPageNum);
			mView.addObject("totalPageCount", totalPageCount);
					
		}

		@Override
		public void insert(HttpServletRequest request, CafeDto dto) {
			
			//세션에서 작성자 정보를 얻어온다.
			String id=(String)request.getSession().getAttribute("id"); // 작성자는 세션에서 얻어서
			//FileDto 객체에 작성자 정보를 담는다.
			dto.setWriter(id); // DB 에 저장
			
			//FileDao 객체를 이용해서 DB 에 저장하기
			dao.insert(dto);		
			
		}

		public void getData(HttpServletRequest request) {
			//1. 파라미터로 전달되는 글번호 읽어오기
			int num=Integer.parseInt(request.getParameter("num"));
			//검색과 관련된 파라미터를 읽어와 본다.
			String keyword=request.getParameter("keyword");
			String condition=request.getParameter("condition");		
			
			//CafeDto 객체를 생성해서 
			CafeDto dto=new CafeDto();
			if(keyword != null) {//검색어가 전달된 경우 
				if(condition.equals("titlecontent")) {//제목+내용 검색
					dto.setTitle(keyword);
					dto.setContent(keyword);
				}else if(condition.equals("title")) {//제목 검색
					dto.setTitle(keyword);
				}else if(condition.equals("writer")) {//작성자 검색
					dto.setWriter(keyword);
				}
				//list.jsp 에서 필요한 내용 담기
				request.setAttribute("condition", condition);
				request.setAttribute("keyword", keyword);
			}		
			//글번호도 dto 에 담는다.
			dto.setNum(num);
			
			//2. CafeDao 를 이용해서 글정보를 읽어와서
			CafeDto resultDto=dao.getData(dto);
			// 글 조회수 올리기
			dao.addViewCount(num);
		
			//3. request 에 담고
			request.setAttribute("dto", resultDto);
			//로그인 여부 확인해서  request 에 담기 
			String id=(String)request.getSession().getAttribute("id");
			boolean isLogin=false;
			if(id!=null) {
				isLogin=true;
			}
		
			// 로그인 여부 
			request.setAttribute("isLogin", isLogin);
			// 댓글 목록
			List<CafeCommentDto> commentList=
					cafeCommentDao.getList(num);
			request.setAttribute("commentList", commentList);		
		}

		@Override
		public void delete(HttpServletRequest request, int num) {
			/*
			 * 
			 * 이 요청을 한 클라이언트가 자신의 글을 지우는게 맞는지  확인하기
			 * 
			 * 
			 */
			//세션에 저장된 아이디
			String id=(String)request.getSession().getAttribute("id");
			CafeDto dto= new CafeDto();
			dto.setNum(num);
			String writer=dao.getData(dto).getWriter();

			if(!id.equals(writer) ) {
				throw new ForbiddenException();
			}
			
		
			dao.delete(num);
			
		}

		@Override
		public void update(HttpServletRequest request) {
			//수정할 글정보 얻어오기 
			int num=Integer.parseInt(request.getParameter("num"));
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			//CafeDto 에 담기
			CafeDto dto=new CafeDto();
			dto.setNum(num);
			dto.setTitle(title);
			dto.setContent(content);
			//CafeDao 를 이용해서 수정 반영
			dao.update(dto);		
		}

		@Override
		public void updateform(ModelAndView mView, HttpServletRequest request, CafeDto dto) {
			//1. 파라미터로 전달되는 수정할 글번호 읽어오기
			int num=Integer.parseInt(request.getParameter("num"));
		
			CafeDto resultDto=dao.getData(dto);
			
			mView.addObject("dto", resultDto);
			
		}

		@Override
		public void commentInsert(CafeCommentDto dto) {
			
			//저장할 댓글의 번호를 미리 얻어낸다.
			int seq=cafeCommentDao.getSequence();
			//댓글을 DB 에 저장
			dto.setNum(seq);
			//댓글의 그룹 번호를 읽어온다. ( 0 or 다른 숫자가 들어있다 )
			int comment_group=dto.getComment_group();
			if(comment_group==0) {//원글의 댓글인 경우
				dto.setComment_group(seq);
			}
			//새 댓글을 저장한다. 
			cafeCommentDao.insert(dto);		
		}

	}