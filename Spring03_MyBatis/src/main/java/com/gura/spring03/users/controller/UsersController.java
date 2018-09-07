package com.gura.spring03.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.users.dto.UsersDto;
import com.gura.spring03.users.service.UsersService;

@Controller
public class UsersController {
   //서비스 DI
   @Autowired
   private UsersService service;
   
   //회원 가입 요청 처리
   @RequestMapping("/users/signup")
   public ModelAndView signup(@ModelAttribute UsersDto dto, ModelAndView mView) {
      //1. 서비스에 전달할 ModelAndView 객체 생성
      //ModelAndView mView=new ModelAndView();
      
      //2. 직접 인자에 ModelAndView mView를 설정해서 받아서 써도 됨. 
      //이 방법은 인자로 받을게 많으면 복잡해지므로 객체 생성하든지 받아 쓰든지 상황에 따라 알아서. 
      
      //서비스에 ModelAndView 객체와 폼 전송된 회원 가입 정보가
      //담겨있는 UsersDto 객체를 전달한다
      service.signup(mView, dto);
      //ModelAndView 객체에 담고
      mView.setViewName("users/signup");
      //리턴해준다
      return mView;
      
   }
   
   
   //회원가입 요청 처리
   @RequestMapping("/users/signup_form")
   public String signupForm() {
      return "users/signup_form";
   }
   
   
   
   //아이디 중복확인 ajax 요청에 대한 응답
   /*
    *  1. pom.xml에 jackson 라이브러리 추가
    *  2. @ResponseBody 어노테이션
    *  3. { } : Map or Dto 리턴
    *       [ ] : List 리턴
    */
   
   //ajax를 json으로 쉽게
   @RequestMapping("/users/checkid")
   @ResponseBody
   public Map<String, Object> checkid(@RequestParam String inputId){
      //서비스 객체를 이용해서 사용가능 여부를 boolean type으로 리턴받음
      boolean canUse=service.canUseId(inputId);
      //Map에 담는다
      Map<String,Object> map=new HashMap<>();
      map.put("canUse", canUse);
      // { "canUse" : true} or {"canUse":false}
      return map;
   }
   
   //로그인 폼 요청 처리
   @RequestMapping("/users/loginform")
   public String loginForm(HttpServletRequest request) {
      //로그인 후 이동할 url 주소를 읽어온다
      String url=request.getParameter("url");
      //만일 전달되지 않았으면
      if(url==null) {
         //인덱스로 이동할 수 있도록
         url=request.getContextPath()+"/";
      }
      //request에 담기
      request.setAttribute("url", url);
      return "users/loginform";
   }
   
   
   public ModelAndView loginForm2(@RequestParam String url, HttpServletRequest request) {
     
      //만일 전달되지 않았으면
      if(url==null) {
         //인덱스로 이동할 수 있도록
         url=request.getContextPath()+"/";
      }
     
      ModelAndView mView=new ModelAndView();
      mView.addObject("url", url);
      mView.setViewName("users/loginform");
      
      return mView; //View 페이지 정보
   }
   
   //로그인 요청 처리
   @RequestMapping("/users/login")
   public ModelAndView login(@ModelAttribute UsersDto dto, 
         @RequestParam String url, HttpSession session) {
      ModelAndView mView=new ModelAndView();
      //서비스를 통해서 로그인 처리를 한다
      service.login(mView, dto, session);
      
      //로그인 후 이동할 url
      mView.addObject("url", url);
      mView.setViewName("users/login");
      return mView;
   }
   
   @RequestMapping("/users/logout")
   public String logout(HttpSession session){
	   //세션 초기화
	   session.invalidate();
	   //view페이지 정보 리턴
	   return "users/logout";
   }
   
   @RequestMapping("/users/info")
   public ModelAndView authInfo(HttpServletRequest request, HttpSession session){
	   ModelAndView mView=new ModelAndView();
	   
	   service.info(mView, session);
	   
	   //view페이지의 정보를 담아서
	   mView.setViewName("users/info");
	   //ModealAndView 객체 리턴해준다d
	   
	   return mView;
   }
   
   //회원 가입 정보 수정폼 요청 처리
   @RequestMapping("/users/updateform")
   public ModelAndView authUpdateForm(HttpServletRequest request,
		   HttpSession session) {
	   //객체 생ㅅㅇ해서
	   ModelAndView mView=new ModelAndView();
	   //서비스에 인자로 전달해서 회원 정보가 담기게 하고
	   service.updateForm(mView, session);
	   //view페이지에서 회원 정보 수정 폼을 출력한다
	   mView.setViewName("users/updateform");
	   
	   return mView;
	   
	   
   }
   
   @RequestMapping("/users/update")
   public ModelAndView authUpdate(HttpServletRequest request,
		   @ModelAttribute UsersDto dto) {
	   service.update(dto);
	   //개인 정보 보기 페이지로 리다이렉트 이동

	   return new ModelAndView("redirect:/users/info.do");
   }
   
   @RequestMapping("users/pw_updateform")
   public ModelAndView authPwUpdateFOrm(HttpServletRequest request) {
	   return new ModelAndView("users/pw_updateform");
   }
   
   
   @RequestMapping("/users/pw_check")
   @ResponseBody
   public Map<String, Object> pwCheck(@RequestParam String inputPwd,
         HttpSession session){
      boolean isValid=service.isValidPwd(inputPwd, session);
      Map<String,Object> map=new HashMap<>();
      map.put("isValid", isValid);
      return map;
   }
   
   //비밀번호 수정 반영 요청 처리
   @RequestMapping("/users/pw_update")
   public ModelAndView authPwUpdate(HttpServletRequest request,
		   @RequestParam String pwd, HttpSession session) {
	   service.updatePwd(pwd, session);
	   return new ModelAndView("redirect:/users/info.do");
   }
 //회원탈퇴 요청 처리
 	@RequestMapping("/users/delete") // returun type 이 ModelAndView /auth?? / .1
 	public ModelAndView authDelete(HttpServletRequest request,
 			ModelAndView mView) { // .2
 		service.delete(mView, request.getSession()); //.2 세션을 mView 로 받지 않고 request 로 받을 수 있다.
 		//view 페이지로 이동해서 응답하기 //.3
 		mView.setViewName("users/delete");
 		return mView;
 	}
 }
 /*
 * ModelAndView - Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장
 * HttpServletRequest - 클라이언트의 요청과 관련된 정보와 동작을 가지고 있는 객체 !
 * 						(클라이언트 ip정보,쿠키,헤더,get/post로 전송한 값 가져옴)
 *
 */
   
