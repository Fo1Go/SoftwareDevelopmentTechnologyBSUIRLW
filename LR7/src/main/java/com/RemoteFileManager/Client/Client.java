package com.RemoteFileManager.Client;

import java.net.*;
import java.io.*;

public class Client {
    protected Socket clientSocket;
    protected PrintWriter out;
    protected BufferedReader in;

    public void connectToServer(String ip, int port) {
        try {
            this.clientSocket = new Socket(ip, port);
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public String sendMessage(String msg) throws IOException {
        this.out.println(msg);
        return in.readLine();
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
