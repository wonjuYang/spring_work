package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/fortune")
	public String showFortune(HttpServletRequest request) {
		String fortuneToday="동쪾으로 가면 귀인을만나여";
		request.setAttribute("fortuneToday", fortuneToday);
		return "fortune";
	}
	
	@RequestMapping("/person")
	public ModelAndView showPerson() {
		String personToday="나야 나";
		//request에 담을 Model과 view 페이지 정보를 가지는 객체
		ModelAndView mView=new ModelAndView();
		mView.addObject("personToday", personToday);
		mView.setViewName("person");
		
		return mView;
	}
}
