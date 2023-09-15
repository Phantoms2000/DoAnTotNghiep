/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AD
 */
public class NhanVien extends CanBo {

    private String CongViec;

    public NhanVien() {
    }

    public NhanVien(String CongViec, String MaCB, String HoTen, String GioiTinh, String DiaChi, int NamSinh) {
        super(MaCB, HoTen, GioiTinh, DiaChi, NamSinh);
        this.CongViec = CongViec;
    }

    public String getCongViec() {
        return CongViec;
    }

    public void setCongViec(String CongViec) {
        this.CongViec = CongViec;
    }

}
