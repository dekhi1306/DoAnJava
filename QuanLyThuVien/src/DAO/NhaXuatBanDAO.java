/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Lộc
 */
import DTO.NhaXuatBanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhaXuatBanDAO {
    MyConnectUnit connect;
    
    public NhaXuatBanDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<NhaXuatBanDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("nhaxuatban", condition, OrderBy);
        ArrayList<NhaXuatBanDTO> listNhaXuatBan=new ArrayList<NhaXuatBanDTO>();
        while(result.next()){
            NhaXuatBanDTO nhaxuatban=new NhaXuatBanDTO();
            nhaxuatban.setMaNXB(result.getString("MaNXB"));
            nhaxuatban.setTenNXB(result.getString("TenNXB"));
            listNhaXuatBan.add(nhaxuatban);
        }
        return listNhaXuatBan;
    }
    
    public ArrayList<NhaXuatBanDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<NhaXuatBanDTO> list() throws Exception{
        return list(null);
    }
    
    public NhaXuatBanDTO getByID(String id) throws Exception{
        ArrayList<NhaXuatBanDTO > listNhaXuatBan =this.list("MaNXB = " + "'" + id + "'");
        if(listNhaXuatBan.size()>0)
            return listNhaXuatBan.toArray(new NhaXuatBanDTO [listNhaXuatBan.size()])[0];
        return null;
    }
    
    public NhaXuatBanDTO getByName(String name) throws Exception{
        ArrayList<NhaXuatBanDTO> listNhaXuatBan=this.list("TenNXB = " + "'" + name + "'");
        if(listNhaXuatBan.size()>0)
            return listNhaXuatBan.toArray(new NhaXuatBanDTO[listNhaXuatBan.size()])[0];
        return null;
    }
}
