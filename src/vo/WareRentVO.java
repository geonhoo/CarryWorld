package vo;

public class WareRentVO {
	private String pro_name, r_start, r_end;
	private int pro_num, price, r_period, to_price;
	
	public WareRentVO() {
		
	}
	
	public WareRentVO(String r_start, int r_period) {
		this.r_start = r_start;
		this.r_period = r_period;
	}
	
	public WareRentVO(String r_start, int r_period, int price) {
		this.r_start = r_start;
		this.r_period = r_period;
		this.price = price;
	}
	
	public WareRentVO(int pro_num, String r_start, String r_end, int r_period) {
		this.pro_num = pro_num;
		this.r_start = r_start;
		this.r_end = r_end;
		this.r_period = r_period;
	}
	
	public WareRentVO(int pro_num, String pro_name, int price, String r_start,
			int r_period, String r_end, int to_price) {
		this.pro_num = pro_num;
		this.pro_name = pro_name;
		this.price = price;
		this.r_start = r_start;
		this.r_period = r_period;
		this.r_end = r_end;
		this.to_price = to_price;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getR_start() {
		return r_start;
	}

	public void setR_start(String r_start) {
		this.r_start = r_start;
	}

	public String getR_end() {
		return r_end;
	}

	public void setR_end(String r_end) {
		this.r_end = r_end;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getR_period() {
		return r_period;
	}

	public void setR_period(int r_period) {
		this.r_period = r_period;
	}

	public int getTo_price() {
		return to_price;
	}

	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}

	
}
