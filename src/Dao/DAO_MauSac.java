/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connectDB.ConnectDB;
import Entity.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguyen chau tai
 */
public class DAO_MauSac {

    public DAO_MauSac() {

    }

    public ArrayList<MauSac> getAlltbMauSac() {
        ArrayList<MauSac> dsMau = new ArrayList<MauSac>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {

            String sql = "select * from MauSac";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String maMau = rs.getString(1);
                String tenMau = rs.getString(2);
                MauSac mau = new MauSac(maMau, tenMau);
                dsMau.add(mau);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return dsMau;
    }

    public MauSac getMauSactheoMa(String ma) {
        MauSac mau = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from MauSac where maMau = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ma);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maMau");
                String tenSP = rs.getString("tenMau");
                mau = new MauSac(maSP, tenSP);
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
        return mau;
    }
    public MauSac getMauSactheoTen(String ten) {
        MauSac mau = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement state = null;
        try {
            String sql = "select * from MauSac where tenMau = ?";
            state = con.prepareStatement(sql);
            state.setString(1, ten);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("maMau");
                String tenSP = rs.getString("tenMau");
                mau = new MauSac(maSP, tenSP);
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
        return mau;
    }
}
