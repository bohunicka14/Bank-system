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

public class InsuranceFinder extends BaseFinder<Insurance> {
    
    private static final InsuranceFinder INSTANCE = new InsuranceFinder();
    
    public static InsuranceFinder getInstance() { return INSTANCE; }
    
    private InsuranceFinder() { }
		
    public Insurance findById(int id) throws SQLException {
        return findByInt("SELECT * FROM insurance WHERE id = ?", id);
    }
    
    public List<Insurance> findAll() throws SQLException {
        return findAll("SELECT * FROM insurance");
    }

    @Override
    protected Insurance load(ResultSet r) throws SQLException {
        Insurance c = new Insurance();
    
        c.setId(r.getInt("id"));
        c.setStart_date(r.getDate("start_date"));
        c.setDuration(r.getInt("duration"));
        c.setDescription(r.getString("decription"));
        c.setPrice(r.getInt("price"));

        return c;
    }

}
