/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Inka
 */
public class SentAmountStatisticsFinder extends BaseFinder<SentAmountStatistics> {
    
    private static final SentAmountStatisticsFinder INSTANCE = new SentAmountStatisticsFinder();
    
    public static SentAmountStatisticsFinder getInstance() {
        return INSTANCE;
    }
    
    private SentAmountStatisticsFinder() { }

    public List<SentAmountStatistics> findAll(int number) throws SQLException, IOException {
       

        Account account = AccountFinder.getInstance().findByNumber(number);
        
        if (account == null) {
//            System.out.println("No such account exists");
            return null;
        } else {
            int accountId = account.getId();
            
//        --------------------------------------------------------------
//        priemerna odoslana suma
//        --------------------------------------------------------------
            return findAll("select count(*) as count, avg(operations.amount) as average\n" +
                            "from operations join accounts ON operations.id_sender = accounts.id \n" +
                            "where operations.id_sender = " + Integer.toString(accountId) + " \n" +
                            "group by accounts.number;");
        }
    }

    @Override
    protected SentAmountStatistics load(ResultSet r) throws SQLException {
        SentAmountStatistics statistic = new SentAmountStatistics();

//         private int number;
//        private int month;
//        private int count;
//        private BigDecimal amount_sum;
//        
        statistic.setCount(r.getInt("count"));
        statistic.setAverage(r.getBigDecimal("average"));


        return statistic;
    }
    
}
