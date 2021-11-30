package com.anywide.shop.order.service;

import java.math.BigDecimal;

import com.anywide.dawdler.core.annotation.RemoteService;
import com.anywide.dawdler.distributed.transaction.annotation.DistributedTransaction;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;

@RemoteService("distributed-transaction-order-service")
public interface OrderService {
	@DistributedTransaction(action = "order",sponsor = false)
	public boolean createOrder(Integer userId, Integer productId, BigDecimal amount);

	public boolean updateStatusOrder(DistributedTransactionContext context, String status);

}
