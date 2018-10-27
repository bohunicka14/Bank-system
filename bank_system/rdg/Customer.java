
package bank_system.rdg;

/**
 *
 * @author Inka
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Customer extends BaseGateway {
	
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthNumber;
    private String status;

    public Integer getId() { return id;	}
    public void setId(Integer id) { this.id = id; }	

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getBirthNumber() { return birthNumber; }
    public void setBirthNumber(String birthNumber) { this.birthNumber = birthNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void insert() throws SQLException {
        if (id != null) {
            throw new IllegalStateException("id has been set");
        }

        insert("INSERT INTO customers (first_name, last_name, birth_number, status) VALUES (?,?,?,?)");
    }

    @Override
    protected void insertFill(PreparedStatement s) throws SQLException {
        s.setString(1, firstName);
        s.setString(2, lastName);
        s.setString(3, birthNumber);
        s.setString(4, status);
    }

    @Override
    protected void insertUpdateKeys(ResultSet r) throws SQLException {
        id = r.getInt(1);
    }

    public void update() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        update("UPDATE customers SET first_name = ?, last_name = ?, birth_number = ?, status = ? WHERE id = ?");
    }

    @Override
    protected void updateFill(PreparedStatement s) throws SQLException {
        s.setString(1, firstName);
        s.setString(2, lastName);
        s.setString(3, birthNumber);
        s.setString(4, status);
        s.setInt(5, id);
    }

    public void delete() throws SQLException {
        if (id == null) {
                throw new IllegalStateException("id is not set");
        }

        delete("DELETE FROM customers WHERE birth_number = ?");
    }

    @Override
    protected void deleteFill(PreparedStatement s) throws SQLException {
        s.setString(1, birthNumber);
    }
	
}
