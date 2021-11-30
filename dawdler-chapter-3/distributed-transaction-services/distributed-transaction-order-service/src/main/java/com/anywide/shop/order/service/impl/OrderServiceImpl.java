package com.anywide.shop.order.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import com.anywide.dawdler.core.rpc.context.RpcContext;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.dawdler.serverplug.db.annotation.DBTransaction;
import com.anywide.shop.order.entity.Order;
import com.anywide.shop.order.mapper.OrderMapper;
import com.anywide.shop.order.service.OrderService;

public class OrderServiceImpl implements OrderService{
	@Resource
	OrderMapper orderMapper;
	
	@Override
	@DBTransaction
	public boolean createOrder(Integer userId,Integer productId, BigDecimal amount) {
		System.out.println(RpcContext.getContext().getAttachments());
		DistributedTransactionContext context = (DistributedTransactionContext) RpcContext.getContext().getAttachment(DistributedTransactionContext.DISTRIBUTED_TRANSACTION_CONTEXT_KEY);
		Order order = new Order();
		order.setAddtime((int)(System.currentTimeMillis()/1000));
		order.setAmount(amount);
		order.setProductId(productId);
		order.setStatus(context.getStatus());
		order.setBranchTxId(context.getBranchTxId());
		order.setGlobalTxId(context.getGlobalTxId());
		order.setUserId(userId);
		return orderMapper.insert(order) > 0;
	}

	@Override
	@DBTransaction
	public boolean updateStatusOrder(DistributedTransactionContext context, String status) {
		Order order = new Order();
		order.setBranchTxId(context.getBranchTxId());
		order.setUserId((Integer)context.getDatas().get("userId"));
		order.setStatus(status);
		return orderMapper.updateStatusByBranchTxIdAndUserId(order)>0;
	}
 

}
