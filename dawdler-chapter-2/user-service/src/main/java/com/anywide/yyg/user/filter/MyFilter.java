package com.anywide.yyg.user.filter;

import com.anywide.dawdler.core.bean.RequestBean;
import com.anywide.dawdler.core.bean.ResponseBean;
import com.anywide.dawdler.server.filter.DawdlerFilter;
import com.anywide.dawdler.server.filter.FilterChain;

public class MyFilter implements DawdlerFilter {

	@Override
	public void doFilter(RequestBean request, ResponseBean response, FilterChain chain) throws Exception {
		chain.doFilter(request, response);
	}

}
