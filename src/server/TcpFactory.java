/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class TcpFactory implements Runnable {

    ServerSocket welcomeSocket;

    public TcpFactory() {
        try {
            welcomeSocket = new ServerSocket(6789);
        } catch (IOException ex) {
            Logger.getLogger(TcpFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("waiting for client...");
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("client received");
                Server.sockets.add(new ClientSocket(connectionSocket, new DataOutputStream(connectionSocket.getOutputStream())));
            } catch (IOException ex) {
                Logger.getLogger(TcpFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
