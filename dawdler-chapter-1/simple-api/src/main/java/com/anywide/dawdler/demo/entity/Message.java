package com.anywide.dawdler.demo.entity;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 4726982442137628060L;
	private int id;
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
