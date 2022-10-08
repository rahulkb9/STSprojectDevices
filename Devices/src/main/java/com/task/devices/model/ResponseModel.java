package com.task.devices.model;

import java.util.List;

public class ResponseModel {

	private Integer Count = 0;
//	private String status = Constants.FAIL;
	private List<Object> data;

	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseModel(Integer count, List<Object> data) {
		super();
		Count = count;
		this.data = data;
	}

	public Integer getCount() {
		return Count;
	}

	public void setCount(Integer count) {
		Count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
}
