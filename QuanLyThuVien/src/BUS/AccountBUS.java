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
import DAO.AccountDAO;
import DTO.AccountDTO;
import java.util.ArrayList;
import java.util.Arrays;

public class AccountBUS {
    private ArrayList<AccountDTO> listAccount;
    
    public AccountBUS(){
    
    }
    
    public void listAccount() throws Exception{
        AccountDAO accountdao=new AccountDAO();
        listAccount=new ArrayList<AccountDTO>();
        listAccount=accountdao.list();
    }
    
    public ArrayList<AccountDTO> getList(){
        return listAccount;
    }
    
    public AccountDTO Check(String username, char[] password){
        for(AccountDTO account: listAccount){
            char[] correctPass=account.getPassword().toCharArray();
            if(account.getUsername().equals(username) && Arrays.equals(password, correctPass))
                return account;
        }
        return null;
    }
}
