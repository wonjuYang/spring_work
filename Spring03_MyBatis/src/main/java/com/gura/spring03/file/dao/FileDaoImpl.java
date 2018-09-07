package com.gura.spring03.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.gura.spring03.exception.DeleteFailException;
import com.gura.spring03.file.dto.FileDto;
/*
 * 
 * Dao는 @Repostory 어노테이션을 붙여서 만든다.
 * Dao에서는 SqlSession 객체를 이용해서 DB에 
 * SELECT INSERT UPDATE DELETE 작업을 하기 떄문에
 * SQLException이 발생할 가능성이 있는데,
 * Spring 프레임워크는 @Repository 어노테이션이 붙어있는
 * Dao에서 발생하는 SqLException을 catch 해서
 * DataAccessException type의 예외를 발생시킨다.
 * 
 * 따라서 ExceptionController 에 있는 DataAccessException을
 * 처리하는 메소드에서 해당 예외를 처리하면 된다.
 */
@Repository
public class FileDaoImpl implements FileDao{
	
	//의존객체 DI
	@Autowired
	private SqlSession session;
	
	@Override
	public void delete(int num) {
		session.delete("file.delete", num);
	}

	@Override
	public void addDownCount(int num) {
		session.update("file.addDownCount", num);
	}

	@Override
	public FileDto getData(int num) {
		
		return session.selectOne("file.getData", num);
	}

	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert", dto);
	}

	@Override
	public List<FileDto> getList(FileDto dto) {
		
		return session.selectList("file.getList", dto);
	}

	@Override
	public int getCount() {
		return session.selectOne("file.getCount");
	}

}