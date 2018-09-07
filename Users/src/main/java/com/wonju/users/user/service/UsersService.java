package com.wonju.users.user.service;

import org.springframework.web.servlet.ModelAndView;


import com.wonju.users.user.dto.UsersDto;

public interface UsersService {

	public void insert(UsersDto dto);
	public boolean isValid(UsersDto dto);
	public void update(UsersDto dto);
	public void delete(int num);
	public void getData(ModelAndView mView, int num);
}
