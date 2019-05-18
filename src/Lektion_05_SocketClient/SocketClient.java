/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion_05_SocketClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aalsc
 */
public class SocketClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s;
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        
        //Connect to server on same machine port 6789
        try (Socket clientSocket = new Socket("localhost", 6789);) {
            
            //Set up stream to send/recieve data
            inputStream = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
            outputStream = new PrintWriter(new DataOutputStream(clientSocket.getOutputStream()));
            
            //Send "Java" to server
            outputStream.println("Java");
            outputStream.flush(); //Sends data to server
            
            //Read anything from the server until nomore lines and output it to the screen
            while (inputStream.hasNext()) {
                s = inputStream.nextLine();
                System.out.println(s);
            }
            inputStream.close();
            outputStream.close();
            
        } catch (IOException ex) {
            //If any exception occurs display it
            System.out.println("Error"+ex);
        }
        
        
        
    }
    
}
