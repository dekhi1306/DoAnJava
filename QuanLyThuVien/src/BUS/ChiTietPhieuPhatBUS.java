/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author 01042001
 */
import DAO.ChiTietPhieuPhatDAO;
import DTO.ChiTietPhieuPhatDTO;
import java.util.ArrayList;
public class ChiTietPhieuPhatBUS {
    private ArrayList<ChiTietPhieuPhatDTO> listChiTiet;
    public ChiTietPhieuPhatBUS(){
        
    }
    public void listChiTietPhieuPhat()throws Exception{
        ChiTietPhieuPhatDAO chitiet=new ChiTietPhieuPhatDAO();
        listChiTiet=new ArrayList<ChiTietPhieuPhatDTO>();
        listChiTiet=chitiet.list();   
    }
    public ArrayList<ChiTietPhieuPhatDTO> getList(){
        return listChiTiet;
    }
    public void Add(ChiTietPhieuPhatDTO chitietphieuphat) throws Exception{
        listChiTiet.add(chitietphieuphat);
        ChiTietPhieuPhatDAO ctphieumuondao=new ChiTietPhieuPhatDAO();
        ctphieumuondao.Insert(chitietphieuphat);
    }
    public void Edit(ChiTietPhieuPhatDTO ctpm) throws Exception {
        for(int i=0;i<listChiTiet.size();i++) {
            if(listChiTiet.get(i).getMaPhieuPhat().equals(ctpm.getMaPhieuPhat())) {
                listChiTiet.set(i, ctpm);
                ChiTietPhieuPhatDAO ctdao = new ChiTietPhieuPhatDAO();
                ctdao.Update(ctpm);
                return;
            }
        }
    }
    public ArrayList<ChiTietPhieuPhatDTO> Search(String MaPhieuPhat, String MaSach, String MaLoiPhat) {
        ArrayList<ChiTietPhieuPhatDTO> res=new ArrayList<ChiTietPhieuPhatDTO>();
        boolean mapp=false, masach=false, malp=false;
        if(MaSach.equals(""))
            masach=true;
        if(MaPhieuPhat.equals(""))
            mapp=true;
        if(MaLoiPhat.equals(""))
            malp=true;
        for(ChiTietPhieuPhatDTO ctpm: listChiTiet){
            if(!MaSach.equals(""))
                masach=(ctpm.getMaSach().contains(MaSach)) ? true : false;
            if(!MaPhieuPhat.equals(""))
                mapp=(ctpm.getMaPhieuPhat().contains(MaPhieuPhat)) ? true : false;
            if(!MaLoiPhat.equals(""))
                malp=(ctpm.getMaLoiPhat().contains(MaLoiPhat)) ? true : false;
            if(masach && mapp && malp )
                res.add(ctpm);
        }
        return res;
    }
    
    public void Remove(String MaPhieuPhat, String MaSach, String MaLoiPhat) throws Exception {
        for(ChiTietPhieuPhatDTO ctpm: listChiTiet) {
            if(ctpm.getMaPhieuPhat().equals(MaPhieuPhat) &&
                    ctpm.getMaSach().equals(MaSach) &&
                    ctpm.getMaLoiPhat().equals(MaLoiPhat) ) {
                listChiTiet.remove(ctpm);
                ChiTietPhieuPhatDAO ctpmdao = new ChiTietPhieuPhatDAO();
                ctpmdao.Delete(MaPhieuPhat, MaSach, MaLoiPhat);
                return;
            }
        }
    }
}
