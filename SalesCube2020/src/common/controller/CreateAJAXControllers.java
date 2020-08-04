package common.controller;

import java.util.HashMap;

import common.modal.product.controller.ProductModalAJAXController;

public class CreateAJAXControllers {
	
	public HashMap<String, BaseAJAXController> newAJAXController(){
		
		HashMap<String, BaseAJAXController> map = new HashMap<String, BaseAJAXController>();
		
		BaseAJAXController productAJAX = new ProductModalAJAXController();
		
		map.put("productSearch", productAJAX);
		
		return map;
	}

}
