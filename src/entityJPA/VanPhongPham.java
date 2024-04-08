package entityJPA;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

@Entity
@Table(name = "VanPhongPham")
@DiscriminatorValue("VanPhongPham")
public class VanPhongPham extends SanPham {
	@ManyToOne
	@JoinColumn(name = "maMau")
	private MauSac mauSac;
	private String noiSanXuat;
	
	public VanPhongPham(String tenSanPham, NhomSanPham nhomSanPham, NhaCungCap nhaCungCap, int soLuongTon,
			double donGiaNhap, String moTa, String tinhTrang, double donGiaBan, LocalDateTime ngayTao, double VAT,
			double giamGia, MauSac mauSac, String noiSanXuat) {
		super(tenSanPham, nhomSanPham, nhaCungCap, soLuongTon, donGiaNhap, moTa, tinhTrang, donGiaBan, ngayTao, VAT,
				giamGia);
		this.mauSac = mauSac;
		this.noiSanXuat = noiSanXuat;
	}

    
}
