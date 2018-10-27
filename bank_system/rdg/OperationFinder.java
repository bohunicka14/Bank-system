/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Inka
 */
public class OperationFinder extends BaseFinder<Operation> {
    
    private static final OperationFinder INSTANCE = new OperationFinder();
    
    public static OperationFinder getInstance() { return INSTANCE; }
    
    private OperationFinder() { }
        
    public Operation findById(int id) throws SQLException {
        return findByInt("SELECT * FROM operations WHERE id = ?", id);
    }

    
    
    public List<Operation> findByAccount(int id) throws SQLException {
        
        return findAllByInt("SELECT * FROM operations WHERE id_sender = ?", id);
    }
    
    public List<Operation> findAll() throws SQLException {
        return findAll("SELECT * FROM operations");
    }

    @Override
    protected Operation load(ResultSet r) throws SQLException {
        Operation c = new OperationBasic();
         
        
//        id serial primary key,
//	datetime timestamp,
//	amount numeric,
//	operation_type varchar, -- payment, income
//	id_recipient integer references accounts ON DELETE CASCADE,
//	id_sender integer references accounts ON DELETE CASCADE,
//
//	-- insurance payments
//	id_insurance integer,
//
//	-- standing_orders
//	id_standing_order integer,
//
//	-- card_id
//	id_card integer
                
//        to do
        c.setId(r.getInt("id"));
        c.setDatetime(r.getTimestamp("datetime"));
        c.setAmount(r.getBigDecimal("amount"));
        c.setOperation_type(r.getString("operation_type"));
        c.setId_recipient(r.getInt("id_recipient"));
        c.setId_sender(r.getInt("id_sender"));

        return c;
    }

}
