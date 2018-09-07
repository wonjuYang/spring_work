package com.wonju.users.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.wonju.users.user.dto.UsersDto;
import com.wonju.users.user.service.UsersService;

@Controller
public class UsersController {
	
		//의존 객체
		@Autowired
		private UsersService uService;
		
		
		@RequestMapping("/users/login")
		public String login(@ModelAttribute UsersDto dto, HttpServletRequest request) {
			
			String id=dto.getId();
			
			
			boolean isLoginSuccess=uService.isValid(dto);
			
			if(isLoginSuccess) {
				//세션 객체를 이용해서 로그인 처리 하기 
				request.getSession().setAttribute("id", id);
			}
			
			request.setAttribute("isLoginSuccess", isLoginSuccess);
			
			return "users/login";
		}
		
		
		@RequestMapping("/users/loginform")
		public String loginForm() {
			return "users/loginform";
		}
		
		@RequestMapping("/users/signup")
		public String insert(@ModelAttribute UsersDto dto) {
			
			/*
			 * 회원 정보가 담긴 MemberDto 객체를 MemberService
			 * 객체를 이용해서 DB에 저장하기
			 * 
			 */
			uService.insert(dto);
			
			return "users/signup";
		}
		
		@RequestMapping("/users/signupform")
		public String signupForm() {
			return "users/signupform";
		}
		
		
		
		
		
		
}
