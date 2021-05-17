
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
            docgia.setHoDocGia(result.getString("HoLot"));
            docgia.setTenDocGia(result.getString("Ten"));
            docgia.setNgaysinh(result.getString("NgaySinh"));
            docgia.setGioiTinh(result.getInt("GioiTinh"));
            docgia.setDienthoai(result.getString("DienThoai"));
            docgia.setDiachi(result.getString("DiaChi"));
            docgia.setNghenghiep(result.getString("NgheNghiep"));
            docgia.setTrinhdo(result.getString("TrinhDo"));
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
    
    public DocGiaDTO getByMa(String ma) throws Exception{
        ArrayList<DocGiaDTO> listDocGia=this.list("MaDG = " + "'" + ma + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
    
    public DocGiaDTO getByHo(String ho) throws Exception{
        ArrayList<DocGiaDTO> listDocGia=this.list("HoLot = " + "'" + ho + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
    
    public DocGiaDTO getByTen(String ten) throws Exception{
        ArrayList<DocGiaDTO> listDocGia=this.list("Ten = " + "'" + ten + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
    
    public void Insert(DocGiaDTO docgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaDG", docgia.getMaDocGia());
        map.put("HoLot", docgia.getHoDocGia());
        map.put("Ten", docgia.getTenDocGia());
        map.put("NgaySinh", docgia.getNgaysinh());
        map.put("GioiTinh", docgia.getGioiTinh());
        map.put("DienThoai", docgia.getDienthoai());
        map.put("DiaChi", docgia.getDiachi());
        map.put("NgheNghiep", docgia.getNghenghiep());
        map.put("TrinhDo", docgia.getTrinhdo());
 
        this.connect.Insert("docgia", map);
    }
    
    public void Update(DocGiaDTO docgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaDG", docgia.getMaDocGia());
        map.put("HoLot", docgia.getHoDocGia());
        //theloai=theloaidao.getByName(phieumuon.getTheLoai());
        map.put("Ten", docgia.getTenDocGia());
        //tacgia=tacgiadao.getByName(phieumuon.getTacGia());
        map.put("NgaySinh", docgia.getNgaysinh());
        //nhaxuatban=nxbdao.getByName(phieumuon.getNhaXuatBan());
        map.put("GioiTinh", docgia.getGioiTinh());
        map.put("DienThoai", docgia.getDienthoai());
        map.put("DiaChi", docgia.getDiachi());
        map.put("NgheNghiep", docgia.getNghenghiep());
        map.put("TrinhDo", docgia.getTrinhdo());
 
        this.connect.Update("docgia", map, "MaDG = '" + docgia.getMaDocGia() + "'");
    }
    
    public void Delete(String MaDocGia) throws Exception{
        this.connect.Delete("docgia", "MaDG = '" + MaDocGia + "'" );    
    }
}    

