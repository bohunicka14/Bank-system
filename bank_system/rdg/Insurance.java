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


public class Insurance extends BaseGateway {
    
    private Integer id;
    private Date start_date;
    private Integer duration;
    private String description;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public void insert() throws SQLException {
        if (id != null) {
            throw new IllegalStateException("id has been set");
        }
        insert("INSERT INTO insurance (start_date, duration, description, price) VALUES (?,?,?,?)");
    }

    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setDate(1, start_date);
        s.setInt(2, duration);
        s.setString(3, description);
        s.setInt(4, price);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
    }

    public void update() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        update("UPDATE insurance SET start_date = ?, duration = ?, description = ?, price = ? WHERE id = ?");
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        s.setDate(1, start_date);
        s.setInt(2, duration);
        s.setString(3, description);
        s.setInt(4, price);
    }

    public void delete() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        delete("DELETE FROM insurance WHERE id = ?");
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        s.setInt(1, id);
    }
    
}

