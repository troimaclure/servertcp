/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Administrateur
 */
public class ClientSocket {

    Socket socket;
    DataOutputStream output;

    public ClientSocket(Socket socket, DataOutputStream output) {
        this.socket = socket;
        this.output = output;
        new Thread(new SocketReader(socket)).start();
    }

}
