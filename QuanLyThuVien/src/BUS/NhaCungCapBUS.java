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
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    private ArrayList<NhaCungCapDTO> listNhaCungCap;
    
    public NhaCungCapBUS(){
    
    }
    
    public void listNhaCungCap() throws Exception{
        NhaCungCapDAO nhacungcapdao=new NhaCungCapDAO();
        listNhaCungCap=new ArrayList<NhaCungCapDTO>();
        listNhaCungCap=nhacungcapdao.list();
    }
    
    public ArrayList<NhaCungCapDTO> Search(String MaNCC, String TenNCC){
        ArrayList<NhaCungCapDTO> res=new ArrayList<NhaCungCapDTO>();
        boolean mancc=false, tenncc=false;
        if(MaNCC.equals(""))
            mancc=true;
        if(TenNCC.equals(""))
            tenncc=true;
        for(NhaCungCapDTO ncc: listNhaCungCap){
            if(!MaNCC.equals(""))
                mancc=(ncc.getMaNCC().contains(MaNCC)) ? true : false;
            if(!TenNCC.equals(""))
                tenncc=(ncc.getTenNCC().contains(TenNCC)) ? true : false;
            if(mancc && tenncc)
                res.add(ncc);
        }
        return res;
    }
    
    public ArrayList<NhaCungCapDTO> getList(){
        return listNhaCungCap;
    }
  
}
