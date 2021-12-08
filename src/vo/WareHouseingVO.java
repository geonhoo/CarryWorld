package vo;

public class WareHouseingVO {

	private String m_c_name, s_c_name, phone, pName, startDate, endDate;
	private int width, vertical, height, to_price, grade;
	
	public int getTo_price() {
		return to_price;
	}

	public void setTo_price(int to_price) {
		this.to_price = to_price;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public WareHouseingVO() {
		
	}
	
	public WareHouseingVO(String main, String sub, String phone, String pName, String sDate, String eDate,
			int wi, int ver, int hei) {
		this.m_c_name = main;
		this.s_c_name = sub;
		this.phone = phone;
		this.pName = pName;
		this.startDate = sDate;
		this.endDate = eDate;
		this.width = wi;
		this.vertical = ver;
		this.height = hei;
	}

	public String getM_c_name() {
		return m_c_name;
	}

	public void setM_c_name(String m_c_name) {
		this.m_c_name = m_c_name;
	}

	public String getS_c_name() {
		return s_c_name;
	}

	public void setS_c_name(String s_c_name) {
		this.s_c_name = s_c_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


}