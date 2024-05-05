package com.RemoteFileManager.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void startMenu(Client client) {
        Scanner scanner = new Scanner(System.in);
        int command;
        String msg = """
                What you wanna do:
                0. Exit
                1. Add new catalog
                2. Add new file
                3. Watch all directory.
                4. Find files by extension
                5. Reconnect to server""";
        System.out.println(msg);
        command = scanner.nextInt();

        if (command == 0) {
            Menu.sendMessage(client, "stop");
        } else if (command == 1) {
            String name = null;
            String catalog = null;
            Integer catalog_number = null;
            do {
                System.out.println(1);
                if (name == null)
                    name = Menu.askString(scanner, "Enter name: ");
                if (catalog == null) {
                    if (catalog_number == null)
                        catalog_number = scanner.nextInt();
                    catalog = Menu.askCatalog(client, catalog_number);
                }
            } while (name == null || catalog == null);
            Menu.sendMessage(client, String.format("newCatalog|%s|%s", catalog, name));
        } else if (command == 2) {
            String name = null;
            String catalog = null;
            Integer catalog_number = null;
            Long size = null;
            do {
                if (name == null)
                    name = Menu.askString(scanner, "Enter name: ");
                if (catalog == null) {
                    if (catalog_number == null)
                        catalog_number = scanner.nextInt();
                    catalog = Menu.askCatalog(client, catalog_number);
                }
                if (size == null)
                    size = Menu.askLong(scanner, "Enter size: ");
            } while (name == null || catalog == null || size == null);
            Menu.sendMessage(client, String.format("newFile|%s|%s|%d", name, catalog, size));
        } else if (command == 3) {
            ArrayList<String> catalogs;
            try {
                catalogs = Menu.getAllCatalogs(client);
                if (catalogs != null)
                    for (String catalog : catalogs)
                        System.out.println(catalog);
            } catch (Exception ex) {
                Menu.printTraceback(ex);
            }
        } else if (command == 4) {
            String catalog;
            String extension;
            Boolean isRecurse;
            do {
                catalog = Menu.askCatalog(client, scanner.nextInt());
                extension = askString(scanner, "Enter extension: ");
                isRecurse = Menu.askBoolean(scanner, "Enter (true/false): ");
            } while (catalog == null || extension == null || isRecurse == null);
            Menu.sendMessage(client, String.format("findFilesByExtension|%s|%s|%b", catalog, extension, isRecurse));
        } else if (command == 5) {
            System.out.println("Reconnecting...");
        } else {
            System.out.println("Unknown command!");
        }
    }

    public static void sendMessage(Client client, String msg) {
        try {
            String server_answer = client.sendMessage(msg);
            System.out.println(server_answer);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void printTraceback(Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }

    public static String askString(Scanner scanner, String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static Long askLong(Scanner scanner, String msg) {
        System.out.println(msg);
        return scanner.nextLong();
    }

    public static ArrayList<String> getAllCatalogs(Client client) {
        try {
            return new ArrayList<>(List.of(client.sendMessage("getAllCatalogs").split("\\|")));
        } catch (Exception ex) {
            Menu.printTraceback(ex);
        }
        return null;
    }

    public static boolean askBoolean(Scanner scanner, String msg) {
        System.out.println(msg);
        return scanner.nextBoolean();
    }

    public static String askCatalog(Client client, Integer catalog_number) {
        ArrayList<String> catalogs = Menu.getAllCatalogs(client);
        if (catalogs == null || catalogs.isEmpty()) {
            return null;
        }
        for (int index = 0; catalogs.size() > index; index++) {
            System.out.printf("%d, %s%n", index, catalogs.get(index));
        }
        return catalogs.get(catalog_number);
    }
}
