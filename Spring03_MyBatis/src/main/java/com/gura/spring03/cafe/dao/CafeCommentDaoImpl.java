package com.gura.spring03.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.cafe.dto.CafeCommentDto;

@Repository
public class CafeCommentDaoImpl implements CafeCommentDao{
	
	//의존객체 DI
	@Autowired
	private SqlSession session;
	
	@Override
	public int getSequence() {
		int num=session.selectOne("cafeComment.getSequence");
		return num;
	}

	@Override
	public boolean insert(CafeCommentDto dto) {
		session.insert("cafeComment.insert", dto);
		return false;
	}

	@Override
	public List<CafeCommentDto> getList(int ref_group) {
		return session.selectList("cafeComment.getList", ref_group);
	}

}
