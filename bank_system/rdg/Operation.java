/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Inka
 */
public abstract class Operation extends BaseGateway {
    
    protected Integer id;
    protected Timestamp datetime;
    protected BigDecimal amount;
    protected String operation_type;
    protected int id_recipient;
    protected int id_sender;
    
//    protected int id_insurance;
//    protected int id_standing_order;
//    protected int id_card;
//    

    public Integer getId() {
        return id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public int getId_recipient() {
        return id_recipient;
    }

    public int getId_sender() {
        return id_sender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public void setId_recipient(int id_recipient) {
        this.id_recipient = id_recipient;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }
            
    
    public abstract void insert() throws SQLException;
//    public abstract void update() throws SQLException;
//    public abstract void delete() throws SQLException;

}
