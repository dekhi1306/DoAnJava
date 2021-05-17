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
public class MaNhanVienDTO {
    private String MaNV,HoLot,Ten,NgaySinh,DienThoai, GioiTinh;
    public MaNhanVienDTO(){
        
    }

    public MaNhanVienDTO(String MaNV, String HoLot, String Ten, String NgaySinh, String DienThoai, String GioiTinh) {
        this.MaNV = MaNV;
        this.HoLot = HoLot;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.DienThoai = DienThoai;
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    
    

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoLot() {
        return HoLot;
    }

    public void setHoLot(String HoLot) {
        this.HoLot = HoLot;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
}
