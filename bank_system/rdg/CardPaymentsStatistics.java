/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

import java.math.BigDecimal;

/**
 *
 * @author Inka
 */

// select accounts.number AS number, EXTRACT(MONTH FROM operations.datetime) AS month, count(*) as count, sum(operations.amount) as amount_sum 
//-- from operations join accounts ON operations.id_sender = accounts.id 
//-- where operations.id_card is not NULL AND operations.id_sender = 79 
//-- group by accounts.number, EXTRACT(MONTH FROM operations.datetime);
public class CardPaymentsStatistics {
    
    private int month;
    private int count;
    private BigDecimal amount_sum;

    
    public int getMonth() {
        return month;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getAmount_sum() {
        return amount_sum;
    }

    
    public void setMonth(int month) {
        this.month = month;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAmount_sum(BigDecimal amount_sum) {
        this.amount_sum = amount_sum;
    }
    
    

}
