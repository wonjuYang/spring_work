package com.trpleJ.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home") //.do 생략 가능
	public String TripleJMain() {
		
		return "home";
	}
		

	}
	

