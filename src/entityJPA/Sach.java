package entityJPA;

import java.time.LocalDate;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sach {
//	[maSanPham] [nvarchar](50) NOT NULL,
//	[tenSanPham] [nvarchar](50) NULL,
//	[nhomSanPham] [nvarchar](50) NULL,
//	[soLuongTon] [int] NULL,
//	[donGiaNhap] [float] NULL,
//	[moTa] [nvarchar](500) NULL,
//	[tinhTrang] [nvarchar](50) NULL,
//	[donGiaBan] [float] NULL,
//	[VAT] [float] NULL,
//	[tacGia] [nvarchar](50) NULL,
//	[namXuatBan] [int] NULL,
//	[nhaSanXuat] [nvarchar](50) NULL,
//	[soTrang] [int] NULL,
//	[ngayTao] [datetime] NULL,
//	[giamGia] [float] NULL,
// CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
	
	@Id
	private String maSanPham;
	
	@Column(columnDefinition = "nvarchar(50)")
	private String tenSanPham;
	@Column(columnDefinition = "nvarchar(50)")
	private String nhomSanPham;
	private int soLuongTon;
	private float donGiaNhap;
	@Column(columnDefinition = "nvarchar(500)")
	private String moTa;
	@Column(columnDefinition = "nvarchar(50)")
	private String tinhTrang;
	private float donGiaBan;
	private float VAT;
	@Column(columnDefinition = "nvarchar(50)")
	private String tacGia;
	private int namXuatBan;
	@Column(columnDefinition = "nvarchar(50)")
	private String nhaSanXuat;
	private int soTrang;
	private LocalDate ngayTao;
	private float giamGia;
	
	
	
}
