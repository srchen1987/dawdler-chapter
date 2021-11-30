package com.anywide.yyg.user.service.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.anywide.dawdler.conf.annotation.FieldConfig;
import com.anywide.dawdler.serverplug.db.annotation.DBTransaction;
import com.anywide.dawdler.serverplug.db.transaction.LocalConnectionFactory;
import com.anywide.dawdler.serverplug.load.bean.Page;
import com.anywide.yyg.user.dao.UserDAO;
import com.anywide.yyg.user.entity.User;
import com.anywide.yyg.user.mapper.UserMapper;
import com.anywide.yyg.user.service.UserService;

/**
 * 
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author jackson.song
 * @date 2020年12月16日
 *
 */
public class UserServiceImpl implements UserService {
	@Resource
	UserDAO userDao;

	@Resource
	UserMapper userMapper;

	@FieldConfig(path = "mypath", value = "name")
	private String name;

	@Override
	@DBTransaction
	public int addUser(User user) throws Exception {
		return userDao.insertUser(user);
	}

	@Override
	@DBTransaction
	public Map<String, Object> selectUserList(int pageOn, int row) throws Exception {
		Map<String, Object> result = new HashMap<>();
		Connection con = LocalConnectionFactory.getReadConnection();
		System.out.println("connection :");
		System.out.println(con);
		Page page = new Page(pageOn, row);
		System.out.println("name:" + name);
//		List<User> list = userDao.selectUserList(pageOn, row, page);
		List<User> list = userMapper.selectUserList();
		result.put("page", page);
		result.put("userList", list);
		return result;
	}

}
