package com.anywide.shop.user.service;

import java.math.BigDecimal;
import java.util.Map;

import com.anywide.dawdler.core.annotation.RemoteService;
import com.anywide.dawdler.distributed.transaction.annotation.DistributedTransaction;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;

@RemoteService("distributed-transaction-user-service")
public interface UserService {
	@DistributedTransaction(action = "user",sponsor = false)
	public Map<String, Object> tryPayment(Integer userId,BigDecimal amount);
	
	
	public boolean doPayment(DistributedTransactionContext context, String status);
	
}
