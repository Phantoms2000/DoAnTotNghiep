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
public class KySu extends CanBo {

    private String NganhDT;
    private String LoaiBang;

    public KySu() {
    }

    public KySu(String NganhDT, String LoaiBang, String MaCB, String HoTen, String GioiTinh, String DiaChi, int NamSinh) {
        super(MaCB, HoTen, GioiTinh, DiaChi, NamSinh);
        this.NganhDT = NganhDT;
        this.LoaiBang = LoaiBang;
    }

    public String getNganhDT() {
        return NganhDT;
    }

    public void setNganhDT(String NganhDT) {
        this.NganhDT = NganhDT;
    }

    public String getLoaiBang() {
        return LoaiBang;
    }

    public void setLoaiBang(String LoaiBang) {
        this.LoaiBang = LoaiBang;
    }

}
