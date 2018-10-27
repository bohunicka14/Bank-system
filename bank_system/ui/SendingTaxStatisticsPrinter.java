/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.ui;

import bank_system.rdg.SendingTaxStatistics;
import java.util.List;

/**
 *
 * @author Inka
 */
public class SendingTaxStatisticsPrinter {
    private static final SendingTaxStatisticsPrinter INSTANCE = new SendingTaxStatisticsPrinter();
    
    public static SendingTaxStatisticsPrinter getInstance() {
        return INSTANCE;
    }
    
    private SendingTaxStatisticsPrinter() { }
 
    public void print(List<SendingTaxStatistics> statistics) {
        if (statistics == null){
            return;
        }
        int column1Width = 0;
        int column2Width = 0 ;
        for (SendingTaxStatistics s : statistics) {
            column1Width = Math.max(column1Width, Integer.toString(s.getNumber()).length());
            column2Width = Math.max(column2Width, s.getTax_sum_total().toString().length());
        }
        
        System.out.print("number");
        for (int i = 0; i < column1Width - 1; ++i) {
            System.out.print(" ");
        }
        System.out.println(" | tax_total");
        for (int i = 0; i < column1Width + column2Width + 3; ++i) {
            System.out.print("-");
        }
        System.out.println();
        
        for (SendingTaxStatistics s : statistics) {
            String nString = Integer.toString(s.getNumber());
            int nLength = nString.length();
            
            System.out.print(s.getNumber());
            
            int spaceLength = column1Width - nLength;
            for (int i = 0; i < spaceLength; ++i) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.println(s.getTax_sum_total());
        }
    }
}
