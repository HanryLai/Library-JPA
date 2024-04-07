package Entity;

import java.util.Objects;

public class MauSac {
	private String maMau;
	private String tenMau;
	public MauSac() {

	}
	public MauSac(String maMau, String tenMau) {
		super();
		this.maMau = maMau;
		this.tenMau = tenMau;
	}
	public MauSac(String maMau) {
		super();
		this.maMau = maMau;
	}
	public String getMaMau() {
		return maMau;
	}
	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	@Override
	public String toString() {
		return maMau;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.maMau);
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
        final MauSac other = (MauSac) obj;
        return Objects.equals(this.maMau, other.maMau);
    }
	
	
}
