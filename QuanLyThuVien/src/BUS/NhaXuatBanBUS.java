/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Lộc
 */
import DAO.NhaXuatBanDAO;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;

public class NhaXuatBanBUS {
    private ArrayList<NhaXuatBanDTO> listNXB;
    
    public NhaXuatBanBUS(){
    
    }
    
    public void listNXB() throws Exception{
        NhaXuatBanDAO nxbdao=new NhaXuatBanDAO();
        listNXB=new ArrayList<NhaXuatBanDTO>();
        listNXB=nxbdao.list();
    }
    
    public ArrayList<NhaXuatBanDTO> Search(String MaNXB, String TenNXB){
        ArrayList<NhaXuatBanDTO> res=new ArrayList<NhaXuatBanDTO>();
        boolean manxb=false, tennxb=false;
        if(MaNXB.equals(""))
            manxb=true;
        if(TenNXB.equals(""))
            tennxb=true;
        for(NhaXuatBanDTO nxb: listNXB){
            if(!MaNXB.equals(""))
                manxb=(nxb.getMaNXB().equals(MaNXB)) ? true : false;
            if(!TenNXB.equals(""))
                tennxb=(nxb.getTenNXB().equals(TenNXB)) ? true : false;
            if(manxb && tennxb)
                res.add(nxb);
        }
        return res;
    }
    
    public ArrayList<NhaXuatBanDTO> getList(){
        return listNXB;
    }
}
