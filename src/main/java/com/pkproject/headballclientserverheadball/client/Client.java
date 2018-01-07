package com.pkproject.headballclientserverheadball.client;

import com.pkproject.headballclientserverheadball.server.ServerClientMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private static final int PORT = 50000;
    private static final String HOST = "localhost";
    private ObjectInputStream sInput;		// to read from the socket
    private ObjectOutputStream sOutput;		// to write on the socket
    private Socket clientSocket;
    public boolean connection = false;

    public Client(String server, int port) {

    }

    // we created new client
    public boolean connectWithServer() {
        if(!connection)
        {
            // try to connect to the server
            try {
               // clientSocket = new Socket(server, port);
            }
            // if it failed not much I can so
            catch(Exception ec) {
                System.out.println("problem with connect");
                return false;
            }

            /* Creating both Data Stream */
            try
            {
                sInput  = new ObjectInputStream(clientSocket.getInputStream());
                sOutput = new ObjectOutputStream(clientSocket.getOutputStream());
            }
            catch (IOException eIO) {
                System.out.println("Problem with createu Input/Output streams");
                return false;
            }

            // creates the Thread to listen from the server
            new Client.ListenFromServer().start();
            // Send our username to the server this is the only message that we
            // will send as a String. All other messages will be ChatMessage objects
            connection = true;
        }
        // success we inform the caller that it worked
        return true;
    }

    public void sendMessege(ServerClientMessage msg) throws IOException {
        sOutput.writeObject(msg);
    }

    class ListenFromServer extends Thread {
        ServerClientMessage cm;


        public void run() {
            while(true) {
                try {
                    cm = (ServerClientMessage) sInput.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
