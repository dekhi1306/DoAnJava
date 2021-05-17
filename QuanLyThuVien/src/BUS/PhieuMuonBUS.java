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
import DAO.PhieuMuonDAO;
import DTO.PhieuMuonDTO;
import DTO.PhieuPhatDTO;
import DTO.ChiTietPhieuMuonDTO;
import DTO.ChiTietPhieuPhatDTO;
import java.util.ArrayList;
public class PhieuMuonBUS {
    private ArrayList<PhieuMuonDTO> listPhieuMuon;
    
    public void listPhieuMuon () throws Exception{
        PhieuMuonDAO phieumuon=new PhieuMuonDAO();
        listPhieuMuon=new ArrayList<PhieuMuonDTO>();
        listPhieuMuon=phieumuon.list();
    }
    public ArrayList<PhieuMuonDTO> getList(){
        return listPhieuMuon;
    }
    public void Add(PhieuMuonDTO phieumuon) throws Exception{
        listPhieuMuon.add(phieumuon);
        PhieuMuonDAO phieumuondao=new PhieuMuonDAO();
        phieumuondao.Insert(phieumuon);
    }
}
