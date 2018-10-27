/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

/**
 *
 * @author Inka
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountTypeFinder extends BaseFinder<AccountType> {
    
    private static final AccountTypeFinder INSTANCE = new AccountTypeFinder();
    
    public static AccountTypeFinder getInstance() { return INSTANCE; }
    
    private AccountTypeFinder() { }
        
    public AccountType findById(int id) throws SQLException {
        return findByInt("SELECT * FROM account_types WHERE id = ?", id);
    }
    
    public AccountType findByName(String name) throws SQLException {
        return findByString("SELECT * FROM account_types WHERE name = ?", name);
    }

    public List<AccountType> findAll() throws SQLException {
        return findAll("SELECT * FROM account_types");
    }

    @Override
    protected AccountType load(ResultSet r) throws SQLException {
        AccountType c = new AccountType();
      
        c.setId(r.getInt("id"));
        c.setName(r.getString("name"));
        c.setReceiving_tax(r.getBigDecimal("receiving_tax"));
        c.setSending_tax(r.getBigDecimal("sending_tax"));

        return c;
    }

}
