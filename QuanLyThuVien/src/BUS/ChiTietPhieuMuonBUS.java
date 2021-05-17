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
import DAO.ChiTietPhieuMuonDAO;
import DTO.ChiTietPhieuMuonDTO;
import DTO.SachDTO;
import DTO.PhieuMuonDTO;
import java.util.ArrayList;
public class ChiTietPhieuMuonBUS {
     private ArrayList<ChiTietPhieuMuonDTO> listChiTiet;
    public ChiTietPhieuMuonBUS(){
        
    }
    public void listChiTietPhieuMuon()throws Exception{
        ChiTietPhieuMuonDAO chitiet=new ChiTietPhieuMuonDAO();
        listChiTiet=new ArrayList<ChiTietPhieuMuonDTO>();
        listChiTiet=chitiet.list();   
    }
    public ArrayList<ChiTietPhieuMuonDTO> getList(){
        return listChiTiet;
    }
    public void Add(ChiTietPhieuMuonDTO chitietphieumuon) throws Exception{
        listChiTiet.add(chitietphieumuon);
        ChiTietPhieuMuonDAO ctphieumuondao=new ChiTietPhieuMuonDAO();
        ctphieumuondao.Insert(chitietphieumuon);
    }
    public void Edit(ChiTietPhieuMuonDTO ctpm) throws Exception {
        for(int i=0;i<listChiTiet.size();i++) {
            if(listChiTiet.get(i).getMaPhieuMuon().equals(ctpm.getMaPhieuMuon())) {
                listChiTiet.set(i, ctpm);
                ChiTietPhieuMuonDAO ctdao = new ChiTietPhieuMuonDAO();
                ctdao.Update(ctpm);
                return;
            }
        }
    }
    public ArrayList<ChiTietPhieuMuonDTO> Search(String MaPhieuMuon, String MaSach, int SoLuong) {
        ArrayList<ChiTietPhieuMuonDTO> res=new ArrayList<ChiTietPhieuMuonDTO>();
        boolean mapm=false, masach=false, soluong=false;
        if(MaSach.equals(""))
            masach=true;
        if(MaPhieuMuon.equals(""))
            mapm=true;
        if(SoLuong==-1)
            soluong=true;
        for(ChiTietPhieuMuonDTO ctpm: listChiTiet){
            if(!MaSach.equals(""))
                masach=(ctpm.getMaSach().contains(MaSach)) ? true : false;
            if(!MaPhieuMuon.equals(""))
                mapm=(ctpm.getMaPhieuMuon().contains(MaPhieuMuon)) ? true : false;
            if(SoLuong!=-1)
                soluong=(ctpm.getSoLuong()>=SoLuong) ? true : false;
            if(masach && mapm && soluong )
                res.add(ctpm);
        }
        return res;
    }
    
    public void Remove(String MaPhieuMuon, String MaSach, int SoLuong) throws Exception {
        for(ChiTietPhieuMuonDTO ctpm: listChiTiet) {
            if(ctpm.getMaPhieuMuon().equals(MaPhieuMuon) &&
                    ctpm.getMaSach().equals(MaSach) &&
                    ctpm.getSoLuong()==SoLuong) {
                listChiTiet.remove(ctpm);
                ChiTietPhieuMuonDAO ctpmdao = new ChiTietPhieuMuonDAO();
                ctpmdao.Delete(MaPhieuMuon, MaSach, SoLuong);
                return;
            }
        }
    }
}
