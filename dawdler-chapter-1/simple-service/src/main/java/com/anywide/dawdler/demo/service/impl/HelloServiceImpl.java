package com.anywide.dawdler.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.anywide.dawdler.demo.entity.Message;
import com.anywide.dawdler.demo.service.HelloService;
public class HelloServiceImpl implements HelloService{

	@Override
	public String say(String text) {
		System.out.println(new Date()+":"+text);
		return "hi,"+text;
	}

	@Override
	public List<Message> responseList(Map<String, Object> data) {
		System.out.println(data);
		List<Message> list = new ArrayList<>();
		Message message = new Message();
		message.setId(1);
		message.setText("text1");
		list.add(message);
		return list;
	}
}
