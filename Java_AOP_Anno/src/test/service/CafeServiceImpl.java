package test.service;

import org.springframework.stereotype.Component;

@Component
public class CafeServiceImpl implements CafeService{

	@Override
	public void insert() {
		System.out.println("새 글을 추가합니다");
		
	}

	@Override
	public void select() {
		System.out.println("글 선택");
		
	}



}
