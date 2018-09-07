package com.gura.spring03.cafe.dao;

import java.util.List;

import com.gura.spring03.cafe.dto.CafeCommentDto;

public interface CafeCommentDao {
	public int getSequence();
	public boolean insert(CafeCommentDto dto);
	public List<CafeCommentDto> getList(int ref_group);
	
	
	
}
