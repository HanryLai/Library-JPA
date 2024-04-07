package entity;

public class TaiKhoan {
	private String tenDangNhap;
	private String matKhau;
	private String email;
	public TaiKhoan() {
		
	}
	public TaiKhoan(String tenDangNhap, String matKhau, String email) {
		
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
	}
	
	public static TaiKhoan ChuyenString(String text) {
		return new TaiKhoan(text);
	}
	
	public TaiKhoan(String tenDangNhap) {
		
		this.tenDangNhap = tenDangNhap;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", email=" + email + "]";
	}
	
	
}
