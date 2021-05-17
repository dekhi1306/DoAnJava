
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
            docgia.setMaDocGia(result.getString("MaDocGia"));
            docgia.setMaDocGia(result.getString("MaDocGia"));
            docgia.setTenDocGia(result.getString("TenDocGia"));
            docgia.setNgaysinh(result.getString("Ngaysinh"));
            docgia.setDiachi(result.getString("Diachi"));
            docgia.setDienthoai(result.getString("Dienthoai"));
            docgia.setNghenghiep(result.getString("Nghenghiep"));
            docgia.setTrinhdo(result.getString("Trinhdo"));
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
        ArrayList<DocGiaDTO> listDocGia=this.list("MaDocGia = " + "'" + ma + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
    
    public DocGiaDTO getByHo(String ho) throws Exception{
        ArrayList<DocGiaDTO> listDocGia=this.list("HoDocGia = " + "'" + ho + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
    
    public DocGiaDTO getByTen(String ten) throws Exception{
        ArrayList<DocGiaDTO> listDocGia=this.list("TenDG = " + "'" + ten + "'");
        if(listDocGia.size()>0)
            return listDocGia.toArray(new DocGiaDTO[listDocGia.size()])[0];
        return null;
    }
    
    public void Insert(DocGiaDTO docgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaDocGia", docgia.getMaDocGia());
        map.put("HoDocGia", docgia.getHoDocGia());
        map.put("TenDocGia", docgia.getTenDocGia());
        map.put("Ngaysinh", docgia.getNgaysinh());
        map.put("Diachi", docgia.getDiachi());
        map.put("Dienthoai", docgia.getDienthoai());
        map.put("Nghenghiep", docgia.getNghenghiep());
        map.put("Trinhdo", docgia.getTrinhdo());
 
        this.connect.Insert("docgia", map);
    }
    
    public void Update(DocGiaDTO docgia) throws Exception{
        HashMap<String, Object> map=new HashMap<String, Object>();
        
        map.put("MaDocGia", docgia.getMaDocGia());
        map.put("HoDocGia", docgia.getHoDocGia());
        map.put("TenDocGia", docgia.getTenDocGia());
        map.put("Ngaysinh", docgia.getNgaysinh());
        map.put("Diachi", docgia.getDiachi());
        map.put("Dienthoai", docgia.getDienthoai());
        map.put("Nghenghiep", docgia.getNghenghiep());
        map.put("Trinhdo", docgia.getTrinhdo());
 
        this.connect.Update("docgia", map, "MaDocGia = '" + docgia.getMaDocGia() + "'");
    }
    
    public void Delete(String MaDocGia) throws Exception{
        this.connect.Delete("docgia", "MaDocGia = '" + MaDocGia + "'" );    
    }
}    

