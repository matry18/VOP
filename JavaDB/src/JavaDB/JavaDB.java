/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaDB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class JavaDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String table = "\"MovieExec\"";
        try {
            Class.forName("org.postgresql.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Movies", "postgres", "Password");//obs. husk at ændre password
            ResultSet rs = myCon.createStatement().executeQuery("Select * from " + table);
            while (rs.next()) {
               
                int count = rs.getMetaData().getColumnCount();
                int i = 1;
                while (i <= count) {
                    //System.out.print(rs.getMetaData().getColumnName(i));
                    System.out.print(rs.getString(rs.getMetaData().getColumnName(i)) + "\t");
                    i++;
                }
                System.out.println();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("CNFE: " + ex);
        } catch (SQLException ex) {
            System.out.println("SQLE: " + ex);
        }

    }

}
