/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author Lộc
 */
import DAO.ThongKeDAO;
import DTO.CTPhieuNhapDTO;
import DTO.ChiTietPhieuMuonDTO;
import DTO.PhieuMuonDTO;
import DTO.PhieuNhapHangDTO;
import DTO.PhieuPhatDTO;
import java.util.ArrayList;
import java.util.Vector;

public class ThongKeBUS {
    private static ArrayList<PhieuNhapHangDTO> listPN = null;
    private static ArrayList<PhieuMuonDTO> listPM = null;
    private static ArrayList<PhieuPhatDTO> listPP = null;
    
    public ThongKeBUS() throws Exception{
        PhieuNhapHangBUS pn=new PhieuNhapHangBUS();
        PhieuMuonBUS pm=new PhieuMuonBUS();
        PhieuPhatBUS pp=new PhieuPhatBUS();
        pn.listPhieuNhapHang();
        pm.listPhieuMuon();
        pp.listPhieuPhat();
        listPN=pn.getList();
        listPM=pm.getList();
        listPP=pp.getList();
    }
    
    public ArrayList<CTPhieuNhapDTO> listNH(String from, String to) throws Exception{
        ArrayList<CTPhieuNhapDTO> listRes = new ArrayList<CTPhieuNhapDTO>();
        ArrayList<String> listMa = new ArrayList<String>();
        boolean fromDate=false, toDate=false, corDate;
        int fromD=0, fromM=0, fromY=0, toD=0, toM=0, toY=0, day=0, month=0, year=0;
        String[] dateInput1, dateInput2, date;
        if(from.equals(""))
            fromDate=true;
        else{
            dateInput1=from.split("-");
            fromD=Integer.parseInt(dateInput1[0]);
            fromM=Integer.parseInt(dateInput1[1]);
            fromY=Integer.parseInt(dateInput1[2]); 
        }
        if(to.equals(""))
            toDate=true;
        else{
            dateInput2=to.split("-");
            toD=Integer.parseInt(dateInput2[0]);
            toM=Integer.parseInt(dateInput2[1]);
            toY=Integer.parseInt(dateInput2[2]);
        }
        for(PhieuNhapHangDTO pn: listPN){
            date=(pn.getNgayPH()).split("-");
            day=Integer.parseInt(date[0]);
            month=Integer.parseInt(date[1]);
            year=Integer.parseInt(date[2]);
            if(!from.equals("")){
                if(year<fromY)
                    fromDate=false;
                else{
                    if(year>fromY)
                        fromDate=true;
                    else{
                        if(month<fromM)
                            fromDate=false;
                        else{
                            if(month>fromM)
                                fromDate=true;
                            else{
                                if(day<fromD)
                                    fromDate=false;
                                else
                                    fromDate=true;
                            }
                        }
                    }
                }
            }     
            if(!to.equals("")){
                if(year>toY)
                    toDate=false;
                else{
                    if(year<toY)
                        toDate=true;
                    else{
                        if(month>toM)
                            toDate=false;
                        else{
                            if(month<toM)
                                toDate=true;
                            else{
                                if(day>toD)
                                    toDate=false;
                                else
                                    toDate=true;
                            }
                        }
                    }
                }
            }
            corDate=(fromDate && toDate);
            if(corDate)
                listMa.add(pn.getMaPNH());
        }
        ThongKeDAO thongkedao=new ThongKeDAO();
        listRes=thongkedao.listNH(listMa);
        return listRes;
    }
    
