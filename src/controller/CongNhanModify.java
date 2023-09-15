/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CongNhan;

/**
 *
 * @author AD
 */
public class CongNhanModify {

    private ConnectToDB ctd = new ConnectToDB();

    //Doc du lieu tu csdl
    public ArrayList<CongNhan> getListCongNhan() {
        ArrayList<CongNhan> listCongNhan = new ArrayList<CongNhan>();
        String sql = "SELECT * FROM CongNhan";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CongNhan cn = new CongNhan();
                cn.setMaCB(rs.getString("MaCN"));
                cn.setHoTen(rs.getString("HoTenCN"));
                cn.setGioiTinh(rs.getString("GioiTinh"));
                cn.setDiaChi(rs.getString("DiaChi"));
                cn.setNamSinh(rs.getInt("NamSinh"));
                cn.setBac(rs.getInt("Bac"));
                listCongNhan.add(cn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCongNhan;
    }

    //Them cong nhan vao co so du lieu
    public boolean themCongNhan(CongNhan cn) {
        String sql = "INSERT INTO CongNhan (MaCN, HoTenCN, GioiTinh, DiaChi, NamSinh, Bac) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, cn.getMaCB());
            ps.setString(2, cn.getHoTen());
            ps.setString(3, cn.getGioiTinh());
            ps.setString(4, cn.getDiaChi());
            ps.setInt(5, cn.getNamSinh());
            ps.setInt(6, cn.getBac());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Sua thong tin cong nhan
    public boolean suaCongNhan(CongNhan cn){
        String sql = "UPDATE CongNhan SET HoTenCN = ?, GioiTinh = ?, DiaChi = ?, NamSinh = ?, Bac = ? WHERE MaCN = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, cn.getHoTen());
            ps.setString(2, cn.getGioiTinh());
            ps.setString(3, cn.getDiaChi());
            ps.setInt(4, cn.getNamSinh());
            ps.setInt(5, cn.getBac());
            ps.setString(6, cn.getMaCB());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Xoa thong tin cong nhan
    public boolean xoaCongNhan(String MaCB){
        String sql = "DELETE FROM CongNhan WHERE MaCN = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, MaCB);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Tim kiem cong nhan
    public CongNhan timCongNhan(String MaCB){
        String sql = "SELECT * FROM CongNhan WHERE MaCN = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, MaCB);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CongNhan c = new CongNhan();
                c.setMaCB(rs.getString("MaCN"));
                c.setHoTen(rs.getString("HoTenCN"));
                c.setGioiTinh(rs.getString("GioiTinh"));
                c.setDiaChi(rs.getString("DiaChi"));
                c.setNamSinh(rs.getInt("NamSinh"));
                c.setBac(rs.getInt("Bac"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
