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
public class SendingTaxStatistics {
    private int number;
    private BigDecimal tax_sum_total;

    public int getNumber() {
        return number;
    }

    public BigDecimal getTax_sum_total() {
        return tax_sum_total;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTax_sum_total(BigDecimal tax_sum_total) {
        this.tax_sum_total = tax_sum_total;
    }
    
}
