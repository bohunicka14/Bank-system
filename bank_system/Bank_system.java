/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_system;

/**
 *
 * @author Inka
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import bank_system.ui.MainMenu;

public class Bank_system {

    public static void main(String[] args) throws SQLException, IOException {

        String url = "";
        String username = "";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DbContext.setConnection(connection);

            MainMenu mainMenu = new MainMenu();
            mainMenu.run();

        } finally {
            DbContext.clear();
        }	
    }
}
