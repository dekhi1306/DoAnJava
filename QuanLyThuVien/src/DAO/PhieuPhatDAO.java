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
import DTO.PhieuPhatDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
public class PhieuPhatDAO {
    MyConnectUnit connect;
    
    public PhieuPhatDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<PhieuPhatDTO>list(String condition, String OderBY) throws Exception{
        ResultSet result=this.connect.Select("phieuphat", condition, OderBY);
        ArrayList<PhieuPhatDTO> listphieuphat=new ArrayList<PhieuPhatDTO>();
        while(result.next()){
            PhieuPhatDTO phieuphat=new PhieuPhatDTO();
            phieuphat.setMaPieuPhat(result.getString("MaPhieuPhat"));
            phieuphat.setMaPhieuMuon(result.getString("MaPhieuMuon"));
            phieuphat.setTongTien(result.getInt("TongTien"));
            listphieuphat.add(phieuphat);
        }
        return listphieuphat;
    }
    public ArrayList<PhieuPhatDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<PhieuPhatDTO>list() throws Exception{
        return list(null);
    }
    public PhieuPhatDTO getByID (String id) throws Exception{
        ArrayList<PhieuPhatDTO> listPhieuMuon=this.list("MaPhieuMuon"+" "+id+" ");
        if(listPhieuMuon.size()>0)
            return listPhieuMuon.toArray(new PhieuPhatDTO[listPhieuMuon.size()])[0];
        return null;
    }
}
