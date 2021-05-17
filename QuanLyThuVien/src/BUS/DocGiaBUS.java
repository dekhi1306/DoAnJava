
package BUS;
import DAO.DocGiaDAO;
import DTO.DocGiaDTO;
import java.util.ArrayList;

public class DocGiaBUS {
    private ArrayList<DocGiaDTO> listDocGia;
    
    public DocGiaBUS(){
        
    }
    
    public void listDocGia() throws Exception {
        DocGiaDAO docgiadao=new DocGiaDAO();
        listDocGia=new ArrayList<DocGiaDTO>();
        listDocGia=docgiadao.list();   
    }
    
    public void Add(DocGiaDTO docgia) throws Exception {
        listDocGia.add(docgia);
        DocGiaDAO docgiadao=new DocGiaDAO();
        docgiadao.Insert(docgia);
    }
    
    public void Edit(DocGiaDTO docgia) throws Exception {
        for(int i=0;i<listDocGia.size();i++) {
            if(listDocGia.get(i).getMaDocGia().equals(docgia.getMaDocGia())) {
                listDocGia.set(i, docgia);
                DocGiaDAO docgiadao = new DocGiaDAO();
                docgiadao.Update(docgia);
                return;
            }
        }
    }
    
    public void Remove(String MaDocGia) throws Exception {
        for(DocGiaDTO docgia: listDocGia) {
            if(docgia.getMaDocGia().equals(MaDocGia)) {
                listDocGia.remove(docgia);
                DocGiaDAO docgiadao = new DocGiaDAO();
                docgiadao.Delete(MaDocGia);
                return;
            }
        }
    }
    
    public ArrayList<DocGiaDTO> Search(String MaDocGia, String HoDocGia,String TenDocGia, String Ngaysinh, String Diachi, String Dienthoai, String Nghenghiep, String Trinhdo) {
        ArrayList<DocGiaDTO> res=new ArrayList<DocGiaDTO>();
        boolean madocgia=false, hodocgia=false, tendocgia=false, ngaysinh=false, diachi=false, dienthoai=false, nghenghiep=false, trinhdo=false;
        if(MaDocGia.equals(""))
            madocgia=true;
        if(HoDocGia.equals(""))
            hodocgia=true;
        if(TenDocGia.equals(""))
            tendocgia=true;
        if(Ngaysinh.equals(""))
            ngaysinh=true;
        if(Diachi.equals(""))
            diachi=true;
        if(Dienthoai.equals(""))
            dienthoai=true;
        if(Nghenghiep.equals(""))
            nghenghiep=true;
        if(Trinhdo.equals(""))
            trinhdo=true;
        for(DocGiaDTO docgia: listDocGia){
            if(!MaDocGia.equals(""))
                madocgia=(docgia.getMaDocGia().contains(MaDocGia)) ? true : false;
            if(!HoDocGia.equals(""))
                hodocgia=(docgia.getHoDocGia().contains(HoDocGia)) ? true : false;
            if(!TenDocGia.equals(""))
                tendocgia=(docgia.getTenDocGia().contains(TenDocGia)) ? true : false;
            if(!Ngaysinh.equals(""))
                ngaysinh=(docgia.getNgaysinh().contains(Ngaysinh)) ? true : false;
            if(!Diachi.equals(""))
                diachi=(docgia.getDiachi().contains(Diachi)) ? true : false;
            if(!Dienthoai.equals(""))
                dienthoai=(docgia.getDienthoai().contains(Dienthoai)) ? true : false;      
            if(!Nghenghiep.equals(""))
                nghenghiep=(docgia.getNghenghiep().contains(Nghenghiep)) ? true : false;
            if(!Trinhdo.equals(""))
                trinhdo=(docgia.getTrinhdo().contains(Trinhdo)) ? true : false;
            if(madocgia && hodocgia && tendocgia && ngaysinh && diachi && dienthoai && nghenghiep && trinhdo)
                res.add(docgia);
        }
        return res;
    }
    
    public ArrayList<DocGiaDTO> getList(){
        return listDocGia;
    }
}
