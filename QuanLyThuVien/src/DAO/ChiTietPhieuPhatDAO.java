/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author 01042001
 */
import DTO.ChiTietPhieuPhatDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
public class ChiTietPhieuPhatDAO {
    MyConnectUnit connect;
    
    public ChiTietPhieuPhatDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<ChiTietPhieuPhatDTO>list(String condition, String OderBY) throws Exception{
        ResultSet result=this.connect.Select("phieuphat", condition, OderBY);
        ArrayList<ChiTietPhieuPhatDTO> listphieuphat=new ArrayList<ChiTietPhieuPhatDTO>();
        while(result.next()){
            ChiTietPhieuPhatDTO chitietphieuphat=new ChiTietPhieuPhatDTO();
            chitietphieuphat.setMaPhieuPhat(result.getString("MaPhieuPhat"));
            chitietphieuphat.setMaSach(result.getString("MaSach"));
            chitietphieuphat.setMaLoiPhat(result.getString("MaLoiPhat"));
            listphieuphat.add(chitietphieuphat);
        }
        return listphieuphat;
    }
    public ArrayList<ChiTietPhieuPhatDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<ChiTietPhieuPhatDTO>list() throws Exception{
        return list(null);
    }
    public ChiTietPhieuPhatDTO getByID (String id) throws Exception{
        ArrayList<ChiTietPhieuPhatDTO> listPhieuMuon=this.list("MaPhieuMuon"+" "+id+" ");
        if(listPhieuMuon.size()>0)
            return listPhieuMuon.toArray(new ChiTietPhieuPhatDTO[listPhieuMuon.size()])[0];
        return null;
    }
}
