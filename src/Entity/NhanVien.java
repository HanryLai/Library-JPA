package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String hoTenNV;
	private LocalDate ngaySinh;
	private String soDienThoai;
	private String gioiTinh;
	private String email;
	private TaiKhoan taiKhoan;
	private int tinhTrangLamViec;
	private CaLamViec caLamViec;
	private ChucVu chucVu;
	
	
	public NhanVien() {
            super();
        }
	public NhanVien(String ma) {
            super();
            this.maNhanVien = ma;
	}
	public NhanVien(String maNhanVien, String hoTenNV, LocalDate ngaySinh, String soDienThoai, String gioiTinh,
			String email, String taiKhoanStr, int tinhTrangLamViec, String caLamViecStr, ChucVu chucVu) {
		this.maNhanVien = maNhanVien;
		this.hoTenNV = hoTenNV;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.email = email;
                this.taiKhoan = new TaiKhoan(taiKhoanStr);
		this.tinhTrangLamViec = tinhTrangLamViec;
		this.caLamViec =  new CaLamViec(caLamViecStr);
		this.chucVu = chucVu;
	}
        public NhanVien(String maNhanVien, String hoTenNV, LocalDate ngaySinh, String soDienThoai, String gioiTinh,
			String email, int tinhTrangLamViec, String caLamViecStr, ChucVu chucVu) {
		this.maNhanVien = maNhanVien;
		this.hoTenNV = hoTenNV;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.tinhTrangLamViec = tinhTrangLamViec;
		this.caLamViec =  new CaLamViec(caLamViecStr);
		this.chucVu = chucVu;
	}
        public String getTenDangNhap(){ // Lấy tenDangNhap từ TaiKhoan 
            return taiKhoan.getTenDangNhap();
        }
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTenNV() {
		return hoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public int getTinhTrangLamViec() {
		return tinhTrangLamViec;
	}
	public void setTinhTrangLamViec(int tinhTrangLamViec) {
		this.tinhTrangLamViec = tinhTrangLamViec;
	}
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	
	

    public CaLamViec getCaLamViec() {
		return caLamViec;
	}
	public void setCaLamViec(CaLamViec caLamViec) {
		this.caLamViec = caLamViec;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTenNV=" + hoTenNV + ", ngaySinh=" + ngaySinh
				+ ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh + ", email=" + email + ", taiKhoan="
				+ taiKhoan + ", tinhTrangLamViec=" + tinhTrangLamViec + ", caLamViec=" + caLamViec + ", chucVu="
				+ chucVu + "]";
	}
	@Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.maNhanVien);
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNhanVien, other.maNhanVien);
    }
	
	
}
