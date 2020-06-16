/*
 * ƒ^ƒCƒgƒ‹FSalesCube
 * à–¾@@FŠÇ—ƒVƒXƒeƒ€
 *
 * ’˜ìŒ @F
 * ‰ïĞ–¼@FŠ”®‰ïĞƒRƒXƒƒfƒBƒA
 *
 * •ÏX—š—ğF2020.06.16@V‹Kì¬
 *
 */
package beans;

 /**
  * —X•Ö”Ô†‹y‚ÑZŠî•ñ
  * —X•Ö”Ô†‹y‚ÑZŠ‚É•t‚·‚éƒT[ƒrƒX‚ğ’ñ‹Ÿ‚·‚é<br>
  * E—X•Ö”Ô†‚ğæ“¾‚·‚é<br>
  * EZŠ1‚ğæ“¾‚·‚é<br>
  * EZŠ2‚ğæ“¾‚·‚é<br> 
  * E—X•Ö”Ô†‚ğİ’è‚·‚é<br>
  * EZŠ1‚ğİ’è‚·‚é<br>
  * EZŠ2‚ğİ’è‚·‚é<br>
  * 
  * @author ‹v–ì
  * @version 1.0
  * 
  */
public class AddressBean {
	/** —X•Ö”Ô†@F@—X•Ö”Ô†‚ğ•Û‚·‚é */
	private int zipCode;

	/** ZŠ1@F@ZŠ1‚ğ•Û‚·‚é */
	private String zipAddress1;
	
	/** ZŠ2@F@ZŠ2(Ú×‚ÈZŠ)‚ğ•Û‚·‚é */
	private String zipAddress2;

	/**
	 * —X•Ö”Ô†‚ğæ“¾‚·‚é
	 * 
	 * @return the zipCode —X•Ö”Ô†‚ğ•Ô‚·
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * —X•Ö”Ô†‚ğİ’è‚·‚é
	 * 
	 * @param zipCode the zipCode to set İ’è‚·‚é—X•Ö”Ô†
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * ZŠ1‚ğæ“¾‚·‚é
	 * 
	 * @return the zipAddress1 ZŠ1‚ğ•Ô‚·
	 */
	public String getZipAddress1() {
		return zipAddress1;
	}

	/**
	 * ZŠ1‚ğİ’è‚·‚é
	 * 
	 * @param zipAddress1 the zipAddress1 to set İ’è‚·‚éZŠ1
	 */
	public void setZipAddress1(String zipAddress1) {
		this.zipAddress1 = zipAddress1;
	}

	/**
	 * ZŠ2‚ğæ“¾‚·‚é
	 * 
	 * @return the zipAddress2 ZŠ2‚ğ•Ô‚·
	 */
	public String getZipAddress2() {
		return zipAddress2;
	}

	/**
	 * ZŠ2‚ğİ’è‚·‚é
	 * 
	 * @param zipAddress2 the zipAddress2 to set İ’è‚·‚éZŠ2
	 */
	public void setZipAddress2(String zipAddress2) {
		this.zipAddress2 = zipAddress2;
	}
	
	
	
	
	
}
