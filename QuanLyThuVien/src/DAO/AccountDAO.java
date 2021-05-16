/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Lộc
 */
import DTO.AccountDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDAO {
    MyConnectUnit connect;
    
    public AccountDAO() {
        connect=DAO.getDAO();
    }
    
    public ArrayList<AccountDTO> list(String condition, String OrderBy) throws Exception {
        ResultSet result=this.connect.Select("account", condition, OrderBy);
        ArrayList<AccountDTO> listAccount=new ArrayList<AccountDTO>();
        while(result.next()){
            AccountDTO account=new AccountDTO();
            account.setUsername(result.getString("username"));
            account.setPassword(result.getString("password"));
            listAccount.add(account);
        }
        return listAccount;
    }
    
    public ArrayList<AccountDTO> list(String condition) throws Exception{
        return list(condition, null);
    }
    
    public ArrayList<AccountDTO> list() throws Exception{
        return list(null);
    }
    
    
}
