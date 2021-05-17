
package DTO;

/**
 *
 * @author ASUS
 */
public class DocGiaDTO {
    private String MaDocGia;
    private String HoDocGia;
    private String TenDocGia;
    private String Ngaysinh;
    private String Diachi;
    private String Dienthoai;
    private String Nghenghiep;
    private String Trinhdo;
    
    public DocGiaDTO(){
        
    }
    public DocGiaDTO(String MaDocGia, String HoDocGia,String TenDocGia, String Ngaysinh, String Diachi, String Dienthoai, String Nghenghiep, String Trinhdo){
        this.MaDocGia = MaDocGia;
        this.HoDocGia = HoDocGia;
        this.TenDocGia = TenDocGia;
        this.Ngaysinh = Ngaysinh; 
        this.Diachi = Diachi;
        this.Dienthoai = Dienthoai;
        this.Nghenghiep = Nghenghiep;
        this.Trinhdo = Trinhdo; 
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public String getHoDocGia() {
        return HoDocGia;
    }

    public void setHoDocGia(String HoDocGia) {
        this.HoDocGia = HoDocGia;
    }

    public String getTenDocGia() {
        return TenDocGia;
    }

    public void setTenDocGia(String TenDocGia) {
        this.TenDocGia = TenDocGia;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getDienthoai() {
        return Dienthoai;
    }

    public void setDienthoai(String Dienthoai) {
        this.Dienthoai = Dienthoai;
    }

    public String getNghenghiep() {
        return Nghenghiep;
    }

    public void setNghenghiep(String Nghenghiep) {
        this.Nghenghiep = Nghenghiep;
    }

    public String getTrinhdo() {
        return Trinhdo;
    }

    public void setTrinhdo(String Trinhdo) {
        this.Trinhdo = Trinhdo;
    }
    
}
