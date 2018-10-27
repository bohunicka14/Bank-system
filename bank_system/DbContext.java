/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system;

import java.sql.Connection;
/**
 *
 * @author Inka
 */
public class DbContext {
		
    private static Connection connection;

    public static void setConnection(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection cannot be null");
        }

        DbContext.connection = connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            throw new IllegalStateException("connection must be set before calling this method");
        }

        return connection;
    }

    public static void clear() {
        connection = null;
    }
	
}
