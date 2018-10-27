/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.ui;

import bank_system.rdg.SentAmountStatistics;
import java.util.List;

/**
 *
 * @author Inka
 */
public class SentAmountStatisticsPrinter {
    private static final SentAmountStatisticsPrinter INSTANCE = new SentAmountStatisticsPrinter();
    
    public static SentAmountStatisticsPrinter getInstance() {
        return INSTANCE;
    }
    
    private SentAmountStatisticsPrinter() { }
 
    public void print(List<SentAmountStatistics> statistics) {
        if (statistics == null){
            return;
        }
        int column1Width = 0;
        int column2Width = 0 ;
        for (SentAmountStatistics s : statistics) {
            column1Width = Math.max(column1Width, Integer.toString(s.getCount()).length());
            column2Width = Math.max(column2Width, s.getAverage().toString().length());
        }
        
        System.out.print("count");
        for (int i = 0; i < column1Width - 1; ++i) {
            System.out.print(" ");
        }
        System.out.println(" | average");
        for (int i = 0; i < column1Width + column2Width + 3; ++i) {
            System.out.print("-");
        }
        System.out.println();
        
        for (SentAmountStatistics s : statistics) {
            String nString = Integer.toString(s.getCount());
            int nLength = nString.length();
            
            System.out.print(s.getCount());
            
            int spaceLength = column1Width - nLength;
            for (int i = 0; i < spaceLength; ++i) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            System.out.println(s.getAverage());
        }
    }
}
