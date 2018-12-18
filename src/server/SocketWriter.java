/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrateur
 */
public class SocketWriter {

    public SocketWriter(String message) {
        ArrayList<ClientSocket> remove = new ArrayList<>();

        for (ClientSocket s : Server.sockets) {
            try {
                if (s.socket.isClosed() || !s.socket.isBound() || !s.socket.isConnected() || s.socket.isInputShutdown() || s.socket.isOutputShutdown()) {
                    remove.add(s);
                    continue;
                }
                System.out.println("sending : " + message);
                s.output.writeBytes(message);
            } catch (IOException ex) {
                remove.add(s);
                
            }
        }
        Server.sockets.removeAll(remove);

    }

}
