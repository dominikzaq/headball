package com.pkproject.headballclientserverheadball.client;

import com.pkproject.headballclientserverheadball.objects.StateGame;
import com.pkproject.headballclientserverheadball.server.Server;
import com.pkproject.headballclientserverheadball.server.ServerClientMessage;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private ObjectInputStream sInput;		// to read from the socket
    private ObjectOutputStream sOutput;		// to write on the socket
    private Socket clientSocket;
    public boolean connection = false;
    public StateGame stateGame;
    public boolean keepGoing = true;
    public Client(StateGame stateGame) {
        this.stateGame = stateGame;
    }
    // we created new client


    public boolean isKeepGoing() {
        return keepGoing;
    }

    public void setKeepGoing(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    public boolean connectWithServer() {
        if(!connection)
        {
            // try to connect to the server
            try {
                clientSocket = new Socket(HOST, Server.portServer);
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
        return connection;
    }

    public void closeConnectWithServer() {
        try {
            if(sInput != null) sInput.close();
        }
        catch(Exception e) {}
        try {
            if(sOutput != null) sOutput.close();
        }
        catch(Exception e) {}
        try{
            if(clientSocket != null) clientSocket.close();
        }
        catch(Exception e) {}
    }

    public boolean turnOnGame() {
        try {
            sOutput.writeObject(new ServerClientMessage(ServerClientMessage.TURNONGAME));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erorr turn on game");
            closeConnectWithServer();
            return false;
        }
        System.out.println(" send object");
        return true;
    }

    public  boolean exitGame() {
        try {
            System.out.println("turn off game");
            sOutput.writeObject(new ServerClientMessage(ServerClientMessage.TURNOFFGAME));
        } catch (IOException e) {
            e.printStackTrace();
            closeConnectWithServer();
            return false;
        }
        return true;
    }

    class ListenFromServer extends Thread {
        private ServerClientMessage cm;
        public void run() {
            System.out.println("[]"+stateGame.isStartGame());
            System.out.println(stateGame);

           while(connection) {
                try {
                    cm = (ServerClientMessage) sInput.readObject();
                } catch (EOFException e) {

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println(cm.getType() + "listen form serwer");
                if (cm != null) {
                    switch (cm.getType()) {
                        case ServerClientMessage.TURNONGAME:
                            stateGame.setStartGame(true);
                            System.out.println("[]" + stateGame.isStartGame());
                            break;
                        case ServerClientMessage.TURNOFFGAME:
                            stateGame.setEndGame(true);
                            System.out.println("[]" + stateGame.isEndGame());
                            connection = false;
                            break;
                    }

                }
         }
        }

    }
}
