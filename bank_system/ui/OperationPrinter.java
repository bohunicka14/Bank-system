/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.ui;

import bank_system.rdg.Account;
import bank_system.rdg.AccountFinder;
import bank_system.rdg.Operation;
import java.sql.SQLException;

/**
 *
 * @author Inka
 */

//id serial primary key,
//	datetime timestamp,
//	amount numeric,
//	operation_type varchar, -- payment, income
//	id_recipient integer references accounts ON DELETE CASCADE,
//	id_sender integer references accounts ON DELETE CASCADE,
//
//	-- insurance payments
//	id_insurance integer,
//
//	-- standing_orders
//	id_standing_order integer,
//
//	-- card_id
//	id_card integer

public class OperationPrinter {
    private static final OperationPrinter INSTANCE = new OperationPrinter();
    
    public static OperationPrinter getInstance() { return INSTANCE; }
    
    private OperationPrinter() { }
    
    public void print(Operation operation) throws SQLException {
        if (operation == null) {
            throw new NullPointerException("operation cannot be null");
        }
        
        Account sender = AccountFinder.getInstance().findById(operation.getId_sender());
        Account receiver = AccountFinder.getInstance().findById(operation.getId_recipient());
        
        System.out.print("id :          ");
        System.out.println(operation.getId());
        System.out.print("datetime:   ");
        System.out.println(operation.getDatetime());
        System.out.print("amount:    ");
        System.out.println(operation.getAmount());
        System.out.print("operation type: ");
        System.out.println(operation.getOperation_type());
        System.out.print("recipient's account number:       ");
        if (receiver == null){
            System.out.println("null");
        }
        else{
            System.out.println(receiver.getNumber());
        }
        
        System.out.print("sender's account number:       ");
        System.out.println(sender.getNumber());
        System.out.println();
    }
    
}
