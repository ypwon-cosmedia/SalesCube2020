package master.product.beans;

import java.sql.*;

/**
 * �ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽﾏ更�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽi�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽJ�ｿｽi�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽI�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽC�ｿｽ�ｿｽ�ｿｽi�ｿｽﾔゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽEJAN�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽp�ｿｽﾔ予�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽ�ｿｽ�ｿｽ譁ｼ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽ�ｿｽ�ｿｽ謠､�ｿｽi�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽi�ｿｽ~�ｿｽj�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽi�ｿｽO�ｿｽﾝ）�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽﾝ庫管暦ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾏ出�ｿｽﾗ撰ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽq�ｿｽﾉ厄ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽI�ｿｽﾔゑｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ[�ｿｽh�ｿｽ^�ｿｽC�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ_�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ_�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽﾐ茨ｿｽ�ｿｽS�ｿｽﾝ庫撰ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽﾐ茨ｿｽ�ｿｽS�ｿｽﾝ庫撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽﾅ托ｿｽﾛ有�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽﾅ托ｿｽﾛ有�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽP�ｿｽﾊ費ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽP�ｿｽﾊ費ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ轟�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽﾊ奇ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽｵゑｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽﾛ管ゑｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽB�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽW�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽv�ｿｽZ�ｿｽ|�ｿｽ�ｿｽ�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽZ�ｿｽb�ｿｽg�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽJ�ｿｽe�ｿｽS�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽj�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽJ�ｿｽe�ｿｽS�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽJ�ｿｽe�ｿｽS�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽP�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽd�ｿｽﾊ単�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽP�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊゑｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽc�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽ�ｿｽ�ｿｽl�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽs�ｿｽb�ｿｽL�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽl�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
 * �ｿｽE�ｿｽR�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽg�ｿｽ�ｿｽﾝ定す�ｿｽ�ｿｽ<br>
�ｿｽ@* 
 * @author �ｿｽ�ｿｽ�ｿｽ�ｿｽ
 * @version 1.0
 */

