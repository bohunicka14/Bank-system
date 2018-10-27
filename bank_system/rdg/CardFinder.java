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

public class CardFinder extends BaseFinder<Card> {
    
    private static final CardFinder INSTANCE = new CardFinder();
    
    public static CardFinder getInstance() { return INSTANCE; }
    
    private CardFinder() { }
        
    public Card findById(int id) throws SQLException {
        return findByInt("SELECT * FROM cards WHERE id = ?", id);
    }

    public Card findByNumber(int number) throws SQLException {
        return findByInt("SELECT * FROM cards WHERE number = ?", number);
    }
    
    public List<Card> findByAccount(int number) throws SQLException {
//        dokoncit
        Account account = AccountFinder.getInstance().findByNumber(number);
        if (account == null) {
            System.out.println("No such account exists");
            return null;
        }
        else{
            return findAllByInt("SELECT * FROM cards WHERE id_account = ?", account.getId());
        }
        
    }
    
    public List<Card> findAll() throws SQLException {
        return findAll("SELECT * FROM cards");
    }

    @Override
    protected Card load(ResultSet r) throws SQLException {
        Card c = new Card();

        c.setId(r.getInt("id"));
        c.setNumber(r.getInt("number"));
        c.setValid_from(r.getDate("valid_from"));
        c.setValid_till(r.getDate("valid_till"));
        c.setId_account(r.getInt("id_account"));

        return c;
    }

}
