package com.gura.spring03.shop.dto;

public class OrderDto {
	private int num;
	private String id;
	private int code;
	private String addr;
	public OrderDto(int num, String id, int code, String addr) {
		super();
		this.num = num;
		this.id = id;
		this.code = code;
		this.addr = addr;
	}
	
	public OrderDto() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
