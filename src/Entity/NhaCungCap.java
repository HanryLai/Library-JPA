package Entity;

import java.util.Objects;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String diaChiNCC;
	private String soDienThoai;
	private String email;
	private String ghiChu;
	
	
	public NhaCungCap() {
		
	}
	public NhaCungCap(String maNCC, String tenNCC, String diaChiNCC, String soDienThoai, String email, String ghiChu) {
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChiNCC = diaChiNCC;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.ghiChu = ghiChu;
	}
	
	public NhaCungCap(String maNCC) {
		super();
		this.maNCC = maNCC;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiaChiNCC() {
		return diaChiNCC;
	}
	public void setDiaChiNCC(String diaChiNCC) {
		this.diaChiNCC = diaChiNCC;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return maNCC;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.maNCC);
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
        final NhaCungCap other = (NhaCungCap) obj;
        return Objects.equals(this.maNCC, other.maNCC);
    }
	
	
}
