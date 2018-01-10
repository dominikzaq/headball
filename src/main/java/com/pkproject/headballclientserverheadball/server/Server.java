package com.pkproject.headballclientserverheadball.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static int uniqueConnectIdWithClient;
    // lista, trzymajaca w sobie wszystkich polaczonych uzytkownikow
    private ArrayList<Server.ClientThread> al;
    // numer portu ktory sluzy do polaczenia
    public static int portServer = 1111;
    // wlacz/wylacz server dla konkretnego uzytkownika
    private boolean keepGoing;


    public Server() {
        // inicjalizacja arrayList dla listy clientow
        al = new ArrayList<Server.ClientThread>();
    }

    private void startServer() throws IOException {
        keepGoing = true;
        ServerSocket serverSocket = new ServerSocket(portServer);

        while(keepGoing) {
            System.out.println("port server=" + portServer);

            Socket socket = serverSocket.accept();  	// accept connection
            // jezeli przerwiemy oczekiwanie
            if(!keepGoing)
                break;
            // utworzenie watku nowego clienta
            Server.ClientThread t = new Server.ClientThread(socket);
            // zapisanei go do listy

     al.add(t);
            // wlaczenie watku dla nowego clienta

            t.start();
        }

        //close all connect
        serverSocket.close();
        for(int i = 0; i < al.size(); ++i) {
            Server.ClientThread tc = al.get(i);
            try {
                tc.sInput.close();
                tc.sOutput.close();
                tc.socket.close();
            }
            catch(IOException ioE) {
            }
        }

    }


    //check which one user is disconnect
    synchronized void remove(int id) {
        // poszukaj w liscie ktory z uzytkownikow sie odlaczyl od servera
        for(int i = 0; i < al.size(); ++i) {
            Server.ClientThread ct = al.get(i);
            // jesli go znajdziesz, usun go
            if(ct.id == id) {
                al.remove(i);
                return;
            }
        }
    }



    class ClientThread extends Thread {
        private Socket socket;
        private ObjectInputStream sInput;
        private ObjectOutputStream sOutput;
        int id;
        ServerClientMessage cm;

        ClientThread(Socket socket) {
            // przypisanie unikalnego id
           // id = ++uniqueConnectIdWithClient;
            this.socket = socket;
            //utworzenie data streams
            System.out.println("Watek probuje utworzyc obiekt Input/Output Streams");
            try
            {
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                sInput  = new ObjectInputStream(socket.getInputStream());
            }
            catch (IOException e) {
                return;
            }
        }
        public void run() {
            boolean keepGoing = true;

            while (keepGoing) {

                try {
                    cm = (ServerClientMessage) sInput.readObject();
                    //sOutput.writeObject(new ServerClientMessage(ServerClientMessage.TURNONGAME));

                    System.out.print(cm.getType());
                } catch (IOException e) {
                    System.out.println("Problem z odczytaniem wiadomosci od uzytkownika: ");

                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Problem z odczytaniem wiadomosci od uzytkownika: ");

                    e.printStackTrace();
                }
                switch(cm.getType()) {
                    case ServerClientMessage.TURNONGAME:
                        writeMsg(new ServerClientMessage(ServerClientMessage.TURNONGAME));
                        System.out.println("writeMsg(new ServerClientMessage(ServerClientMessage.TURNONGAME));\n ");

                        break;
                    case ServerClientMessage.TURNOFFGAME:
                        writeMsg(new ServerClientMessage(ServerClientMessage.TURNOFFGAME));
                        System.out.println(" writeMsg(new ServerClientMessage(ServerClientMessage.TURNOFFGAME));\n");
                        break;
                }
            }

            remove(id);
            close();
        }

        private void writeMsg(ServerClientMessage serverClientMessage) {
            if(!socket.isConnected()) {
                close();
            }
            try {
                sOutput.writeObject(serverClientMessage);
            }
            catch(IOException e) {
                System.out.println("Problem z wyslaniem wiadomosci przez server");
            }
        }


        private void close() {
            // probuj zamknac polaczenie
            try {
                if(sOutput != null) sOutput.close();
            }
            catch(Exception e) {}
            try {
                if(sInput != null) sInput.close();
            }
            catch(Exception e) {};
            try {
                if(socket != null) socket.close();
            }
            catch (Exception e) {}
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startServer();
    }

}
