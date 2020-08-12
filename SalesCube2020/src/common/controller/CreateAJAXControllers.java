package common.controller;

import java.util.HashMap;

import common.modal.customer.controller.CustomerModalAJAXController;
import common.modal.product.controller.ProductModalAJAXController;
import common.modal.supplier.controller.SupplierModalAJAXController;
import estimate.Input.Controller.EstimateInputCommonController;
import estimate.common.controller.EstimateCategoryModalAJAXController;
import estimate.common.controller.EstimateConfigurationModalAJAXController;
import estimate.common.controller.UserModalAJAXController;
import order.search.controller.OrderSearchAJAXController;

public class CreateAJAXControllers {
	
	public HashMap<String, BaseAJAXController> newAJAXController(){
		
		HashMap<String, BaseAJAXController> map = new HashMap<String, BaseAJAXController>();
		
		BaseAJAXController productAJAX = new ProductModalAJAXController();
		BaseAJAXController ordersearchAJAX = new OrderSearchAJAXController();
		BaseAJAXController estimateCategoryAJAX = new EstimateCategoryModalAJAXController();
		BaseAJAXController supplierAJAX = new SupplierModalAJAXController();
		BaseAJAXController estimateConfigurationAJAX = new EstimateConfigurationModalAJAXController();
		BaseAJAXController customerAJAX = new CustomerModalAJAXController();
		BaseAJAXController userAJAX = new UserModalAJAXController();
		BaseAJAXController estimateInputCommonAJAX = new EstimateInputCommonController();
		
		map.put("productSearch", productAJAX);
		
		map.put("configModalUpdate", ordersearchAJAX);
		map.put("orderSearch", ordersearchAJAX);
		
		
		map.put("estimateCategoryGet", estimateCategoryAJAX);
		
		map.put("searchModalSupplier", supplierAJAX);
		
		map.put("estimateShowCfgGet", estimateConfigurationAJAX);
		map.put("estimateNotShowCfgGet", estimateConfigurationAJAX);
		map.put("estimateCfgUpd", estimateConfigurationAJAX);
		
		map.put("customerSearch", customerAJAX);
		
		map.put("userSearch", userAJAX);
		map.put("deptSearch", userAJAX);
		map.put("roleSearch", userAJAX);
		
		map.put("estimateCustomerSearch", estimateInputCommonAJAX);
		map.put("estimateProductSearch", estimateInputCommonAJAX);
		map.put("confirmEstimateSheetId", estimateInputCommonAJAX);
		
		return map;
	}

}
