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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Account extends BaseGateway {
	
    private Integer id;
    private Integer number;
    private BigDecimal deposit;
    private Date valid_from;
    private BigDecimal interest_rate;
    private Integer id_charges;
    private Integer id_customer;
    private Integer id_insurance;

    public Integer getNumber() { return number;	}
    public void setNumber(Integer number) { this.number = number; }	
    
    public Integer getId() { return id;	}
    public void setId(Integer id) { this.id = id; }	
    
    public BigDecimal getDeposit() {
        return deposit;
    }

    public Date getValid_from() {
        return valid_from;
    }

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public Integer getId_charges() {
        return id_charges;
    }

    public Integer getId_customer() {
        return id_customer;
    }

    public Integer getId_insurance() {
        return id_insurance;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public void setValid_from(Date valid_from) {
        this.valid_from = valid_from;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }

    public void setId_charges(Integer id_charges) {
        this.id_charges = id_charges;
    }

    public void setId_customer(Integer id_customer) {
        this.id_customer = id_customer;
    }

    public void setId_insurance(Integer id_insurance) {
        this.id_insurance = id_insurance;
    }


    public void insert() throws SQLException {
        if (id != null) {
            throw new IllegalStateException("id has been set");
        }
        insert("INSERT INTO accounts (number, deposit, valid_from, interest_rate, id_account_type, id_customer, id_insurance) VALUES (?,?,?,?,?,?,?)");
    }

    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setInt(1, number);
        s.setBigDecimal(2, deposit);
        s.setDate(3, valid_from);
        s.setBigDecimal(4, interest_rate);
        s.setInt(5, id_charges);
        s.setInt(6, id_customer);
//        System.out.println("tu je chyba");
        if (id_insurance == null){
            s.setNull(7, java.sql.Types.INTEGER);
        }
        else{
            s.setInt(7, id_insurance);
        }
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
    }

    public void update() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        update("UPDATE accounts SET number = ?, deposit = ?, valid_from = ?, interest_rate = ?, id_account_type = ?, id_customer = ?, id_insurance = ? WHERE id = ?");
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        s.setInt(1, number);
        s.setBigDecimal(2, deposit);
        s.setDate(3, valid_from);
        s.setBigDecimal(4, interest_rate);
        s.setInt(5, id_charges);
        s.setInt(6, id_customer);
        s.setInt(7, id_insurance);
        s.setInt(8, id);
    }

    public void delete() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("number is not set");
        }

        delete("DELETE FROM accounts WHERE number = ?");
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        s.setInt(1, number);
    }
	
}

