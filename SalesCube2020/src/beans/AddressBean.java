/*
 * タイトル：SalesCube
 * 説明　　：管理システム
 *
 * 著作権　：
 * 会社名　：株式会社コスメディア
 *
 * 変更履歴：2020.06.16　新規作成
 *
 */
package beans;

 /**
  * 郵便番号及び住所情報
  * 郵便番号及び住所に付随するサービスを提供する<br>
  * ・郵便番号を取得する<br>
  * ・住所1を取得する<br>
  * ・住所2を設定する<br>
  * 
  * @author 久野
  * @version 1.0
  * 
  */
public class AddressBean {
	/** 郵便番号　：　郵便番号を保持する */
	private int zipCode;

	/** 住所1　：　住所1を保持する */
	private String ZipAddress1;
	
	/** 住所2　：　住所2(詳細な住所)を保持する */
	private String ZipAddress2;

	/**
	 * 郵便番号を取得する
	 * 
	 * @return the zipCode 郵便番号を返す
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * 郵便番号を設定する
	 * 
	 * @param zipCode the zipCode to set 設定する郵便番号
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * 住所1を取得する
	 * 
	 * @return the zipAddress1 住所1を返す
	 */
	public String getZipAddress1() {
		return ZipAddress1;
	}

	/**
	 * 住所1を設定する
	 * 
	 * @param zipAddress1 the zipAddress1 to set 設定する住所1
	 */
	public void setZipAddress1(String zipAddress1) {
		ZipAddress1 = zipAddress1;
	}

	/**
	 * 住所2を取得する
	 * 
	 * @return the zipAddress2 住所2を返す
	 */
	public String getZipAddress2() {
		return ZipAddress2;
	}

	/**
	 * 住所2を設定する
	 * 
	 * @param zipAddress2 the zipAddress2 to set 設定する住所2
	 */
	public void setZipAddress2(String zipAddress2) {
		ZipAddress2 = zipAddress2;
	}
	
	
	
	
	
}
