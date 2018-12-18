/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;

/**
 *
 * @author Administrateur
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<ClientSocket> sockets = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(new TcpFactory()).start();
    
    }
}
