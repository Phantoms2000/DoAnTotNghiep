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
public class TaiKhoan {

    private String TenTaiKhoan;
    private String MatKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenTaiKhoan, String MatKhau) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

}
