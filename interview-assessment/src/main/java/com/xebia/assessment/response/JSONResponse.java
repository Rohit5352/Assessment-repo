package com.xebia.assessment.response;

public class JSONResponse {

	
	private Integer status;
	
	
	private Object message;
	
	
	private Object data;
	
	public JSONResponse() {
		super();
	}

	
	public JSONResponse(Integer status, Object message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	

	public JSONResponse( Object message, Object data) {
		this.message = message;
		this.data = data;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	public Object getMessage() {
		return message;
	}

	
	public void setMessage(Object message) {
		this.message = message;
	}

	
	public Object getData() {
		return data;
	}

	
	public void setData(Object data) {
		this.data = data;
	}
	
}
