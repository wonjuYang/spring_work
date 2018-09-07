package com.wonju.users.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.wonju.users.user.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	
	//의존객체 자동 주입(Dependency Injection)
	@Autowired
	private SqlSession session;
		
		
	@Override
	public boolean canUseId(String inputId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UsersDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsersDto getData(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(UsersDto dto) {
		String result = session.selectOne("users.isValid", dto);
		if(result==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean insert(UsersDto dto) {
		
		session.insert("users.insert", dto);
		
		return false;
	}

}
