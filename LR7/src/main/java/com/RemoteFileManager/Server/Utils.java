package com.RemoteFileManager.Server;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static ArrayList<Catalog> getListOfAllCatalogs(Catalog catalog) {
        ArrayList<Catalog> catalogs = new ArrayList<>();
        catalogs.add(catalog);
        for (int index = 0; catalogs.size() > index; index++) {
            if (!catalogs.get(index).getCatalogs().isEmpty()) {
                catalogs.addAll(catalogs.get(index).getCatalogs());
            }
        }
        return catalogs;
    }

    public static Catalog userChooseCatalog(Catalog catalog) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose root catalog: ");
        ArrayList<Catalog> catalogs = Utils.getListOfAllCatalogs(catalog);
        if (catalogs.isEmpty())
            catalogs.addFirst(catalog);
        for (int index = 0; catalogs.size() > index; index++) {
            System.out.println(index + ": " + catalogs.get(index).getName());
        }
        int rootCatalogNumber = scanner.nextInt();
        return catalogs.get(rootCatalogNumber);
    }
}
