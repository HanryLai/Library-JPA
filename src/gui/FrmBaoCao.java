/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.Interface.BanBaoCao_Dao;
import dao.Interface.ChiTietBaoCao_Dao;
import dao.Interface.HoaDon_Dao;
import dao.Interface.NhanVien_Dao;
import entityJPA.BanBaoCao;
import entityJPA.ChiTietBanBaoCao;
import entityJPA.NhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
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
//public class FrmBaoCao extends javax.swing.JPanel {
public class FrmBaoCao extends javax.swing.JPanel {
    /**
     * Creates new form FrmDSKhachHang
     */
    private FrmChinh frm = new FrmChinh();
    private Thread thread = null;

 
    public FrmBaoCao() throws SQLException, RemoteException {
        initComponents();
        loadData();
        thread = new Thread(this::setTimeAuto);
        thread.start();
        frm.setSize(1690, 787);
        createChart();
    }
    
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
    
    private HoaDon_Dao dao_hoadon = Dao_Package_Static.dao_HoaDon;
    private CategoryDataset createDataset() throws RemoteException {
        String ngayHienTai = jDateChooser3.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("day:"+ngayHienTai);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(6, 0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(11, 0))){
            dataset.addValue(dao_CTBC.getDoanhThuTheoCa(Integer.parseInt(dao_hoadon.getMaHoaDonTheoNgay(ngayHienTai).get(0)), ngayHienTai+" 06:00:00", ngayHienTai+" 11:00:00"),
                "Doanh thu", "Sáng");
            dataset.addValue(0, "Doanh thu", "Chiều");
            dataset.addValue(0, "Doanh thu", "Tối");
        }
        else if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(11, 0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(16, 0))){
            dataset.addValue(0, "Doanh thu", "Sáng");
            dataset.addValue(dao_CTBC.getDoanhThuTheoCa(Integer.parseInt(dao_hoadon.getMaHoaDonTheoNgay(ngayHienTai).get(0)), ngayHienTai+" 11:00:00", ngayHienTai+" 16:00:00"),
                "Doanh thu", "Chiều");
            dataset.addValue(0, "Doanh thu", "Tối");
        }
        else{
            dataset.addValue(0, "Doanh thu", "Sáng");
            dataset.addValue(0, "Doanh thu", "Chiều");
            dataset.addValue(dao_CTBC.getDoanhThuTheoCa(Integer.parseInt(dao_hoadon.getMaHoaDonTheoNgay(ngayHienTai).get(0)), ngayHienTai+" 16:00:00", ngayHienTai+" 21:00:00"),
                "Doanh thu", "Tối");
        }
        return dataset;
    }
    
    private void showPanelChange(JPanel a, JPanel b) {
        a.removeAll();
        a.add(b);
        a.repaint();
        a.revalidate();
    }
    
    public void showForm(Component com) {
        pnlCenter.removeAll();
        pnlCenter.add(com);
        pnlCenter.repaint();
        pnlCenter.revalidate();
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
    
    public void deleteTable() {
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        jTable1.setModel(dm);
    }
    
    private BanBaoCao_Dao dao_BCDT = Dao_Package_Static.dao_BanBaoCao;
    private ChiTietBaoCao_Dao dao_CTBC = Dao_Package_Static.dao_ChiTietBaoCao;
    private ArrayList<entityJPA.ChiTietBanBaoCao> dataSach;
    private ArrayList<ChiTietBanBaoCao> dataVPP;
    private ArrayList<ChiTietBanBaoCao> dataTTSach;
    private ArrayList<ChiTietBanBaoCao> dataTTVPP;
    
    public String thietLapMaHoaDon() {
        // Lấy ngày hiện tại và lấy mã nhân viên từ DAO
        LocalDate ngayHienTai = LocalDate.now();
        String ngayHienTaiStr = ngayHienTai.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        return "HD" + ngayHienTaiStr + "%";
    }
    
    public void loadData() throws SQLException, RemoteException {
        deleteTable();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        LocalDateTime ngayHienTai = LocalDateTime.now();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));System.out.println("datetime: "+today+" 06:00:00");
        System.out.println("today: "+today);
        jDateChooser3.setDate(new Date());
        
        int stt1 = 1;
        if (ngayHienTai.toLocalTime().isAfter(LocalTime.of(6, 0)) && ngayHienTai.toLocalTime().isBefore(LocalTime.of(11, 0))){
            dataSach = dao_CTBC.getSachDaBan(today+" 06:00:00", today+" 11:00:00");
            System.out.println("dataS1: "+dataSach);
            for (ChiTietBanBaoCao ctbc : dataSach) {
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
            dataVPP = dao_CTBC.getVPPDaBan(today+" 06:00:00", today+" 11:00:00");
            for (ChiTietBanBaoCao ctbc : dataVPP) {
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
        else if (ngayHienTai.toLocalTime().isAfter(LocalTime.of(11, 0)) && ngayHienTai.toLocalTime().isBefore(LocalTime.of(16, 0))){
            dataSach = dao_CTBC.getSachDaBan(today+" 11:00:00", today+" 16:00:00");
            System.out.println("dataS2: "+dataSach);
            for (ChiTietBanBaoCao ctbc : dataSach) {
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
            dataVPP = dao_CTBC.getVPPDaBan(today+" 11:00:00", today+" 16:00:00");
            for (ChiTietBanBaoCao ctbc : dataVPP) {
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
        else {
            dataSach = dao_CTBC.getSachDaBan(today+" 16:00:00", today+" 21:00:00");
            System.out.println("dataS3: "+dataSach);
            for (ChiTietBanBaoCao ctbc : dataSach) {
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
            dataVPP = dao_CTBC.getVPPDaBan(today+" 16:00:00", today+" 21:00:00");
            for (ChiTietBanBaoCao ctbc : dataVPP) {
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
        
        
        
        
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        String ngayHienTai1 = jDateChooser3.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        dataTTSach = dao_CTBC.getTinhTrangNhapSach(ngayHienTai1);
        dataTTVPP = dao_CTBC.getTinhTrangNhapVPP(ngayHienTai1);
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
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlChange = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        pnlTopLeft = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlCenterKHchange = new javax.swing.JPanel();
        pnlInit = new javax.swing.JPanel();
        pnlBC1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNameLogin = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1690, 787));
        setLayout(new java.awt.BorderLayout());

        pnlChange.setLayout(new java.awt.BorderLayout());

        pnlCenter.setBackground(new java.awt.Color(153, 153, 153));
        pnlCenter.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(240, 242, 245));

        pnlTopLeft.setBackground(new java.awt.Color(204, 204, 255));
        pnlTopLeft.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(1312, 754));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jDateChooser3.setDateFormatString("dd-MM-yyyy");
        jDateChooser3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Tối");
        jLabel16.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel16AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setText("Ngày làm việc");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel24.setText("Ca làm việc:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("THÔNG TIN BÁO CÁO");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(45, 45, 45)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(563, 563, 563)
                .addComponent(jLabel3)
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(14, 14, 14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel16))
                        .addGap(15, 15, 15))))
        );

        pnlCenterKHchange.setBackground(new java.awt.Color(250, 250, 250));
        pnlCenterKHchange.setLayout(new java.awt.BorderLayout());

        pnlInit.setBackground(new java.awt.Color(250, 250, 250));
        pnlInit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlInit.setPreferredSize(new java.awt.Dimension(1150, 630));

        pnlBC1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Tình trạng");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Báo cáo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout pnlBC1Layout = new javax.swing.GroupLayout(pnlBC1);
        pnlBC1.setLayout(pnlBC1Layout);
        pnlBC1Layout.setHorizontalGroup(
            pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBC1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBC1Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        pnlBC1Layout.setVerticalGroup(
            pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBC1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBC1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlBC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlInitLayout = new javax.swing.GroupLayout(pnlInit);
        pnlInit.setLayout(pnlInitLayout);
        pnlInitLayout.setHorizontalGroup(
            pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        pnlInitLayout.setVerticalGroup(
            pnlInitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCenterKHchange.add(pnlInit, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCenterKHchange, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
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
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(pnlTopLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

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

    private void lblNameLoginAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblNameLoginAncestorAdded
        // TODO add your handling code here:
        lblNameLogin.setText(gui.FrmLogin.tenNguoiDung);
    }//GEN-LAST:event_lblNameLoginAncestorAdded
    private NhanVien_Dao dao_nhanvien = Dao_Package_Static.dao_NhanVien;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LocalDate today = jDateChooser3.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();        
        String todayString = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String ngayHienTai = jDateChooser3.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String caLv = "";
        if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(6, 0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(11, 0))) {
            caLv = "Sang";
        } else if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(11, 0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(16, 0))) {
            caLv = "Chieu";
        } else {
            caLv = "Toi";
        }
        
        String maBBC = "BC"+today.format(DateTimeFormatter.ofPattern("ddMMyyyy"))+
                "DTBH"+caLv; // BC01122023DTBHSang
        String tenBBC = "BaoCaoDoanhThu"+
                today.format(DateTimeFormatter.ofPattern("ddMMyyyy"))+caLv; // BaoCaoDoanhThu30112023Sang
        
        
        String tenNV = gui.FrmLogin.tenNguoiDung;
        String thoiGianBC = todayString+"-"+caLv; // 30/11/2023 - Sáng
        double doanhThu = 0;
        if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(6, 0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(11, 0))) {
            doanhThu = dao_CTBC.getDoanhThuTheoCa(Integer.parseInt(dao_hoadon.getMaHoaDonTheoNgay(ngayHienTai).get(0)),
                    today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 06:00:00", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 11:00:00");
        } else if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(11, 0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(16, 0))) {
            doanhThu = dao_CTBC.getDoanhThuTheoCa(Integer.parseInt(dao_hoadon.getMaHoaDonTheoNgay(ngayHienTai).get(0)),
                    today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 11:00:00", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 16:00:00");
        } else {
            doanhThu = dao_CTBC.getDoanhThuTheoCa(Integer.parseInt(dao_hoadon.getMaHoaDonTheoNgay(ngayHienTai).get(0)),
                    today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 16:00:00", today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" 21:00:00");
        }

        String ghiChu = "";
        BanBaoCao bbc = new BanBaoCao();
        bbc.setTenBanBaoCao(tenBBC);
        bbc.setTenNhanVien(tenNV);
        bbc.setThoiGianBaoCao(thoiGianBC);
        bbc.setDoanhThu(doanhThu);
        dao_BCDT.taoBanBaoCao(bbc);
        
        
        BanBaoCao bbc1 = new BanBaoCao();
        
        String tenSanPham = "";
        int soLuongBan = 0;
        double thanhTien = 0;
        int soLuongNhap = 0;
        int tonKho = 0;
        String ghiChuSP = "";
        for(int i=0;i<jTable1.getRowCount();i++){
            tenSanPham = jTable1.getValueAt(i, 1).toString();
            soLuongBan = Integer.parseInt(jTable1.getValueAt(i,2).toString());
            thanhTien = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            ghiChuSP = jTable1.getValueAt(i, 4).toString();
            
            ChiTietBanBaoCao ctbbc = new ChiTietBanBaoCao();
            ctbbc.setBanBaoCao(bbc1);
            ctbbc.getSanPham().setTenSanPham(tenSanPham);
            ctbbc.setSoLuongBan(soLuongBan);
            ctbbc.setThanhTien(thanhTien);
            ctbbc.setGhiChu(ghiChuSP);
            dao_CTBC.taoChiTietBaoCao(ctbbc);
            System.out.println("ctbbc: "+ctbbc);
        }
        for(int i=0;i<jTable2.getRowCount();i++){
            tenSanPham = jTable2.getValueAt(i, 1).toString();
            soLuongNhap = Integer.parseInt(jTable2.getValueAt(i,2).toString());
            tonKho = Integer.parseInt(jTable2.getValueAt(i, 3).toString());
            ghiChuSP = jTable2.getValueAt(i, 4).toString();
            
            ChiTietBanBaoCao ctbbc = new ChiTietBanBaoCao();
            ctbbc.setBanBaoCao(bbc1);
            ctbbc.getSanPham().setTenSanPham(tenSanPham);
            ctbbc.setSoLuongNhap(soLuongNhap);
            ctbbc.setTonKho(tonKho);
            ctbbc.setGhiChu(ghiChuSP);
            dao_CTBC.taoChiTietBaoCao(ctbbc);
            System.out.println("ctbbc: "+ctbbc);
            if(i==jTable2.getRowCount())
                JOptionPane.showMessageDialog(null, "Tạo thành công");
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel16AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel16AncestorAdded
        // TODO add your handling code here:
        if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(6,0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(11,0))) {
            jLabel16.setText("Sáng");
        } else if (LocalDateTime.now().toLocalTime().isAfter(LocalTime.of(11,0)) && LocalDateTime.now().toLocalTime().isBefore(LocalTime.of(16,0))) {
            jLabel16.setText("Chiều");
        } else {
            jLabel16.setText("Tối");
        }
    }//GEN-LAST:event_jLabel16AncestorAdded
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblNameLogin;
    private javax.swing.JPanel pnlBC1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlCenterKHchange;
    private javax.swing.JPanel pnlChange;
    private javax.swing.JPanel pnlInit;
    private javax.swing.JPanel pnlTopLeft;
    // End of variables declaration//GEN-END:variables
}
