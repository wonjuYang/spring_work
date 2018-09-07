package com.wonju.users.user.dao;

import com.wonju.users.user.dto.UsersDto;

public interface UsersDao {
	public boolean canUseId(String inputId);
	public boolean update(UsersDto dto);
	public boolean delete(String id);
	public UsersDto getData(String id);
	public boolean isValid(UsersDto dto);
	public boolean insert(UsersDto dto);
}
