package com.anywide.shop.compensator;

import com.anywide.dawdler.core.annotation.Service;
import com.anywide.dawdler.distributed.transaction.compensate.process.DistributedTransactionCustomProcessor;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.shop.order.service.OrderService;

public class OrderCompensator extends DistributedTransactionCustomProcessor {

	@Service
	OrderService orderService;
	public OrderCompensator() {
		super("order");
	}

	@Override
	public boolean process(DistributedTransactionContext context, String status) {
		return orderService.updateStatusOrder(context, status);
	}

}
