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
import DTO.PhieuMuonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
public class PhieuMuonDAO {
    MyConnectUnit connect;
    
    public PhieuMuonDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<PhieuMuonDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("phieumuon", condition, OrderBy);
        ArrayList<PhieuMuonDTO> listPhieuMuon=new ArrayList<PhieuMuonDTO>();
        while(result.next()){
            PhieuMuonDTO phieumuon=new PhieuMuonDTO();
            phieumuon.setMaPhieuMuon(result.getString("MaPhieuMuon"));
            phieumuon.setMaDocGia(result.getString("MaDocGia"));
            phieumuon.setMaNhanVien(result.getString("MaNhanVien"));
            phieumuon.setNgayMuon(result.getString("NgayMuon"));
            phieumuon.setNgayHenTra(result.getString("NgayHenTra"));
            listPhieuMuon.add(phieumuon);
        }
        return listPhieuMuon;
    }
    public ArrayList<PhieuMuonDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    public ArrayList<PhieuMuonDTO>list() throws Exception{
        return list(null);
    }
    public PhieuMuonDTO getByID (String id) throws Exception{
        ArrayList<PhieuMuonDTO> listPhieuMuon=this.list("MaPhieuMuon"+" "+id+" ");
        if(listPhieuMuon.size()>0)
            return listPhieuMuon.toArray(new PhieuMuonDTO[listPhieuMuon.size()])[0];
        return null;
    }
    public void Insert(PhieuMuonDTO phieumuon) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaPhieuMuon", phieumuon.getMaPhieuMuon());
        map.put("MaDocGia", phieumuon.getMaDocGia());
        map.put("MaNhanVien", phieumuon.getMaNhanVien());
        map.put("NgayMuon", phieumuon.getNgayMuon());
        map.put("NgayHenTra", phieumuon.getNgayHenTra());
 
        this.connect.Insert("phieumuon"+ "", map);
    }
    
    public void Update(PhieuMuonDTO sach) throws Exception{
        /*HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaSach", sach.getMaSach());
        map.put("TenSach", sach.getTenSach());
        theloai=theloaidao.getByName(sach.getTheLoai());
        map.put("MaTL", theloai.getMaTheLoai());
        tacgia=tacgiadao.getByName(sach.getTacGia());
        map.put("MaTG", tacgia.getMaTacGia());
        nhaxuatban=nxbdao.getByName(sach.getNhaXuatBan());
        map.put("MaNXB", nhaxuatban.getMaNXB());
        map.put("NamXuatBan", sach.getNamXuatBan());
        map.put("SoLuong", sach.getSoLuong());
        map.put("DonGia", sach.getDonGia());
 
        this.connect.Update("sach", map, "MaSach = '" + sach.getMaSach() + "'");*/
    }
    
    public void Delete(String MaSach) throws Exception{
        //this.connect.Delete("sach", "MaSach = '" + MaSach + "'" );    
    }
}
