/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.ui;

/**
 *
 * @author Inka
 */

import bank_system.rdg.Account;
import bank_system.rdg.AccountType;
import bank_system.rdg.AccountTypeFinder;
import bank_system.rdg.Customer;
import bank_system.rdg.CustomerFinder;
import java.sql.SQLException;


public class AccountPrinter {
    
    private static final AccountPrinter INSTANCE = new AccountPrinter();
    
    public static AccountPrinter getInstance() { return INSTANCE; }
    
    private AccountPrinter() { }
   
   
    public void print(Account account) throws SQLException {
        if (account == null) {
            throw new NullPointerException("account cannot be null");
        }
//        pridat number
        Customer c = CustomerFinder.getInstance().findById(account.getId_customer());
        AccountType at = AccountTypeFinder.getInstance().findById(account.getId_charges());
        
        System.out.print("Customer:    ");
        System.out.println(c.getFirstName() + " " + c.getLastName());
        System.out.print("id :          ");
        System.out.println(account.getId());
        System.out.print("number:   ");
        System.out.println(account.getNumber());
        System.out.print("deposit:   ");
        System.out.println(account.getDeposit());
        System.out.print("valid from:    ");
        System.out.println(account.getValid_from());
        System.out.print("interest rate: ");
        System.out.println(account.getInterest_rate());
        System.out.print("id account type:       ");
        System.out.println(account.getId_charges());
        System.out.print("insurance name:       ");
        System.out.println(at.getName());
        
        System.out.print("insurance receiving tax:       ");
        System.out.println(at.getReceiving_tax());
        
        System.out.print("insurance sending tax:       ");
        System.out.println(at.getSending_tax());
        
        
        System.out.println();
    }
}

