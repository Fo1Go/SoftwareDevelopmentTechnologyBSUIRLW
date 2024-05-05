package com.RemoteFileManager.Server;

import com.RemoteFileManager.Models.Catalogs;
import com.RemoteFileManager.Repository.CatalogRepository;
import com.RemoteFileManager.Repository.FileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartServer {
    public static void main(String[] args) throws IOException {
        int PORT = 8888;
        Server server = new Server();
        String command;
        ArrayList<String> arguments;
        FileRepository fileRep = new FileRepository();
        CatalogRepository catRep = new CatalogRepository();
        try {
            server.start(PORT);
        } catch (Exception ex) {
            server.printTraceback(ex);
            return;
        }
        System.out.println("Server started");
        while (true) {
            try {
                System.out.println("Server...");
                command = server.listen();
                System.out.println(command);
                arguments = new ArrayList<>(List.of(command.split("\\|")));
                command = arguments.getFirst();
                if (arguments.isEmpty()) {
                    server.sendMessage("Unknown command");
                }
                else if (command.equals("getAllCatalogs")) {
                    ArrayList<Catalogs> catalogs = (ArrayList<Catalogs>) catRep.getAllCatalogs();
                    StringBuilder msg = new StringBuilder();
                    for (int index = 0; catalogs.size() > index; index++) {
                        msg.append(String.format("%d|%s", index, catalogs.get(index)));
                    }
                    server.sendMessage(msg.toString());
                }
                else if (command.equals("newCatalog")) {

                }
                else if (command.equals("newFile")) {

                }
                else if (command.equals("findFilesByExtension")) {

                } else {
                    server.sendMessage("IDK");
                }
                server.sendMessage("all gud");
            } catch (Exception ex) {
                server.printTraceback(ex);
                server.sendMessage("HTTP 500");
                break;
            }



//            if (command == 0) {
//                server.out.println("0");
//            } else if (command == 1) {
//                String name = null;
//                Catalog catalog = null;
//                catalog.appendCatalog(new Catalog(catalog.getLocation(), name));
//            } else if (command == 2) {
//                String name = null;
//                Catalog catalog = null;
//                Long size = null;
//
//                catalog.appendFile(new File(catalog, name, size));
//                FP.addFile(new Files(name, size));

//            } else if (command == 3) {
//                ArrayList<Catalog> catalogs = Utils.getListOfAllCatalogs(root);
//                if (catalogs.isEmpty())
//                    catalogs.addFirst(root);
//                for (Catalog catalog : catalogs) {
//                    System.out.println(catalog.getName() + " catalog size: " + catalog.getSize());
//                    for (File file : catalog.getFiles()) {
//                        System.out.println("  " + file.getName());
//                    }
//                }
//            } else if (command == 4) {
//                Catalog catalog = null;
//                String extention = null;
//                Boolean isRecurse = null;
//                while (true) {
//                    for (File file : catalog.findFilesByExtension(extention, isRecurse)) {
//                        System.out.println(file.getName() + " file size: " + file.getSize());
//                    }
//                }
//            } else {
//                System.out.println("Unknown command!");
//            }
        }
        server.stopServer();
    }
}
