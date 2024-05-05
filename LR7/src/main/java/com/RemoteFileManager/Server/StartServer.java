package com.RemoteFileManager.Server;

public class StartServer {
    public static void main(String[] args) {
        int PORT = 8888;
        Server server = new Server();
        String command;
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
                server.sendMessage("All gud");
            } catch (Exception ex) {
                server.printTraceback(ex);
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
