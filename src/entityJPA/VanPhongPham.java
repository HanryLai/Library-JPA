package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "VanPhongPham")

public class VanPhongPham extends SanPham {
	
	@OneToOne
	@JoinColumn(name = "mauSac")
	private MauSac	mauSac;
	
    private String noiSanXuat;

	public VanPhongPham(int maSanPham, String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon,
			double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, double VAT, LocalDateTime ngayTao,
			double giamGia, MauSac mauSac, String noiSanXuat) {
		super(maSanPham,tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, VAT, ngayTao,
				giamGia);
		this.mauSac = mauSac;
		this.noiSanXuat = noiSanXuat;
	}

	@Override
	public String toString() {
		return "VanPhongPham [maSanPham=" + getMaSanPham()
				+ ", tenSanPham=" + getTenSanPham()
				+ ", nhomSanPham=" + getNhomSanPham().getMaNhomSanPham()
				+ ", nhaCungCap=" + getNhaCungCap().getMaNCC()
				+ ", soLuongTon=" + soLuongTon
				+ ", donGiaNhap=" + donGiaNhap
				+ ", moTa=" + moTa
				+ ", tinhTrang=" + tinhTrang
				+ ", donGiaBan=" + donGiaBan
				+ ", VAT=" + VAT
				+ ", ngayTao=" + ngayTao
				+ ", giamGia=" + giamGia
				+ ", mauSac=" + mauSac.getMaMau()
				+ ", noiSanXuat=" + noiSanXuat + "]";
	}
}
