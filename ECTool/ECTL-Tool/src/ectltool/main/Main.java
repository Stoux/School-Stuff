/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.main;

import ectltool.presentation.MainFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Leon
 */
public class Main {

    //PRAGMA table_info(`reportrts_user`);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, Integer> sold = new HashMap<>();
        try {
            File folder = new File("D:\\log");
            
            HashSet<String> names = new HashSet<>();
            names.add("spy215");
            names.add("smurphyman112");
            names.add("OminousWo1f");
            names.add("Itzpersonal");
            names.add("AtypicalAbyss");
            
            for (File f : folder.listFiles()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    
                        
                }
            }
            if (1 + 1 == 2) return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = null;
                  // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Leon/Documents/GitHub/School-Stuff/ECTool/ECTL-Tool/res/ReportRTS.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM `reportrts_request` WHERE `mod_id` = 518;");
            while(rs.next())
            {
              // read the result set
              System.out.println(rs.getString(1));
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        if (1 + 1 == 2) return;
        try {
            new MainFrame().setVisible(true);
        } catch (Exception e) {
            
        }
    }
        
    public static void write (BufferedWriter w, String msg) throws IOException {
        w.write(msg);
        w.newLine();
    }
}
