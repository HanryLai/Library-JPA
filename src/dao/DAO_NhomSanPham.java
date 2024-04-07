/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhomSanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_NhomSanPham {
    public DAO_NhomSanPham() {
		
	}
	public ArrayList<NhomSanPham> getAllNhomSanPham(){
		ArrayList<NhomSanPham> dsNsp = new ArrayList<NhomSanPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			
			String sql = "select * from NhomSanPham";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				String maNhomSanPham = rs.getString(1);
				String tenNhomSanPham = rs.getString(2);
				
				NhomSanPham nsp = new NhomSanPham(maNhomSanPham, tenNhomSanPham);
				dsNsp.add(nsp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNsp;
	}
	public NhomSanPham getNsptheoTen(String ten) {
		NhomSanPham nsp = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			String sql = "select * from NhomSanPham where tenNhomSanPham = ?";
			state = con.prepareStatement(sql);
			state.setString(1, ten);
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				String maNsp = rs.getString(1);
				String tenNsp = rs.getString(2);
				nsp = new NhomSanPham(maNsp, tenNsp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				state.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return nsp;
	}
	public NhomSanPham getNspTheoMa(String ma) {
		NhomSanPham nsp = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement state = null;
		try {
			String sql = "select * from NhomSanPham where maNhomSanPham = ?";
			state = con.prepareStatement(sql);
			state.setString(1, ma);
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				String maNsp = rs.getString(1);
				String tenNsp = rs.getString(2);
				nsp = new NhomSanPham(maNsp, tenNsp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				state.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return nsp;
	}
}
