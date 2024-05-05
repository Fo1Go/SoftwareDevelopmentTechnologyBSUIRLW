package com.RemoteFileManager.Server;

public class StartProxyServer {
    public static void main(String[] args) {
        int PROXYPORT = 9999;
        String SERVERHOST = "127.0.0.1";
        int SERVERPORT = 8888;

        Proxy proxy = new Proxy();
        try {
            proxy.start(PROXYPORT);
        } catch (Exception ex) {
            proxy.printTraceback(ex);
        }
        System.out.println("Proxy started");
        while(true) {
            try{
                proxy.connectToServer(SERVERHOST, SERVERPORT);
                System.out.println("Proxy...");
                System.out.println("Proxy command: " + proxy.listen());
                proxy.stopConnection();
            } catch (Exception ex) {
                proxy.stopConnection();
                proxy.printTraceback(ex);
                break;
            }
        }
        proxy.stopServer();
    }
}
