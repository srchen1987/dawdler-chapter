package com.anywide.yyg.user.web.listener;

import javax.servlet.ServletContext;

import com.anywide.dawdler.clientplug.web.listener.WebContextListener;
import com.anywide.dawdler.clientplug.web.validator.RuleOperatorProvider;
import com.anywide.dawdler.core.annotation.Order;
import com.anywide.yyg.user.validator.operators.RegPasswordRuleOperator;

@Order(1)
public class UserWebContextListener2 implements WebContextListener{

	@Override
	public void contextInitialized(ServletContext servletContext) {
		
		RuleOperatorProvider.registerRuleOperatorScanPackage(RegPasswordRuleOperator.class);//添加扫描验证器，扫描并添加所有同包类的规则
		/*	RegPasswordRuleOperator uo = new RegPasswordRuleOperator();
			RuleOperatorProvider.registerRuleOperator(uo);*/ //只加载指定的验证器
			RuleOperatorProvider.help();//生成文档给开发人员使用
	}

	@Override
	public void contextDestroyed(ServletContext servletContext) {
		System.out.println(this.getClass().getSimpleName()+" contextDestroyed "+servletContext.getRealPath(""));
	}

}
