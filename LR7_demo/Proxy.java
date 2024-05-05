package LR7_demo;

import java.io.*;

public class Proxy extends Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(9090);
    }
}
