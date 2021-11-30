package com.anywide.shop.order.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.anywide.dawdler.clientplug.annotation.RequestMapping;
import com.anywide.dawdler.clientplug.annotation.RequestMapping.ViewType;
import com.anywide.dawdler.clientplug.annotation.RequestParam;
import com.anywide.dawdler.clientplug.web.TransactionController;
import com.anywide.dawdler.core.annotation.Service;
import com.anywide.dawdler.distributed.transaction.annotation.DistributedTransaction;
import com.anywide.shop.order.service.OrderService;
import com.anywide.shop.product.service.ProductService;
import com.anywide.shop.user.service.UserService;

@RequestMapping(value = "/order")
public class OrderController extends TransactionController {
	@Service
	UserService userService;

	@Service
	OrderService orderService;

	@Service
	ProductService productService;
	
	
	@DistributedTransaction(action = "createOrder",sponsor = true)
	@RequestMapping(value = "/createOrder.do", viewType = ViewType.json)
	public void createOrder(@RequestParam Integer productId, @RequestParam Integer stock,
			@RequestParam BigDecimal amount) throws Exception {
		int userId = 1;
//		RpcContext.getContext().setAttachment("testdata", "test");
		boolean success = orderService.createOrder(userId, productId, amount);
		Map<String, Object> result;
		if(!success) {
			result = new HashMap<>();
			result.put("success", false);
			result.put("msg", "订单创建失败!");
			setData(result);
			return;
		}
		result = userService.tryPayment(userId, amount);
		success = (boolean) result.get("success");
		if(!success) {
			setData(result);
			return;
		}

		result = productService.tryDeductStock(productId, stock);
		
		setData(result);
	}
	
	
	@RequestMapping(value = "/order.html", viewType = ViewType.velocity)
	public void order() throws Exception {
		System.out.println("order");
		setTemplatePath("order/add.html");
	}


}
