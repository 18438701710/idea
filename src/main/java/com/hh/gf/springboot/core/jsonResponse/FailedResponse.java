package com.hh.gf.springboot.core.jsonResponse;

public class FailedResponse extends CommonResponse{
	
	public static FailedResponse create(String message){
		FailedResponse res = new FailedResponse();
		res.setStatus(CommonResponse.CODE_ERROR);
		res.setMessage(message);
		return res;
	}

	public static FailedResponse create(String message, String errorCode){
		FailedResponse res = new FailedResponse();
		res.setStatus(errorCode);
		res.setMessage(message);
		return res;
	}

	public static FailedResponse create(Object data, String message){
		FailedResponse res = new FailedResponse();
		res.setStatus(CommonResponse.CODE_ERROR);
		res.setMessage(message);
		res.setData(data);
		return res;
	}

	public static FailedResponse create(Object data, String message, String errorCode){
		FailedResponse res = new FailedResponse();
		res.setStatus(errorCode);
		res.setMessage(message);
		res.setData(data);
		return res;
	}
}
