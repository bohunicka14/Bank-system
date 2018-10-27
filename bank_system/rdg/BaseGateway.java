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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bank_system.DbContext;


public abstract class BaseGateway {

    protected void insert(String sql) throws SQLException {
        try (PreparedStatement s = DbContext.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            insertFill(s);
            s.executeUpdate();

            try (ResultSet r = s.getGeneratedKeys()) {
                r.next();
                insertUpdateKeys(r);
            }
        }
    }

    protected abstract void insertFill(PreparedStatement s) throws SQLException;

    protected abstract void insertUpdateKeys(ResultSet r) throws SQLException;

    protected void update(String sql) throws SQLException {
        try (PreparedStatement s = DbContext.getConnection().prepareStatement(sql)) {
            updateFill(s);
            s.executeUpdate();
        }
    }

    protected abstract void updateFill(PreparedStatement s) throws SQLException;

    public void delete(String sql) throws SQLException {
        try (PreparedStatement s = DbContext.getConnection().prepareStatement(sql)) {
            deleteFill(s);
            s.executeUpdate();
        }
    }

    protected abstract void deleteFill(PreparedStatement s) throws SQLException;

}
