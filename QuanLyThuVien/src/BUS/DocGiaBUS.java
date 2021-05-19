
package BUS;
import DAO.DocGiaDAO;
import DTO.DocGiaDTO;
import java.util.ArrayList;

public class DocGiaBUS {
    private ArrayList<DocGiaDTO> ListDocGia;
    
    public DocGiaBUS(){
        
    }
    public void listDocGia() throws Exception{
        DocGiaDAO dgdao=new DocGiaDAO();
        ListDocGia = new ArrayList<DocGiaDTO>();
        ListDocGia=dgdao.list();
    }
    
    public void Add(DocGiaDTO docgia) throws Exception {
        ListDocGia.add(docgia);
        DocGiaDAO docgiadao=new DocGiaDAO();
        docgiadao.Insert(docgia);
    }
    
    public void Edit(DocGiaDTO docgia) throws Exception {
        for(int i=0;i<ListDocGia.size();i++) {
            if(ListDocGia.get(i).getMaDocGia().equals(docgia.getMaDocGia())) {
                ListDocGia.set(i, docgia);
                DocGiaDAO docgiadao = new DocGiaDAO();
                docgiadao.Update(docgia);
                return;
            }
        }
    }
    
    public void Remove(String MaDocGia) throws Exception {
        for(DocGiaDTO docgia: ListDocGia) {
            if(docgia.getMaDocGia().equals(MaDocGia)) {
                ListDocGia.remove(docgia);
                DocGiaDAO docgiadao = new DocGiaDAO();
                docgiadao.Delete(MaDocGia);
                return;
            }
        }
    }
    
   public ArrayList<DocGiaDTO> Search(String MaDG, String HoLot, String Ten, String NgaySinh, int GioiTinh, String DienThoai, String DiaChi, String NgheNghiep, String TrinhDo){
        ArrayList<DocGiaDTO> res=new ArrayList<DocGiaDTO>();
        boolean madg=false, holot=false,ten=false,ngaysinh=false,dienthoai=false, gioitinh=false,dc=false,nghenghiep=false,trinhdo=false;
        if(MaDG.equals(""))
            madg=true;
        if(HoLot.equals(""))
            holot=true;
        if(Ten.equals(""))
            ten=true;
        if(NgaySinh.equals(""))
            ngaysinh=true;
        if(DienThoai.equals(""))
            dienthoai=true;
        if(GioiTinh==-1)
            gioitinh=true;
        if(DiaChi.equals(""))
            dc=true;
        if(NgheNghiep.equals(""))
            nghenghiep=true;
        if(TrinhDo.equals("Chọn trình độ"))
            trinhdo=true;
        for(DocGiaDTO ms: ListDocGia){
            if(!MaDG.equals(""))
                madg=(ms.getMaDocGia().contains(MaDG)) ? true : false;
            if(!HoLot.equals(""))
                holot=(ms.getHoLot().contains(HoLot)) ? true : false;
            if(!Ten.equals(""))
                ten=(ms.getTen().contains(Ten)) ? true : false;
            if(!NgaySinh.equals(""))
                ngaysinh=(ms.getNgaySinh().contains(NgaySinh)) ? true : false;
            if(!DienThoai.equals(""))
                dienthoai=(ms.getDienThoai().contains(DienThoai)) ? true : false;
            if(!DiaChi.equals(""))
                dc=(ms.getDiaChi().contains(DiaChi)) ? true : false;
            if(!NgheNghiep.equals(""))
                nghenghiep=(ms.getNgheNghiep().contains(NgheNghiep)) ? true : false;
            if(!TrinhDo.equals("Chọn trình độ"))
                trinhdo=(ms.getTrinhDo().equals(TrinhDo)) ? true : false;
            if(GioiTinh!=-1)
                gioitinh=(ms.getGioiTinh()==GioiTinh) ? true : false;
            
            if(madg&& holot && ten && ngaysinh && gioitinh && dienthoai  && dc && nghenghiep && trinhdo)
                res.add(ms);
        }
        return res;
    }
    
    public ArrayList<DocGiaDTO> getList(){
        return ListDocGia;
    }
}
