package com.anywide.shop.compensator;

import com.anywide.dawdler.core.annotation.Service;
import com.anywide.dawdler.distributed.transaction.compensate.process.DistributedTransactionCustomProcessor;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.shop.user.service.UserService;

public class UserCompensator extends DistributedTransactionCustomProcessor {
	@Service
	UserService userService;
	public UserCompensator() {
		super("user");
	}

	@Override
	public boolean process(DistributedTransactionContext context, String status) {
		return userService.doPayment(context, status);
	}

}
