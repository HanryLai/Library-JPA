/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import dao.Interface.BanBaoCao_Dao;
import dao.Interface.ChiTietBaoCao_Dao;
import dao.Interface.HoaDon_Dao;
import entityJPA.BanBaoCao;
import entityJPA.ChiTietBanBaoCao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import client_Dao.Dao_Package_Static;


/**
 *
 * @author nguyen chau tai
 */
public class FrmXemBaoCao extends javax.swing.JPanel {

    /**
     * Creates new form FrmDSKhachHang
     */
    private FrmChinh frm = new FrmChinh();
    private Thread thread = null;
    public FrmXemBaoCao() throws SQLException, RemoteException {
        initComponents();
        loadData();
        thread = new Thread(this::setTimeAuto);
        thread.start();
       
        offField();
        
    }

    public void offField(){
        lblDTCN.setVisible(false);
        txtDTCN.setVisible(false);
        txtNVBC.setVisible(false);
        lblTSP.setVisible(false);
        txtTSP.setVisible(false);
        pnlBC2.setVisible(false);
    }
    public void onField() throws RemoteException {
        jLabel3.setText("Nhân viên báo cáo");
        lblDTCN.setVisible(true);
        txtDTCN.setVisible(true);
        txtNVBC.setVisible(true);
        lblTSP.setVisible(true);
        txtTSP.setVisible(true);
        txtDTCN.setText(String.format("%s", dao_CTBC.getDoanhThuCaNgay(Integer.parseInt(maBBC))));
        txtTSP.setText(String.format("%s", dao_CTBC.getTongSanPhamBanDuoc(Integer.parseInt(maBBC))));
        txtNVBC.setText(tenNVBC);
        pnlBC2.setVisible(true);
    }
    
    private void showPanelChange(JPanel a, JPanel b) {
        a.removeAll();
        a.add(b);
        a.repaint();
        a.revalidate();
    }
    
    public void deleteTable() {
        DefaultTableModel dm = (DefaultTableModel) tableXemBC.getModel();
        dm.getDataVector().removeAllElements();
    }

    private BanBaoCao_Dao dao_BCDT = Dao_Package_Static.dao_BanBaoCao;
    private ArrayList<BanBaoCao> data;
    
    public void loadData() throws SQLException, RemoteException {
        deleteTable();
        DefaultTableModel model = (DefaultTableModel) tableXemBC.getModel();


        data = dao_BCDT.getALLBanBaoCao();
        int stt = 1;
        for (BanBaoCao bbc : data) {
            String[] newRow = {
                String.format("%s", stt),
                String.format("%s", bbc.getTenBanBaoCao()),
                String.format("%s", bbc.getTenNhanVien()),
                String.format("%s", bbc.getThoiGianBaoCao())
            };

            model.addRow(newRow);
            stt++;
        }
        
    }
    
    public String thietLapMaHoaDon() {
        // Lấy ngày hiện tại và lấy mã nhân viên từ DAO
        LocalDate ngayHienTai = LocalDate.now();
        String ngayHienTaiStr = ngayHienTai.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String maHoaDonCheck = "HD" + ngayHienTaiStr + "%";
        return maHoaDonCheck;
    }

//    private DAO_ChiTietBanBaoCao dao_CTBC = new DAO_ChiTietBanBaoCao();
    ChiTietBaoCao_Dao dao_CTBC = Dao_Package_Static.dao_ChiTietBaoCao;
//    private DAO_BanBaoCao dao_BBC;
private BanBaoCao_Dao dao_BBC = Dao_Package_Static.dao_BanBaoCao;
    private ArrayList<ChiTietBanBaoCao> dataX;
    private ArrayList<ChiTietBanBaoCao> dataTTSach;
    private ArrayList<ChiTietBanBaoCao> dataTTVPP;
    
