package com.RemoteFileManager.Client;

public class ClientStart {
    public static void main(String[] args) {
        // Client starts
        int PORT = 8888;
        String HOST = "127.0.0.1";
        Client client = new Client();
        // Connecting to proxy server

        while (true) {
            try {
                client.connectToServer(HOST, PORT);
                Menu menu = new Menu();
                menu.startMenu(client);
                client.stopConnection();
            } catch (Exception ex) {
                Menu.printTraceback(ex);
                client.stopConnection();
                break;
            }
        }
    }
}
