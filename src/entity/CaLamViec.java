package entity;

import java.util.Objects;

public class CaLamViec {
	private String maCa;
	private String tenCa;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	public CaLamViec() {
		
	}
	public CaLamViec(String maCa, String tenCa, String thoiGianBatDau, String thoiGianKetThuc) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
	
	public CaLamViec(String maCa) {
		super();
		this.maCa = maCa;
	}
	public String getMaCa() {
		return maCa;
	}
	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}
	public String getTenCa() {
		return tenCa;
	}
	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	@Override
	public String toString() {
		return "CaLamViec [maCa=" + maCa + ", tenCa=" + tenCa + ", thoiGianBatDau=" + thoiGianBatDau
				+ ", thoiGianKetThuc=" + thoiGianKetThuc + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaLamViec other = (CaLamViec) obj;
		return Objects.equals(maCa, other.maCa);
	}

        
	
	
}
