/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KySu;

/**
 *
 * @author AD
 */
public class KySuModify {

    private ConnectToDB ctd = new ConnectToDB();

    //Doc du lieu tu co so du lieu
    public ArrayList<KySu> getListKySu() {
        ArrayList<KySu> listKySu = new ArrayList<KySu>();
        String sql = "SELECT * FROM KySu";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu ks = new KySu();
                ks.setMaCB(rs.getString("MaKS"));
                ks.setHoTen(rs.getString("HoTenKS"));
                ks.setGioiTinh(rs.getString("GioiTinh"));
                ks.setDiaChi(rs.getString("DiaChi"));
                ks.setNamSinh(rs.getInt("NamSinh"));
                ks.setNganhDT(rs.getString("NganhDT"));
                ks.setLoaiBang(rs.getString("LoaiBang"));
                listKySu.add(ks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKySu;
    }

    //Chen du lieu vao co so du lieu
    public boolean themKySu(KySu ks) {
        String sql = "INSERT INTO KySu (MaKS, HoTenKS, GioiTinh, DiaChi, NamSinh, NganhDT, LoaiBang) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, ks.getMaCB());
            ps.setString(2, ks.getHoTen());
            ps.setString(3, ks.getGioiTinh());
            ps.setString(4, ks.getDiaChi());
            ps.setInt(5, ks.getNamSinh());
            ps.setString(6, ks.getNganhDT());
            ps.setString(7, ks.getLoaiBang());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Sua thong tin ky su
    public boolean suaKySu(KySu ks) {
        String sql = "UPDATE KySu SET HoTenKS = ?, GioiTinh = ?, DiaChi = ?, NamSinh = ?, NganhDT = ?, LoaiBang = ? WHERE MaKS = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, ks.getHoTen());
            ps.setString(2, ks.getGioiTinh());
            ps.setString(3, ks.getDiaChi());
            ps.setInt(4, ks.getNamSinh());
            ps.setString(5, ks.getNganhDT());
            ps.setString(6, ks.getLoaiBang());
            ps.setString(7, ks.getMaCB());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Xoa thong tin ky su theo ma
    public boolean xoaKySu(String MaCB) {
        String sql = "DELETE FROM KySu WHERE MaKS = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, MaCB);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Tim kiem thong tin ky su
    public KySu timKySu(String MaCB) {
        String sql = "SELECT * FROM KySu WHERE MaKS = ?";
        try {
            PreparedStatement ps = ctd.getConnectionToDB().prepareStatement(sql);
            ps.setString(1, MaCB);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KySu k = new KySu();
                k.setMaCB(rs.getString("MaKS"));
                k.setHoTen(rs.getString("HoTenKS"));
                k.setGioiTinh(rs.getString("GioiTinh"));
                k.setDiaChi(rs.getString("DiaChi"));
                k.setNamSinh(rs.getInt("NamSinh"));
                k.setNganhDT(rs.getString("NganhDT"));
                k.setLoaiBang(rs.getString("LoaiBang"));
                return k;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
