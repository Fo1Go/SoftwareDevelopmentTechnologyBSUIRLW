package LR7;

import java.net.*;
import java.io.*;

public class Proxy extends Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(9090);
    }
}
