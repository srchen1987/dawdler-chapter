package com.anywide.yyg.user.service;

import java.util.HashMap;
import java.util.Map;

import com.anywide.dawdler.core.annotation.CircuitBreaker;
import com.anywide.dawdler.core.annotation.RemoteService;
import com.anywide.yyg.user.entity.User;

@RemoteService("user-service")
public interface UserService {
	
	int addUser(User user)throws Exception;
	
	@CircuitBreaker(fallbackMethod = "selectUserListFallback")
	Map<String, Object> selectUserList(int pageOn,int row)throws Exception;
	
	default Map<String, Object> selectUserListFallback(int pageOn,int row)throws Exception{
		Map<String, Object> result = new HashMap<>();
		return result;
	}
}
