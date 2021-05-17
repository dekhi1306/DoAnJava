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
import DAO.MaNhanVienDAO;
import DTO.MaNhanVienDTO;
import java.util.ArrayList;
public class MaNhanVienBUS {
    private ArrayList<MaNhanVienDTO>ListMaNhanVien;
    
    public MaNhanVienBUS(){
        
    }
    public void listMaNV() throws Exception{
        MaNhanVienDAO mnvdao=new MaNhanVienDAO();
        ListMaNhanVien = new ArrayList<MaNhanVienDTO>();
        ListMaNhanVien=mnvdao.list();
    }
   public ArrayList<MaNhanVienDTO> Search(String MaNV, String HoLot, String Ten, String NgaySinh, String DienThoai, String GioiTinh){
        ArrayList<MaNhanVienDTO> res=new ArrayList<MaNhanVienDTO>();
        boolean manv=false, holot=false,ten=false,ngaysinh=false,dienthoai=false,gioitinh=false;
        String gt;
        if(MaNV.equals(""))
            manv=true;
        if(HoLot.equals(""))
            holot=true;
        if(Ten.equals(""))
            ten=true;
        if(NgaySinh.equals(""))
            ngaysinh=true;
        if(DienThoai.equals(""))
            dienthoai=true;
        if(GioiTinh.equals(""))
            gioitinh=true;
        for(MaNhanVienDTO ms: ListMaNhanVien){
            if(!MaNV.equals(""))
                manv=(ms.getMaNV().contains(MaNV)) ? true : false;
            if(!HoLot.equals(""))
                holot=(ms.getHoLot().contains(HoLot)) ? true : false;
            if(!Ten.equals(""))
                ten=(ms.getTen().contains(Ten)) ? true : false;
            if(!NgaySinh.equals(""))
                ngaysinh=(ms.getNgaySinh().contains(NgaySinh)) ? true : false;
            if(!DienThoai.equals(""))
                dienthoai=(ms.getDienThoai().contains(DienThoai)) ? true : false;
            if(!GioiTinh.equals("")){
                if(Integer.parseInt(ms.getGioiTinh())==1){
                    gt="Nam";
                }else gt="Nữ";
                gioitinh=(gt.contains(GioiTinh)) ? true : false;}
            
            if(manv && holot && ten && ngaysinh && dienthoai && gioitinh)
                res.add(ms);
        }
        return res;
    }
    
    public ArrayList<MaNhanVienDTO> getList(){
        return ListMaNhanVien;
    }
}
