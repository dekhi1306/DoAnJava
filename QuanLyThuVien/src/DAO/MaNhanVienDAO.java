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
import DTO.MaNhanVienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
public class MaNhanVienDAO {
    MyConnectUnit connect;
    public MaNhanVienDAO(){
        connect=DAO.getDAO();
    }
    public ArrayList<MaNhanVienDTO>list(String condition, String OderBy) throws Exception{
        ResultSet result =this.connect.Select("nhanvien", condition, OderBy);
        ArrayList<MaNhanVienDTO>listMaNhanVien=new ArrayList<MaNhanVienDTO>();
        while(result.next()){
            MaNhanVienDTO manv=new MaNhanVienDTO();
            manv.setMaNV(result.getString("MaNV"));
            manv.setHoLot(result.getString("HoLot"));
            manv.setTen(result.getString("Ten"));
            manv.setNgaySinh(result.getString("NgaySinh"));
            manv.setDienThoai(result.getString("DienThoai"));
            manv.setGioiTinh(result.getString("GioiTinh"));
            listMaNhanVien.add(manv);
        }
        return listMaNhanVien;
    }
    public ArrayList<MaNhanVienDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<MaNhanVienDTO> list() throws Exception{
        return list(null);
    }
    
}
