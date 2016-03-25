package com.school.vo;

import java.io.Serializable;

public class Status implements Serializable {
	private String statuscd;

	public String getStatuscd() {
		return statuscd;
	}

	public void setStatuscd(String statuscd) {
		this.statuscd = statuscd;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	private String errorCode;
	private String errorDesc;
}
