package com.anywide.shop.product.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.anywide.dawdler.core.rpc.context.RpcContext;
import com.anywide.dawdler.distributed.transaction.TransactionStatus;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.dawdler.serverplug.db.annotation.DBTransaction;
import com.anywide.shop.product.entity.Product;
import com.anywide.shop.product.entity.ProductOperateInfo;
import com.anywide.shop.product.mapper.ProductMapper;
import com.anywide.shop.product.mapper.ProductOperateInfoMapper;
import com.anywide.shop.product.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Resource
	ProductMapper productMapper;
	
	@Resource
	ProductOperateInfoMapper productOperateInfoMapper;
	
	@Override
	@DBTransaction
	public Map<String, Object> tryDeductStock(Integer productId, Integer stock) {
		Map<String, Object> resultMap = new HashMap<>();
		Product product = new Product();
		product.setProductId(productId);
		product.setStock(stock);
		int result = productMapper.deductStockByPrimaryKey(product);
		if(result == 0) {
			resultMap.put("success", false);
			resultMap.put("msg", "库存不足!");
			return resultMap;
		}
		
		DistributedTransactionContext context = (DistributedTransactionContext) RpcContext.getContext().getAttachment(DistributedTransactionContext.DISTRIBUTED_TRANSACTION_CONTEXT_KEY);
		System.out.println("context:"+context);
		ProductOperateInfo infoRecord = new ProductOperateInfo();
		infoRecord.setAddtime((int)(System.currentTimeMillis()/1000));
		infoRecord.setBranchTxId(context.getBranchTxId());
		infoRecord.setGlobalTxId(context.getGlobalTxId());
		infoRecord.setStock(stock);
		infoRecord.setProductId(productId);
		infoRecord.setStatus(context.getStatus());
		productOperateInfoMapper.insert(infoRecord);
		resultMap.put("success", true);
		return resultMap;
	}

	@Override
	@DBTransaction
	public boolean doDeductStock(DistributedTransactionContext context, String status) {
		int productId = (Integer)context.getDatas().get("productId");
		ProductOperateInfo infoRecord = new ProductOperateInfo();
		infoRecord.setBranchTxId(context.getBranchTxId());
		infoRecord.setProductId(productId);
		infoRecord.setStatus(status);
		if(TransactionStatus.CONFIRM.equals(status)) {
			productOperateInfoMapper.confirmByBranchTxId(infoRecord);
			return true;
		}else if(TransactionStatus.CANCEL.equals(status)) {
			int update = productOperateInfoMapper.cancelByBranchTxId(infoRecord);
			if(update == 0)return true;
			int stock = (Integer)context.getDatas().get("stock");
			Product product = new Product();
			product.setProductId(productId);
			product.setStock(stock);
			return productMapper.addStockByPrimaryKey(product)>0;
		}else {
			return false;
		}
	}

}
