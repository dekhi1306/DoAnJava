/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Vy
 */
import DTO.CTPhieuNhapDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.HashMap;

public class CTPhieuNhapDAO {

    MyConnectUnit connect;

    public CTPhieuNhapDAO() {
        connect = DAO.getDAO();
    }

    public ArrayList<CTPhieuNhapDTO> list(String condition, String OderBy) throws Exception {
        ResultSet result = this.connect.Select("ctphieunhap", condition, OderBy);
        ArrayList<CTPhieuNhapDTO> listctphieunhap = new ArrayList<CTPhieuNhapDTO>();
        while (result.next()) {
               CTPhieuNhapDTO chitiet=new CTPhieuNhapDTO();
               chitiet.setPhieunhap(result.getString("MaPN"));
               chitiet.setSach(result.getString("MaSach"));
               chitiet.setSoluong(result.getInt("SoLuong"));
               chitiet.setDongia(result.getInt("DonGia"));
               chitiet.setThanhtien(result.getInt("ThanhTien"));
               listctphieunhap.add(chitiet);
        }
        return listctphieunhap;
                
    }
    public ArrayList<CTPhieuNhapDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<CTPhieuNhapDTO>list() throws Exception{
        return list(null);
    }
    public CTPhieuNhapDTO getByID (String id) throws Exception{
        ArrayList<CTPhieuNhapDTO> listPhieuNhap=this.list("MaPN"+" "+id+" ");
        if(listPhieuNhap.size()>0)
            return listPhieuNhap.toArray(new CTPhieuNhapDTO[listPhieuNhap.size()])[0];
        return null;
    }
    public void Insert(CTPhieuNhapDTO ctphieunhap) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPN", ctphieunhap.getPhieunhap());
        map.put("MaSach", ctphieunhap.getSach());
        map.put("SoLuong", ctphieunhap.getSoluong());
        map.put("DonGia", ctphieunhap.getDongia());
        map.put("ThanhTien", ctphieunhap.getThanhtien());
 
        this.connect.Insert("ctphieunhap"+ "", map);
    }
     public void Update(CTPhieuNhapDTO ctphieunhap) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPN", ctphieunhap.getPhieunhap());
        map.put("MaSach", ctphieunhap.getSach());
        map.put("SoLuong", ctphieunhap.getSoluong());
        map.put("DonGia", ctphieunhap.getDongia());
        map.put("ThanhTien", ctphieunhap.getThanhtien());
 
        this.connect.Update("ctphieunhap", map, "MaPN = '" + ctphieunhap.getPhieunhap() + "'");
    }

    public void Delete(String MaPhieuNhapHang, String MaSach, int SoLuong, int DonGia, int ThanhTien) throws Exception {
         this.connect.Delete("ctphieunhap", "MaPN = '" + MaPhieuNhapHang+"'AND MaSach = '" + MaSach+ "' AND SoLuong = '" + SoLuong+"'AND DonGia = '" + DonGia+ "'AND ThanhTien = '" + ThanhTien+"'" );    
    }
}
