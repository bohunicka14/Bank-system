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
public class SentAmountStatistics {
    private int count;
    private BigDecimal average;

    public int getCount() {
        return count;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }
    
    
}
