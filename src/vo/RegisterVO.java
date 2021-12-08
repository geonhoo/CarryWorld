package vo;



public class RegisterVO {
	int user_info_no;
	String name;
	String jumin; 
	String phone;
	String addr;
	String email;
	String id;
	String pass;
	String bank;
	String acc_name;
	String acc_num;
	
	public RegisterVO(String name,String jumin,String phone,String addr,String email,String id,String pass,String bank, String acc_name,String acc_num){
		
		this.name = name;
		this.jumin = jumin;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.id = id;
		this.pass = pass;
		this.bank = bank;
		this.acc_name = acc_name;
		this.acc_num = acc_num;
	}
public RegisterVO(String id) {
	this.id =id;
}
public RegisterVO(String id,String pass) {
	this.id =id;
	this.pass=pass;
}
public RegisterVO() {}
	public int getUser_info_no() {
		return user_info_no;
	}
	public void setUser_info_no(int user_info_no) {
		this.user_info_no = user_info_no;
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public String getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}
	
	
	}



