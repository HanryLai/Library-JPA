package entity;

public class ChiTietHoanTra {
	private HoaDonHoanTra hoaDonHoanTra;
	private SanPham sanPham;
	private int soLuong;
	private double thanhTien;
	public ChiTietHoanTra() {
	}
	public ChiTietHoanTra(HoaDonHoanTra hoaDonHoanTra, SanPham sanPham, int soLuong, double thanhTien) {
		super();
		this.hoaDonHoanTra = hoaDonHoanTra;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public HoaDonHoanTra getHoaDonHoanTra() {
		return hoaDonHoanTra;
	}
	public void setHoaDonHoanTra(HoaDonHoanTra hoaDonHoanTra) {
		this.hoaDonHoanTra = hoaDonHoanTra;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "ChiTietHoanTra [hoaDonHoanTra=" + hoaDonHoanTra + ", sanPham=" + sanPham + ", soLuong=" + soLuong
				+ ", thanhTien=" + thanhTien + "]";
	}
	
}
