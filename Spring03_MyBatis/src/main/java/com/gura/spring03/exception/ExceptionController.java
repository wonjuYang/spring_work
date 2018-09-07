package com.gura.spring03.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * 
 * 예외 처리하는 컨트롤러
 * 
 * 1. @ControllerAdvice 어노테이션을 붙이고
 * 2. component scan을 해서 bean 으로 만들고
 * 3. @ExceptionHandler(예외 type)을 메소드에 붙여준다.
 * 
 */

//스프링 프레임워크가 발생시키는 exception이나 우리가 직접 핸들링 하고 싶을 때 쓰는 곳
@ControllerAdvice
public class ExceptionController {
	// ForbiddenException type 오류 가 발생했을 때 
	@ExceptionHandler(ForbiddenException.class)
	public ModelAndView error403(ForbiddenException fe) {
		ModelAndView mView=new ModelAndView();
		
		mView.setViewName("error/403");
		return mView;
	}
	
	@ExceptionHandler(NodeliveryException.class)
	public ModelAndView errorNodelivery(NodeliveryException ne) {
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg", ne.getMessage());
		mView.setViewName("error/data_access");
		return mView;
	}
	
	/*
	 * @Repository 어노ㅔ이션이 붙어 있는 Dao 에서 DB 관련 
	 * Exception이 발생하면 스프링으 DataAccessException으로 바꿔서 발생 시킨다.
	 * 
	 * 
	 */
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView errorDataAccess(DataAccessException dae) {
		ModelAndView mView= new ModelAndView();
		//예외 객체를 request에 담기
		
		mView.addObject("msg", dae.getMessage());
		
		mView.setViewName("error/data_access");
		return mView;
		
	}
}
