package com.RemoteFileManager.Server;

import java.net.*;
import java.io.*;

public class Server {
    protected ServerSocket serverSocket;
    protected Socket clientSocket;
    protected PrintWriter out;
    protected BufferedReader in;

    public void start(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void stopServer() {
        try {
            this.in.close();
            this.out.close();
            this.clientSocket.close();
            this.serverSocket.close();
        } catch (IOException ex) {
            this.printTraceback(ex);
        }
    }

    protected void defineInAndOut() throws IOException {
        this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }

    public String listen() throws IOException {
        this.clientSocket = this.serverSocket.accept();
        this.defineInAndOut();
        return this.in.readLine();
    }

    public String sendMessage(String msg) throws IOException {
        this.out.println(msg);
        return "Done";
    }

    public void printTraceback(Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
