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

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Card extends BaseGateway {

    private Integer id;
    private Integer number;
    private Date valid_from;
    private Date valid_till;
    private Integer id_account;

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Date getValid_from() {
        return valid_from;
    }

    public Date getValid_till() {
        return valid_till;
    }

    public Integer getId_account() {
        return id_account;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public void setValid_till(Date valid_till) {
        this.valid_till = valid_till;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
    }

    public void insert() throws SQLException {
        if (id != null) {
            throw new IllegalStateException("id has been set");
        }
        insert("INSERT INTO cards (number, valid_from, valid_till, id_account) VALUES (?,?,?,?)");
    }

    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setInt(1, number);
        s.setDate(2, valid_from);
        s.setDate(3, valid_till);
        s.setInt(4, id_account);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
    }

    public void update() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        update("UPDATE cards SET number = ?, valid_from = ?, valid_till = ?, id_account = ? WHERE id = ?");
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        s.setInt(1, number);
        s.setDate(2, valid_from);
        s.setDate(3, valid_till);
        s.setInt(4, id_account);
        s.setInt(5, id);
    }

    public void delete() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("number is not set");
        }

        delete("DELETE FROM cards WHERE number = ?");
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        s.setInt(1, number);
    }
	
}

