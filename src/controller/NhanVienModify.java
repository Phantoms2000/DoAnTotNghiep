/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanVien;

/**
 *
 * @author AD
 */
public class NhanVienModify {

    private ConnectToDB ctd = new ConnectToDB();

    //Doc du lieu tu co so du lieu
    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<NhanVien>();
        String sql = "SELECT * FROM NhanVien";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaCB(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setNamSinh(rs.getInt("NamSinh"));
                nv.setCongViec(rs.getString("CongViec"));
                listNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    //Them du lieu vao co so du lieu
    public boolean themNhanVien(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, HoTenNV, GioiTinh, DiaChi, NamSinh, CongViec) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, nv.getMaCB());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getGioiTinh());
            ps.setString(4, nv.getDiaChi());
            ps.setInt(5, nv.getNamSinh());
            ps.setString(6, nv.getCongViec());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Sua thong tin nhan vien
    public boolean suaNhanVien(NhanVien nv){
        String sql = "UPDATE NhanVien SET HoTenNV = ?, GioiTinh = ?, DiaChi = ?, NamSinh = ?, CongViec = ? WHERE MaNV = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getGioiTinh());
            ps.setString(3, nv.getDiaChi());
            ps.setInt(4, nv.getNamSinh());
            ps.setString(5, nv.getCongViec());
            ps.setString(6, nv.getMaCB());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Xoa thong tin nhan vien
    public boolean xoaNhanVien(String MaCB){
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, MaCB);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Tim kiem thong tin nhan vien theo ma
    public NhanVien timNhanVien(String MaCB){
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, MaCB);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien n = new NhanVien();
                n.setMaCB(rs.getString("MaNV"));
                n.setHoTen(rs.getString("HoTenNV"));
                n.setGioiTinh(rs.getString("GioiTinh"));
                n.setDiaChi(rs.getString("DiaChi"));
                n.setNamSinh(rs.getInt("NamSinh"));
                n.setCongViec(rs.getString("CongViec"));
                return n;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
