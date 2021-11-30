package com.anywide.yyg.user.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anywide.dawdler.clientplug.annotation.RequestBody;
import com.anywide.dawdler.clientplug.annotation.RequestMapping;
import com.anywide.dawdler.clientplug.annotation.RequestMapping.ViewType;
import com.anywide.dawdler.clientplug.annotation.RequestParam;
import com.anywide.dawdler.clientplug.annotation.ResponseBody;
import com.anywide.dawdler.clientplug.web.TransactionController;
import com.anywide.dawdler.conf.annotation.FieldConfig;
import com.anywide.dawdler.core.annotation.Service;
import com.anywide.yyg.user.entity.User;
import com.anywide.yyg.user.service.UserService;

@RequestMapping(value="/user")
public class UserController extends TransactionController{
	@Service
	UserService userService;
	@FieldConfig(path="mypath",value = "name")
	private String name;
	/**
	 * 
	* <p>Title: list</p> 
	* @author jackson.song 
	* @return void
	* <p>Description:查看用户列表 </p>  
	 * @throws Exception 
	 
	*
	 */
	@RequestMapping(value="/list.html" ,viewType=ViewType.json)
	public void list(HttpServletRequest request, HttpServletResponse response, @RequestParam String path) throws Exception{
		System.out.println("request:"+request);
		System.out.println("response:"+response);
		System.out.println("path:"+path);
		System.out.println("name:"+name);
		if("error".equals(path)) {
			throw new NullPointerException(" my exception ... null");
		}
		// 获取参数
		int pageOn = paramInt("pageOn",1);
		int row = paramInt("row",10);
		if(row > 50) 
			row = 50;
		// 设置查询条件
		Map<String,Object> searchMap=new HashMap<String,Object>();
		searchMap.put("pageOn", pageOn);
		searchMap.put("row", row);
		Map<String, Object> result = userService.selectUserList(pageOn, row);
		setData(result);
		System.out.println("result\t"+result);
		setTemplatePath("user/list.html");
	}
	
	
	@RequestMapping(value="/json.html" ,viewType=ViewType.json)
	public void json(@RequestBody User user){
		System.out.println("user username:"+user.getUsername());
		System.out.println("user age:"+user.getAge());
		Map<String, Object> result =new HashMap<String, Object>();
		result.put("user", "hello");
		setData(result);
	}
	
	
	@RequestMapping(value="/responseBody.html")
	@ResponseBody
	public Object responseBody() throws Exception{
		return "hello";
	}
	
	
}
