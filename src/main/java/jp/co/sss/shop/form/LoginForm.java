package jp.co.sss.shop.form;

public class LoginForm {
	private Integer userId;
	private String password;
	public LoginForm(Integer userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
