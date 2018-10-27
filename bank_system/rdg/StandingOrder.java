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


public class StandingOrder extends BaseGateway {
    
    private Integer id;
    private BigDecimal amount;
    private Integer issue_date;
    private Integer id_recipient;
    private Integer id_sender;

    public Integer getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getIssue_date() {
        return issue_date;
    }

    public Integer getId_recipient() {
        return id_recipient;
    }

    public Integer getId_sender() {
        return id_sender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setIssue_date(Integer issue_date) {
        this.issue_date = issue_date;
    }

    public void setId_recipient(Integer id_recipient) {
        this.id_recipient = id_recipient;
    }

    public void setId_sender(Integer id_sender) {
        this.id_sender = id_sender;
    }
    
    

    public void insert() throws SQLException {
        if (id != null) {
            throw new IllegalStateException("id has been set");
        }
        insert("INSERT INTO standing_orders (amount, issue_date, id_recipient, id_sender) VALUES (?,?,?,?)");
    }

            
    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setBigDecimal(1, amount);
        s.setInt(2, issue_date);
        s.setInt(3, id_recipient);
        s.setInt(4, id_sender);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
    }

    public void update() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        update("UPDATE standig_orders SET amount = ?, issue_date = ?, id_recipient = ?, id_sender = ? WHERE id = ?");
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        s.setBigDecimal(1, amount);
        s.setInt(2, issue_date);
        s.setInt(3, id_recipient);
        s.setInt(4, id_sender);
    }

    public void delete() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        delete("DELETE FROM standing_orders WHERE id = ?");
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        s.setInt(1, id);
    }
    
}

