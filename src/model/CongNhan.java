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
public class CongNhan extends CanBo {

    private int Bac;

    public CongNhan() {
    }

    public CongNhan(int Bac, String MaCB, String HoTen, String GioiTinh, String DiaChi, int NamSinh) {
        super(MaCB, HoTen, GioiTinh, DiaChi, NamSinh);
        this.Bac = Bac;
    }

    public int getBac() {
        return Bac;
    }

    public void setBac(int Bac) {
        this.Bac = Bac;
    }

}