    private void createChart() throws RemoteException {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createBarChart(
            "Doanh thu theo ca",      // Chart title
            "Ca làm việc",           // X-axis label
            "VND",              // Y-axis label
            dataset,              // Data
            PlotOrientation.VERTICAL,
            true,                 // Include legend
            true,
            false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(460, 479));
        jPanel17.setLayout(new BorderLayout());
        jPanel17.removeAll();
        jPanel17.add(chartPanel, BorderLayout.CENTER);
        jPanel17.validate();
    }
    
//    private DAO_HoaDon dao_hoadon = new DAO_HoaDon();
    private HoaDon_Dao dao_hoadon = Dao_Package_Static.dao_HoaDon;
    private CategoryDataset createDataset() throws RemoteException {
        String ngayHienTai = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("day:"+ngayHienTai);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (tenBBC.endsWith("Sang")){
            dataset.addValue(dao_CTBC.getDoanhThuTheoTenBC(tenBBC), "Doanh thu", "Sáng");
            dataset.addValue(0, "Doanh thu", "Chiều");
            dataset.addValue(0, "Doanh thu", "Tối");
        }
        else if (tenBBC.endsWith("Chieu")){
            dataset.addValue(0, "Doanh thu", "Sáng");
            dataset.addValue(dao_CTBC.getDoanhThuTheoTenBC(tenBBC), "Doanh thu", "Chiều");
            dataset.addValue(0, "Doanh thu", "Tối");
        }
        else{
            dataset.addValue(0, "Doanh thu", "Sáng");
            dataset.addValue(0, "Doanh thu", "Chiều");
            dataset.addValue(dao_CTBC.getDoanhThuTheoTenBC(tenBBC), "Doanh thu", "Tối");
        }
        return dataset;
    }
    
    
    public void loadData2() throws SQLException, ParseException, RemoteException {
        deleteTable();
        DefaultTableModel model = (DefaultTableModel) tableBH.getModel();
        dataX = dao_CTBC.getChiTietBanBaoCao(dao_BBC.getMaBBCTheoTen(tenBBC));
        
        int stt1 = 1;
        for (ChiTietBanBaoCao ctbc : dataX) {
            if(ctbc.getSoLuongNhap() ==0 && ctbc.getTonKho()== 0){
                    String[] newRow = {
                    String.format("%s", stt1),
                    String.format("%s", ctbc.getSanPham().getTenSanPham()),
                    String.format("%s", ctbc.getSoLuongBan()),
                    String.format("%s", ctbc.getThanhTien()),
                    String.format("%s", ctbc.getGhiChu()),
                };
                model.addRow(newRow);
                stt1++; 
            }
        }

        DefaultTableModel model2 = (DefaultTableModel) tableTT.getModel();
        String ngayHienTai = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Chuỗi ngày ban đầu
        // Định dạng của ngày đầu vào
        DateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        // Định dạng của ngày đầu ra
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Chuyển đổi chuỗi ngày sang đối tượng Date
        String ngay = thoiGianBC.split("-")[0];
        Date originalDate = originalFormat.parse(ngay);

        // Chuyển đổi ngày sang định dạng mới
        String formattedDateStr = targetFormat.format(originalDate);

        dataTTSach = dao_CTBC.getTinhTrangNhapSach(formattedDateStr);
        dataTTVPP = dao_CTBC.getTinhTrangNhapVPP(formattedDateStr);
        
        int stt2 = 1;
        for (ChiTietBanBaoCao ctbc : dataTTSach) {
            String[] newRow = {
                String.format("%s", stt2),
                String.format("%s", ctbc.getSanPham().getTenSanPham()),
                String.format("%s", ctbc.getSoLuongNhap()),
                String.format("%s", ctbc.getTonKho()),
                String.format("%s", ctbc.getGhiChu()),
            };
            model2.addRow(newRow);
            stt2++;
        }
        for (ChiTietBanBaoCao ctbc : dataTTVPP) {
            String[] newRow = {
                String.format("%s", stt2),
                String.format("%s", ctbc.getSanPham().getTenSanPham()),
                String.format("%s", ctbc.getSoLuongNhap()),
                String.format("%s", ctbc.getTonKho()),
                String.format("%s", ctbc.getGhiChu()),
            };
            model2.addRow(newRow);
            stt2++;
        }
        createChart();
    }
    
