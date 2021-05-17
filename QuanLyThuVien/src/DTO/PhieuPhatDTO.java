/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author 01042001
 */
public class PhieuPhatDTO {
     private String MaPhieuMuon;
    private String MaPieuPhat;
    private int TongTien;
    
    public PhieuPhatDTO(){
        
    }

    public String getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(String MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public String getMaPieuPhat() {
        return MaPieuPhat;
    }

    public void setMaPieuPhat(String MaPieuPhat) {
        this.MaPieuPhat = MaPieuPhat;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
}