public class ProductModifyBean {
	/** �ｿｽ�ｿｽ�ｿｽi�ｿｽR�ｿｽ[�ｿｽh�ｿｽF�ｿｽ�ｿｽ�ｿｽi�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productCode;

	/** �ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productName;
	
	/** �ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽJ�ｿｽi�ｿｽF�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽJ�ｿｽi�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productKana;
	
	/** �ｿｽI�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽC�ｿｽ�ｿｽ�ｿｽi�ｿｽﾔ：�ｿｽI�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽC�ｿｽ�ｿｽ�ｿｽi�ｿｽﾔゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String onlinePcode;
	
	/** JAN�ｿｽR�ｿｽ[�ｿｽh�ｿｽFJAN�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String janPcode;
	
	/** �ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽF�ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String discardDate;
	
	/** �ｿｽd�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽF�ｿｽd�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String supplierCode;
	
	/** �ｿｽd�ｿｽ�ｿｽ�ｿｽ譁ｼ�ｿｽF�ｿｽd�ｿｽ�ｿｽ�ｿｽ譁ｼ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String supplierName;

	/** �ｿｽd�ｿｽ�ｿｽ�ｿｽ�ｿｽi�ｿｽﾔ：�ｿｽd�ｿｽ�ｿｽ�ｿｽ�ｿｽi�ｿｽﾔゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String supplierPcode;
	
	/** �ｿｽd�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽi�ｿｽ~�ｿｽj�ｿｽF�ｿｽd�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽi�ｿｽ~�ｿｽj�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String supplierPriceYen;
	
	/** �ｿｽd�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽi�ｿｽO�ｿｽﾝ）�ｿｽF�ｿｽd�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽi�ｿｽO�ｿｽﾝ）�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String supplierPriceDol;

	/** �ｿｽﾝ庫管暦ｿｽ�ｿｽ謨ｪ�ｿｽF�ｿｽﾝ庫管暦ｿｽ�ｿｽ謨ｪ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String stockCtlCategory;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String packQuantity;
	
	/** �ｿｽ�ｿｽ�ｿｽﾏ出�ｿｽﾗ撰ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽﾏ出�ｿｽﾗ撰ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String avgShipCount;
	
	/** �ｿｽq�ｿｽﾉ厄ｿｽ�ｿｽF�ｿｽq�ｿｽﾉ厄ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String warehouseName;
	
	/** �ｿｽI�ｿｽﾔ：�ｿｽI�ｿｽﾔゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String rackCode;

	/** �ｿｽ�ｿｽ�ｿｽ[�ｿｽh�ｿｽ^�ｿｽC�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽ[�ｿｽh�ｿｽ^�ｿｽC�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String leadTime;

	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ_�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ_�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String poNum;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ_�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ_�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String poUpdFlag;

	/** �ｿｽ�ｿｽ�ｿｽﾐ茨ｿｽ�ｿｽS�ｿｽﾝ庫撰ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽﾐ茨ｿｽ�ｿｽS�ｿｽﾝ庫撰ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String mineSafetyStock;
	
	/** �ｿｽ�ｿｽ�ｿｽﾐ茨ｿｽ�ｿｽS�ｿｽﾝ庫撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽF�ｿｽ�ｿｽ�ｿｽﾐ茨ｿｽ�ｿｽS�ｿｽﾝ庫撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String mineSafetyStockUpdFlag;

	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽb�ｿｽg�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽb�ｿｽg�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String poLot;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String lotUpdFlag;

	/** �ｿｽﾝ庫鯉ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽF�ｿｽﾝ庫鯉ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String maxStockNum;
	
	/** �ｿｽﾝ庫鯉ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽF�ｿｽﾝ庫鯉ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String stockUpdFlag;

	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String maxPoNum;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String maxPoUpdFlag;

	/** �ｿｽ轟�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽF�ｿｽ轟�ｿｽ�ｿｽx�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String roMaxNum;
	
	/** �ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String retailPrice;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String discountId;
	
	/** �ｿｽ�ｿｽ�ｿｽﾞ状況：�ｿｽ�ｿｽ�ｿｽﾞ状況ゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productStatusCategory;
	
	/** �ｿｽ�ｿｽ�ｿｽﾞ保管：�ｿｽ�ｿｽ�ｿｽﾞ保管ゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productStockCategory;
	
	/** �ｿｽ�ｿｽ�ｿｽﾞ抵ｿｽ�ｿｽB�ｿｽF�ｿｽ�ｿｽ�ｿｽﾞ抵ｿｽ�ｿｽB�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productPurvayCategory;
	
	/** �ｿｽ�ｿｽ�ｿｽﾞ標�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽﾞ標�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String productStandardCategory;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽi�ｿｽ|�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽi�ｿｽ|�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String soRate;

	/** �ｿｽZ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽi�ｿｽt�ｿｽ�ｿｽ�ｿｽO�ｿｽF�ｿｽZ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽi�ｿｽt�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String setTypeCategory;

	/** �ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽﾞ１�ｿｽF�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽﾞ１�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String product1;

	/** �ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽﾞ２�ｿｽF�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽﾞ２�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String product2;
	
	/** �ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽﾞ３�ｿｽF�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽﾞ３�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String product3;
	
	/** �ｿｽP�ｿｽﾊコ�ｿｽ[�ｿｽh�ｿｽF�ｿｽP�ｿｽﾊコ�ｿｽ[�ｿｽh�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String unitCategory;
	
	/** �ｿｽd�ｿｽﾊ：�ｿｽd�ｿｽﾊゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String weight;
	
	/** �ｿｽd�ｿｽﾊ単�ｿｽﾊ：�ｿｽd�ｿｽﾊ単�ｿｽﾊゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String weightUnitSizeCategory;

	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String length;
	
	/** �ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽP�ｿｽﾊ：�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽP�ｿｽﾊゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String lengthUnitSizeCategory;

	/** �ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽF�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String width;
	
	/** �ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊ：�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String widthUnitSizeCategory;

	/** �ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽF�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String depth;

	/** �ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊ：�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String depthUnitSizeCategory;	
	
	/** �ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽF�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String height;
	
	/** �ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊ：�ｿｽT�ｿｽC�ｿｽY�ｿｽi�ｿｽ�ｿｽ�ｿｽj�ｿｽP�ｿｽﾊゑｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String heightUnitSizeCategory;

	/** �ｿｽc�ｿｽ�ｿｽ�ｿｽF�ｿｽc�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String coreNum;
	
	/** �ｿｽ�ｿｽ�ｿｽl�ｿｽF�ｿｽ�ｿｽ�ｿｽl�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String remarks;

	/** �ｿｽs�ｿｽb�ｿｽL�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽl�ｿｽF�ｿｽs�ｿｽb�ｿｽL�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽl�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String eadRemarks;
	
	/** �ｿｽR�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽg�ｿｽF�ｿｽR�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽg�ｿｽ�ｿｽﾛ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ */
	private String commentData;
	
	
	private String termShipNum;
	private String maxPoUpdNum;
	private String fractCategory;
	private	String taxCategory;
	private String stockAssesCategory;
	private String productCategory;
	private String productRank;
	private String num1;
	private String num2;
	private String num3;
	private String num4;
	private String num5;
	private String dec1;
	private String dec2;
	private String dec3;
	private String dec4;
	private String dec5;
	private String lastRoDate;
	private String salesStandardDeviation;
	private String entrustSafetyStock;
	private String creFunc;
	private String creDatetm;
	private String creUser;
	private String updFunc;
	private String updDatetm;
	private String updUser;
	private String delFunc;
	private String delDatetm;
	private String delUser;
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productKana
	 */
	public String getProductKana() {
		return productKana;
	}
	/**
	 * @param productKana the productKana to set
	 */
	public void setProductKana(String productKana) {
		this.productKana = productKana;
	}
	/**
	 * @return the onlinePcode
	 */
	public String getOnlinePcode() {
		return onlinePcode;
	}
	/**
	 * @param onlinePcode the onlinePcode to set
	 */
	public void setOnlinePcode(String onlinePcode) {
		this.onlinePcode = onlinePcode;
	}
	/**
	 * @return the janPcode
	 */
	public String getJanPcode() {
		return janPcode;
	}
	/**
	 * @param janPcode the janPcode to set
	 */
	public void setJanPcode(String janPcode) {
		this.janPcode = janPcode;
	}
	/**
	 * @return the discardDate
	 */
	public String getDiscardDate() {
		return discardDate;
	}
	/**
	 * @param discardDate the discardDate to set
	 */
	public void setDiscardDate(String discardDate) {
		this.discardDate = discardDate;
	}
	/**
	 * @return the supplierCode
	 */
	public String getSupplierCode() {
		return supplierCode;
	}
	/**
	 * @param supplierCode the supplierCode to set
	 */
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * @return the supplierPcode
	 */
	public String getSupplierPcode() {
		return supplierPcode;
	}
	/**
	 * @param supplierPcode the supplierPcode to set
	 */
	public void setSupplierPcode(String supplierPcode) {
		this.supplierPcode = supplierPcode;
	}
	/**
	 * @return the supplierPriceYen
	 */
	public String getSupplierPriceYen() {
		return supplierPriceYen;
	}
	/**
	 * @param supplierPriceYen the supplierPriceYen to set
	 */
	public void setSupplierPriceYen(String supplierPriceYen) {
		this.supplierPriceYen = supplierPriceYen;
	}
	/**
	 * @return the supplierPriceDol
	 */
	public String getSupplierPriceDol() {
		return supplierPriceDol;
	}
	/**
	 * @param supplierPriceDol the supplierPriceDol to set
	 */
	public void setSupplierPriceDol(String supplierPriceDol) {
		this.supplierPriceDol = supplierPriceDol;
	}
	/**
	 * @return the stockCtlCategory
	 */
	public String getStockCtlCategory() {
		return stockCtlCategory;
	}
	/**
	 * @param stockCtlCategory the stockCtlCategory to set
	 */
	public void setStockCtlCategory(String stockCtlCategory) {
		this.stockCtlCategory = stockCtlCategory;
	}
	/**
	 * @return the packQuantity
	 */
	public String getPackQuantity() {
		return packQuantity;
	}
	/**
	 * @param packQuantity the packQuantity to set
	 */
	public void setPackQuantity(String packQuantity) {
		this.packQuantity = packQuantity;
	}
	/**
	 * @return the avgShipCount
	 */
	public String getAvgShipCount() {
		return avgShipCount;
	}
	/**
	 * @param avgShipCount the avgShipCount to set
	 */
	public void setAvgShipCount(String avgShipCount) {
		this.avgShipCount = avgShipCount;
	}
	/**
	 * @return the warehouseName
	 */
	public String getWarehouseName() {
		return warehouseName;
	}
	/**
	 * @param warehouseName the warehouseName to set
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	/**
	 * @return the rackCode
	 */
	public String getRackCode() {
		return rackCode;
	}
	/**
	 * @param rackCode the rackCode to set
	 */
	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}
	/**
	 * @return the leadTime
	 */
	public String getLeadTime() {
		return leadTime;
	}
	/**
	 * @param leadTime the leadTime to set
	 */
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}
	/**
	 * @return the poNum
	 */
	public String getPoNum() {
		return poNum;
	}
	/**
	 * @param poNum the poNum to set
	 */
	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}
	/**
	 * @return the poUpdFlag
	 */
	public String getPoUpdFlag() {
		return poUpdFlag;
	}
	/**
	 * @param poUpdFlag the poUpdFlag to set
	 */
	public void setPoUpdFlag(String poUpdFlag) {
		this.poUpdFlag = poUpdFlag;
	}
	/**
	 * @return the mineSafetyStock
	 */
	public String getMineSafetyStock() {
		return mineSafetyStock;
	}
	/**
	 * @param mineSafetyStock the mineSafetyStock to set
	 */
	public void setMineSafetyStock(String mineSafetyStock) {
		this.mineSafetyStock = mineSafetyStock;
	}
	/**
	 * @return the mineSafetyStockUpdFlag
	 */
	public String getMineSafetyStockUpdFlag() {
		return mineSafetyStockUpdFlag;
	}
	/**
	 * @param mineSafetyStockUpdFlag the mineSafetyStockUpdFlag to set
	 */
	public void setMineSafetyStockUpdFlag(String mineSafetyStockUpdFlag) {
		this.mineSafetyStockUpdFlag = mineSafetyStockUpdFlag;
	}
	/**
	 * @return the poLot
	 */
	public String getPoLot() {
		return poLot;
	}
	/**
	 * @param poLot the poLot to set
	 */
	public void setPoLot(String poLot) {
		this.poLot = poLot;
	}
	/**
	 * @return the lotUpdFlag
	 */
	public String getLotUpdFlag() {
		return lotUpdFlag;
	}
	/**
	 * @param lotUpdFlag the lotUpdFlag to set
	 */
	public void setLotUpdFlag(String lotUpdFlag) {
		this.lotUpdFlag = lotUpdFlag;
	}
	/**
	 * @return the maxStockNum
	 */
	public String getMaxStockNum() {
		return maxStockNum;
	}
	/**
	 * @param maxStockNum the maxStockNum to set
	 */
	public void setMaxStockNum(String maxStockNum) {
		this.maxStockNum = maxStockNum;
	}
	/**
	 * @return the stockUpdFlag
	 */
	public String getStockUpdFlag() {
		return stockUpdFlag;
	}
	/**
	 * @param stockUpdFlag the stockUpdFlag to set
	 */
	public void setStockUpdFlag(String stockUpdFlag) {
		this.stockUpdFlag = stockUpdFlag;
	}
	/**
	 * @return the maxPoNum
	 */
	public String getMaxPoNum() {
		return maxPoNum;
	}
	/**
	 * @param maxPoNum the maxPoNum to set
	 */
	public void setMaxPoNum(String maxPoNum) {
		this.maxPoNum = maxPoNum;
	}
	/**
	 * @return the maxPoUpdFlag
	 */
	public String getMaxPoUpdFlag() {
		return maxPoUpdFlag;
	}
	/**
	 * @param maxPoUpdFlag the maxPoUpdFlag to set
	 */
	public void setMaxPoUpdFlag(String maxPoUpdFlag) {
		this.maxPoUpdFlag = maxPoUpdFlag;
	}
	/**
	 * @return the roMaxNum
	 */
	public String getRoMaxNum() {
		return roMaxNum;
	}
	/**
	 * @param roMaxNum the roMaxNum to set
	 */
	public void setRoMaxNum(String roMaxNum) {
		this.roMaxNum = roMaxNum;
	}
	/**
	 * @return the retailPrice
	 */
	public String getRetailPrice() {
		return retailPrice;
	}
	/**
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * @return the discountId
	 */
	public String getDiscountId() {
		return discountId;
	}
	/**
	 * @param discountId the discountId to set
	 */
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}
	/**
	 * @return the productStatusCategory
	 */
	public String getProductStatusCategory() {
		return productStatusCategory;
	}
	/**
	 * @param productStatusCategory the productStatusCategory to set
	 */
	public void setProductStatusCategory(String productStatusCategory) {
		this.productStatusCategory = productStatusCategory;
	}
	/**
	 * @return the productStockCategory
	 */
	public String getProductStockCategory() {
		return productStockCategory;
	}
	/**
	 * @param productStockCategory the productStockCategory to set
	 */
	public void setProductStockCategory(String productStockCategory) {
		this.productStockCategory = productStockCategory;
	}
	/**
	 * @return the productPurvayCategory
	 */
	public String getProductPurvayCategory() {
		return productPurvayCategory;
	}
	/**
	 * @param productPurvayCategory the productPurvayCategory to set
	 */
	public void setProductPurvayCategory(String productPurvayCategory) {
		this.productPurvayCategory = productPurvayCategory;
	}
	/**
	 * @return the productStandardCategory
	 */
	public String getProductStandardCategory() {
		return productStandardCategory;
	}
	/**
	 * @param productStandardCategory the productStandardCategory to set
	 */
	public void setProductStandardCategory(String productStandardCategory) {
		this.productStandardCategory = productStandardCategory;
	}
	/**
	 * @return the soRate
	 */
	public String getSoRate() {
		return soRate;
	}
	/**
	 * @param soRate the soRate to set
	 */
	public void setSoRate(String soRate) {
		this.soRate = soRate;
	}
	/**
	 * @return the setTypeCategory
	 */
	public String getSetTypeCategory() {
		return setTypeCategory;
	}
	/**
	 * @param setTypeCategory the setTypeCategory to set
	 */
	public void setSetTypeCategory(String setTypeCategory) {
		this.setTypeCategory = setTypeCategory;
	}
	/**
	 * @return the product1
	 */
	public String getProduct1() {
		return product1;
	}
	/**
	 * @param product1 the product1 to set
	 */
	public void setProduct1(String product1) {
		this.product1 = product1;
	}
	/**
	 * @return the product2
	 */
	public String getProduct2() {
		return product2;
	}
	/**
	 * @param product2 the product2 to set
	 */
	public void setProduct2(String product2) {
		this.product2 = product2;
	}
	/**
	 * @return the product3
	 */
	public String getProduct3() {
		return product3;
	}
	/**
	 * @param product3 the product3 to set
	 */
	public void setProduct3(String product3) {
		this.product3 = product3;
	}
	/**
	 * @return the unitCategory
	 */
	public String getUnitCategory() {
		return unitCategory;
	}
	/**
	 * @param unitCategory the unitCategory to set
	 */
	public void setUnitCategory(String unitCategory) {
		this.unitCategory = unitCategory;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return the weightUnitSizeCategory
	 */
	public String getWeightUnitSizeCategory() {
		return weightUnitSizeCategory;
	}
	/**
	 * @param weightUnitSizeCategory the weightUnitSizeCategory to set
	 */
	public void setWeightUnitSizeCategory(String weightUnitSizeCategory) {
		this.weightUnitSizeCategory = weightUnitSizeCategory;
	}
	/**
	 * @return the length
	 */
	public String getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * @return the lengthUnitSizeCategory
	 */
	public String getLengthUnitSizeCategory() {
		return lengthUnitSizeCategory;
	}
	/**
	 * @param lengthUnitSizeCategory the lengthUnitSizeCategory to set
	 */
	public void setLengthUnitSizeCategory(String lengthUnitSizeCategory) {
		this.lengthUnitSizeCategory = lengthUnitSizeCategory;
	}
	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}
	/**
	 * @return the widthUnitSizeCategory
	 */
	public String getWidthUnitSizeCategory() {
		return widthUnitSizeCategory;
	}
	/**
	 * @param widthUnitSizeCategory the widthUnitSizeCategory to set
	 */
	public void setWidthUnitSizeCategory(String widthUnitSizeCategory) {
		this.widthUnitSizeCategory = widthUnitSizeCategory;
	}
	/**
	 * @return the depth
	 */
	public String getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(String depth) {
		this.depth = depth;
	}
	/**
	 * @return the depthUnitSizeCategory
	 */
	public String getDepthUnitSizeCategory() {
		return depthUnitSizeCategory;
	}
	/**
	 * @param depthUnitSizeCategory the depthUnitSizeCategory to set
	 */
	public void setDepthUnitSizeCategory(String depthUnitSizeCategory) {
		this.depthUnitSizeCategory = depthUnitSizeCategory;
	}
	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * @return the heightUnitSizeCategory
	 */
	public String getHeightUnitSizeCategory() {
		return heightUnitSizeCategory;
	}
	/**
	 * @param heightUnitSizeCategory the heightUnitSizeCategory to set
	 */
	public void setHeightUnitSizeCategory(String heightUnitSizeCategory) {
		this.heightUnitSizeCategory = heightUnitSizeCategory;
	}
	/**
	 * @return the coreNum
	 */
	public String getCoreNum() {
		return coreNum;
	}
	/**
	 * @param coreNum the coreNum to set
	 */
	public void setCoreNum(String coreNum) {
		this.coreNum = coreNum;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the eadRemarks
	 */
	public String getEadRemarks() {
		return eadRemarks;
	}
	/**
	 * @param eadRemarks the eadRemarks to set
	 */
	public void setEadRemarks(String eadRemarks) {
		this.eadRemarks = eadRemarks;
	}
	/**
	 * @return the commentData
	 */
	public String getCommentData() {
		return commentData;
	}
	/**
	 * @param commentData the commentData to set
	 */
	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}
	/**
	 * @return the termShipNum
	 */
	public String getTermShipNum() {
		return termShipNum;
	}
	/**
	 * @param termShipNum the termShipNum to set
	 */
	public void setTermShipNum(String termShipNum) {
		this.termShipNum = termShipNum;
	}
	/**
	 * @return the maxPoUpdNum
	 */
	public String getMaxPoUpdNum() {
		return maxPoUpdNum;
	}
	/**
	 * @param maxPoUpdNum the maxPoUpdNum to set
	 */
	public void setMaxPoUpdNum(String maxPoUpdNum) {
		this.maxPoUpdNum = maxPoUpdNum;
	}
	/**
	 * @return the fractCategory
	 */
	public String getFractCategory() {
		return fractCategory;
	}
	/**
	 * @param fractCategory the fractCategory to set
	 */
	public void setFractCategory(String fractCategory) {
		this.fractCategory = fractCategory;
	}
	/**
	 * @return the taxCategory
	 */
	public String getTaxCategory() {
		return taxCategory;
	}
	/**
	 * @param taxCategory the taxCategory to set
	 */
	public void setTaxCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}
	/**
	 * @return the stockAssesCategory
	 */
	public String getStockAssesCategory() {
		return stockAssesCategory;
	}
	/**
	 * @param stockAssesCategory the stockAssesCategory to set
	 */
	public void setStockAssesCategory(String stockAssesCategory) {
		this.stockAssesCategory = stockAssesCategory;
	}
	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * @return the productRank
	 */
	public String getProductRank() {
		return productRank;
	}
	/**
	 * @param productRank the productRank to set
	 */
	public void setProductRank(String productRank) {
		this.productRank = productRank;
	}
	/**
	 * @return the num1
	 */
	public String getNum1() {
		return num1;
	}
	/**
	 * @param num1 the num1 to set
	 */
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	/**
	 * @return the num2
	 */
	public String getNum2() {
		return num2;
	}
	/**
	 * @param num2 the num2 to set
	 */
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	/**
	 * @return the num3
	 */
	public String getNum3() {
		return num3;
	}
	/**
	 * @param num3 the num3 to set
	 */
	public void setNum3(String num3) {
		this.num3 = num3;
	}
	/**
	 * @return the num4
	 */
	public String getNum4() {
		return num4;
	}
	/**
	 * @param num4 the num4 to set
	 */
	public void setNum4(String num4) {
		this.num4 = num4;
	}
	/**
	 * @return the num5
	 */
	public String getNum5() {
		return num5;
	}
	/**
	 * @param num5 the num5 to set
	 */
	public void setNum5(String num5) {
		this.num5 = num5;
	}
	/**
	 * @return the dec1
	 */
	public String getDec1() {
		return dec1;
	}
	/**
	 * @param dec1 the dec1 to set
	 */
	public void setDec1(String dec1) {
		this.dec1 = dec1;
	}
	/**
	 * @return the dec2
	 */
	public String getDec2() {
		return dec2;
	}
	/**
	 * @param dec2 the dec2 to set
	 */
	public void setDec2(String dec2) {
		this.dec2 = dec2;
	}
	/**
	 * @return the dec3
	 */
	public String getDec3() {
		return dec3;
	}
	/**
	 * @param dec3 the dec3 to set
	 */
	public void setDec3(String dec3) {
		this.dec3 = dec3;
	}
	/**
	 * @return the dec4
	 */
	public String getDec4() {
		return dec4;
	}
	/**
	 * @param dec4 the dec4 to set
	 */
	public void setDec4(String dec4) {
		this.dec4 = dec4;
	}
	/**
	 * @return the dec5
	 */
	public String getDec5() {
		return dec5;
	}
	/**
	 * @param dec5 the dec5 to set
	 */
	public void setDec5(String dec5) {
		this.dec5 = dec5;
	}

	/**
	 * @return the lastRoDate
	 */
	public String getLastRoDate() {
		return lastRoDate;
	}
	/**
	 * @param lastRoDate the lastRoDate to set
	 */
	public void setLastRoDate(String lastRoDate) {
		this.lastRoDate = lastRoDate;
	}
	/**
	 * @return the salesStandardDeviation
	 */
	public String getSalesStandardDeviation() {
		return salesStandardDeviation;
	}
	/**
	 * @param salesStandardDeviation the salesStandardDeviation to set
	 */
	public void setSalesStandardDeviation(String salesStandardDeviation) {
		this.salesStandardDeviation = salesStandardDeviation;
	}
	/**
	 * @return the entrustSafetyStock
	 */
	public String getEntrustSafetyStock() {
		return entrustSafetyStock;
	}
	/**
	 * @param entrustSafetyStock the entrustSafetyStock to set
	 */
	public void setEntrustSafetyStock(String entrustSafetyStock) {
		this.entrustSafetyStock = entrustSafetyStock;
	}
	/**
	 * @return the creFunc
	 */
	public String getCreFunc() {
		return creFunc;
	}
	/**
	 * @param creFunc the creFunc to set
	 */
	public void setCreFunc(String creFunc) {
		this.creFunc = creFunc;
	}
	/**
	 * @return the creDatetm
	 */
	public String getCreDatetm() {
		return creDatetm;
	}
	/**
	 * @param creDatetm the creDatetm to set
	 */
	public void setCreDatetm(String creDatetm) {
		this.creDatetm = creDatetm;
	}
	/**
	 * @return the creUser
	 */
	public String getCreUser() {
		return creUser;
	}
	/**
	 * @param creUser the creUser to set
	 */
	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}
	/**
	 * @return the updFunc
	 */
	public String getUpdFunc() {
		return updFunc;
	}
	/**
	 * @param updFunc the updFunc to set
	 */
	public void setUpdFunc(String updFunc) {
		this.updFunc = updFunc;
	}
	/**
	 * @return the updDatetm
	 */
	public String getUpdDatetm() {
		return updDatetm;
	}
	/**
	 * @param updDatetm the updDatetm to set
	 */
	public void setUpdDatetm(String updDatetm) {
		this.updDatetm = updDatetm;
	}
	/**
	 * @return the updUser
	 */
	public String getUpdUser() {
		return updUser;
	}
	/**
	 * @param updUser the updUser to set
	 */
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	/**
	 * @return the delFunc
	 */
	public String getDelFunc() {
		return delFunc;
	}
	/**
	 * @param delFunc the delFunc to set
	 */
	public void setDelFunc(String delFunc) {
		this.delFunc = delFunc;
	}
	/**
	 * @return the delDatetm
	 */
	public String getDelDatetm() {
		return delDatetm;
	}
	/**
	 * @param delDatetm the delDatetm to set
	 */
	public void setDelDatetm(String delDatetm) {
		this.delDatetm = delDatetm;
	}
	/**
	 * @return the delUser
	 */
	public String getDelUser() {
		return delUser;
	}
	/**
	 * @param delUser the delUser to set
	 */
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	
	
	
	
	
	
	

	
	
	

}
