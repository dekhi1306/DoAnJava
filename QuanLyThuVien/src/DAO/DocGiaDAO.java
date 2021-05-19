package DAO;
import DTO.DocGiaDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class DocGiaDAO {
    MyConnectUnit connect;
     
    public DocGiaDAO() {
        connect=DAO.getDAO();
    }
     
    public ArrayList<DocGiaDTO> list(String condition, String OrderBy) throws Exception{
        ResultSet result=this.connect.Select("docgia", condition, OrderBy);
        ArrayList<DocGiaDTO> listDocGia=new ArrayList<DocGiaDTO>();
        while(result.next()){
            DocGiaDTO docgia=new DocGiaDTO();
            docgia.setMaDocGia(result.getString("MaDG"));
<<<<<<< HEAD
            docgia.setHoLot(result.getString("HoLot"));
            docgia.setTen(result.getString("Ten"));
            docgia.setNgaySinh(result.getString("NgaySinh"));
            docgia.setGioiTinh(result.getInt("GioiTinh"));
            docgia.setDienThoai(result.getString("DienThoai"));
            docgia.setDiaChi(result.getString("DiaChi"));
            docgia.setNgheNghiep(result.getString("NgheNghiep"));
            docgia.setTrinhDo(result.getString("TrinhDo"));
=======
            docgia.setHoDocGia(result.getString("HoLot"));
            docgia.setTenDocGia(result.getString("Ten"));
            docgia.setNgaysinh(result.getString("NgaySinh"));
            docgia.setGioiTinh(result.getInt("GioiTinh"));
            docgia.setDienthoai(result.getString("DienThoai"));
            docgia.setDiachi(result.getString("DiaChi"));
            docgia.setNghenghiep(result.getString("NgheNghiep"));
            docgia.setTrinhdo(result.getString("TrinhDo"));
>>>>>>> 4fb84017ed56f662d58cfb770b2af262c3c45695
            listDocGia.add(docgia);
        }
        return listDocGia;
    }
    
     public ArrayList<DocGiaDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<DocGiaDTO> list() throws Exception{
        return list(null);
    }
    
    public void Insert(DocGiaDTO docgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaDG", docgia.getMaDocGia());
        map.put("HoLot", docgia.getHoLot());
        map.put("Ten", docgia.getTen());
        map.put("NgaySinh", docgia.getNgaySinh());
        map.put("GioiTinh", docgia.getGioiTinh());
        map.put("DienThoai", docgia.getDienThoai());
        map.put("DiaChi", docgia.getDiaChi());
        map.put("NgheNghiep", docgia.getNgheNghiep());
        map.put("TrinhDo", docgia.getTrinhDo());
 
        this.connect.Insert("docgia", map);
    }
    
    public void Update(DocGiaDTO docgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaDG", docgia.getMaDocGia());
        map.put("HoLot", docgia.getHoLot());
        map.put("Ten", docgia.getTen());     
        map.put("NgaySinh", docgia.getNgaySinh());     
        map.put("GioiTinh", docgia.getGioiTinh());
        map.put("DienThoai", docgia.getDienThoai());
        map.put("DiaChi", docgia.getDiaChi());
        map.put("NgheNghiep", docgia.getNgheNghiep());
        map.put("TrinhDo", docgia.getTrinhDo());
 
        this.connect.Update("docgia", map, "MaDG = '" + docgia.getMaDocGia() + "'");
    }
    
    public void Delete(String MaDocGia) throws Exception{
        this.connect.Delete("docgia", "MaDG = '" + MaDocGia + "'" );    
    }
    
    public DocGiaDTO getByMa(String ma) throws Exception{
        ArrayList<DocGiaDTO> listDocGia=this.list("MaDG = " + "'" + ma + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
 
}    

