/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.database;

import ectltool.opdrachtinterface.Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leon
 */
public class DBConnection {
    
    private Connection con;
    
    public DBConnection(Table t) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ectl","school", "school");
        Statement s = con.createStatement();
        s.executeUpdate(t.getTableCreateString());
    }

    public Connection getConnection() {
        return con;
    }
}
