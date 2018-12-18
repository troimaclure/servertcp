/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class SocketReader implements Runnable {

    Socket socket;
    BufferedReader inFromClient;

    public SocketReader(Socket socket) {
        try {
            this.socket = socket;
            inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException ex) {
            Logger.getLogger(SocketReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            String clientSentence = "";
            try {
                clientSentence = inFromClient.readLine();
                new SocketWriter(clientSentence + '\n');
            } catch (IOException ex) {
                System.err.println("Client disconnected");
                break;
            }
        }

    }

}
