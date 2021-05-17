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
import DTO.LoiPhatDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
public class LoiPhatDAO {
    MyConnectUnit connect;
    
    public LoiPhatDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<LoiPhatDTO>list(String condition, String OderBY) throws Exception{
        ResultSet result=this.connect.Select("phieuphat", condition, OderBY);
        ArrayList<LoiPhatDTO> listloiphat=new ArrayList<LoiPhatDTO>();
        while(result.next()){
            LoiPhatDTO loiphat=new LoiPhatDTO();
            loiphat.setMaLoiPhat(result.getString("MaLoiPhat"));
            loiphat.setTenLoiPhat(result.getString("TenLoiPhat"));
            loiphat.setTienPhat(result.getInt("TienPhat"));
            listloiphat.add(loiphat);
        }
        return listloiphat;
    }
    public ArrayList<LoiPhatDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<LoiPhatDTO>list() throws Exception{
        return list(null);
    }
    public LoiPhatDTO getByID (String id) throws Exception{
        ArrayList<LoiPhatDTO> listPhieuMuon=this.list("MaPhieuMuon"+" "+id+" ");
        if(listPhieuMuon.size()>0)
            return listPhieuMuon.toArray(new LoiPhatDTO[listPhieuMuon.size()])[0];
        return null;
    }
}
