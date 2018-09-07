package com.gura.spring02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring02.dto.MemberDto;

@Controller
public class JsonCotroller {
	@RequestMapping("/json/test01")
	@ResponseBody
	public String json01() {
		
		return "{\"msg\":\"hello~\"}";
	}
	
	@RequestMapping("/json/test02")
	@ResponseBody
	public Map<String, Object> json02(){
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("addr", "노량진");
		map.put("isMan", true);
		return map;
	}
	
	@RequestMapping("/json/test03")
	@ResponseBody
	public List<String> json03(){
		List<String> list = new ArrayList<>();
		list.add("하나");
		list.add("두울");
		list.add("세엣");
		list.add("네엣");
		return list;
		
	}
	
	
	@RequestMapping("/json/test04")
	@ResponseBody
	public List<Map<String, Object>> json04(){
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1=new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		map1.put("isMan", true);
		
		Map<String, Object> map2=new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "원숭이");
		map2.put("addr", "상도동");
		map2.put("isMan", true);
		
		Map<String, Object> map3=new HashMap<>();
		map3.put("num", 3);
		map3.put("name", "해골");
		map3.put("addr", "아현동");
		map3.put("isMan", true);
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		
		return list;
		
	}
	
	@RequestMapping("/json/test05")
	@ResponseBody
	public MemberDto json05() {
		MemberDto dto = new MemberDto(1, "김구라", "노량진");
		
		return dto;
		
	}
	
	@RequestMapping("/json/test06")
	@ResponseBody
	public List<MemberDto> json06(){
		List<MemberDto> list= new ArrayList<>();
		
		MemberDto dto1 = new MemberDto(1, "김구라", "노량진");
		MemberDto dto2 = new MemberDto(2, "해골", "행신동");
		MemberDto dto3 = new MemberDto(3, "원숭이", "상도동");
		
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		return list;
		
	}
}
