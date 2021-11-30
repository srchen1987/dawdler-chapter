package com.anywide.yyg.user.listener;

import com.anywide.dawdler.server.context.DawdlerContext;
import com.anywide.dawdler.server.listener.DawdlerServiceListener;

/**
 * 
 * @ClassName: UserServiceStartupListener
 * @Description: 一个监听器的展现示例
 * @author jackson.song
 *
 */
public class UserServiceStartupListener implements DawdlerServiceListener {

	@Override
	public void contextDestroyed(DawdlerContext dawdlerContext) throws Exception {
		System.out.println("UserServiceStartupListener contextDestroyed" + dawdlerContext.getDeployClassPath());
	}

	@Override
	public void contextInitialized(DawdlerContext dawdlerContext) throws Exception {
		System.out.println("UserServiceStartupListener contextInitialized" + dawdlerContext.getDeployClassPath());
	}

}
