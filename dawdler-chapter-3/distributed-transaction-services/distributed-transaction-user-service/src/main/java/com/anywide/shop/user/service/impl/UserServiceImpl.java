package com.anywide.shop.user.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.anywide.dawdler.core.rpc.context.RpcContext;
import com.anywide.dawdler.distributed.transaction.TransactionStatus;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.dawdler.serverplug.db.annotation.DBTransaction;
import com.anywide.shop.user.entity.GoldInfo;
import com.anywide.shop.user.entity.User;
import com.anywide.shop.user.mapper.GoldInfoMapper;
import com.anywide.shop.user.mapper.UserMapper;
import com.anywide.shop.user.service.UserService;

public class UserServiceImpl implements UserService{
	@Resource
	UserMapper userMapper;
	
	@Resource
	GoldInfoMapper goldInfoMapper;
	
	@Override
	@DBTransaction
	public Map<String, Object> tryPayment(Integer userId, BigDecimal amount) {
		Map<String, Object> resultMap = new HashMap<>();
		User user = new User();
		user.setUserId(userId);
		user.setGold(amount);
		int update = userMapper.deductGoldByUserId(user);
		if(update == 0) {
			resultMap.put("success", false);
			resultMap.put("msg", "余额不足!");
			return resultMap;
		}
		DistributedTransactionContext context = (DistributedTransactionContext) RpcContext.getContext().getAttachment(DistributedTransactionContext.DISTRIBUTED_TRANSACTION_CONTEXT_KEY);
		GoldInfo goldInfo = new GoldInfo();
		goldInfo.setAddtime((int)(System.currentTimeMillis()/1000));
		goldInfo.setAmount(amount);
		goldInfo.setStatus(context.getStatus());
		goldInfo.setBranchTxId(context.getBranchTxId());
		goldInfo.setGlobalTxId(context.getGlobalTxId());
		goldInfo.setUserId(userId);
		goldInfoMapper.insertSelective(goldInfo);
		resultMap.put("success", true);
		return resultMap;
	}

	@Override
	@DBTransaction
	public boolean doPayment(DistributedTransactionContext context, String status) {
		System.out.println("context.getDatas():"+context.getDatas());
		int userId = (Integer)context.getDatas().get("userId");
		GoldInfo goldInfo = new GoldInfo();
		goldInfo.setBranchTxId(context.getBranchTxId());
		goldInfo.setUserId(userId);
		goldInfo.setStatus(status);
		if(TransactionStatus.CONFIRM.equals(status)) {
			goldInfoMapper.confirmByBranchTxId(goldInfo);
			return true;
		}else if(TransactionStatus.CANCEL.equals(status)) {
			int update = goldInfoMapper.cancelByBranchTxId(goldInfo);
			if(update == 0)return true;
			BigDecimal amount = (BigDecimal) context.getDatas().get("amount");
			User user = new User();
			user.setUserId(userId);
			user.setGold(amount);
			return userMapper.addGoldByUserId(user)>0;
		}else {
			return false;
		}
	}

}
