/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Inka
 */

//
//      id serial primary key,
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

public class OperationStandingOrder extends Operation{
    protected int id_standing_order;

    public int getId_standing_order() {
        return id_standing_order;
    }

    public void setId_standing_order(int id_standing_order) {
        this.id_standing_order = id_standing_order;
    }

    

    
    @Override
    public void insert() throws SQLException {
        if (id != null) {
                throw new IllegalStateException("id has been set");
        }

        insert("INSERT INTO operations (datetime, amount, operation_type, id_recipient, id_sender, id_standing_order) VALUES (?,?,?,?,?,?)");
    }
    
    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setTimestamp(1, datetime);
        s.setBigDecimal(2, amount);
        s.setString(3, operation_type);
        s.setInt(4, id_recipient);
        s.setInt(5, id_sender);
        s.setInt(6, id_standing_order);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
