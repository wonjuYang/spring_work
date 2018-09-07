package com.wonju.users.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.wonju.users.user.dao.UsersDao;
import com.wonju.users.user.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService{
	
	//의존 객체 주입
	@Autowired
	private UsersDao dao;

	@Override
	public void insert(UsersDto dto) {
		dao.insert(dto);
		
	}
	
	@Override
	public boolean isValid(UsersDto dto) {
		return dao.isValid(dto);
		
	}

	@Override
	public void update(UsersDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getData(ModelAndView mView, int num) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
