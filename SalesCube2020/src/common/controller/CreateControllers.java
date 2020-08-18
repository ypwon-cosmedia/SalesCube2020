package common.controller;

import java.util.*;

import common.modal.stock.controller.StockToOrderController;
import estimate.Input.Controller.EstimateAddController;
import estimate.Input.Controller.EstimateModifyController;
import estimate.Search.controller.EstimateSearchController;
import estimate.unitPriceInquiry.Controller.UnitPriceInquiryController;
import master.customer.controller.CustomerController;
import master.product.controller.GetCategoryController;
import master.product.controller.ProductAddController;
import master.product.controller.ProductDeleteController;
import master.product.controller.ProductDiscountController;
import master.product.controller.ProductExcelController;
import master.product.controller.ProductInitController;
import master.product.controller.ProductModifyController;
import master.product.controller.ProductSearchController;
import master.setProduct.controller.SetProductController;
import order.input.controller.OrderInputController;
import order.move.controller.OrderMoveController;
import order.online.controller.OrderOnlineController;
import order.search.controller.OrderSearchController;
import user.controller.UserController;

public class CreateControllers {

	public HashMap<String, BaseController> newControllers()  {

        HashMap<String, BaseController> map = new HashMap<String, BaseController>();

        BaseController customerObj    = new CustomerController();
		BaseController setProductObj = new SetProductController();
		BaseController menuObj = new MenuController();
		BaseController productModifyObj = new ProductModifyController();
		BaseController productSearchObj = new ProductSearchController();
		BaseController productDiscountObj = new ProductDiscountController();
		BaseController productExcelObj = new ProductExcelController();
		BaseController productInitObj = new ProductInitController();
		BaseController productAddObj = new ProductAddController();
		BaseController productDeleteObj = new ProductDeleteController();
		BaseController getCategoryObj = new GetCategoryController();
		BaseController userObj = new UserController();
		BaseController orderObj = new OrderMoveController();
		BaseController orderInputObj = new OrderInputController();
		BaseController orderSearchObj = new OrderSearchController();
		BaseController estimateAddObj = new EstimateAddController();
		BaseController estimateModifyObj = new EstimateModifyController();
		BaseController estimateSearchObj = new EstimateSearchController();
		BaseController unitPriceInquiryObj = new UnitPriceInquiryController();
		BaseController stockObj = new StockToOrderController();
		BaseController orderOnlineObj = new OrderOnlineController();

		map.put( "moveAddCustomer", customerObj);
		map.put( "moveModifyCustomer", customerObj);
		map.put( "initCustomer", customerObj);
		map.put( "updateCustomer", customerObj);
		map.put( "searchAddress", customerObj);
		map.put( "searchCustomer", customerObj);
		map.put( "deleteCustomer", customerObj);
		map.put( "addCustomer", customerObj);
		map.put( "modifyCustomer", customerObj);
		map.put( "customerExcelOutput", customerObj);
		map.put( "customerHistoryOutput", customerObj);
		
		map.put( "moveModifySetProduct", setProductObj);
		map.put( "searchSetProduct", setProductObj);
		map.put( "deleteSetProduct", setProductObj);
		map.put( "modifySetProduct", setProductObj);
		
		map.put( "customer", menuObj);
		map.put( "setProduct", menuObj);
		map.put( "product", menuObj);
		map.put( "menu", menuObj);
		map.put( "searchforset", menuObj);
		map.put( "resultforset", menuObj);
		
		map.put( "moveAddProduct", productAddObj);
		map.put( "addProduct", productAddObj);
		
		map.put( "quantityDiscount", productDiscountObj);
		
		map.put( "initProduct", productInitObj);
		map.put( "updateInitProduct", productInitObj);
		
		map.put( "modifyProduct", productModifyObj);
		map.put( "moveModifyProduct", productModifyObj);
		
		map.put( "productExcelInput", productExcelObj);
		map.put( "productExcelOutput", productExcelObj);
		map.put( "productHistoryOutput", productExcelObj);
		
		map.put( "searchProduct", productSearchObj);
		
		map.put( "deleteProduct", productDeleteObj);
		
		map.put( "getCategory", getCategoryObj);
		
		map.put( "login", userObj);
		map.put( "logout", userObj);
		
		map.put( "orderinput", orderObj);
		map.put( "orderupdate", orderObj);
		map.put( "ordersearch", orderObj);
		map.put( "onlineorder", orderObj);
		
		map.put( "orderinputCmp", orderInputObj);
		map.put( "orderupdateCmp", orderInputObj);
		map.put( "stocksearch", orderInputObj);
		map.put( "moveStockToUpdate", stockObj);
		
		map.put( "productModalSearch", orderSearchObj);
		
		map.put( "moveEstimateAdd", estimateAddObj);
		map.put( "estimateAdd", estimateAddObj);
		
		map.put( "moveEstimateModify", estimateModifyObj);
		map.put( "estimateModify", estimateModifyObj);
		map.put( "estimateDelete", estimateModifyObj);
		map.put( "estimatePdfOutput", estimateModifyObj);
		
		map.put( "moveEstimateSearch", estimateSearchObj);
		map.put( "estimateSearch", estimateSearchObj);
		map.put( "estimateExcelOutput", estimateSearchObj);
		
		map.put( "moveUnitPriceInquiry", unitPriceInquiryObj);
		map.put( "unitPriceInquirySearch", unitPriceInquiryObj);
		
		map.put( "uploadcsv", orderOnlineObj);

        return map;

    }
}
