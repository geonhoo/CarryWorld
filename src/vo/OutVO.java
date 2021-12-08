package vo;

public class OutVO {
	String outHopeDate,comeName, kStartDate, kEndDate, shareBool, saleBool, shareHopeDate, userSaleHopeDate, outComplDate;
	int saleHopePrice,rentHopePrice, outNum, sharehopeCash, shareHopeRentDate;
	
	
	public  OutVO 
	(String outComplDate,  String userSaleHopeDate, String shareHopeDate,  String outHopeDate, String comeName, String kStartDate, String kEndDat, String shareBool, String saleBool, int saleHopePrice, int rentHopePrice, int sharehopeCash, int outNum, int shareHopeRentDate ) {
		this.outNum = outNum;
		this.saleHopePrice = saleHopePrice;
		this.rentHopePrice = rentHopePrice;
		this.outHopeDate = outHopeDate;
		this.comeName = comeName;
		this.kStartDate = kStartDate;
		this.kEndDate = kEndDat;
		this.shareBool = shareBool;
		this.saleBool = saleBool;
		this.sharehopeCash = sharehopeCash;
		this.shareHopeDate = shareHopeDate;
		this.userSaleHopeDate = userSaleHopeDate;
		this.shareHopeRentDate = shareHopeRentDate;
		this.outComplDate = outComplDate;
	}


	public OutVO(int k_n, int userSaleHopePay) {
	
	}


	public OutVO(int k_n, String receiHopeDate) {
	
	}


	public OutVO(int k_n, int sharehopeCash, String u_s_h_d) {
		
	}


	public OutVO(int k_n, int sharehopeCash, String shareHopeDate, int shareHopeRentDate) {
	
	}


	public OutVO() {
	
	}


	public String getOutHopeDate() {
		return outHopeDate;
	}


	public void setOutHopeDate(String outHopeDate) {
		this.outHopeDate = outHopeDate;
	}


	public String getComeName() {
		return comeName;
	}


	public void setComeName(String comeName) {
		this.comeName = comeName;
	}


	public String getkStartDate() {
		return kStartDate;
	}


	public void setkStartDate(String kStartDate) {
		this.kStartDate = kStartDate;
	}


	public String getkEndDate() {
		return kEndDate;
	}


	public void setkEndDate(String kEndDate) {
		this.kEndDate = kEndDate;
	}


	public String getShareBool() {
		return shareBool;
	}


	public void setShareBool(String shareBool) {
		this.shareBool = shareBool;
	}


	public String getSaleBool() {
		return saleBool;
	}


	public void setSaleBool(String saleBool) {
		this.saleBool = saleBool;
	}


	public String getShareHopeDate() {
		return shareHopeDate;
	}


	public void setShareHopeDate(String shareHopeDate) {
		this.shareHopeDate = shareHopeDate;
	}


	public String getUserSaleHopeDate() {
		return userSaleHopeDate;
	}


	public void setUserSaleHopeDate(String userSaleHopeDate) {
		this.userSaleHopeDate = userSaleHopeDate;
	}


	public String getOutComplDate() {
		return outComplDate;
	}


	public void setOutComplDate(String outComplDate) {
		this.outComplDate = outComplDate;
	}


	public int getSaleHopePrice() {
		return saleHopePrice;
	}


	public void setSaleHopePrice(int saleHopePrice) {
		this.saleHopePrice = saleHopePrice;
	}


	public int getRentHopePrice() {
		return rentHopePrice;
	}


	public void setRentHopePrice(int rentHopePrice) {
		this.rentHopePrice = rentHopePrice;
	}


	public int getOutNum() {
		return outNum;
	}


	public void setOutNum(int outNum) {
		this.outNum = outNum;
	}


	public int getSharehopeCash() {
		return sharehopeCash;
	}


	public void setSharehopeCash(int sharehopeCash) {
		this.sharehopeCash = sharehopeCash;
	}


	public int getShareHopeRentDate() {
		return shareHopeRentDate;
	}


	public void setShareHopeRentDate(int shareHopeRentDate) {
		this.shareHopeRentDate = shareHopeRentDate;
	}


	
	
}
	
	

	
	
	
