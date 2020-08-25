package common.controller;

import java.util.HashMap;

import common.modal.customer.controller.CustomerModalAJAXController;
import common.modal.product.controller.ProductModalAJAXController;
import common.modal.stock.controller.StockController;
import common.modal.supplier.controller.SupplierModalAJAXController;
import estimate.Input.Controller.EstimateInputCommonController;
import estimate.Search.controller.EstimateSearchAJAXController;
import estimate.common.controller.EstimateCategoryModalAJAXController;
import estimate.common.controller.EstimateConfigurationModalAJAXController;
import estimate.common.controller.UserModalAJAXController;
import order.common.bill.Controller.OrderCommonBillController;
import order.input.controller.ProductToOrder;
import order.online.controller.OrderOnlineAJAXController;
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
		BaseAJAXController onlineAJAX = new OrderOnlineAJAXController();
		BaseAJAXController estimateSearchAJAX = new EstimateSearchAJAXController();
		BaseAJAXController stock = new StockController();
		BaseAJAXController bill = new OrderCommonBillController();
		BaseAJAXController orderInput = new ProductToOrder();
		
		map.put("productSearch", productAJAX);
		map.put("initProductModal", productAJAX);
				
		map.put("configModalUpdate", ordersearchAJAX);
		map.put("orderSearch", ordersearchAJAX);
		map.put("csvOutput", ordersearchAJAX);
		
		
		map.put("estimateCategoryGet", estimateCategoryAJAX);
		
		map.put("searchModalSupplier", supplierAJAX);
		
		map.put("estimateShowCfgGet", estimateConfigurationAJAX);
		map.put("estimateNotShowCfgGet", estimateConfigurationAJAX);
		map.put("estimateCfgUpd", estimateConfigurationAJAX);
		
		map.put("customerSearch", customerAJAX);
		
		map.put("estimateSearch", estimateSearchAJAX);
		map.put("estimateCreateTable", estimateSearchAJAX);
		map.put("estimateExcelOutput", estimateSearchAJAX);
		map.put("userSearch", userAJAX);
		map.put("deptSearch", userAJAX);
		map.put("roleSearch", userAJAX);
		
		map.put("estimateCustomerSearch", estimateInputCommonAJAX);
		map.put("estimateProductSearch", estimateInputCommonAJAX);
		map.put("confirmEstimateSheetId", estimateInputCommonAJAX);
		
		map.put("uploadcsv", onlineAJAX);
		
		map.put("pcodetoinfo", orderInput);
		map.put("deliverytoinfo", orderInput);
		map.put("cuscodetoinfo", orderInput);
		map.put("stocksearch", stock);
		map.put("billsearch", bill);
		map.put("checkRoSlipId", orderInput);
		
		return map;
	}

}
