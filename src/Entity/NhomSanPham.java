package Entity;

public class NhomSanPham {
	private String maNhomSanPham;
	private String tenNhomSanPham;
	
	public NhomSanPham() {
		
	}
	
	public NhomSanPham(String maNhomSanPham) {
		super();
		this.maNhomSanPham = maNhomSanPham;
	}

	public NhomSanPham(String maNhomSanPham, String tenNhomSanPham) {
		this.maNhomSanPham = maNhomSanPham;
		this.tenNhomSanPham = tenNhomSanPham;
	}
	public String getMaNhomSanPham() {
		return maNhomSanPham;
	}
	public void setMaNhomSanPham(String maNhomSanPham) {
		this.maNhomSanPham = maNhomSanPham;
	}
	public String getTenNhomSanPham() {
		return tenNhomSanPham;
	}
	public void setTenNhomSanPham(String tenNhomSanPham) {
		this.tenNhomSanPham = tenNhomSanPham;
	}

	@Override
	public String toString() {
		return maNhomSanPham;
	}
	
	
	
	
}
