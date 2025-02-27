USE [master]
GO
/****** Object:  Database [QuanLyHieuSachONEEIGHT]    Script Date: 12/5/2023 12:32:40 PM ******/
CREATE DATABASE [QuanLyHieuSachONEEIGHT]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyHieuSachONEEIGHT].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyHieuSachONEEIGHT]
GO
/****** Object:  Table [dbo].[BanBaoCao]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BanBaoCao](
	[maBanBaoCao] [nvarchar](50) NOT NULL,
	[tenBanBaoCao] [nvarchar](50) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[doanhThu] [float] NOT NULL,
	[thoiGianBaoCao] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_BanBaoCao] PRIMARY KEY CLUSTERED 
(
	[maBanBaoCao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CaLamViec]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CaLamViec](
	[maCa] [nvarchar](50) NOT NULL,
	[tenCa] [nvarchar](50) NULL,
	[thoiGianBatDau] [nvarchar](50) NULL,
	[thoiGianKetThuc] [nvarchar](50) NULL,
 CONSTRAINT [PK_CaLamViec] PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietBanBaoCao]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietBanBaoCao](
	[banBaoCao] [nvarchar](50) NOT NULL,
	[sanPham] [nvarchar](50) NOT NULL,
	[soLuongBan] [int] NULL,
	[thanhTien] [float] NULL,
	[soLuongNhap] [int] NULL,
	[tonKho] [int] NULL,
	[ghiChu] [nvarchar](500) NULL,
 CONSTRAINT [PK_ChiTietBanBaoCao] PRIMARY KEY CLUSTERED 
(
	[banBaoCao] ASC,
	[sanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDoiHang]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDoiHang](
	[hoaDonDoiHang] [nvarchar](50) NOT NULL,
	[sanPham] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[thanhTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietDoiHang] PRIMARY KEY CLUSTERED 
(
	[hoaDonDoiHang] ASC,
	[sanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[hoaDon] [nvarchar](50) NOT NULL,
	[sanPham] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[hoaDon] ASC,
	[sanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoanTra]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoanTra](
	[hoaDonHoanTra] [nvarchar](50) NOT NULL,
	[sanPham] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
 CONSTRAINT [PK_ChiTietHoanTra] PRIMARY KEY CLUSTERED 
(
	[hoaDonHoanTra] ASC,
	[sanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[ngayLap] [datetime] NULL,
	[nhanVien] [nvarchar](50) NULL,
	[khachHang] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](500) NULL,
	[tinhTrangHoaDon] [int] NULL,
	[tongTien] [float] NULL,
	[chietKhau] [float] NULL,
	[khuyenMai] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonDoiHang]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonDoiHang](
	[maHoaDonDoi] [nvarchar](50) NOT NULL,
	[hoaDonHoanTra] [nvarchar](50) NOT NULL,
	[ghiChu] [nvarchar](500) NULL,
	[tienHoanTra] [float] NOT NULL,
	[chietKhau] [float] NULL,
	[khuyenMai] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDonDoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonHoanTra]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonHoanTra](
	[maHoaDonHoanTra] [nvarchar](50) NOT NULL,
	[ngayHoan] [datetime] NULL,
	[nhanVien] [nvarchar](50) NULL,
	[hoaDon] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](500) NULL,
	[tinhTrangHoaDon] [int] NULL,
	[tienHoanTra] [float] NULL,
 CONSTRAINT [PK_HoaDonHoanTra] PRIMARY KEY CLUSTERED 
(
	[maHoaDonHoanTra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](50) NOT NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[soDienThoai] [nvarchar](50) NULL,
	[tongTienMua] [float] NULL,
	[soLuongHoaDon] [int] NULL,
	[nhomKhachHang] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKhuyenMai] [nvarchar](50) NOT NULL,
	[tenKhuyenMai] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](100) NULL,
	[trangThai] [nvarchar](50) NULL,
	[tyLeKhuyenMai] [float] NULL,
	[tienToiThieu] [float] NULL,
	[giaTriKhuyenMaiToiDa] [float] NULL,
	[ngayBatDau] [datetime] NULL,
	[ngayKetThuc] [datetime] NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[maMau] [nvarchar](50) NOT NULL,
	[tenMau] [nvarchar](50) NULL,
 CONSTRAINT [PK_MauSac] PRIMARY KEY CLUSTERED 
(
	[maMau] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [nvarchar](50) NOT NULL,
	[tenNCC] [nvarchar](50) NULL,
	[diachiNCC] [nvarchar](50) NULL,
	[soDienThoai] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](500) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[hoTenNV] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[soDienthoaiNV] [nvarchar](50) NULL,
	[gioiTinh] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[taiKhoan] [nvarchar](50) NULL,
	[tinhTrangLamViec] [int] NULL,
	[caLamViec] [nvarchar](50) NULL,
	[chucVu] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhomSanPham]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomSanPham](
	[maNhomSanPham] [nvarchar](50) NOT NULL,
	[tenNhomSanPham] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhomSanPham] PRIMARY KEY CLUSTERED 
(
	[maNhomSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[maSanPham] [nvarchar](50) NOT NULL,
	[tenSanPham] [nvarchar](50) NULL,
	[nhomSanPham] [nvarchar](50) NULL,
	[nhaCungCap] [nvarchar](50) NULL,
	[soLuongTon] [int] NULL,
	[donGiaNhap] [float] NULL,
	[moTa] [nvarchar](500) NULL,
	[tinhTrang] [nvarchar](50) NULL,
	[donGiaBan] [float] NULL,
	[VAT] [float] NULL,
	[tacGia] [nvarchar](50) NULL,
	[namXuatBan] [int] NULL,
	[nhaSanXuat] [nvarchar](50) NULL,
	[soTrang] [int] NULL,
	[ngayTao] [datetime] NULL,
	[giamGia] [float] NULL,
 CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenDangNhap] [nvarchar](50) NOT NULL,
	[matkhau] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VanPhongPham]    Script Date: 12/14/2023 2:29:22 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VanPhongPham](
	[maSanPham] [nvarchar](50) NOT NULL,
	[tenSanPham] [nvarchar](50) NULL,
	[nhomSanPham] [nvarchar](50) NULL,
	[nhaCungCap] [nvarchar](50) NULL,
	[soLuongTon] [int] NULL,
	[donGiaNhap] [float] NULL,
	[moTa] [nvarchar](500) NULL,
	[donGiaBan] [float] NULL,
	[VAT] [float] NULL,
	[mauSac] [nvarchar](50) NULL,
	[noiSanXuat] [nvarchar](50) NULL,
	[ngayTao] [datetime] NULL,
	[giamGia] [float] NULL,
	[tinhTrang] [nvarchar](50) NULL,
 CONSTRAINT [PK_VanPhongPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BanBaoCao] ([maBanBaoCao], [tenBanBaoCao], [tenNhanVien], [doanhThu], [thoiGianBaoCao]) VALUES (N'BC13122023DTBHChieu', N'BaoCaoDoanhThu13122023Chieu', N'Võ Thị Kim Anh', 929500, N'13/12/2023-Chieu')
INSERT [dbo].[BanBaoCao] ([maBanBaoCao], [tenBanBaoCao], [tenNhanVien], [doanhThu], [thoiGianBaoCao]) VALUES (N'BC13122023DTBHSang', N'BaoCaoDoanhThu13122023Sang', N'Võ Thị Kim Anh', 184000, N'13/12/2023-Sang')
INSERT [dbo].[BanBaoCao] ([maBanBaoCao], [tenBanBaoCao], [tenNhanVien], [doanhThu], [thoiGianBaoCao]) VALUES (N'BC14122023DTBHSang', N'BaoCaoDoanhThu14122023Sang', N'Võ Thị Kim Anh', 87000, N'14/12/2023-Sang')
GO
INSERT [dbo].[CaLamViec] ([maCa], [tenCa], [thoiGianBatDau], [thoiGianKetThuc]) VALUES (N'CA01', N'Sáng', N'6:00', N'11:00')
INSERT [dbo].[CaLamViec] ([maCa], [tenCa], [thoiGianBatDau], [thoiGianKetThuc]) VALUES (N'CA02', N'Chiều', N'11:00', N'16:00')
INSERT [dbo].[CaLamViec] ([maCa], [tenCa], [thoiGianBatDau], [thoiGianKetThuc]) VALUES (N'CA03', N'Tối', N'16:00', N'21:00')
GO
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHChieu', N'Bách Khoa Toàn Thư Về Địa Lý', 2, 338000, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHChieu', N'Cây Cam Ngọt Của Tôi ', 1, 106500, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHChieu', N'Hồi Ký Lý Quang Diệu', 1, 416000, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHChieu', N'Mười Ba', 1, 22500, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHChieu', N'Tiếng Việt Chân Trời Sáng Tạo', 1, 46500, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHSang', N'Bách Khoa Toàn Thư Về Địa Lý', 1, 169000, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC13122023DTBHSang', N'Bìa Acco Nhựa A4 - FO-PPFFA4 - Màu Lá', 1, 15000, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC14122023DTBHSang', N'Bấm Kim Số 3 - Màu Xanh Dương', 1, 15000, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC14122023DTBHSang', N'Tiếng Việt Lớp 1 - Tập 1', 1, 36000, 0, 0, N'')
INSERT [dbo].[ChiTietBanBaoCao] ([banBaoCao], [sanPham], [soLuongBan], [thanhTien], [soLuongNhap], [tonKho], [ghiChu]) VALUES (N'BC14122023DTBHSang', N'Tiếng Việt Lớp 1 - Tập 2', 1, 36000, 0, 0, N'')
GO
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD03122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD03122023-000001', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD03122023-000002', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD03122023-000002', N'S23102023-000005', 1, 50700)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD04122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD04122023-000002', N'S23102023-000001', 2, 124800)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD04122023-000002', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietDoiHang] ([hoaDonDoiHang], [sanPham], [soLuong], [thanhTien]) VALUES (N'HDD14122023-000001', N'S01122022-000001', 1, 32500)
GO
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000003', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000004', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000005', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000005', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000005', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD03122023-000005', N'S23102023-000004', 1, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000003', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000004', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000004', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000004', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000004', N'S23102023-000004', 1, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000005', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000005', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000005', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000005', N'S23102023-000004', 1, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000006', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000006', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000006', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000006', N'S23102023-000004', 1, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000007', N'S23102023-000001', 2, 124800)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000007', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000008', N'S23102023-000001', 2, 124800)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000008', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000009', N'S23102023-000001', 2, 124800)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000009', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD04122023-000010', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000001', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000003', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000003', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000003', N'S23102023-000003', 10, 617500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000004', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000004', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000004', N'S24102023-000006', 1, 32500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000005', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000006', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD05122023-000007', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000001', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000001', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000002', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000002', N'S23102023-000004', 6, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000003', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000003', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000003', N'S23102023-000004', 7, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000004', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000004', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000004', N'S23102023-000004', 2, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000005', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000005', N'S23102023-000004', 2, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000005', N'S24102023-000006', 1, 32500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000006', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000006', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000007', N'S23102023-000004', 2, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000008', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000008', N'S23102023-000004', 1, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000009', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000009', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000009', N'S23102023-000004', 2, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000010', N'S23102023-000004', 2, 99190)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000011', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD06122023-000011', N'S23102023-000004', 6, 595140)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000001', N'S01122022-000001', 1, 32500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000001', N'S24102023-000007', 29, 4901000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000002', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000003', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000004', N'S10012023-000001', 1, 46500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000005', N'S10012023-000003', 1, 111000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000006', N'S10052023-000003', 1, 36000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD12122023-000007', N'S10052023-000007', 1, 36000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000001', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000002', N'S01122022-000004', 1, 22500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000003', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000003', N'S10012023-000001', 1, 46500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000003', N'S10012023-000002', 1, 106500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000004', N'S01122022-000003', 1, 416000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000005', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000005', N'S01122022-000003', 1, 416000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000005', N'S01122022-000004', 1, 22500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000005', N'S10012023-000002', 90, 9585000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000006', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD13122023-000006', N'VPP15062023-000005', 1, 15000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000001', N'S10052023-000001', 1, 36000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000001', N'S10052023-000002', 1, 36000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000001', N'VPP15062023-000008', 1, 15000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000002', N'S01122022-000004', 4, 90000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000002', N'S23102023-000003', 7, 432250)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000003', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000003', N'S01122022-000004', 1, 22500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000004', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000005', N'S01122022-000001', 1, 32500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000006', N'S01122022-000001', 1, 32500)
INSERT [dbo].[ChiTietHoaDon] ([hoaDon], [sanPham], [soLuong], [thanhTien]) VALUES (N'HD14122023-000007', N'S01122022-000001', 1, 32500)
GO
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT03122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT03122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT03122023-000003', N'S23102023-000003', 1, 61750)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT03122023-000003', N'S23102023-000004', 1, 99190)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT04122023-000001', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT04122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT04122023-000003', N'S23102023-000001', 2, 124800)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT04122023-000003', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT06122023-000001', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT06122023-000002', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT06122023-000003', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT06122023-000003', N'S23102023-000002', 1, 143000)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT06122023-000004', N'S23102023-000001', 1, 62400)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT06122023-000005', N'S23102023-000004', 2, 198380)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT13122023-000001', N'S01122022-000001', 1, 32500)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT13122023-000002', N'S01122022-000004', 1, 22500)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT14122023-000001', N'S01122022-000004', 1, 22500)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT14122023-000002', N'S01122022-000002', 1, 169000)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT14122023-000003', N'S01122022-000001', 1, 32500)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT14122023-000004', N'S10052023-000001', 1, 36000)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT14122023-000005', N'S01122022-000001', 1, 32500)
INSERT [dbo].[ChiTietHoanTra] ([hoaDonHoanTra], [sanPham], [soLuong], [thanhTien]) VALUES (N'HT14122023-000006', N'S01122022-000001', 1, 32500)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD01022023-000001', CAST(N'2023-02-01T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD02022023-000001', CAST(N'2023-02-02T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 11153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03012023-000001', CAST(N'2023-01-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03022023-000001', CAST(N'2023-02-03T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03032023-000001', CAST(N'2023-03-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03042023-000001', CAST(N'2023-04-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5660, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03052023-000001', CAST(N'2023-05-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03062023-000001', CAST(N'2023-06-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03072023-000001', CAST(N'2023-07-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03082023-000001', CAST(N'2023-08-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03092023-000001', CAST(N'2023-09-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03102023-000001', CAST(N'2023-10-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03122023-000001', CAST(N'2023-12-03T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03122023-000002', CAST(N'2023-12-03T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', -1, 53040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03122023-000003', CAST(N'2023-12-03T00:49:42.137' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', -1, 53040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03122023-000004', CAST(N'2023-12-03T00:50:12.030' AS DateTime), N'QL23102023-000007', N'KH03122023-000007', N'', 1, 142142, 0, N'FREE')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD03122023-000005', CAST(N'2023-12-03T16:06:10.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', -1, 348023, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04012023-000001', CAST(N'2023-01-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04022023-000001', CAST(N'2023-02-04T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04032023-000001', CAST(N'2023-03-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04042023-000001', CAST(N'2023-04-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1560, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04052023-000001', CAST(N'2023-05-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04062023-000001', CAST(N'2023-06-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04072023-000001', CAST(N'2023-07-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04082023-000001', CAST(N'2023-08-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04092023-000001', CAST(N'2023-09-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04102023-000001', CAST(N'2023-10-04T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1561160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000001', CAST(N'2023-12-04T10:53:20.853' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 59280, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000002', CAST(N'2023-12-04T10:53:28.293' AS DateTime), N'QL23102023-000007', N'KH04122023-000001', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000003', CAST(N'2023-12-04T10:53:59.453' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 53040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000004', CAST(N'2023-12-04T11:09:34.967' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 348023, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000005', CAST(N'2023-12-04T11:09:57.703' AS DateTime), N'QL23102023-000007', N'KH04122023-000002', N'', 1, 356340, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000006', CAST(N'2023-12-04T11:10:19.197' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 338023, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000007', CAST(N'2023-12-04T11:16:19.607' AS DateTime), N'QL23102023-000007', N'KH04122023-000003', N'', 1, 267800, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000008', CAST(N'2023-12-04T11:16:27.973' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 254410, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000009', CAST(N'2023-12-04T11:16:49.540' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', -1, 244410, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD04122023-000010', CAST(N'2023-12-04T13:48:56.657' AS DateTime), N'QL23102023-000007', N'KH04122023-000004', N'', -1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05012023-000001', CAST(N'2023-01-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05022023-000001', CAST(N'2023-02-05T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05032023-000001', CAST(N'2023-03-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05042023-000001', CAST(N'2023-04-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 11160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05052023-000001', CAST(N'2023-05-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05062023-000001', CAST(N'2023-06-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05072023-000001', CAST(N'2023-07-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05082023-000001', CAST(N'2023-08-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05092023-000001', CAST(N'2023-09-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05102023-000001', CAST(N'2023-10-05T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000001', CAST(N'2023-12-05T13:09:18.800' AS DateTime), N'QL23102023-000007', N'KH05122023-000005', N'', 0, 61750, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000002', CAST(N'2023-12-05T12:55:16.960' AS DateTime), N'QL23102023-000007', N'KH25102023-000001', N'', 1, 62400, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000003', CAST(N'2023-12-05T12:44:21.180' AS DateTime), N'QL23102023-000007', N'KH25102023-000001', N'', 0, 812900, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000004', CAST(N'2023-12-05T12:44:30.500' AS DateTime), N'QL23102023-000007', N'KH05122023-000001', N'', 1, 227250, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000005', CAST(N'2023-12-05T12:52:32.317' AS DateTime), N'QL23102023-000007', N'KH05122023-000002', N'', 1, 61750, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000006', CAST(N'2023-12-05T12:53:32.117' AS DateTime), N'QL23102023-000007', N'KH05122023-000003', N'', 1, 143000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD05122023-000007', CAST(N'2023-12-05T12:54:18.900' AS DateTime), N'QL23102023-000007', N'KH05122023-000004', N'', 1, 143000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06012023-000001', CAST(N'2023-01-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06022023-000001', CAST(N'2023-02-06T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06032023-000001', CAST(N'2023-03-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 111156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06042023-000001', CAST(N'2023-04-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06052023-000001', CAST(N'2023-05-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06062023-000001', CAST(N'2023-06-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06072023-000001', CAST(N'2023-07-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06082023-000001', CAST(N'2023-08-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06092023-000001', CAST(N'2023-09-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06102023-000001', CAST(N'2023-10-06T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 561111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000001', CAST(N'2023-12-06T20:03:04.420' AS DateTime), N'QL23102023-000007', N'KH06122023-000001', N'', 0, 267150, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000002', CAST(N'2023-12-06T21:05:57.573' AS DateTime), N'QL23102023-000007', N'KH06122023-000003', N'', 0, 304590, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000003', CAST(N'2023-12-06T21:43:58.190' AS DateTime), N'QL23102023-000007', N'KH06122023-000004', N'', -1, 303940, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000004', CAST(N'2023-12-06T21:38:24.917' AS DateTime), N'QL23102023-000007', N'KH06122023-000005', N'', -1, 304590, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000005', CAST(N'2023-12-06T21:34:41.057' AS DateTime), N'QL23102023-000007', N'KH06122023-000006', N'', 1, 307190, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000006', CAST(N'2023-12-06T21:36:28.103' AS DateTime), N'QL23102023-000007', N'KH06122023-000007', N'', 1, 204750, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000007', CAST(N'2023-12-06T21:37:32.590' AS DateTime), N'QL23102023-000007', N'KH06122023-000008', N'', -1, 99190, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000008', CAST(N'2023-12-06T21:38:56.047' AS DateTime), N'QL23102023-000007', N'KH06122023-000009', N'', -1, 242190, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000009', CAST(N'2023-12-06T21:39:41.340' AS DateTime), N'QL23102023-000007', N'KH06122023-000010', N'', -1, 304590, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000010', CAST(N'2023-12-06T22:06:08.613' AS DateTime), N'QL23102023-000007', N'KH06122023-000011', N'', 0, 99190, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD06122023-000011', CAST(N'2023-12-06T22:09:55.153' AS DateTime), N'QL23102023-000007', N'KH06122023-000012', N'', 1, 657540, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07012023-000001', CAST(N'2023-01-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07022023-000001', CAST(N'2023-02-07T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 53040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07032023-000001', CAST(N'2023-03-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07042023-000001', CAST(N'2023-04-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 560, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07052023-000001', CAST(N'2023-05-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07062023-000001', CAST(N'2023-06-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07072023-000001', CAST(N'2023-07-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07082023-000001', CAST(N'2023-08-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07092023-000001', CAST(N'2023-09-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD07102023-000001', CAST(N'2023-10-07T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08012023-000001', CAST(N'2023-01-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08022023-000001', CAST(N'2023-02-08T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08032023-000001', CAST(N'2023-03-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08042023-000001', CAST(N'2023-04-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08052023-000001', CAST(N'2023-05-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08062023-000001', CAST(N'2023-06-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08072023-000001', CAST(N'2023-07-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08082023-000001', CAST(N'2023-08-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08092023-000001', CAST(N'2023-09-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD08102023-000001', CAST(N'2023-10-08T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09012023-000001', CAST(N'2023-01-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09022023-000001', CAST(N'2023-02-09T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09032023-000001', CAST(N'2023-03-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09042023-000001', CAST(N'2023-04-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09052023-000001', CAST(N'2023-05-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09062023-000001', CAST(N'2023-06-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09072023-000001', CAST(N'2023-07-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 15611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09082023-000001', CAST(N'2023-08-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 15611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09092023-000001', CAST(N'2023-09-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 15611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD09102023-000001', CAST(N'2023-10-09T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 15611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10012023-000001', CAST(N'2023-01-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10022023-000001', CAST(N'2023-02-10T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 111153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10032023-000001', CAST(N'2023-03-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10042023-000001', CAST(N'2023-04-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10052023-000001', CAST(N'2023-05-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10062023-000001', CAST(N'2023-06-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10072023-000001', CAST(N'2023-07-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10082023-000001', CAST(N'2023-08-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10092023-000001', CAST(N'2023-09-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD10102023-000001', CAST(N'2023-10-10T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 561111160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11012023-000001', CAST(N'2023-01-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11022023-000001', CAST(N'2023-02-11T00:48:27.687' AS DateTime), N'QL23102023-000007', N'KH03122023-000001', N'', 1, 1111153040, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11032023-000001', CAST(N'2023-03-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11042023-000001', CAST(N'2023-04-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 560, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11052023-000001', CAST(N'2023-05-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11062023-000001', CAST(N'2023-06-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11072023-000001', CAST(N'2023-07-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11082023-000001', CAST(N'2023-08-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11092023-000001', CAST(N'2023-09-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD11102023-000001', CAST(N'2023-10-11T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 5611160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12012023-000001', CAST(N'2023-01-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12032023-000001', CAST(N'2023-03-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12042023-000001', CAST(N'2023-04-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 11160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12052023-000001', CAST(N'2023-05-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 115116160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12062023-000001', CAST(N'2023-06-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12072023-000001', CAST(N'2023-07-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12082023-000001', CAST(N'2023-08-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12092023-000001', CAST(N'2023-09-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12102023-000001', CAST(N'2023-10-12T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000001', CAST(N'2023-12-12T21:48:30.957' AS DateTime), N'QL23102023-000007', N'KH30122021-000031', N'', 1, 32500, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000002', CAST(N'2023-12-12T21:48:45.317' AS DateTime), N'QL23102023-000007', N'KH30062021-000020', N'', 0, 159000, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000003', CAST(N'2023-12-12T22:22:25.677' AS DateTime), N'QL23102023-000007', N'KH30062021-000020', N'', 0, 169000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000004', CAST(N'2023-12-12T22:22:31.237' AS DateTime), N'QL23102023-000007', N'KH29062021-000025', N'', 0, 46500, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000005', CAST(N'2023-12-12T22:22:35.670' AS DateTime), N'QL23102023-000007', N'KH28012021-000018', N'', 0, 111000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000006', CAST(N'2023-12-12T22:22:40.230' AS DateTime), N'QL23102023-000007', N'KH28012021-000018', N'', 0, 36000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD12122023-000007', CAST(N'2023-12-12T22:22:46.053' AS DateTime), N'QL23102023-000007', N'KH28082021-000054', N'', 0, 36000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13012023-000001', CAST(N'2023-01-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13032023-000001', CAST(N'2023-03-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13042023-000001', CAST(N'2023-04-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 560, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13052023-000001', CAST(N'2023-05-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13062023-000001', CAST(N'2023-06-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13072023-000001', CAST(N'2023-07-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 56160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13082023-000001', CAST(N'2023-08-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 561160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13092023-000001', CAST(N'2023-09-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 561160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13102023-000001', CAST(N'2023-10-13T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 561160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13122023-000001', CAST(N'2023-12-13T14:10:18.520' AS DateTime), N'QL23102023-000007', N'KH30102021-000034', N'', 0, 169000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13122023-000002', CAST(N'2023-12-13T14:10:39.350' AS DateTime), N'QL23102023-000007', N'KH29062021-000038', N'', -1, 22500, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13122023-000003', CAST(N'2023-12-13T15:03:47.670' AS DateTime), N'QL23102023-000007', N'KH30122021-000031', N'', 0, 312000, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13122023-000004', CAST(N'2023-12-13T15:19:22.363' AS DateTime), N'QL23102023-000007', N'KH29062021-000025', N'', 1, 416000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13122023-000005', CAST(N'2023-12-13T19:40:14.640' AS DateTime), N'QL23102023-000007', N'KH13122023-000001', N'', 0, 10272500, 100000, N'RFNKOAWBNF')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD13122023-000006', CAST(N'2023-12-13T10:16:22.030' AS DateTime), N'QL23102023-000007', N'KH13122023-000002', N'', 1, 184000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14012023-000001', CAST(N'2023-01-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14032023-000001', CAST(N'2023-03-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14042023-000001', CAST(N'2023-04-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 11160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14052023-000001', CAST(N'2023-05-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14062023-000001', CAST(N'2023-06-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14072023-000001', CAST(N'2023-07-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14082023-000001', CAST(N'2023-08-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14092023-000001', CAST(N'2023-09-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14102023-000001', CAST(N'2023-10-14T00:47:46.920' AS DateTime), N'QL23102023-000007', N'KH03122023-000006', N'', 1, 1156160, 0, N'aaa')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000001', CAST(N'2023-12-14T08:07:26.640' AS DateTime), N'QL23102023-000007', N'KH14122023-000001', N'', -1, 87000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000002', CAST(N'2023-12-14T01:58:03.560' AS DateTime), N'QL23102023-000007', N'KH13122023-000001', N'ban hang', -1, 512250, 10000, N'RFNKOAWBNF')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000003', CAST(N'2023-12-14T01:57:41.400' AS DateTime), N'QL23102023-000007', N'KH30122021-000031', N'', 1, 193500, 2000, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000004', CAST(N'2023-12-14T02:03:39.493' AS DateTime), N'QL23102023-000007', N'KH13122023-000001', N'', -1, 169000, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000005', CAST(N'2023-12-14T02:08:14.710' AS DateTime), N'QL23102023-000007', N'KH13122023-000001', N'', -1, 32500, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000006', CAST(N'2023-12-14T02:10:15.213' AS DateTime), N'QL23102023-000007', N'KH13122023-000001', N'', -1, 32500, 0, N'')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [nhanVien], [khachHang], [ghiChu], [tinhTrangHoaDon], [tongTien], [chietKhau], [khuyenMai]) VALUES (N'HD14122023-000007', CAST(N'2023-12-14T02:13:32.317' AS DateTime), N'QL23102023-000007', N'KH13122023-000001', N'', -1, 32500, 0, N'')
GO
INSERT [dbo].[HoaDonDoiHang] ([maHoaDonDoi], [hoaDonHoanTra], [ghiChu], [tienHoanTra], [chietKhau], [khuyenMai]) VALUES (N'HDD03122023-000001', N'HT03122023-000002', N'', 195130, 0, N'')
INSERT [dbo].[HoaDonDoiHang] ([maHoaDonDoi], [hoaDonHoanTra], [ghiChu], [tienHoanTra], [chietKhau], [khuyenMai]) VALUES (N'HDD03122023-000002', N'HT03122023-000003', N'', 184015, 0, N'')
INSERT [dbo].[HoaDonDoiHang] ([maHoaDonDoi], [hoaDonHoanTra], [ghiChu], [tienHoanTra], [chietKhau], [khuyenMai]) VALUES (N'HDD04122023-000001', N'HT04122023-000002', N'', 56160, 0, N'aaa')
INSERT [dbo].[HoaDonDoiHang] ([maHoaDonDoi], [hoaDonHoanTra], [ghiChu], [tienHoanTra], [chietKhau], [khuyenMai]) VALUES (N'HDD04122023-000002', N'HT04122023-000003', N'', 244410, 0, N'aaa')
INSERT [dbo].[HoaDonDoiHang] ([maHoaDonDoi], [hoaDonHoanTra], [ghiChu], [tienHoanTra], [chietKhau], [khuyenMai]) VALUES (N'HDD14122023-000001', N'HT14122023-000006', N'', 32500, 0, N'')
GO
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT03122023-000001', CAST(N'2023-12-03T01:07:42.910' AS DateTime), N'QL23102023-000007', N'HD03122023-000002', N'', 1, 53040)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT03122023-000002', CAST(N'2023-12-03T01:10:23.173' AS DateTime), N'QL23102023-000007', N'HD03122023-000003', N'', 1, 53040)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT03122023-000003', CAST(N'2023-12-03T16:06:42.647' AS DateTime), N'QL23102023-000007', N'HD03122023-000005', N'', 1, 152893)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT04122023-000001', CAST(N'2023-12-04T14:36:48.603' AS DateTime), N'QL23102023-000007', N'HD04122023-000010', N'', 1, 56160)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT04122023-000002', CAST(N'2023-12-04T14:38:42.203' AS DateTime), N'QL23102023-000007', N'HD04122023-000010', N'', 1, 56160)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT04122023-000003', CAST(N'2023-12-04T14:40:18.300' AS DateTime), N'QL23102023-000007', N'HD04122023-000009', N'', 1, 244410)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT06122023-000001', CAST(N'2023-12-06T21:50:32.013' AS DateTime), N'QL23102023-000007', N'HD06122023-000003', N'', 1, 143000)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT06122023-000002', CAST(N'2023-12-06T21:52:42.763' AS DateTime), N'QL23102023-000007', N'HD06122023-000009', N'', 1, 62400)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT06122023-000003', CAST(N'2023-12-06T21:52:52.060' AS DateTime), N'QL23102023-000007', N'HD06122023-000008', N'', 1, 242190)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT06122023-000004', CAST(N'2023-12-06T21:55:32.627' AS DateTime), N'QL23102023-000007', N'HD06122023-000004', N'', 1, 62400)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT06122023-000005', CAST(N'2023-12-06T21:58:45.597' AS DateTime), N'QL23102023-000007', N'HD06122023-000007', N'', 1, 99190)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT13122023-000001', CAST(N'2023-12-13T15:17:06.300' AS DateTime), N'QL23102023-000007', N'HD12122023-000001', N'', 1, 32500)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT13122023-000002', CAST(N'2023-12-13T15:19:05.253' AS DateTime), N'QL23102023-000007', N'HD13122023-000002', N'', 1, 22500)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT14122023-000001', CAST(N'2023-12-14T02:00:58.063' AS DateTime), N'QL23102023-000007', N'HD14122023-000002', N'', 1, 22500)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT14122023-000002', CAST(N'2023-12-14T02:03:58.757' AS DateTime), N'QL23102023-000007', N'HD14122023-000004', N'', 1, 169000)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT14122023-000003', CAST(N'2023-12-14T02:09:18.660' AS DateTime), N'QL23102023-000007', N'HD14122023-000005', N'', 1, 32500)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT14122023-000004', CAST(N'2023-12-14T02:10:31.683' AS DateTime), N'QL23102023-000007', N'HD14122023-000001', N'', 1, 36000)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT14122023-000005', CAST(N'2023-12-14T02:11:52.550' AS DateTime), N'QL23102023-000007', N'HD14122023-000006', N'', 1, 32500)
INSERT [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra], [ngayHoan], [nhanVien], [hoaDon], [ghiChu], [tinhTrangHoaDon], [tienHoanTra]) VALUES (N'HT14122023-000006', CAST(N'2023-12-14T02:14:06.403' AS DateTime), N'QL23102023-000007', N'HD14122023-000007', N'', 1, 32500)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH01042021-000001', N'Phan Văn Quyết', N'0809909865', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH01102021-000030', N'Lê Văn Vinh', N'0981353188', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH02022021-000049', N'Nguyễn Bảo Nhật Lệ', N'0751681684', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03042021-000012', N'Nguyễn Viết Tịnh', N'0723031756', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000001', N'A', N'0965180419', 1751289, 9, N'KHACHVIP')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000002', N'Khách lẻ', N'', 56160, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000003', N'Khách lẻ', N'', 133000, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000004', N'Khách lẻ', N'', 0, 0, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000005', N'Khách lẻ', N'', 143000, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000006', N'Khách lẻ', N'', 56160, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH03122023-000007', N'Khách lẻ', N'', 142142, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH04122023-000001', N'Khách lẻ', N'', 56160, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH04122023-000002', N'Khách lẻ', N'', 356340, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH04122023-000003', N'Khách lẻ', N'', 267800, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH04122023-000004', N'Khách lẻ', N'', 56160, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05022021-000003', N'Phạm Ái Linh', N'0987486132', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05032021-000057', N'Lê Nhật Minh', N'0716161681', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05062021-000022', N'Hoàng Bảo Ngọc', N'0784651113', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05092021-000040', N'Nguyễn Huyền Trang', N'0354654677', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05092021-000042', N'Lê Quốc Bình', N'0971231234', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05122023-000001', N'Khách lẻ', N'', 227250, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05122023-000002', N'Khách lẻ', N'', 61750, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05122023-000003', N'Khách lẻ', N'', 143000, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05122023-000004', N'Khách lẻ', N'', 143000, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH05122023-000005', N'Khách lẻ', N'', 0, 0, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000001', N'Khách lẻ', N'', 0, 0, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000002', N'Khách lẻ', N'', 0, 0, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000003', N'Khách lẻ', N'', 0, 0, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000004', N'Khách lẻ', N'', 303940, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000005', N'Khách lẻ', N'', 304590, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000006', N'Khách lẻ', N'', 307190, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000007', N'Khách lẻ', N'', 204750, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000008', N'Khách lẻ', N'', 99190, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000009', N'Khách lẻ', N'', 242190, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000010', N'Khách lẻ', N'', 304590, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000011', N'Khách lẻ', N'', 0, 0, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH06122023-000012', N'Khách lẻ', N'', 657540, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH07062021-000023', N'La Vân Hy', N'0987411444', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH08052021-000026', N'Anh Ðức', N'0988545716', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH08082021-000047', N'Phạm Thị Mỹ Tuyền', N'0323031645', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH09022021-000014', N'Phạm Hùng Cường', N'0934553252', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH09032021-000059', N'Trần Hải Bằng', N'0756235633', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH09082021-000009', N'Nguyễn Hồng Huy', N'0792030217', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH10032021-000013', N'Phạm Anh Khoa', N'0872030020', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH10082021-000052', N'Võ Đức Hòa', N'0976016351', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH12082021-000010', N'Đỗ Phúc Hưng ', N'0564464168', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH12092021-000063', N'Phạm Gia Phúc', N'0798548646', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH13062021-000039', N'Nguyễn Khánh Ngọc', N'0317861122', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH13102021-000008', N'Huỳnh Việt Nhật', N'0393536342', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH13122023-000001', N'Nguyen Chau Tinh', N'0965180417', 746250, 3, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH13122023-000002', N'Khách lẻ', N'', 184000, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH14032021-000050', N'Nguyễn Thùy Chi', N'0584613815', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH14062021-000033', N'Phạm Hoàng', N'0965161213', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH14122023-000001', N'Khách lẻ', N'', 87000, 1, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH15032021-000007', N'Đỗ Quỳnh Chi', N'0981272137', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH15052021-000060', N'Cao Khai Minh', N'0968416013', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH15092021-000032', N'Đỗ Song Oanh', N'0325489494', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH15102021-000037', N'Phạm Duy Thắng', N'0509554546', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH16012021-000061', N'Hồ Ðức Phong', N'0550955128', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH16022021-000017', N'Phạm An Hạ ', N'0795164813', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH16072021-000027', N'Ngô Kỳ Anh', N'0787210218', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH16072021-000053', N'Hồ Viết Vũ', N'0632361019', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH17042021-000019', N'Lê Minh Giang', N'0501298742', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH17062021-000036', N'Hồ Ngọc Thiên Kim', N'0844447144', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH18122021-000011', N'Hoàng Húc Hi', N'0312346584', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH19012021-000058', N'Nguyễn Thị Hiên', N'0315932603', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH19062021-000046', N'Bình Dân', N'0561235290', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH20012021-000006', N'Lê Bảo Trân', N'0731186168', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH20032021-000016', N'Chu Bạch Liên', N'0894684141', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH20032021-000056', N'Lê Minh Quân', N'0885492588', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH20092021-000044', N'Hà Hữu Châu', N'0566194647', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH20112021-000055', N'Hà Hùng Anh', N'0381646423', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH22022021-000015', N'Nguyễn Diệp Chi', N'0916351811', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH22062021-000021', N'Cao Hoàng', N'0311368411', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH23062021-000051', N'Đỗ Quang Khải', N'0500350308', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH23082021-000024', N'Phạm Đức Duy', N'0916843158', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH23082021-000045', N'Võ Đức Hùng', N'0804076830', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH23102021-000028', N'Võ Văn Thiên', N'0596709190', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH24052021-000035', N'Trần Hải Ðăng', N'0754623462', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH24102021-000029', N'Hồ Tuệ Nhi', N'0515136816', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH24102023-000003', N'', N'', 10, 10, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH24102023-000004', N'', N'', 11, 11, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25082021-000043', N'Trần Đức Huy', N'0579999861', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25082021-000048', N'Phạm Ðại Dương', N'0798824883', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102021-000004', N'Lại Dương Hoa', N'0979812341', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000001', N'Randal Ondra', N'0875849592', 62401, 2, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000002', N'Huberto MacGillacolm', N'0804076819', 2, 2, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000003', N'Huberto MacGillacolm', N'0804076819', 2, 2, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000004', N'Cad Upson', N'0315932603', 3, 3, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000005', N'Waite Whates', N'0787210218', 4, 4, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000006', N'Bernette Krienke', N'0783186012', 6, 6, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH25102023-000007', N'Kip Schimek', N'0393536342', 7, 7, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH26102023-000001', N'', N'', 8, 8, N'KHACHLE')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH26102023-000002', N'Helga Stuffins', N'0632361019', 9, 9, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH26122021-000005', N'Trần Cao Chiến', N'0783186012', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH27012021-000062', N'Lê Lâm Oanh', N' 0744628620', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH27072021-000041', N'Phan Thi Trân', N'0523030882', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH27102023-000005', N'Alexine Newart', N'0579999861', 12, 12, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH27102023-000006', N'Costanza Kick', N'0596709190', 13, 13, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH28012021-000018', N'Trần Thu Nguyệt', N'0762143613', 0, 0, N'KHACHBT')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH28032021-000002', N'Phạm Diệu Anh', N'0841651681', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH28082021-000054', N'Phạm Tú Quyên', N'0360971756', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH29062021-000025', N'Võ Thị Ngọc Lan', N'0523031435', 416000, 1, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH29062021-000038', N'Đỗ Quốc Bảo', N'0513518381', 22500, 1, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH30062021-000020', N'Phạm Nhật Minh', N'0784564616', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH30102021-000034', N'Võ Tấn Lộc', N'0364894351', 0, 0, N'KHACHBT')
INSERT [dbo].[KhachHang] ([maKhachHang], [tenKhachHang], [soDienThoai], [tongTienMua], [soLuongHoaDon], [nhomKhachHang]) VALUES (N'KH30122021-000031', N'Chu Ðoan Trang', N'0568438718', 226000, 2, N'KHACHBT')
GO
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ghiChu], [trangThai], [tyLeKhuyenMai], [tienToiThieu], [giaTriKhuyenMaiToiDa], [ngayBatDau], [ngayKetThuc]) VALUES (N'aaa', N'aaa', N'aaa', N'Đang hoạt động', 10, 0, 10000, CAST(N'2023-12-06T00:11:29.920' AS DateTime), CAST(N'2023-12-29T00:11:30.907' AS DateTime))
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ghiChu], [trangThai], [tyLeKhuyenMai], [tienToiThieu], [giaTriKhuyenMaiToiDa], [ngayBatDau], [ngayKetThuc]) VALUES (N'C0PSSCAPPO', N'Sale 12-12', N'Sale dip dac biet', N'Đang hoạt động', 50, 0, 100000, CAST(N'2023-12-13T19:34:01.807' AS DateTime), CAST(N'2023-12-14T19:34:03.523' AS DateTime))
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ghiChu], [trangThai], [tyLeKhuyenMai], [tienToiThieu], [giaTriKhuyenMaiToiDa], [ngayBatDau], [ngayKetThuc]) VALUES (N'FREE', N'aaa', N'aaaa', N'Đã ngừng', 0.6, 0, 10000, CAST(N'2023-12-02T00:00:00.000' AS DateTime), CAST(N'2023-12-07T23:52:27.773' AS DateTime))
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ghiChu], [trangThai], [tyLeKhuyenMai], [tienToiThieu], [giaTriKhuyenMaiToiDa], [ngayBatDau], [ngayKetThuc]) VALUES (N'GT4PQ4MKN7', N'Sale Tet', N'Tết', N'Đang hoạt động', 70, 0, 20000, CAST(N'2023-12-13T19:37:39.157' AS DateTime), CAST(N'2024-02-21T19:37:40.523' AS DateTime))
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ghiChu], [trangThai], [tyLeKhuyenMai], [tienToiThieu], [giaTriKhuyenMaiToiDa], [ngayBatDau], [ngayKetThuc]) VALUES (N'KM06122023-000001', N'Sales', N'Giam gia tet', N'Đang hoạt động', 0.5, 0, 100000, CAST(N'2023-12-06T22:04:22.880' AS DateTime), CAST(N'2023-12-14T22:04:24.330' AS DateTime))
INSERT [dbo].[KhuyenMai] ([maKhuyenMai], [tenKhuyenMai], [ghiChu], [trangThai], [tyLeKhuyenMai], [tienToiThieu], [giaTriKhuyenMaiToiDa], [ngayBatDau], [ngayKetThuc]) VALUES (N'RFNKOAWBNF', N'Sale Noel', N'Noel', N'Đang hoạt động', 30, 0, 20000, CAST(N'2023-12-13T19:37:39.157' AS DateTime), CAST(N'2023-12-25T19:37:40.523' AS DateTime))
GO
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'BLACK', N'Đen')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'BLUE', N'Xanh lục')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'BROWN', N'Nâu')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'COLORS', N'Nhiều màu')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'GRAY', N'Xám')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'GREEN', N'Xanh lục')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'ORANGE', N'Cam')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'PINK', N'Hồng')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'PURPLE', N'Tím')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'RED', N'Đỏ')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'SILVER', N'Bạc')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'WHITE', N'Trắng')
INSERT [dbo].[MauSac] ([maMau], [tenMau]) VALUES (N'YELLOW', N'Vàng')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000001', N'Cty Văn Hóa Đông Tây', N'Số 9 Lê Văn Thiêm - Thanh Xuân - Hà Nội', N'02422157878', N'lienhe@dongtay.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000002', N'Nhà Xuất Bản Kim Đồng', N'Số 55 Quang Trung, Nguyễn Du, Hai Bà Trưng, Hà Nội', N'1900571595', N'cskh_online@nxbkimdong.com.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000003', N'Nhã Nam', N'Số 59, Đỗ Quang, Trung Hoà, Cầu Giấy, Hà Nội', N'02435146875', N'info@nhanam.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000004', N'Bình Tây', N'16 Trịnh Hoài Đức, Phường 13, Quận 5, TP. HCM', N' 19002152', N'bitex@bitex.com.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000005', N'AZ Việt Nam', N'Số 65 Đường 9 An Dương Tây Hồ Hà Nội', N'0964484633', N'bophanbanle@azbooks.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000006', N'NXB Trẻ', N'161B Lý Chính Thắng, Võ Thị Sáu, Quận 3 , TP. HCM', N'02838437450', N'hopthubandoc@nxbtre.com.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC23102023-000007', N'FIRST NEWS', N'11 Nguyễn Thị Minh Khai, Bến Nghé, Quận 1, TP.HCM', N'0238227979', N'triviet@firstnews.com.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC24102023-000001', N'Đinh Tị', N'Số 78 - Đường số 1, P.4, Gò Vấp, TP. HCM', N'02838437450', N'hopthubandoc@nxbtre.com.vn', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC24102023-000002', N'Alpha Books', N'Tầng 3, Dream Home Center, Thanh Xuân, Hà Nội', N'0932329959', N'mkt.alphabooks@gmail.com', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC24102023-000003', N'Thiên Long Hoàn Cầu', N'Số 10 Mai Chí Thọ, Thủ Thiêm, Thủ Đức, TP.HCM', N'02837505555', N'info@thienlonggroup.com', N'')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diachiNCC], [soDienThoai], [email], [ghiChu]) VALUES (N'NCC24102023-000004', N'Deli', N'29 DD11, P. TÂN HƯNG THUẬN, Q.12, TPHCM.', N'0394334199', N'hoangthienanhcm@gmail.com', N'')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'QL23102023-000001', N'Nguyễn Tấn Lộc', CAST(N'2003-12-04' AS Date), N'0362447457', N'Nam', N'nguyentanloc1108@gmail.com', N'QL23102023000001', 1, N'CA01', N'QUANLY')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'QL23102023-000007', N'Nguyễn Châu Tình', CAST(N'2003-01-18' AS Date), N'0909546226', N'Nam', N'chautinh05122@gmail.com', N'QL23102023000007', 1, N'CA02', N'QUANLY')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'QL23102023-000012', N'Trần Đăng Hiếu', CAST(N'2003-03-15' AS Date), N'0955698563', N'Nam', N'tdh1503@gmail.com', N'QL23102023000012', 1, N'CA03', N'QUANLY')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000002', N'Võ Thị Kim Anh', CAST(N'1990-03-11' AS Date), N'0365221423', N'Nữ', N'kimanhvo@gmail.com', N'TN23102023000002', 1, N'CA01', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000003', N'Nguyễn Thành Nhân', CAST(N'2000-09-21' AS Date), N'0707569255', N'Nam', N'thanhnhanwork@gmail.com', N'TN23102023000003', 1, N'CA01', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000004', N'Hoàng Văn Thuận', CAST(N'2001-11-10' AS Date), N'0886245365', N'Nam', N'hoangvanthuan@gmail.com', N'TN23102023000004', 1, N'CA01', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000005', N'Trần Đăng Quyết', CAST(N'2000-07-12' AS Date), N'09882146325', N'Nam', N'dangquyettranwork@gmail.com', N'TN23102023000005', 1, N'CA02', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000006', N'Đặng Thanh Nam', CAST(N'2000-12-25' AS Date), N'0325226985', N'Nam', N'thanhnam@gmail.com', N'TN23102023000006', 1, N'CA02', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000008', N'Trần Thị Nhi', CAST(N'2001-05-12' AS Date), N'0778985665', N'Nữ', N'nhiwork@gmail.com', N'TN23102023000008', 1, N'CA02', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000009', N'Nguyễn Thành Thuận', CAST(N'2000-09-21' AS Date), N'0907599155', N'Nam', N'thanhthuan@gmail.com', N'TN23102023000009', 1, N'CA03', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000010', N'Đoàn Nam Phi', CAST(N'2001-04-19' AS Date), N'0566789452', N'Nam', N'namphidoan@gmail.com', N'TN23102023000010', 1, N'CA03', N'THUNGAN')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTenNV], [ngaySinh], [soDienthoaiNV], [gioiTinh], [email], [taiKhoan], [tinhTrangLamViec], [caLamViec], [chucVu]) VALUES (N'TN23102023-000011', N'Võ Thị Phương', CAST(N'2000-03-16' AS Date), N'0965251364', N'Nữ', N'phuongvo@gmail.com', N'TN23102023000011', 1, N'CA03', N'THUNGAN')
GO
INSERT [dbo].[NhomSanPham] ([maNhomSanPham], [tenNhomSanPham]) VALUES (N'NSP001', N'Sách')
INSERT [dbo].[NhomSanPham] ([maNhomSanPham], [tenNhomSanPham]) VALUES (N'NSP002', N'Dụng Cụ Học Sinh')
INSERT [dbo].[NhomSanPham] ([maNhomSanPham], [tenNhomSanPham]) VALUES (N'NSP003', N'Văn Phòng Phẩm')
INSERT [dbo].[NhomSanPham] ([maNhomSanPham], [tenNhomSanPham]) VALUES (N'NSP004', N'SGK')
INSERT [dbo].[NhomSanPham] ([maNhomSanPham], [tenNhomSanPham]) VALUES (N'NSP005', N'Truyện')
GO
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S01122022-000001', N'Chú Thuật Hồi Chiến', N'NSP005', N'NCC23102023-000002', 50, 25000, N'Fushiguro cũng đã thâm nhập và đang trên đường tới căn cứ, nhưng lại bị một thuật sư năm 3 đi cùng Hakari cản trở!!?', N'Còn hàng', 32500, 0.08, N'Gege Akutami', 2023, N'NXB Kim Đồng', 192, CAST(N'2022-12-01T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S01122022-000002', N'Bách Khoa Toàn Thư Về Địa Lý', N'NSP004', N'NCC24102023-000003', 33, 130000, N'Một cuốn sách tuyệt vời để tìm hiểu về hành tinh Trái Đất cùng con người và các nền văn hóa từ gần 200 quốc gia khắp thế giới.', N'Còn hàng', 169000, 0.08, N'Nhiều Tác Giả', 2019, N'NXB Thanh Niên', 400, CAST(N'2022-12-01T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S01122022-000003', N'Hồi Ký Lý Quang Diệu', N'NSP001', N'NCC24102023-000001', 31, 320000, N'Lý Quang Diệu khắc họa chân dung người đàn bà thép Margaret Thatcher và Ronald Reagan, Giang Trạch Dân, George Bush và Đặng Tiểu Bình.', N'Còn hàng', 416000, 0.08, N'Lý Quang Diệu', 2023, N'NXB Hội Nhà Văn', 560, CAST(N'2022-12-01T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S01122022-000004', N'Mười Ba', N'NSP001', N'NCC23102023-000006', 25, 15000, N'', N'Còn hàng', 22500, 0.08, N'Võ Tấn Đạt', 2019, N'NXB Hoa Học Trò', 160, CAST(N'2022-12-07T14:09:00.557' AS DateTime), 0.1)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10012023-000001', N'Tiếng Việt Chân Trời Sáng Tạo', N'NSP004', N'NCC24102023-000003', 30, 31000, N'', N'Còn hàng', 46500, 0.08, N'Nhiều Tác Giả', 2023, N'Nhà Xuất Bản Giáo Dục', 164, CAST(N'2023-01-10T00:39:33.000' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10012023-000002', N'Cây Cam Ngọt Của Tôi ', N'NSP005', N'NCC23102023-000001', 97, 71000, N'', N'Còn hàng', 106500, 0.08, N'José Maurode Vasconcelos', 2020, N'NXB Hội Nhà Văn', 244, CAST(N'2023-01-10T00:54:52.920' AS DateTime), 0.3)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10012023-000003', N'Không Diệt Không Sinh Đừng Sợ Hãi ', N'NSP001', N'NCC23102023-000001', 500, 74000, N'', N'Còn hàng', 111000, 0.08, N'Thích Nhất Hạnh', 2022, N'Thế Giớ', 224, CAST(N'2023-01-10T01:01:38.663' AS DateTime), 0.2)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10012023-000004', N'Muôn Kiếp Nhân Sinh  ', N'NSP001', N'NCC23102023-000001', 500, 44000, N'', N'Còn hàng', 66000, 0.08, N'Many Times Many Lives ', 2018, N'Thế Giới', 244, CAST(N'2023-01-10T01:03:50.477' AS DateTime), 0.4)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000001', N'Tiếng Việt Lớp 1 - Tập 1', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:16:02.350' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000002', N'Tiếng Việt Lớp 1 - Tập 2', N'NSP004', N'NCC23102023-000005', 499, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:17:24.373' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000003', N'Tiếng Việt Lớp 2 - Tập 1', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:17:33.853' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000004', N'Tiếng Việt Lớp 2-  Tập 2', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:17:46.057' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000005', N'Tiếng Việt Lớp 3 - Tập 1', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:17:54.413' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000006', N'Tiếng Việt Lớp 3 - Tập 2', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:18:02.150' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000007', N'Tiếng Việt Lớp 4 - Tập 1', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:18:08.327' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000008', N'Tiếng Việt Lớp 4 - Tập 2', N'NSP004', N'NCC23102023-000005', 500, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:18:18.647' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000009', N'Tiếng Việt Lớp 5 - Tập 1', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:18:46.077' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000010', N'Tiếng Việt Lớp 5 - Tập 2', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:18:58.750' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000011', N'Đạo Đức Lớp 1', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:19:22.537' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000013', N'Đạo Đức Lớp 3', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:19:59.510' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000014', N'Đạo Đức Lớp 4', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:20:05.127' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000015', N'Đạo Đức Lớp 5', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:20:14.760' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10052023-000022', N'Đạo Đức Lớp 2', N'NSP004', N'NCC23102023-000005', 300, 24000, N'', N'Còn hàng', 36000, 0.08, N'Nhiều Tác Giả', 2022, N'Giáo Dục', 56, CAST(N'2023-05-10T01:19:52.933' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000003', N'One Piece Tập 3', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:23:48.223' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000004', N'One Piece Tập 4', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:23:53.150' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000005', N'One Piece Tập 5', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:00.710' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000006', N'One Piece Tập 6', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:05.623' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000007', N'One Piece Tập 7', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:11.440' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000008', N'One Piece Tập 8', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:17.270' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000009', N'One Piece Tập 9', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:23.103' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000010', N'One Piece Tập 10', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:29.567' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000011', N'One Piece Tập 11', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:34.207' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000012', N'One Piece Tập 12', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:41.063' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000013', N'One Piece Tập 13', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:45.453' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000014', N'One Piece Tập 14', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:50.510' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10082023-000015', N'One Piece Tập 15', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:24:54.973' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10112023-000001', N'Điều Kỳ Diệu Của Tiệm Tạp Hóa Namiya', N'NSP005', N'NCC23102023-000003', 33, 48000, N'Atsuya, Shota và Kouhei đã rẽ vào lánh tạm trong một căn nhà hoang bên con dốc vắng người qua lại. Căn nhà có vẻ khi xưa là một tiệm tạp hóa với biển hiệu cũ kỹ bám đầy bồ hóng, khiến người ta khó lòng đọc được trên đó viết gì.', N'Còn hàng', 62400, 0.08, N'Higashino Keigo', 2023, N'NXB Hội Nhà Văn', 358, CAST(N'2023-11-10T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10112023-000002', N'Đất Rừng Phương Nam - Điện Ảnh', N'NSP005', N'NCC23102023-000002', 50, 110000, N'Đất rừng phương Nam là một trong những tác phẩm viết về Nam bộ xuất sắc nhất, làm nổi bật trọn vẹn vẻ đẹp con người và thiên nhiên nơi đây. Mỗi lần đọc là mỗi lần tình yêu xứ sở được khơi gợi đến nao lòng', N'Còn hàng', 143000, 0.08, N'Đoàn Giỏi', 2023, N'NXB Kim Đồng', 276, CAST(N'2023-11-10T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10112023-000003', N'Châu Sa Đáy Mắt', N'NSP001', N'NCC23102023-000005', 25, 47500, N'Sách được phát hành bởi Wavebooks - thương hiệu sách dành cho người Việt trẻ.', N'Còn hàng', 61750, 0.08, N'Higashino Keigo', 2023, N'NXB Thế Giới', 280, CAST(N'2023-11-10T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10112023-000004', N'Cơn Lốc Quản Trị', N'NSP001', N'NCC23102023-000006', 22, 76300, N'Các mô hình quản lý chỉ mang lý luận kỹ thuật cục bộ hạn hẹp và những giải pháp cấu trúc có sẵn cho doanh nghiệp.', N'Còn hàng', 99190, 0.08, N'Phan Van Trườnng', 2023, N'NXB Trẻ', 248, CAST(N'2023-11-10T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10112023-000005', N'Đắc Nhân Tâm (Tái Bản 2021)', N'NSP001', N'NCC23102023-000007', 60, 39000, N'', N'Còn hàng', 50700, 0.08, N'Minh Ðức', 2021, N'NXB Tổng Hợp TPHCM', 320, CAST(N'2023-11-10T16:44:17.923' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10122023-000001', N'One Piece Tập 1', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:21:17.087' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S10122023-000002', N'One Piece Tập 2', N'NSP005', N'NCC23102023-000005', 150, 24000, N'', N'Còn hàng', 36000, 0.08, N'Echiro Oda', 2010, N'Kim Đồng', 171, CAST(N'2023-08-10T01:23:40.897' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S13122023-000001', N'Sách Tiếng Anh ', N'NSP004', N'NCC23102023-000002', 50, 27000, N'Sách Tiếng Anh dành cho những người mới tiếp cận', N'Còn hàng', 40500, 0.1, N'Trần Cao Bội Ngọc', 2023, N'Kim Đồng', 188, CAST(N'2023-12-13T10:14:19.173' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S23102023-000001', N'Điều Kỳ Diệu Của Tiệm Tạp Hóa Namiya', N'NSP001', N'NCC23102023-000003', 13, 48000, N'Atsuya, Shota và Kouhei đã rẽ vào lánh tạm trong một căn nhà hoang bên con dốc vắng người qua lại. Căn nhà có vẻ khi xưa là một tiệm tạp hóa với biển hiệu cũ kỹ bám đầy bồ hóng, khiến người ta khó lòng đọc được trên đó viết gì.', N'Còn hàng', 62400, 0.08, N'Higashino Keigo', 2023, N'NXB Hội Nhà Văn', 358, CAST(N'2023-11-29T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S23102023-000002', N'Đất Rừng Phương Nam - Điện Ảnh', N'NSP001', N'NCC23102023-000002', 31, 110000, N'Đất rừng phương Nam là một trong những tác phẩm viết về Nam bộ xuất sắc nhất, làm nổi bật trọn vẹn vẻ đẹp con người và thiên nhiên nơi đây. Mỗi lần đọc là mỗi lần tình yêu xứ sở được khơi gợi đến nao lòng', N'Còn hàng', 143000, 0.08, N'Đoàn Giỏi', 2023, N'NXB Kim Đồng', 276, CAST(N'2023-11-29T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S23102023-000003', N'Châu Sa Đáy Mắt', N'NSP001', N'NCC23102023-000005', 10, 47500, N'Sách được phát hành bởi Wavebooks - thương hiệu sách dành cho người Việt trẻ.', N'Còn hàng', 61750, 0.08, N'Higashino Keigo', 2023, N'NXB Thế Giới', 280, CAST(N'2023-11-29T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S23102023-000004', N'Cơn Lốc Quản Trị', N'NSP001', N'NCC23102023-000006', -2, 76300, N'Các mô hình quản lý chỉ mang lý luận kỹ thuật cục bộ hạn hẹp và những giải pháp cấu trúc có sẵn cho doanh nghiệp.', N'Còn hàng', 99190, 0.08, N'Phan Van Tru?ng', 2023, N'NXB Trẻ', 248, CAST(N'2023-11-29T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S23102023-000005', N'Đắc Nhân Tâm (Tái Bản 2021)', N'NSP001', N'NCC23102023-000007', 59, 39000, N'', N'Còn hàng', 50700, 0.08, N'Dale Carnegie , Minh Ð?c', 2021, N'NXB Tổng Hợp TPHCM', 320, CAST(N'2023-11-29T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S24102023-000006', N'Chú Thuật Hồi Chiến', N'NSP002', N'NCC23102023-000002', 47, 25000, N'Fushiguro cũng đã thâm nhập và đang trên đường tới căn cứ, nhưng lại bị một thuật sư năm 3 đi cùng Hakari cản trở!!?', N'Còn hàng', 32500, 0.08, N'Gege Akutami', 2023, N'NXB Kim Đồng', 192, CAST(N'2023-11-30T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S24102023-000007', N'Bách Khoa Toàn Thư Về Địa Lý', N'NSP002', N'NCC24102023-000003', 35, 130000, N'Một cuốn sách tuyệt vời để tìm hiểu về hành tinh Trái Đất cùng con người và các nền văn hóa từ gần 200 quốc gia khắp thế giới.', N'Còn hàng', 169000, 0.08, N'Nhi?u Tác Gi?', 2019, N'NXB Thanh Niên', 400, CAST(N'2023-11-30T23:48:06.927' AS DateTime), 0)
INSERT [dbo].[Sach] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [tinhTrang], [donGiaBan], [VAT], [tacGia], [namXuatBan], [nhaSanXuat], [soTrang], [ngayTao], [giamGia]) VALUES (N'S24102023-000008', N'Hồi Ký Lý Quang Diệu', N'NSP002', N'NCC24102023-000001', 32, 320000, N'Lý Quang Diệu khắc họa chân dung người đàn bà thép Margaret Thatcher và Ronald Reagan, Giang Trạch Dân, George Bush và Đặng Tiểu Bình.', N'Còn hàng', 416000, 0.8, N'Lý Quang Di?u', 2023, N'NXB Hội Nhà Văn', 560, CAST(N'2023-11-30T23:48:06.927' AS DateTime), 0)
GO
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'QL23102023000001', N'NTL@11082003', N'nguyentanloc1108@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'QL23102023000007', N'NCT@123456', N'chautinh05122@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'QL23102023000012', N'TDH123456', N'tdh1503@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000002', N'VKA@11031990', N'kimanhvo@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000003', N'NTN@21092000', N'thanhnhan@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000004', N'HVT@10112001', N'hoangvanthuan@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000005', N'TDQ@12072000', N'dangquyettranwork@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000006', N'DTN@25122000', N'thanhnam@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000008', N'TTN@12052001', N'nhiwork@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000009', N'NTT@21092000', N'dangkhoawork@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000010', N'DNP@19042001', N'namphidoan@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matkhau], [email]) VALUES (N'TN23102023000011', N'VTP@16032000', N'phuongvo@gmail.com')
GO
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000001', N'Bìa Trình Ký Đôi Toppoint', N'NSP003', N'NCC24102023-000002', 510, 14000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 21000, 0.08, N'GREEN', N'Hàn Quốc', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000002', N'Hộp 10 Bút Gel Màu FlexOffice FO-GELB056', N'NSP002', N'NCC24102023-000003', 65, 83000, N'Thiết kế với thân 10 tone màu pastel bắt mắt, với thiết kế đơn giản, hợp thời trang, hợp xu hướng.', 1079000, 0.08, N'COLORS', N'Trung Quốc', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000003', N'Bấm Ghim Số 10 Deli E0224F-Xanh Dương', N'NSP002', N'NCC24102023-000004', 62, 31300, N'Sản phẩm được làm từ chất liệu thép bền, chống gỉ sét và nhựa cao cấp, cứng cáp.', 40690, 0.08, N'BLUE', N'Trung Quốc', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000004', N'Bìa Lá Smile TopTeam Macaron Màu Tím', N'NSP003', N'NCC24102023-000002', 410, 16000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 24000, 0.08, N'PURPLE', N'Hàn Quốc', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000005', N'Bìa Lổ Toppoint US ', N'NSP002', N'NCC24102023-000002', 510, 4000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 6000, 0.08, N'BLACK', N'Nhật Bản', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000006', N'Bìa Còng ', N'NSP003', N'NCC24102023-000004', 100, 8000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 12000, 0.08, N'BLACK', N'Việt Nam', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000007', N'Hộp Kẹp Bướm Echo ', N'NSP003', N'NCC24102023-000004', 3500, 5800, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 8700, 0.08, N'BLACK', N'Việt Nam', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15012023-000008', N'Bìa Nút Pazto Màu Pastel', N'NSP003', N'NCC24102023-000004', 365, 16000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 24000, 0.08, N'YELLOW', N'Việt Nam', CAST(N'2023-01-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15032023-000001', N'Máy Tính Casio FX 580 VN X', N'NSP002', N'NCC23102023-000004', 50, 480000, N'Sản phẩm Máy tính điện tử bán chạy', 624000, 0.08, N'BLACK', N'Thái Lan', CAST(N'2023-03-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15032023-000002', N'BÚT LÔNG BẢNG WB-03', N'NSP002', N'NCC24102023-000003', 72, 8900, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 11570, 0.08, N'COLORS', N'Việt Nam', CAST(N'2023-03-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15032023-000003', N'BÚT DẠ QUANG DELI ES621', N'NSP002', N'NCC24102023-000004', 100, 5600, N'Bút có kiểu dáng nhỏ gọn, trẻ trung, tiện lợi giúp bạn có thể sử dụng ở mọi lúc, mọi nơi, là một trong những dụng cụ không thể thiếu cho giới học sinh, sinh viên hay nhân viên văn phòng.', 7280, 0.08, N'COLORS', N'Việt Nam', CAST(N'2023-03-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15032023-000004', N'Bấm Không Dùng Kim Plus ', N'NSP003', N'NCC24102023-000004', 500, 96000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 144000, 0.08, N'ORANGE', N'Việt Nam', CAST(N'2023-03-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15032023-000005', N'Ống Đựng Bút Usign US', N'NSP002', N'NCC24102023-000004', 300, 22000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 33000, 0.08, N'SILVER', N'Việt Nam', CAST(N'2023-03-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15032023-000009', N'Bìa Còng ', N'NSP003', N'NCC24102023-000004', 350, 8000, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 12000, 0.08, N'GREEN', N'Việt Nam', CAST(N'2023-03-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000001', N'Bìa Acco Nhựa A4 - FO-PPFFA4 - Màu Xanh', N'NSP003', N'NCC24102023-000002', 30, 10000, N'Bìa kẹp hồ sơ', 15000, 0.08, N'BLUE', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000002', N'Bìa Acco Nhựa A4 - FO-PPFFA4 - Màu Đen', N'NSP003', N'NCC24102023-000002', 30, 10000, N'Bìa kẹp hồ sơ', 15000, 0.08, N'BLACK', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000003', N'Bìa Acco Nhựa A4 - FO-PPFFA4 - Màu Đỏ', N'NSP003', N'NCC24102023-000002', 30, 10000, N'Bìa kẹp hồ sơ', 15000, 0.08, N'RED', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000004', N'Bìa Acco Nhựa A4 - FO-PPFFA4 - Màu Hồng', N'NSP003', N'NCC24102023-000002', 30, 10000, N'Bìa kẹp hồ sơ', 15000, 0.08, N'PINK', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000005', N'Bìa Acco Nhựa A4 - FO-PPFFA4 - Màu Lá', N'NSP003', N'NCC24102023-000002', 29, 10000, N'Bìa kẹp hồ sơ', 15000, 0.08, N'GREEN', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000006', N'Kim Kẹp Tam Giác Elephant 172565', N'NSP003', N'NCC24102023-000002', 60, 4000, N'ghim kẹp giấy', 6000, 0.08, N'WHITE', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000007', N'Hộp 12 Kẹp Bướm 51mm SLECHO H12', N'NSP003', N'NCC24102023-000002', 50, 8000, N'Kẹp Giấy', 12000, 0.08, N'BLUE', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000008', N'Bấm Kim Số 3 - Màu Xanh Dương', N'NSP003', N'NCC24102023-000002', 44, 10000, N'Ghim bấm giấy', 15000, 0.08, N'BLUE', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000009', N'Bấm Kim Số 3 - Màu Xanh Lá ', N'NSP003', N'NCC24102023-000002', 45, 10000, N'Ghim bấm giấy', 15000, 0.08, N'GREEN', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP15062023-000010', N'Bấm Kim Số 3 - Màu Trắng ', N'NSP003', N'NCC24102023-000002', 45, 10000, N'Ghim bấm giấy', 15000, 0.08, N'WHITE', N'Việt Nam', CAST(N'2023-06-15T00:00:00.000' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP23102023-000001', N'Máy Tính Casio FX 580 VN X', N'NSP001', N'NCC23102023-000004', 50, 480000, N'Sản phẩm Máy tính điện tử bán chạy', 624000, 0.08, N'BLACK', N'Thái Lan', CAST(N'2023-11-29T23:48:06.930' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP23102023-000002', N'Hộp 10 Bút Gel Màu FlexOffice FO-GELB056', N'NSP001', N'NCC24102023-000003', 65, 83000, N'Thiết kế với thân 10 tone màu pastel bắt mắt, với thiết kế đơn giản, hợp thời trang, hợp xu hướng.', 1079000, 0.08, N'COLORS', N'Trung Quốc', CAST(N'2023-11-29T23:48:06.930' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP23102023-000003', N'Bấm Ghim Số 10 Deli E0224F-Xanh Dương', N'NSP001', N'NCC24102023-000004', 62, 31300, N'Sản phẩm được làm từ chất liệu thép bền, chống gỉ sét và nhựa cao cấp, cứng cáp.', 40690, 0.08, N'BLUE', N'Trung Quốc', CAST(N'2023-11-29T23:48:06.930' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP23102023-000004', N'BÚT DẠ QUANG DELI ES621', N'NSP001', N'NCC24102023-000004', 100, 5600, N'Bút có kiểu dáng nhỏ gọn, trẻ trung, tiện lợi giúp bạn có thể sử dụng ở mọi lúc, mọi nơi, là một trong những dụng cụ không thể thiếu cho giới học sinh, sinh viên hay nhân viên văn phòng.', 7280, 0.08, N'COLORS', N'Việt Nam', CAST(N'2023-11-29T23:48:06.930' AS DateTime), 0, N'Còn hàng')
INSERT [dbo].[VanPhongPham] ([maSanPham], [tenSanPham], [nhomSanPham], [nhaCungCap], [soLuongTon], [donGiaNhap], [moTa], [donGiaBan], [VAT], [mauSac], [noiSanXuat], [ngayTao], [giamGia], [tinhTrang]) VALUES (N'VPP23102023-000005', N'BÚT LÔNG BẢNG WB-03', N'NSP001', N'NCC24102023-000003', 72, 8900, N'Loại bút lông bảng thân cỡ vừa, được thiết kế phù hợp với giáo viên, NVVP', 11570, 0.08, N'COLORS', N'Việt Nam', CAST(N'2023-11-29T23:48:06.930' AS DateTime), 0, N'Còn hàng')
GO
ALTER TABLE [dbo].[ChiTietBanBaoCao]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietBanBaoCao_BanBaoCao] FOREIGN KEY([banBaoCao])
REFERENCES [dbo].[BanBaoCao] ([maBanBaoCao])
GO
ALTER TABLE [dbo].[ChiTietBanBaoCao] CHECK CONSTRAINT [FK_ChiTietBanBaoCao_BanBaoCao]
GO
ALTER TABLE [dbo].[ChiTietBanBaoCao]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietBanBaoCao_Sach] FOREIGN KEY([sanPham])
REFERENCES [dbo].[Sach] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietBanBaoCao] NOCHECK CONSTRAINT [FK_ChiTietBanBaoCao_Sach]
GO
ALTER TABLE [dbo].[ChiTietBanBaoCao]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietBanBaoCao_VPP] FOREIGN KEY([sanPham])
REFERENCES [dbo].[VanPhongPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietBanBaoCao] NOCHECK CONSTRAINT [FK_ChiTietBanBaoCao_VPP]
GO
ALTER TABLE [dbo].[ChiTietDoiHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDoiHang_HoaDonDoiHang] FOREIGN KEY([hoaDonDoiHang])
REFERENCES [dbo].[HoaDonDoiHang] ([maHoaDonDoi])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDoiHang] CHECK CONSTRAINT [FK_ChiTietDoiHang_HoaDonDoiHang]
GO
ALTER TABLE [dbo].[ChiTietDoiHang]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietDoiHang_SACH] FOREIGN KEY([sanPham])
REFERENCES [dbo].[Sach] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietDoiHang] NOCHECK CONSTRAINT [FK_ChiTietDoiHang_SACH]
GO
ALTER TABLE [dbo].[ChiTietDoiHang]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietDoiHang_VanPhongPham] FOREIGN KEY([sanPham])
REFERENCES [dbo].[VanPhongPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietDoiHang] NOCHECK CONSTRAINT [FK_ChiTietDoiHang_VanPhongPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([hoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SACH] FOREIGN KEY([sanPham])
REFERENCES [dbo].[Sach] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] NOCHECK CONSTRAINT [FK_ChiTietHoaDon_SACH]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_VanPhongPham] FOREIGN KEY([sanPham])
REFERENCES [dbo].[VanPhongPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] NOCHECK CONSTRAINT [FK_ChiTietHoaDon_VanPhongPham]
GO
ALTER TABLE [dbo].[ChiTietHoanTra]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoanTra_HoaDonHoanTra] FOREIGN KEY([hoaDonHoanTra])
REFERENCES [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoanTra] CHECK CONSTRAINT [FK_ChiTietHoanTra_HoaDonHoanTra]
GO
ALTER TABLE [dbo].[ChiTietHoanTra]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietHoanTra_SACH] FOREIGN KEY([sanPham])
REFERENCES [dbo].[Sach] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoanTra] NOCHECK CONSTRAINT [FK_ChiTietHoanTra_SACH]
GO
ALTER TABLE [dbo].[ChiTietHoanTra]  WITH NOCHECK ADD  CONSTRAINT [FK_ChiTietHoanTra_VanPhongPham] FOREIGN KEY([sanPham])
REFERENCES [dbo].[VanPhongPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoanTra] NOCHECK CONSTRAINT [FK_ChiTietHoanTra_VanPhongPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([khachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([nhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonDoiHang]  WITH CHECK ADD FOREIGN KEY([hoaDonHoanTra])
REFERENCES [dbo].[HoaDonHoanTra] ([maHoaDonHoanTra])
GO
ALTER TABLE [dbo].[HoaDonHoanTra]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonHoanTra_HoaDon] FOREIGN KEY([hoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[HoaDonHoanTra] CHECK CONSTRAINT [FK_HoaDonHoanTra_HoaDon]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_CaLamViec1] FOREIGN KEY([caLamViec])
REFERENCES [dbo].[CaLamViec] ([maCa])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_CaLamViec1]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[TaiKhoan] ([tenDangNhap])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_NhaCungCap] FOREIGN KEY([nhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_NhaCungCap]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_NhomSanPham] FOREIGN KEY([nhomSanPham])
REFERENCES [dbo].[NhomSanPham] ([maNhomSanPham])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_NhomSanPham]
GO
ALTER TABLE [dbo].[VanPhongPham]  WITH CHECK ADD  CONSTRAINT [FK_VanPhongPham_MauSac] FOREIGN KEY([mauSac])
REFERENCES [dbo].[MauSac] ([maMau])
GO
ALTER TABLE [dbo].[VanPhongPham] CHECK CONSTRAINT [FK_VanPhongPham_MauSac]
GO
ALTER TABLE [dbo].[VanPhongPham]  WITH CHECK ADD  CONSTRAINT [FK_VanPhongPham_NhaCungCap] FOREIGN KEY([nhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[VanPhongPham] CHECK CONSTRAINT [FK_VanPhongPham_NhaCungCap]
GO
ALTER TABLE [dbo].[VanPhongPham]  WITH CHECK ADD  CONSTRAINT [FK_VanPhongPham_NhomSanPham] FOREIGN KEY([nhomSanPham])
REFERENCES [dbo].[NhomSanPham] ([maNhomSanPham])
GO
ALTER TABLE [dbo].[VanPhongPham] CHECK CONSTRAINT [FK_VanPhongPham_NhomSanPham]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [chk_nhomKhachHang] CHECK  (([nhomKhachHang]='KHACHBT' OR [nhomKhachHang]='KHACHVIP' OR [nhomKhachHang]='KHACHLE'))
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [chk_nhomKhachHang]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [chk_chucVu] CHECK  (([chucVu]='QUANLY' OR [chucVu]='THUNGAN'))
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [chk_chucVu]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [chk_gioiTinh] CHECK  (([gioiTinh]='Nam' OR [gioiTinh]=N'Nữ'))
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [chk_gioiTinh]
GO
USE [master]
GO
ALTER DATABASE [QuanLyHieuSachONEEIGHT] SET  READ_WRITE 
GO
