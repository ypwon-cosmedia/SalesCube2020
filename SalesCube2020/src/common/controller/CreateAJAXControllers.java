package common.controller;

import java.util.HashMap;

import common.modal.product.controller.ProductModalAJAXController;
import order.search.controller.OrderSearchAJAXController;

public class CreateAJAXControllers {
	
	public HashMap<String, BaseAJAXController> newAJAXController(){
		
		HashMap<String, BaseAJAXController> map = new HashMap<String, BaseAJAXController>();
		
		BaseAJAXController productAJAX = new ProductModalAJAXController();
		BaseAJAXController ordersearchAJAX = new OrderSearchAJAXController();
		
		map.put("productSearch", productAJAX);
		
		map.put("configModalUpdate", ordersearchAJAX);
		
		
		return map;
	}

}
