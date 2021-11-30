package com.anywide.yyg.user.velocity.tool;

import com.anywide.dawdler.clientplug.velocity.VelocityToolBox;

public class MyTool extends VelocityToolBox {

	public MyTool(String name) {
		super(name);
	}

	public String toUpperCase(String content) {
		if (content == null)
			return null;
		return content.toUpperCase();
	}

}