    public ArrayList<Object> listPM(String from, String to) throws Exception{
        ArrayList<Object> listRes = new ArrayList<>();
        ArrayList<PhieuMuonDTO> listMa = new ArrayList<PhieuMuonDTO>();
        boolean fromDate=false, toDate=false, corDate;
        int fromD=0, fromM=0, fromY=0, toD=0, toM=0, toY=0, day=0, month=0, year=0;
        String[] dateInput1, dateInput2, date;
        if(from.equals(""))
            fromDate=true;
        else{
            dateInput1=from.split("-");
            fromD=Integer.parseInt(dateInput1[0]);
            fromM=Integer.parseInt(dateInput1[1]);
            fromY=Integer.parseInt(dateInput1[2]); 
        }
        if(to.equals(""))
            toDate=true;
        else{
            dateInput2=to.split("-");
            toD=Integer.parseInt(dateInput2[0]);
            toM=Integer.parseInt(dateInput2[1]);
            toY=Integer.parseInt(dateInput2[2]);
        }
        for(PhieuMuonDTO pm: listPM){
            date=(pm.getNgayMuon().split("-"));
            day=Integer.parseInt(date[0]);
            month=Integer.parseInt(date[1]);
            year=Integer.parseInt(date[2]);
            if(!from.equals("")){
                if(year<fromY)
                    fromDate=false;
                else{
                    if(year>fromY)
                        fromDate=true;
                    else{
                        if(month<fromM)
                            fromDate=false;
                        else{
                            if(month>fromM)
                                fromDate=true;
                            else{
                                if(day<fromD)
                                    fromDate=false;
                                else
                                    fromDate=true;
                            }
                        }
                    }
                }
            }     
            if(!to.equals("")){
                if(year>toY)
                    toDate=false;
                else{
                    if(year<toY)
                        toDate=true;
                    else{
                        if(month>toM)
                            toDate=false;
                        else{
                            if(month<toM)
                                toDate=true;
                            else{
                                if(day>toD)
                                    toDate=false;
                                else
                                    toDate=true;
                            }
                        }
                    }
                }
            }
            corDate=(fromDate && toDate);
            if(corDate)
                listMa.add(pm);
        }
        ThongKeDAO thongkedao=new ThongKeDAO();
        listRes=thongkedao.listPM(listMa);
        return listRes;
    }
    
    public ArrayList<Vector> listPP(String from, String to) throws Exception{
        ArrayList<Vector> listRes = new ArrayList<>();
        ArrayList<String> listMa = new ArrayList<String>();
        boolean fromDate=false, toDate=false, corDate;
        int fromD=0, fromM=0, fromY=0, toD=0, toM=0, toY=0, day=0, month=0, year=0;
        String[] dateInput1, dateInput2, date;
        if(from.equals(""))
            fromDate=true;
        else{
            dateInput1=from.split("-");
            fromD=Integer.parseInt(dateInput1[0]);
            fromM=Integer.parseInt(dateInput1[1]);
            fromY=Integer.parseInt(dateInput1[2]); 
        }
        if(to.equals(""))
            toDate=true;
        else{
            dateInput2=to.split("-");
            toD=Integer.parseInt(dateInput2[0]);
            toM=Integer.parseInt(dateInput2[1]);
            toY=Integer.parseInt(dateInput2[2]);
        }
        for(PhieuMuonDTO pm: listPM){
            date=(pm.getNgayMuon()).split("-");
            day=Integer.parseInt(date[0]);
            month=Integer.parseInt(date[1]);
            year=Integer.parseInt(date[2]);
            if(!from.equals("")){
                if(year<fromY)
                    fromDate=false;
                else{
                    if(year>fromY)
                        fromDate=true;
                    else{
                        if(month<fromM)
                            fromDate=false;
                        else{
                            if(month>fromM)
                                fromDate=true;
                            else{
                                if(day<fromD)
                                    fromDate=false;
                                else
                                    fromDate=true;
                            }
                        }
                    }
                }
            }     
            if(!to.equals("")){
                if(year>toY)
                    toDate=false;
                else{
                    if(year<toY)
                        toDate=true;
                    else{
                        if(month>toM)
                            toDate=false;
                        else{
                            if(month<toM)
                                toDate=true;
                            else{
                                if(day>toD)
                                    toDate=false;
                                else
                                    toDate=true;
                            }
                        }
                    }
                }
            }
            corDate=(fromDate && toDate);
            if(corDate)
                listMa.add(pm.getMaPhieuMuon());
        }
        ThongKeDAO thongkedao=new ThongKeDAO();
        listRes=thongkedao.listPP(listMa);
        return listRes;
    }
}
