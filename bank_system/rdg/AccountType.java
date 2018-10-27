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

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountType extends BaseGateway {

    
    private Integer id;
    private String name;
    private BigDecimal receiving_tax;
    private BigDecimal sending_tax;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getReceiving_tax() {
        return receiving_tax;
    }

    public BigDecimal getSending_tax() {
        return sending_tax;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReceiving_tax(BigDecimal receiving_tax) {
        this.receiving_tax = receiving_tax;
    }

    public void setSending_tax(BigDecimal sending_tax) {
        this.sending_tax = sending_tax;
    }

    

    public void insert() throws SQLException {
        if (id != null) {
            throw new IllegalStateException("id has been set");
        }
        insert("INSERT INTO account_types (name, receiving_tax, sending_tax) VALUES (?,?,?)");
    }

        
    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setString(1, name);
        s.setBigDecimal(2, receiving_tax);
        s.setBigDecimal(3, sending_tax);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
    }

    public void update() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        update("UPDATE account_types SET name = ?, receiving_tax = ?, sending_tax = ? WHERE id = ?");
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        s.setString(1, name);
        s.setBigDecimal(2, receiving_tax);
        s.setBigDecimal(3, sending_tax);
    }

    public void delete() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        delete("DELETE FROM account_types WHERE id = ?");
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        s.setInt(1, id);
    }
    
}

