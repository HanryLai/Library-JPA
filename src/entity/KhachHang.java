package entity;

import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	private NhomKhachHang nhomKhachHang;
	private double tongTienMua;
	private int soLuongHoaDon;
	
		
	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, NhomKhachHang nhomKhachHang,
			double tongTienMua, int soLuongHoaDon) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.nhomKhachHang = nhomKhachHang;
		this.tongTienMua = tongTienMua;
		this.soLuongHoaDon = soLuongHoaDon;
	}
	 
	public KhachHang (String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	

	public KhachHang() {
		super();
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public NhomKhachHang getNhomKhachHang() {
		return nhomKhachHang;
	}

	public void setNhomKhachHang(NhomKhachHang nhomKhachHang) {
		this.nhomKhachHang = nhomKhachHang;
	}

	public double getTongTienMua() {
		return tongTienMua;
	}
	public void setTongTienMua(double tongTienMua) {
		this.tongTienMua = tongTienMua;
	}
	public int getSoLuongHoaDon() {
		return soLuongHoaDon;
	}
	public void setSoLuongHoaDon(int soLuongHoaDon) {
		this.soLuongHoaDon = soLuongHoaDon;
	}
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.maKhachHang);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKhachHang, other.maKhachHang);
    }
	
}
