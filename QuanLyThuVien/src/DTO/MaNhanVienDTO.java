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
    private String MaNV,HoLot,Ten;
    public MaNhanVienDTO(){
        
    }

    public MaNhanVienDTO(String MaNV, String HoLot, String Ten) {
        this.MaNV = MaNV;
        this.HoLot = HoLot;
        this.Ten = Ten;
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
