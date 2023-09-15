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
public class CanBo {

    protected String MaCB;
    protected String HoTen;
    protected String GioiTinh;
    protected String DiaChi;
    protected int NamSinh;

    public CanBo() {
    }

    public CanBo(String MaCB, String HoTen, String GioiTinh, String DiaChi, int NamSinh) {
        this.MaCB = MaCB;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.NamSinh = NamSinh;
    }

    public String getMaCB() {
        return MaCB;
    }

    public void setMaCB(String MaCB) {
        this.MaCB = MaCB;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

}
