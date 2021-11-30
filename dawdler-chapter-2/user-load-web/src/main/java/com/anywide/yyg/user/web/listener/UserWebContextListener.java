package com.anywide.yyg.user.web.listener;

import javax.servlet.ServletContext;

import com.anywide.dawdler.clientplug.web.listener.WebContextListener;
import com.anywide.dawdler.core.annotation.Order;

@Order(2)
public class UserWebContextListener implements WebContextListener {

	@Override
	public void contextInitialized(ServletContext servletContext) {
		System.out.println(this.getClass().getSimpleName() + "  contextInitialized " + servletContext.getRealPath(""));
	}

	@Override
	public void contextDestroyed(ServletContext servletContext) {
		System.out.println(this.getClass().getSimpleName() + " contextDestroyed " + servletContext.getRealPath(""));
	}

}
