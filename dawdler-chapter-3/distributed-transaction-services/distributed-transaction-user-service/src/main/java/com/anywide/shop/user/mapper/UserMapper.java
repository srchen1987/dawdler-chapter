package com.anywide.shop.user.mapper;

import com.anywide.shop.user.entity.User;

public interface UserMapper {
	 
	int insert(User record);
 
	int insertSelective(User record);
	
	int deductGoldByUserId(User record);
	
	int addGoldByUserId(User record);
	
}