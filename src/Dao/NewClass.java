/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dao.DAO_ThongKe.ProductInfo;
import connectDB.ConnectDB;
import java.util.List;
import Entity.MonthlyRevenueInfo;

/**
 *
 * @author nguyen chau tai
 */
public class NewClass {
    public static void main(String[] args) {
        ConnectDB.getInstance().connect();  
        DAO_ThongKe tk = new DAO_ThongKe();
        List<ProductInfo> topProducts = tk.getTopSellingProducts();
        for (ProductInfo product : topProducts) {
            System.out.println("Product ID: " + product.getProductId() +
                               ", Total Quantity Sold: " + product.getTotalQuantity());
        }
        
        
        System.out.println(tk.tongDoanhThu(2023));
        System.out.println(tk.tongHoanTra(2023));
        List<MonthlyRevenueInfo> monthlyRevenueList = tk.tongTienTheoThang();

        // In thông tin từ danh sách
        for (MonthlyRevenueInfo info : monthlyRevenueList) {
            System.out.println("Month " + info.getMonth() + ": " + info.getTotalRevenue());
        }
        
        List<MonthlyRevenueInfo> list = tk.tienHoanTheoThang();

        // In thông tin từ danh sách
        for (MonthlyRevenueInfo info : list) {
            System.out.println("Month " + info.getMonth() + ": " + info.getTotalRevenue());
        }
        
        System.out.println(tk.thongKeTongSoHoaDon());
        System.out.println(tk.ThongKeTongDoanhThu());
    }
}
