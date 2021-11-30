package com.anywide.dawdler.demo.service;

import java.util.List;
import java.util.Map;

import com.anywide.dawdler.core.annotation.RemoteService;
import com.anywide.dawdler.core.annotation.RemoteServiceAssistant;
import com.anywide.dawdler.demo.entity.Message;
@RemoteService("simple-service")
public interface HelloService {
	
	@RemoteServiceAssistant(async = true)
	public String say(String text);
	
	public List<Message> responseList(Map<String, Object> data);
}
