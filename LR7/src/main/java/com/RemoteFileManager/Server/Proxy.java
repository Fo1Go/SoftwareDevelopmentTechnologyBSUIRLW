package com.RemoteFileManager.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Proxy extends Server {
    protected PrintWriter outServer;
    protected BufferedReader inServer;
    protected Socket proxySocket;

    // connecting to server
    public void connectToServer(String ip, int port) {
        try {
            this.proxySocket = new Socket(ip, port);
            this.outServer = new PrintWriter(proxySocket.getOutputStream(), true);
            this.inServer = new BufferedReader(new InputStreamReader(proxySocket.getInputStream()));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public String listen() throws IOException {
        this.clientSocket = serverSocket.accept();
        this.defineInAndOut();

        String input = this.in.readLine();
        this.out.println(this.sendMessage(input));
        return input;
    }

    @Override
    public String sendMessage(String msg) throws IOException {
        this.outServer.println(msg);
        return this.inServer.readLine();
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
