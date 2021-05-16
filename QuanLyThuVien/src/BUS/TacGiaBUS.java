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
import DAO.TacGiaDAO;
import DTO.TacGiaDTO;
import java.util.ArrayList;

public class TacGiaBUS {
    private ArrayList<TacGiaDTO> listTacGia;
    
    public TacGiaBUS(){
    
    }
    
    public void listTacGia() throws Exception{
        TacGiaDAO tacgiadao=new TacGiaDAO();
        listTacGia=new ArrayList<TacGiaDTO>();
        listTacGia=tacgiadao.list();
    }
    
    public ArrayList<TacGiaDTO> Search(String MaTG, String TenTG){
        ArrayList<TacGiaDTO> res=new ArrayList<TacGiaDTO>();
        boolean matg=false, tentg=false;
        if(MaTG.equals(""))
            matg=true;
        if(TenTG.equals(""))
            tentg=true;
        for(TacGiaDTO tg: listTacGia){
            if(!MaTG.equals(""))
                matg=(tg.getMaTacGia().contains(MaTG)) ? true : false;
            if(!TenTG.equals(""))
                tentg=(tg.getTenTacGia().contains(TenTG)) ? true : false;
            if(matg && tentg)
                res.add(tg);
        }
        return res;
    }
    
    public ArrayList<TacGiaDTO> getList(){
        return listTacGia;
    }
  
}
