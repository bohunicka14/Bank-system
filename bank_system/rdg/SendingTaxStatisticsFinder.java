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


public class SendingTaxStatisticsFinder extends BaseFinder<SendingTaxStatistics> {
    
    private static final SendingTaxStatisticsFinder INSTANCE = new SendingTaxStatisticsFinder();
    
    public static SendingTaxStatisticsFinder getInstance() {
        return INSTANCE;
    }
    
    private SendingTaxStatisticsFinder() { }

    public List<SendingTaxStatistics> findAll(int number) throws SQLException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//        System.out.print("Enter an account's number: ");
//        int accountNumber = Integer.parseInt(br.readLine());

        Account account = AccountFinder.getInstance().findByNumber(number);
        
        if (account == null) {
//            System.out.println("No such account exists");
            return null;
        } else {
            int accountId = account.getId();
            
//        --------------------------------------------------------------
//        celkove suma zaplatenych dani za odoslane platby
//        --------------------------------------------------------------

            return findAll("select count(*) as number, sum(operations.amount*(account_types.sending_tax/100)) as tax_sum_total\n" +
                            "from operations join accounts ON operations.id_sender = accounts.id \n" +
                            "JOIN account_types ON account_types.id = accounts.id_account_type\n" +
                            "where operations.id_sender = " + Integer.toString(accountId) + " \n" +
                            "group by accounts.number;");
        }
    }

    @Override
    protected SendingTaxStatistics load(ResultSet r) throws SQLException {
        SendingTaxStatistics statistic = new SendingTaxStatistics();

//         private int number;
//        private int month;
//        private int count;
//        private BigDecimal amount_sum;
//        
        statistic.setNumber(r.getInt("number"));
        statistic.setTax_sum_total(r.getBigDecimal("tax_sum_total"));


        return statistic;
    }
    
    
}
