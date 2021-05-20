package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lộc
 */
import DTO.CTPhieuNhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ThongKeDAO {
    MyConnectUnit connect;
    
    public ThongKeDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<CTPhieuNhapDTO> listNH(ArrayList<String> MaPN) throws Exception{
        ResultSet result;
        ArrayList<CTPhieuNhapDTO> listRes = new ArrayList<CTPhieuNhapDTO>();
        String query;
        StringBuilder mapn;
        mapn = new StringBuilder();
        
        for(String ma: MaPN){
            mapn.append(ma);
            mapn.append(",");
        }
        mapn=mapn.delete(mapn.length()-1, mapn.length());
        
        query="SELECT MaSach, SUM(SoLuong) AS 'SoLuong', DonGia, SUM(ThanhTien) AS 'ThanhTien'  FROM `ctphieunhap` WHERE MaPN IN ("+mapn+") GROUP BY MaSach";
        
        result=connect.SelectTK(query);
        while(result.next()){
            CTPhieuNhapDTO ct=new CTPhieuNhapDTO();
            ct.setSach(result.getString("MaSach"));
            ct.setSoluong(result.getInt("SoLuong"));
            ct.setDongia(result.getInt("DonGia"));
            ct.setThanhtien(result.getInt("ThanhTien"));
            listRes.add(ct);
        }
        return listRes;
    }
    public static void main(String args[]) throws Exception {
        ThongKeDAO tk=new ThongKeDAO();
        ArrayList<String> MaPN=new ArrayList<String>();
        MaPN.add("1");
        MaPN.add("2");
        tk.listNH(MaPN);

    }
}
