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

public class AccountFinder extends BaseFinder<Account> {
    
    private static final AccountFinder INSTANCE = new AccountFinder();
    
    public static AccountFinder getInstance() { return INSTANCE; }
    
    private AccountFinder() { }
		
    public Account findById(int id) throws SQLException {
        return findByInt("SELECT * FROM accounts WHERE id = ?", id);
    }

    public Account findByNumber(int number) throws SQLException {
        return findByInt("SELECT * FROM accounts WHERE number = ?", number);
    }
    
    public List<Account> findAll() throws SQLException {
        return findAll("SELECT * FROM accounts");
    }

    @Override
    protected Account load(ResultSet r) throws SQLException {
        Account c = new Account();
                
        c.setId(r.getInt("id"));
        c.setNumber(r.getInt("number"));
        c.setDeposit(r.getBigDecimal("deposit"));
        c.setValid_from(r.getDate("valid_from"));
        c.setInterest_rate(r.getBigDecimal("interest_rate"));
        c.setId_charges(r.getInt("id_account_type"));
        c.setId_customer(r.getInt("id_customer"));
        c.setId_insurance(r.getInt("id_insurance"));

        return c;
    }

}
