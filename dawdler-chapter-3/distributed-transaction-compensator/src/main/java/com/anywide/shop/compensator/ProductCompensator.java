package com.anywide.shop.compensator;

import com.anywide.dawdler.core.annotation.Service;
import com.anywide.dawdler.distributed.transaction.compensate.process.DistributedTransactionCustomProcessor;
import com.anywide.dawdler.distributed.transaction.context.DistributedTransactionContext;
import com.anywide.shop.product.service.ProductService;

public class ProductCompensator extends DistributedTransactionCustomProcessor {
	@Service
	ProductService productService;
	public ProductCompensator() {
		super("product");
	}

	@Override
	public boolean process(DistributedTransactionContext context, String status) {
		return productService.doDeductStock(context, status);
	}
}
