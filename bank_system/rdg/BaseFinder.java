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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bank_system.DbContext;

/**
 *
 * @author shanki
 */
public abstract class BaseFinder<T> {

    protected List<T> findAll(String query) throws SQLException {
        if (query == null) {
            throw new NullPointerException("query cannot be null");
        }

        try (PreparedStatement s = DbContext.getConnection().prepareStatement(query)) {
            try (ResultSet r = s.executeQuery()) {

                List<T> elements = new ArrayList<>();

                while (r.next()) {
                    elements.add(load(r));
                }

                return elements;
            }
        }
    }
    
    protected List<T> findAllByString(String query, String arg) throws SQLException {
        if (query == null) {
            throw new NullPointerException("query cannot be null");
        }

        try (PreparedStatement s = DbContext.getConnection().prepareStatement(query)) {
            s.setString(1, arg);
            try (ResultSet r = s.executeQuery()) {

                List<T> elements = new ArrayList<>();

                while (r.next()) {
                    elements.add(load(r));
                }

                return elements;
            }
        }
    }
    
    protected List<T> findAllByInt(String query, int arg) throws SQLException {
        if (query == null) {
            throw new NullPointerException("query cannot be null");
        }

        try (PreparedStatement s = DbContext.getConnection().prepareStatement(query)) {
            s.setInt(1, arg);
            try (ResultSet r = s.executeQuery()) {

                List<T> elements = new ArrayList<>();

                while (r.next()) {
                    elements.add(load(r));
                }

                return elements;
            }
        }
    }

    protected T findByInt(String query, int value) throws SQLException {
        if (query == null) {
            throw new NullPointerException("query cannot be null");
        }

        try (PreparedStatement s = DbContext.getConnection().prepareStatement(query)) {
            s.setInt(1, value);

            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    T c = load(r);

                    if (r.next()) {
                        throw new RuntimeException("Move than one row was returned");
                    }

                    return c;
                } else {
                    return null;
                }

            }
        }
    }
    
    protected T findByString(String query, String value) throws SQLException {
        if (query == null) {
            throw new NullPointerException("query cannot be null");
        }

        try (PreparedStatement s = DbContext.getConnection().prepareStatement(query)) {
            s.setString(1, value);

            try (ResultSet r = s.executeQuery()) {
                if (r.next()) {
                    T c = load(r);

                    if (r.next()) {
                        throw new RuntimeException("Move than one row was returned");
                    }

                    return c;
                } else {
                    return null;
                }

            }
        }
    }

    protected abstract T load(ResultSet r) throws SQLException;

}

