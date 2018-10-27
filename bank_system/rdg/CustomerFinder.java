/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system.rdg;

/**
 *
 * @author Inka
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerFinder extends BaseFinder<Customer> {
    
    private static final CustomerFinder INSTANCE = new CustomerFinder();
    
    public static CustomerFinder getInstance() { return INSTANCE; }
    
    private CustomerFinder() { }
		
    public Customer findById(int id) throws SQLException {
        return findByInt("SELECT * FROM customers WHERE id = ?", id);
    }

    public Customer findByBirthNumber(String birthNumber) throws SQLException {
        return findByString("SELECT * FROM customers WHERE birth_number = ?", birthNumber);
    }
    
    public List<Customer> findAll() throws SQLException {
        return findAll("SELECT * FROM customers");
    }

    @Override
    protected Customer load(ResultSet r) throws SQLException {
        Customer c = new Customer();

        c.setId(r.getInt("id"));
        c.setFirstName(r.getString("first_name"));
        c.setLastName(r.getString("last_name"));
        c.setBirthNumber(r.getString("birth_number"));
        c.setStatus(r.getString("status"));

        return c;
    }

}
