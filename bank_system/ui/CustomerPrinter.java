/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.ui;

/**
 *
 * @author Inka
 */

import bank_system.rdg.Customer;


public class CustomerPrinter {
    
    private static final CustomerPrinter INSTANCE = new CustomerPrinter();
    
    public static CustomerPrinter getInstance() { return INSTANCE; }
    
    private CustomerPrinter() { }
        
    public void print(Customer customer) {
        if (customer == null) {
            throw new NullPointerException("customer cannot be null");
        }
        
        System.out.print("id :          ");
        System.out.println(customer.getId());
        System.out.print("first name:   ");
        System.out.println(customer.getFirstName());
        System.out.print("last name:    ");
        System.out.println(customer.getLastName());
        System.out.print("birth number: ");
        System.out.println(customer.getBirthNumber());
        System.out.print("status:       ");
        System.out.println(customer.getStatus());
        System.out.println();
    }
}

