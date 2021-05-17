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
}
