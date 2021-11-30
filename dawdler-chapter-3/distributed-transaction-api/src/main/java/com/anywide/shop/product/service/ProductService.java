package com.anywide.shop.product.service;

import java.util.Map;

import com.anywide.dawdler.core.annotation.RemoteService;
import com.anywide.dawdler.distributed.transaction.annotation.DistributedTransaction;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
@RemoteService("distributed-transaction-product-service")
public interface ProductService {
	@DistributedTransaction(action = "product",sponsor = false)
	public Map<String, Object> tryDeductStock(Integer productId, Integer stock);

	public boolean doDeductStock(DistributedTransactionContext context,String status);
}
