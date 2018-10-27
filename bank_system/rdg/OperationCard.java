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


public class OperationCard extends Operation{
    protected int id_card;

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    
    @Override
    public void insert() throws SQLException {
        if (id != null) {
                throw new IllegalStateException("id has been set");
        }

        insert("INSERT INTO operations (datetime, amount, operation_type, id_recipient, id_sender, id_card) VALUES (?,?,?,?,?,?)");
    }
    
    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setTimestamp(1, datetime);
        s.setBigDecimal(2, amount);
        s.setString(3, operation_type);
        s.setInt(4, id_recipient);
        s.setInt(5, id_sender);
        s.setInt(6, id_card);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
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
