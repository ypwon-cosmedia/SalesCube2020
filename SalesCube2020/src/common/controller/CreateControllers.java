package common.controller;

import java.util.*;

import master.customer.controller.CustomerController;
import master.product.controller.ProductAddController;
import master.product.controller.ProductController;
import master.product.controller.ProductDiscountController;
import master.product.controller.ProductExcelController;
import master.product.controller.ProductInitController;
import master.product.controller.ProductModifyController;
import master.product.controller.ProductSearchController;
import master.setProduct.controller.SetProductController;
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
		BaseController userObj = new UserController();


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
		map.put( "deleteProduct", productSearchObj);
		map.put( "getCategory", productSearchObj);
		
		map.put( "login", userObj);
		map.put( "logout", userObj);
		
        return map;

    }
}
