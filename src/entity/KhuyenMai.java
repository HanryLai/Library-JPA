package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class KhuyenMai {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private String ghiChu;
    private String trangThai;
    private double tiLeKM;
    private double tienToiThieu;
    private double giaTriMAX;   
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
	/**
	 * @return the maKhuyenMai
	 */
	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}
	/**
	 * @param maKhuyenMai the maKhuyenMai to set
	 */
	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	/**
	 * @return the tenKhuyenMai
	 */
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	/**
	 * @param tenKhuyenMai the tenKhuyenMai to set
	 */
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	/**
	 * @return the ghiChu
	 */
	public String getGhiChu() {
		return ghiChu;
	}
	/**
	 * @param ghiChu the ghiChu to set
	 */
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	/**
	 * @return the trangThai
	 */
	public String getTrangThai() {
		return trangThai;
	}
	/**
	 * @param trangThai the trangThai to set
	 */
	public void setTrangThai(String trangThai){
            this.trangThai = trangThai;
	}
	/**
	 * @return the tiLeKM
	 */
	public double getTiLeKM() {
		return tiLeKM;
	}
	/**
	 * @param tiLeKM the tiLeKM to set
	 */
	public void setTiLeKM(double tiLeKM) {
		this.tiLeKM = tiLeKM;
	}
	/**
	 * @return the tienToiThieu
	 */
	public double getTienToiThieu() {
		return tienToiThieu;
	}
	/**
	 * @param tienToiThieu the tienToiThieu to set
	 */
	public void setTienToiThieu(double tienToiThieu) {
		this.tienToiThieu = tienToiThieu;
	}
	/**
	 * @return the giaTriMAX
	 */
	public double getGiaTriMAX() {
		return giaTriMAX;
	}
	/**
	 * @param giaTriMAX the giaTriMAX to set
	 */
	public void setGiaTriMAX(double giaTriMAX) {
		this.giaTriMAX = giaTriMAX;
	}
	/**
	 * @return the ngayBatDau
	 */
	public LocalDateTime getNgayBatDau() {
		return ngayBatDau;
	}
	/**
	 * @param ngayBatDau the ngayBatDau to set
	 */
	public void setNgayBatDau(LocalDateTime ngayBatDau){
            this.ngayBatDau = ngayBatDau;
	}
	/**
	 * @return the ngayKetThuc
	 */
	public LocalDateTime getNgayKetThuc() {
		return ngayKetThuc;
	}
	/**
	 * @param ngayKetThuc the ngayKetThuc to set
	 */
	public void setNgayKetThuc(LocalDateTime ngayKetThuc) throws Exception{
            if(ngayKetThuc.isBefore(ngayBatDau)) {
			throw new Exception("ngày kết thúc phải sau ngày bắt đầu");
		}
            this.ngayKetThuc = ngayKetThuc;
	}
	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String ghiChu, String trangThai, double tiLeKM,
			double tienToiThieu, double giaTriMAX, LocalDateTime ngayBatDau, LocalDateTime ngayKetThuc) throws Exception{
		super();
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.ghiChu = ghiChu;
		setTrangThai(trangThai);
		this.tiLeKM = tiLeKM;
		this.tienToiThieu = tienToiThieu;
		this.giaTriMAX = giaTriMAX;
		setNgayBatDau(ngayBatDau);
		setNgayKetThuc(ngayKetThuc);
	}
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
        public KhuyenMai(String maKhuyeMai) {
		super();
		this.maKhuyenMai = maKhuyeMai;
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKhuyenMai=" + maKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", ghiChu=" + ghiChu
				+ ", trangThai=" + trangThai + ", tiLeKM=" + tiLeKM + ", tienToiThieu=" + tienToiThieu + ", giaTriMAX="
				+ giaTriMAX + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "]";
	}
 
    
}
