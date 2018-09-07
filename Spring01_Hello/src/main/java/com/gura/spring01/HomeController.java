package com.gura.spring01;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
/*
 * extends action 대신 
 */
public class HomeController {
	/*
	 * 
	 * Userfactory 에서 했었던 if~else~ 대신
	 */
	@RequestMapping("/home") //.do 생략 가능
	public String gura(HttpServletRequest request) {
		
		List<String> news=new ArrayList<>();
		news.add("안녕하세요");
		news.add("오늘 Spring FrameWork 시작입니다.");
		news.add("근데 왜 안되고 그러세요");
		news.add("개빢치네");
		
		//request에 담기
		request.setAttribute("news", news);
		
		
		
		/*
		 * 
		 * view page 의 정보를 문자열로 리턴하기
		 * 
		 * prefix: /WEB-INF/views/
		 * 
		 * suffix: .jsp
		 * 
		 * "WEB-INF/views/"+"home"+".jsp"
		 * 
		 * 따라서 "WEB-INF/views/home.jsp" 로 사용되어진다.
		 * 
		 * 여기에 대한 설정 정보는
		 * WEB-INF/spring/appServlet/servlet-contex.xml에 있다.
		 */
		return "home"; 
		
	}

	}
	

