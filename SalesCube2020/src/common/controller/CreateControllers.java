package common.controller;

import java.util.*;

import master.customer.controller.CustomerController;
import master.product.controller.ProductController;
import master.product.controller.ProductSearchController;
import master.setProduct.controller.SetProductController;
import user.controller.UserController;

public class CreateControllers {

	public HashMap<String, BaseController> newControllers()  {

        HashMap<String, BaseController> map = new HashMap<String, BaseController>();

        BaseController customerObj    = new CustomerController();
		BaseController setProductObj = new SetProductController();
		BaseController menuObj = new MenuController();
		BaseController productObj = new ProductController();
		BaseController productSearchObj = new ProductSearchController();
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
		
		map.put( "moveAddProduct", productObj);
		map.put( "productExcelInput", productObj);
		map.put( "productExcelOutput", productObj);
		map.put( "initProduct", productObj);
		map.put( "quantityDiscount", productObj);
		map.put( "addProduct", productObj);
		map.put( "modifyProduct", productObj);
		map.put( "productHistoryOutput", productObj);
		
		map.put( "moveModifyProduct", productSearchObj);
		map.put( "searchProduct", productSearchObj);
		map.put( "deleteProduct", productSearchObj);
		map.put( "getCategory", productSearchObj);
		
		map.put( "login", userObj);
		map.put( "logout", userObj);
		
        return map;

    }
}
