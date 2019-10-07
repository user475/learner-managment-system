package com.jpmc.learner.models;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3359277313393003348L;

	private Integer status;
	private Boolean error;
	private String message;
	private Object object;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", error=" + error + ", message=" + message + ", object=" + object + "]";
	}
	
	

}
