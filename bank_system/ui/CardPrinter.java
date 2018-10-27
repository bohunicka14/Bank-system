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
import bank_system.rdg.AccountFinder;
import bank_system.rdg.Card;
import java.sql.SQLException;


public class CardPrinter {
    
    private static final CardPrinter INSTANCE = new CardPrinter();
    
    public static CardPrinter getInstance() { return INSTANCE; }
    
    private CardPrinter() { }
        
    
//    -- cards
//	id serial primary key,
//	number integer,
//	valid_from date,
//	valid_till date,
//	id_account integer references accounts ON DELETE 
    
    public void print(Card card) throws SQLException {
        if (card == null) {
            throw new NullPointerException("card cannot be null");
        }
        Account a = AccountFinder.getInstance().findById(card.getId_account());
        System.out.print("id :          ");
        System.out.println(card.getId());
        System.out.print("number:   ");
        System.out.println(card.getNumber());
        System.out.print("valid_from:    ");
        System.out.println(card.getValid_from());
        System.out.print("valid till: ");
        System.out.println(card.getValid_till());
        System.out.print("account number :       ");
        System.out.println(a.getNumber());
        System.out.println();
    }
}

