/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.ui;

import bank_system.rdg.CardPaymentsStatistics;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Inka
 */
public class CardPaymentsStatisticsPrinter {
    private static final CardPaymentsStatisticsPrinter INSTANCE = new CardPaymentsStatisticsPrinter();
    
    public static CardPaymentsStatisticsPrinter getInstance() {
        return INSTANCE;
    }
    
    private CardPaymentsStatisticsPrinter() { }
 
    public void print(List<CardPaymentsStatistics> statistics) {
        if (statistics == null){
            return;
        }
        int column1Width = 0;
        int column2Width = 0 ;
        int column3Width = 0 ;
        for (CardPaymentsStatistics s : statistics) {
            column1Width = Math.max(column1Width, Integer.toString(s.getCount()).length());
            column2Width = Math.max(column2Width, Integer.toString(s.getMonth()).length());
            column3Width = Math.max(column3Width, s.getAmount_sum().toString().length());
        }
        
        System.out.print("count");
        for (int i = 0; i < column1Width - 5; ++i) {
            System.out.print(" ");
        }
        System.out.print(" | month");
        for (int i = 0; i < column1Width + 3; ++i) {
            System.out.print(" ");
        }
        for (int i = 0; i < column2Width + 3; ++i) {
            System.out.print(" ");
        }
        System.out.print(" | amount_sum");
        System.out.println();
        for (int i = 0; i < column1Width + column2Width + column3Width + 28; ++i) {
            System.out.print("-");
        }
        System.out.println();
        
        for (CardPaymentsStatistics s : statistics) {
            String nString = Integer.toString(s.getCount());
            int nLength = nString.length();
            
            System.out.print(s.getCount());
            
            int spaceLength = column1Width - nLength;
            for (int i = 0; i < spaceLength; ++i) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.print(s.getMonth());
            
            spaceLength = column2Width - nLength;
            for (int i = 0; i < spaceLength; ++i) {
                System.out.print(" ");
            }
            spaceLength = column3Width - nLength;
            for (int i = 0; i < spaceLength; ++i) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.println(s.getAmount_sum());
        }
    }
}
