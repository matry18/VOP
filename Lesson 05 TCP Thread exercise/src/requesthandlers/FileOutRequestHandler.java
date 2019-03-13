/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandlers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class FileOutRequestHandler extends AbstractRequestHandler {

    private String fileName;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        this.fileName = fileName;

    }

    @Override
    public void run() {
        System.out.println("FileOutRequestHandler started for " + socket.getPort());
        try (Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Server ready. Type your massage:");
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String logInfo = "\t" + socket.getInetAddress().toString() + ":" + socket.getPort() + "\t";
                writeToLog(logInfo, line);
                writer.println("You have typed: " + line);
            }

            System.out.println("FileOutRequestHandler finished");
        } catch (IOException ex) {
            System.out.println("Error for I/O" + ex);
        }

    }

    public void writeToLog(String logInfo, String line) {

        PrintWriter outputString;

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException ex) {
            Logger.getLogger(FileOutRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        outputString = new PrintWriter(fileWriter);
        //PrintWriter printWriter = new PrintWriter(fileWriter);
        outputString.append(new Date() + "\t");
        outputString.append(logInfo);
        outputString.append(" ");
        outputString.append(line);
        outputString.append("\n");
        outputString.close();
    }

}