    public void setTimeAuto(){
        try {
            Date thoiGianHienTai = new Date();
            SimpleDateFormat sdf_Gio = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sdf_Ngay = new SimpleDateFormat("dd/MM/yyyy");
            while (true) {
                    thoiGianHienTai = new Date(); // lấy thời gian hiện tại
                    String ngayTrongTuan = "";
                    if (thoiGianHienTai.getDay() == 0)
                        ngayTrongTuan = "Chủ nhật, ";
                    else
                        ngayTrongTuan = "Thứ " + (thoiGianHienTai.getDay() + 1) + ", ";// do getDay() tính từ 1.
                    thread.sleep(1); // cho phép ngủ trong khoảng 1000 mns =1s
                    // lấy thời gian hiện tại vào giờ vào
                    date.setText(
                            sdf_Gio.format(thoiGianHienTai) + " " + ngayTrongTuan +
                            sdf_Ngay.format(thoiGianHienTai)
                            );

            }

        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNull = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlCenterThem = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        pnlTopLeft1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        pnlCenterKHchange1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTimKH1 = new javax.swing.JTextField();
        txtTimKH2 = new javax.swing.JTextField();
        txtTongChiTieu = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblTongDonHang = new javax.swing.JLabel();
        lblTongChiTieu = new javax.swing.JLabel();
        txtTongDonHang = new javax.swing.JTextField();
        txtTimKH10 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnLuuKH = new javax.swing.JButton();
        btnHuyKH = new javax.swing.JButton();
        btnQuayLaiKH = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnlInit1 = new javax.swing.JPanel();
        menuScrollPane3 = new menuGui.MenuScrollPane();
        jTable3 = new javax.swing.JTable();
        pnlCenterXem = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        pnlTopLeft3 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        pnlCenterKHchange3 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtTimKH5 = new javax.swing.JTextField();
        txtTimKH6 = new javax.swing.JTextField();
        txtTongChiTieu2 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        lblTongDonHang2 = new javax.swing.JLabel();
        lblTongChiTieu2 = new javax.swing.JLabel();
        txtTongDonHang2 = new javax.swing.JTextField();
        txtTimKH12 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        btnQuayLaiKH2 = new javax.swing.JButton();
        btnSuaKH1 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        pnlChange = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        pnlTopLeft = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblDTCN = new javax.swing.JLabel();
        txtDTCN = new javax.swing.JTextField();
        txtNVBC = new javax.swing.JTextField();
        lblTSP = new javax.swing.JLabel();
        txtTSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlCenterKHchange = new javax.swing.JPanel();
        pnlInit = new javax.swing.JPanel();
        pnlBC1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableXemBC = new javax.swing.JTable();
        btnXemBC = new javax.swing.JButton();
        btnXemBC1 = new javax.swing.JButton();
        pnlBC2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTT = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNameLogin = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        pnlNull.setBackground(new java.awt.Color(250, 250, 250));
        pnlNull.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Không tìm thấy dữ liệu phù hợp với kết quả tìm kiếm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel7.setText("Thử thay đổi điều kiện lọc hoặc từ khóa tìm kiếm");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMenu/searchnull.png"))); // NOI18N

        javax.swing.GroupLayout pnlNullLayout = new javax.swing.GroupLayout(pnlNull);
        pnlNull.setLayout(pnlNullLayout);
        pnlNullLayout.setHorizontalGroup(
            pnlNullLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNullLayout.createSequentialGroup()
                .addGroup(pnlNullLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNullLayout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel4))
                    .addGroup(pnlNullLayout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(jLabel8)))
                .addContainerGap(364, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNullLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(434, 434, 434))
        );
        pnlNullLayout.setVerticalGroup(
            pnlNullLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNullLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(345, Short.MAX_VALUE))
        );

        pnlCenterThem.setBackground(new java.awt.Color(153, 153, 153));
        pnlCenterThem.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jPanel9.setBackground(new java.awt.Color(240, 242, 245));

        pnlTopLeft1.setBackground(new java.awt.Color(204, 204, 255));
        pnlTopLeft1.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        pnlCenterKHchange1.setBackground(new java.awt.Color(250, 250, 250));
        pnlCenterKHchange1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(250, 250, 250));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Thông tin khách hàng");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Số điện thoại");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Mã khách hàng");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Tên khách hàng");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Nhóm khách hàng");

        txtTimKH1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTimKH1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKH1ActionPerformed(evt);
            }
        });

        txtTimKH2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTimKH2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKH2ActionPerformed(evt);
            }
        });

        txtTongChiTieu.setEditable(false);
        txtTongChiTieu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTongChiTieu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTongChiTieu.setEnabled(false);
        txtTongChiTieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongChiTieuActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách bình thường", "Khách vip" }));

        lblTongDonHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongDonHang.setForeground(new java.awt.Color(3, 136, 253));
        lblTongDonHang.setText("Tổng số lượng đơn hàng");

        lblTongChiTieu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongChiTieu.setForeground(new java.awt.Color(3, 136, 253));
        lblTongChiTieu.setText("Tổng chi tiêu");

        txtTongDonHang.setEditable(false);
        txtTongDonHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTongDonHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTongDonHang.setEnabled(false);
        txtTongDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDonHangActionPerformed(evt);
            }
        });

        txtTimKH10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTimKH10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKH10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKH10ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("(*)");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setText("(*)");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("(*)");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setText("(*)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongChiTieu)
                    .addComponent(txtTimKH1)
                    .addComponent(txtTimKH2)
                    .addComponent(txtTongDonHang)
                    .addComponent(txtTimKH10)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTongChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 640, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKH10, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20))
                        .addGap(17, 17, 17)
                        .addComponent(txtTimKH1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18))
                        .addGap(8, 8, 8)
                        .addComponent(txtTimKH2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongChiTieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongChiTieu, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(lblTongDonHang)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pnlCenterKHchange1.add(jPanel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCenterKHchange1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCenterKHchange1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlTopLeft1.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnLuuKH.setBackground(new java.awt.Color(3, 136, 253));
        btnLuuKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuKH.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuKH.setText("Lưu");
        btnLuuKH.setFocusable(false);
        btnLuuKH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLuuKH.setMargin(new java.awt.Insets(2, 10, 3, 10));
        btnLuuKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKHActionPerformed(evt);
            }
        });

        btnHuyKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuyKH.setForeground(new java.awt.Color(255, 77, 77));
        btnHuyKH.setText("Hủy");
        btnHuyKH.setFocusable(false);
        btnHuyKH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuyKH.setMargin(new java.awt.Insets(2, 10, 3, 10));
        btnHuyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyKHActionPerformed(evt);
            }
        });

        btnQuayLaiKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuayLaiKH.setForeground(new java.awt.Color(3, 136, 253));
        btnQuayLaiKH.setText("Quay lại danh sách khách hàng");
        btnQuayLaiKH.setFocusable(false);
        btnQuayLaiKH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuayLaiKH.setMargin(new java.awt.Insets(2, 10, 3, 10));
        btnQuayLaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuayLaiKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyKH, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnLuuKH, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyKH)
                    .addComponent(btnQuayLaiKH))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTopLeft1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTopLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlCenterThem.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel10.setBackground(new java.awt.Color(250, 250, 250));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setPreferredSize(new java.awt.Dimension(1690, 56));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Khách hàng");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("Nguyễn Châu Tình - DESGIN");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1209, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(19, 19, 19))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCenterThem.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        pnlInit1.setBackground(new java.awt.Color(250, 250, 250));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Nhóm khách hàng", "Tổng chi tiêu", "Tổng số lượng đơn hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(40);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        menuScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout pnlInit1Layout = new javax.swing.GroupLayout(pnlInit1);
        pnlInit1.setLayout(pnlInit1Layout);
        pnlInit1Layout.setHorizontalGroup(
            pnlInit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInit1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menuScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlInit1Layout.setVerticalGroup(
            pnlInit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInit1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menuScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pnlCenterXem.setBackground(new java.awt.Color(153, 153, 153));
        pnlCenterXem.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(153, 153, 153));

        jPanel20.setBackground(new java.awt.Color(240, 242, 245));

        pnlTopLeft3.setBackground(new java.awt.Color(204, 204, 255));
        pnlTopLeft3.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        pnlCenterKHchange3.setBackground(new java.awt.Color(250, 250, 250));
        pnlCenterKHchange3.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(250, 250, 250));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel36.setText("Thông tin khách hàng");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel37.setText("Số điện thoại");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel38.setText("Mã khách hàng");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel39.setText("Tên khách hàng");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel40.setText("Nhóm khách hàng");

        txtTimKH5.setEditable(false);
        txtTimKH5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTimKH5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKH5.setEnabled(false);
        txtTimKH5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKH5ActionPerformed(evt);
            }
        });

        txtTimKH6.setEditable(false);
        txtTimKH6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTimKH6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKH6.setEnabled(false);
        txtTimKH6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKH6ActionPerformed(evt);
            }
        });

        txtTongChiTieu2.setEditable(false);
        txtTongChiTieu2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTongChiTieu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTongChiTieu2.setEnabled(false);
        txtTongChiTieu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongChiTieu2ActionPerformed(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách bình thường", "Khách vip" }));
        jComboBox4.setEnabled(false);

        lblTongDonHang2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongDonHang2.setForeground(new java.awt.Color(3, 136, 253));
        lblTongDonHang2.setText("Tổng số lượng đơn hàng");

        lblTongChiTieu2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongChiTieu2.setForeground(new java.awt.Color(3, 136, 253));
        lblTongChiTieu2.setText("Tổng chi tiêu");

        txtTongDonHang2.setEditable(false);
        txtTongDonHang2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTongDonHang2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTongDonHang2.setEnabled(false);
        txtTongDonHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDonHang2ActionPerformed(evt);
            }
        });

        txtTimKH12.setEditable(false);
        txtTimKH12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTimKH12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKH12.setEnabled(false);
        txtTimKH12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKH12ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel41.setText("(*)");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel42.setText("(*)");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel43.setText("(*)");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel46.setText("(*)");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongChiTieu2)
                    .addComponent(txtTimKH5)
                    .addComponent(txtTimKH6)
                    .addComponent(txtTongDonHang2)
                    .addComponent(txtTimKH12)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTongChiTieu2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongDonHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 640, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKH12, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel43))
                        .addGap(17, 17, 17)
                        .addComponent(txtTimKH5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel41))
                        .addGap(8, 8, 8)
                        .addComponent(txtTimKH6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongChiTieu2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongChiTieu2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(lblTongDonHang2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongDonHang2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addGap(88, 88, 88))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pnlCenterKHchange3.add(jPanel22, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCenterKHchange3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCenterKHchange3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlTopLeft3.add(jPanel21, java.awt.BorderLayout.CENTER);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        btnQuayLaiKH2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuayLaiKH2.setForeground(new java.awt.Color(3, 136, 253));
        btnQuayLaiKH2.setText("Quay lại danh sách khách hàng");
        btnQuayLaiKH2.setFocusable(false);
        btnQuayLaiKH2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuayLaiKH2.setMargin(new java.awt.Insets(2, 10, 3, 10));
        btnQuayLaiKH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiKH2ActionPerformed(evt);
            }
        });

        btnSuaKH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaKH1.setForeground(new java.awt.Color(3, 136, 253));
        btnSuaKH1.setText("Sửa khách hàng");
        btnSuaKH1.setFocusable(false);
        btnSuaKH1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSuaKH1.setMargin(new java.awt.Insets(2, 10, 3, 10));
        btnSuaKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKH1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuayLaiKH2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuayLaiKH2)
                    .addComponent(btnSuaKH1))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTopLeft3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTopLeft3, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlCenterXem.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel24.setBackground(new java.awt.Color(250, 250, 250));
        jPanel24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel24.setPreferredSize(new java.awt.Dimension(1690, 56));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel47.setText("Khách hàng");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel48.setText("Nguyễn Châu Tình - DESGIN");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1209, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addGap(19, 19, 19))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCenterXem.add(jPanel24, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1690, 787));
        setLayout(new java.awt.BorderLayout());

        pnlChange.setLayout(new java.awt.BorderLayout());

        pnlCenter.setBackground(new java.awt.Color(153, 153, 153));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel8.setBackground(new java.awt.Color(240, 242, 245));

        pnlTopLeft.setBackground(new java.awt.Color(204, 204, 255));
        pnlTopLeft.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(1312, 754));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        lblDTCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDTCN.setText("Doanh thu cả ngày");

        txtDTCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTCNActionPerformed(evt);
            }
        });

        txtNVBC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblTSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTSP.setText("Tổng SP bán được");

        txtTSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTSPActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("DANH SÁCH BẢN BẢO CÁO DOANH THU");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTSP)
                    .addComponent(lblTSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(303, 303, 303)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNVBC, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(188, 188, 188)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDTCN))
                .addGap(338, 338, 338))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDTCN)
                            .addComponent(lblTSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNVBC, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlCenterKHchange.setBackground(new java.awt.Color(250, 250, 250));
        pnlCenterKHchange.setLayout(new java.awt.BorderLayout());

        pnlInit.setBackground(new java.awt.Color(250, 250, 250));
        pnlInit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlInit.setPreferredSize(new java.awt.Dimension(1270, 630));
        pnlInit.setLayout(new javax.swing.BoxLayout(pnlInit, javax.swing.BoxLayout.LINE_AXIS));

        pnlBC1.setBackground(new java.awt.Color(255, 255, 255));

        tableXemBC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên báo cáo", "Tên nhân viên", "Thời gian báo cáo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableXemBC.setRowHeight(50);
        tableXemBC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tableXemBCMouseClicked(evt);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jScrollPane1.setViewportView(tableXemBC);
        if (tableXemBC.getColumnModel().getColumnCount() > 0) {
            tableXemBC.getColumnModel().getColumn(0).setMinWidth(50);
            tableXemBC.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableXemBC.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnXemBC.setBackground(new java.awt.Color(51, 153, 255));
        btnXemBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemBC.setForeground(new java.awt.Color(255, 255, 255));
        btnXemBC.setText("Xem báo cáo");
        btnXemBC.setPreferredSize(new java.awt.Dimension(72, 27));
        btnXemBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnXemBCActionPerformed(evt);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnXemBC1.setBackground(new java.awt.Color(51, 153, 255));
        btnXemBC1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemBC1.setForeground(new java.awt.Color(255, 255, 255));
        btnXemBC1.setText("Làm mới");
        btnXemBC1.setPreferredSize(new java.awt.Dimension(72, 27));
        btnXemBC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemBC1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBC1Layout = new javax.swing.GroupLayout(pnlBC1);
        pnlBC1.setLayout(pnlBC1Layout);
        pnlBC1Layout.setHorizontalGroup(
            pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBC1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBC1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXemBC1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnXemBC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        pnlBC1Layout.setVerticalGroup(
            pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemBC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemBC1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlInit.add(pnlBC1);

        pnlBC2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng bán", "Thành tiền", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBH.setRowHeight(30);
        jScrollPane2.setViewportView(tableBH);
        if (tableBH.getColumnModel().getColumnCount() > 0) {
            tableBH.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableBH.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Bán hàng");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng nhập", "Tồn kho", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTT.setRowHeight(30);
        jScrollPane3.setViewportView(tableTT);
        if (tableTT.getColumnModel().getColumnCount() > 0) {
            tableTT.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Tình trạng");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBC2Layout = new javax.swing.GroupLayout(pnlBC2);
        pnlBC2.setLayout(pnlBC2Layout);
        pnlBC2Layout.setHorizontalGroup(
            pnlBC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBC2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlBC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBC2Layout.setVerticalGroup(
            pnlBC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBC2Layout.createSequentialGroup()
                .addGroup(pnlBC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBC2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBC2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlInit.add(pnlBC2);

        pnlCenterKHchange.add(pnlInit, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCenterKHchange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlCenterKHchange, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pnlTopLeft.add(jPanel12, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(pnlTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(366, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlCenter.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(1690, 56));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Báo cáo doanh thu");

        lblNameLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblNameLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameLogin.setText("Nguyễn Châu Tình ");
        lblNameLogin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblNameLoginAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMenu/icons8-user-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1206, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNameLogin)
                        .addGap(2, 2, 2)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlCenter.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pnlChange.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(pnlChange, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKHActionPerformed
        // TODO add your handling code here:
        showPanelChange(pnlChange, pnlCenter);
    }//GEN-LAST:event_btnLuuKHActionPerformed

    private void btnHuyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyKHActionPerformed
        // TODO add your handling code here:
        showPanelChange(pnlChange, pnlCenter);
    }//GEN-LAST:event_btnHuyKHActionPerformed

    private void btnQuayLaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiKHActionPerformed
        // TODO add your handling code here:nl
        showPanelChange(pnlChange, pnlCenter);
    }//GEN-LAST:event_btnQuayLaiKHActionPerformed

    private void txtTimKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKH1ActionPerformed

    private void txtTimKH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKH2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKH2ActionPerformed

    private void txtTongChiTieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongChiTieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongChiTieuActionPerformed

    private void txtTongDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDonHangActionPerformed

    private void txtTimKH10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKH10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKH10ActionPerformed

    private void txtTimKH5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKH5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKH5ActionPerformed

    private void txtTimKH6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKH6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKH6ActionPerformed

    private void txtTongChiTieu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongChiTieu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongChiTieu2ActionPerformed

    private void txtTongDonHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDonHang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDonHang2ActionPerformed

    private void txtTimKH12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKH12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKH12ActionPerformed

    private void btnQuayLaiKH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiKH2ActionPerformed
        // TODO add your handling code here:
        showPanelChange(pnlChange, pnlCenter);
        
    }//GEN-LAST:event_btnQuayLaiKH2ActionPerformed

    private void btnSuaKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKH1ActionPerformed
        // TODO add your handling code here:
        showPanelChange(pnlChange, pnlCenterThem);
    }//GEN-LAST:event_btnSuaKH1ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                evt.consume();
                showPanelChange(pnlChange, pnlCenterXem);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void lblNameLoginAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblNameLoginAncestorAdded
        // TODO add your handling code here:
        lblNameLogin.setText(gui.FrmLogin.tenNguoiDung);
    }//GEN-LAST:event_lblNameLoginAncestorAdded

    private void btnXemBCActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_btnXemBCActionPerformed
        if(tableXemBC.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null, "Hãy chọn bản báo cáo cần xem");
        }
        else{
            showPanelChange(pnlInit, pnlBC2);
            onField();
            try {
                // TODO add your handling code here:
                loadData2();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                Logger.getLogger(FrmXemBaoCao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXemBCActionPerformed

    public void showForm(Component com) {
        pnlCenter.removeAll();
        pnlCenter.add(com);
        pnlCenter.repaint();
        pnlCenter.revalidate();
    }
        public static String tenBBC = "";
    public static String maBBC = "";
    public static String tenNVBC = "";
    public static String thoiGianBC="";
//    private DAO_BanBaoCao dao_BBC1 = new DAO_BanBaoCao();
    private BanBaoCao_Dao dao_BBC1 = Dao_Package_Static.dao_BanBaoCao;
    private void tableXemBCMouseClicked(java.awt.event.MouseEvent evt) throws RemoteException {//GEN-FIRST:event_tableXemBCMouseClicked
        // TODO add your handling code here:
        if(evt.getSource().equals(tableXemBC)){
            tenBBC = tableXemBC.getValueAt(tableXemBC.getSelectedRow(), 1).toString();
            maBBC = String.valueOf(dao_BBC1.getMaBBCTheoTen(tableXemBC.getValueAt(tableXemBC.getSelectedRow(), 1) + ""));
            tenNVBC = tableXemBC.getValueAt(tableXemBC.getSelectedRow(), 2).toString();
            thoiGianBC = tableXemBC.getValueAt(tableXemBC.getSelectedRow(), 3).toString();
        }
        
    }//GEN-LAST:event_tableXemBCMouseClicked

    private void btnXemBC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemBC1ActionPerformed
        try {
            // TODO add your handling code here:
            loadData();
        } catch (SQLException | RemoteException ex) {
            Logger.getLogger(FrmXemBaoCao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXemBC1ActionPerformed

    private void txtDTCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTCNActionPerformed

    private void txtTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTSPActionPerformed
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyKH;
    private javax.swing.JButton btnLuuKH;
    private javax.swing.JButton btnQuayLaiKH;
    private javax.swing.JButton btnQuayLaiKH2;
    private javax.swing.JButton btnSuaKH1;
    private javax.swing.JButton btnXemBC;
    private javax.swing.JButton btnXemBC1;
    private javax.swing.JLabel date;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblDTCN;
    private javax.swing.JLabel lblNameLogin;
    private javax.swing.JLabel lblTSP;
    private javax.swing.JLabel lblTongChiTieu;
    private javax.swing.JLabel lblTongChiTieu2;
    private javax.swing.JLabel lblTongDonHang;
    private javax.swing.JLabel lblTongDonHang2;
    private menuGui.MenuScrollPane menuScrollPane3;
    private javax.swing.JPanel pnlBC1;
    private javax.swing.JPanel pnlBC2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlCenterKHchange;
    private javax.swing.JPanel pnlCenterKHchange1;
    private javax.swing.JPanel pnlCenterKHchange3;
    private javax.swing.JPanel pnlCenterThem;
    private javax.swing.JPanel pnlCenterXem;
    private javax.swing.JPanel pnlChange;
    private javax.swing.JPanel pnlInit;
    private javax.swing.JPanel pnlInit1;
    private javax.swing.JPanel pnlNull;
    private javax.swing.JPanel pnlTopLeft;
    private javax.swing.JPanel pnlTopLeft1;
    private javax.swing.JPanel pnlTopLeft3;
    private javax.swing.JTable tableBH;
    private javax.swing.JTable tableTT;
    private javax.swing.JTable tableXemBC;
    private javax.swing.JTextField txtDTCN;
    private javax.swing.JTextField txtNVBC;
    private javax.swing.JTextField txtTSP;
    private javax.swing.JTextField txtTimKH1;
    private javax.swing.JTextField txtTimKH10;
    private javax.swing.JTextField txtTimKH12;
    private javax.swing.JTextField txtTimKH2;
    private javax.swing.JTextField txtTimKH5;
    private javax.swing.JTextField txtTimKH6;
    private javax.swing.JTextField txtTongChiTieu;
    private javax.swing.JTextField txtTongChiTieu2;
    private javax.swing.JTextField txtTongDonHang;
    private javax.swing.JTextField txtTongDonHang2;
    // End of variables declaration//GEN-END:variables
}
