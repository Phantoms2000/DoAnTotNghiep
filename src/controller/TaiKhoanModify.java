/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TaiKhoan;

/**
 *
 * @author AD
 */
public class TaiKhoanModify {

    private ConnectToDB ctd = new ConnectToDB();

    //Doc du lieu tu co so du lieu
    public ArrayList<TaiKhoan> getTaiKhoan() {
        ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();
        String sql = "SELECT * FROM TaiKhoan";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                tk.setMatKhau(rs.getString("MatKhau"));
                listTaiKhoan.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }

    //Them tai khoan vao co so du lieu
    public boolean themTaiKhoan(TaiKhoan tk) {
        String sql = "INSERT INTO TaiKhoan (TenTaiKhoan, MatKhau) VALUES (?,?)";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, tk.getTenTaiKhoan());
            ps.setString(2, tk.getMatKhau());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Sua tai khoan
    public boolean suaTaiKhoan(TaiKhoan tk) {
        String sql = "UPDATE TaiKhoan SET MatKhau = ? WHERE TenTaiKhoan = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, tk.getMatKhau());
            ps.setString(2, tk.getTenTaiKhoan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Xoa mat khau
    public boolean xoaTaiKhoan(String TenTaiKhoan) {
        String sql = "DELETE FROM TaiKhoan WHERE TenTaiKhoan = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, TenTaiKhoan);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Phan dang nhap
    public TaiKhoan dangNhap(String taiKhoan, String matKhau) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenTaiKhoan = ? AND MatKhau = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan t = new TaiKhoan();
                t.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                t.setMatKhau(rs.getString("MatKhau"));
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
