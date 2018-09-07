package com.gura.spring03.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.dto.CafeDto;

public interface CafeService {
	public void getList(ModelAndView mView, int pageNum, String keyword, String condition); //ModelAndView , int pageNum를 전달받은 것
	public void insert(HttpServletRequest request, CafeDto dto);
	public void getData(HttpServletRequest request);
	public void delete(HttpServletRequest request, int num);
	public void updateform(ModelAndView mView, HttpServletRequest request, CafeDto dto);
	public void update(HttpServletRequest request);
	public void commentInsert(CafeCommentDto dto);
	
}
