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
public class CardPaymentsStatisticsFinder extends BaseFinder<CardPaymentsStatistics> {
    
    private static final CardPaymentsStatisticsFinder INSTANCE = new CardPaymentsStatisticsFinder();
    
    public static CardPaymentsStatisticsFinder getInstance() {
        return INSTANCE;
    }
    
    private CardPaymentsStatisticsFinder() { }

    public List<CardPaymentsStatistics> findAll(int number) throws SQLException, IOException {
       

        Account account = AccountFinder.getInstance().findByNumber(number);
        
        if (account == null) {
//            System.out.println("No such account exists");
            return null;
        } else {
            int accountId = account.getId();
            
//        --------------------------------------------------------------
//        platba kartou za jednotlive mesiace, plus aj ich pocet
//        --------------------------------------------------------------
        
            return findAll("select EXTRACT(MONTH FROM operations.datetime) AS month, count(*) as count, sum(operations.amount) as amount_sum \n" +
                            "from operations join accounts ON operations.id_sender = accounts.id \n" +
                            "where operations.id_card is not NULL AND operations.id_sender = " + Integer.toString(accountId) + " \n" +
                            "group by accounts.number, EXTRACT(MONTH FROM operations.datetime);");
        }
    }

    @Override
    protected CardPaymentsStatistics load(ResultSet r) throws SQLException {
        CardPaymentsStatistics statistic = new CardPaymentsStatistics();

//         private int number;
//        private int month;
//        private int count;
//        private BigDecimal amount_sum;
//        
        statistic.setMonth(r.getInt("month"));
        statistic.setCount(r.getInt("count"));
        statistic.setAmount_sum(r.getBigDecimal("amount_sum"));

        return statistic;
    }
    
    
}
