/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_961;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aalsc
 */
public class DB_961 {
    public static ResultSet sql(String query) {
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection myCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Computer", "postgres", "password"); //obs. husk at ændre password
            rs = myCon.createStatement().executeQuery(query);
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnLabel(i) + "\t");
            }
            System.out.println("");
            while (rs.next()) {
                int count = rs.getMetaData().getColumnCount();
                int i = 1;
                while (i<= count) {
                    System.out.print(rs.getString(rs.getMetaData().getColumnName(i))+"\t");
                    i++;
                }
                System.out.println("");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: "+ex);
             
        } catch (SQLException ex) {
            System.out.println("SQLException: "+ex);
        }
        return rs;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Hvis du skriver '0' afsluttes programmet. Indtast et heltal som pris: \n>");
        while (true) {
            int pris = sc.nextInt();
            if (pris == 0) {
                System.out.println("Programmet afsluttes.");
                break;
            }
            String query = "select \"PC\".price, \"Product\".maker, \"Product\".model, \"PC\".speed From \"Product\" inner join \"PC\" on \"Product\".model = \"PC\".model ORDER BY ABS(price - " + pris + ") Limit 1;";
            sql(query);
            
        }
    }
    
}
