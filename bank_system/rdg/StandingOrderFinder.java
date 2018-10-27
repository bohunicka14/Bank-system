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

public class StandingOrderFinder extends BaseFinder<StandingOrder> {
    
    private static final StandingOrderFinder INSTANCE = new StandingOrderFinder();
    
    public static StandingOrderFinder getInstance() { return INSTANCE; }
    
    private StandingOrderFinder() { }
        
    public StandingOrder findById(int id) throws SQLException {
        return findByInt("SELECT * FROM standing_orders WHERE id = ?", id);
    }

    public List<StandingOrder> findAll() throws SQLException {
        return findAll("SELECT * FROM standing_orders");
    }

    @Override
    protected StandingOrder load(ResultSet r) throws SQLException {
        StandingOrder c = new StandingOrder();
                
        c.setId(r.getInt("id"));
        c.setAmount(r.getBigDecimal("amount"));
        c.setId_recipient(r.getInt("id_recipient"));
        c.setId_sender(r.getInt("id_sender"));

        return c;
    }

}
