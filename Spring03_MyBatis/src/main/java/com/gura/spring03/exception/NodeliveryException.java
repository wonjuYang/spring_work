package com.gura.spring03.exception;
/*
 * 배송이 불가능한 상황이 됐을 때 
 */

import org.springframework.dao.DataAccessException;

public class NodeliveryException extends DataAccessException{

	public NodeliveryException(String msg) {
		super(msg);
		
	}
	

}
