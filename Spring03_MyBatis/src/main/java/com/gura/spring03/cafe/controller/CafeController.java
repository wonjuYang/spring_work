package com.gura.spring03.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.dto.CafeDto;
import com.gura.spring03.cafe.service.CafeService;
import com.gura.spring03.file.dto.FileDto;


@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	//새 댓글 저장 요청처리
	@RequestMapping("/cafe/comment_insert")
	public ModelAndView authcommentInsert(@ModelAttribute CafeCommentDto dto, HttpServletRequest request) {
		
		cafeService.commentInsert(dto);
		
		
		return new ModelAndView("redirect:/cafe/detail.do?num="+dto.getRef_group());
	}
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(ModelAndView mView,
			@RequestParam(defaultValue="1") int pageNum, String keyword, String condition) {
		//pageNum 이라는 파라미터가 넘어오지 않으면 1 페이지가 된다.
		cafeService.getList(mView, pageNum, keyword, condition);
		
		mView.setViewName("cafe/list");	
		return mView;
	}
	
	@RequestMapping("/cafe/insertform")
	public ModelAndView authinsertform(HttpServletRequest request) {
		
		return new ModelAndView("cafe/insertform");
		
	}
	
	@RequestMapping("/cafe/insert")
	public ModelAndView authinsert(HttpServletRequest request,
			@ModelAttribute CafeDto dto) {
		
		cafeService.insert(request, dto);
		
		
		return new ModelAndView("redirect:/cafe/list.do");
		
	}
	
	//글 자세히 보기 요청 처리
	   @RequestMapping("/cafe/detail")
	   public ModelAndView detail(HttpServletRequest request) {
	      //서비스 객체를 이용해서 글 자세히 보기에 관련 된 
	      //Model 이 request 에 담기게 하고
	      cafeService.getData(request);
	      //view 페이지로 forward 이동해서 응답하기
	      return new ModelAndView("cafe/detail");
	   }
	
	@RequestMapping("/cafe/delete")
	public ModelAndView authDelete(HttpServletRequest request, @RequestParam int num) {
		
		cafeService.delete(request, num);
		//파일 목록 보기로 리다이렉트 이동
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	@RequestMapping("/cafe/updateform")
	public ModelAndView authupdateform( ModelAndView mView, HttpServletRequest request,@ModelAttribute CafeDto dto) {
		
		cafeService.updateform(mView, request, dto);
		
		mView.setViewName("cafe/updateform");	
		return mView;
		
		
	}
	
	@RequestMapping("/cafe/update")
	public ModelAndView authupdate(HttpServletRequest request) {
		
		cafeService.update(request);
		
		
		return new ModelAndView("redirect:/cafe/list.do");
		
	}
	
}
