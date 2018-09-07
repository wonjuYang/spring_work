package com.gura.spring03.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;

/*
 * 회원 정보에 관련된 비즈니스 로직을 수행하는 서비스
 * 
 */
@Service
public class MemberServiceImpl implements MemberService {

	//의존 객체 주입
	@Autowired
	private MemberDao dao;
	
	@Override
	public void list(ModelAndView mView) {
		//Dao객체를 사용해서 회원 목록을 얻어옥
		List<MemberDto> list=dao.getList();
		//인자로 전달된 ModelAndview 객체에담는다
		mView.addObject("list", list);
		
	}

	@Override
	public void insert(MemberDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
		
	}

	@Override
	public void getData(ModelAndView mView, int num) {
		MemberDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		
	}
	
	
	
}
