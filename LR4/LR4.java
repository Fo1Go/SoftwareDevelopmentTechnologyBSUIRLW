package LR4;

// Разработать проект управления процессами на основе создания и реализации интерфейсов для
// предметных областей, создать консольное приложение, удовлетворяющее следующим требованиям:
// использовать возможности ООП(классы, наследование, полиморфизм, инкапсуляция).
// Аргументировать принадлежность классу каждого создаваемого метода и
// корректно переопределить для каждого класса методы equals(), hashCode(), toString().
// Каждый класс должен иметь отражающее смысл название и информативный состав.
// Наследование должно применяться только тогда, когда это имеет смысл.
// При кодировании должны быть использованы соглашения об оформлении кода java code convention.
// Классы должны быть грамотно разложены по пакетам.
// При необходимости использовать внутренние и вложенные классы.
// Консольное меню должно быть минимальным.
// Для хранения параметров инициализации можно использовать файлы.
// Для ввода данных использовать обработку исключительных ситуаций.

// 21.Каталог ПО (папка на диске).
// Определить иерархию директории, используя классы: вид ПО, название, версия.
// Организовать поиск файлов по определенному виду,
// реализовать расчет объема занимаемой памяти файлами в папке,
// вывести иерархию версий по названию ПО.

import java.util.ArrayList;
import java.util.Scanner;

public class LR4 {
    public static void main(String... args) {
        Catalog root = new Catalog("/", "/");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int command = -1;

        while (isRunning) {
            System.out.println("""
                    What you wanna do:\s
                    0. Exit
                    1. Add new catalog
                    2. Add new file
                    3. Watch all directory.
                    4. Find files by extension
                    """
            );
            command = scanner.nextInt();

            if (command == 0) {
                isRunning = false;
            } else if (command == 1) {
                String name = null;
                Catalog catalog = null;
                while (true) {
                    try {
                        if (name == null) {
                            System.out.println("Enter catalog name: ");
                            name = scanner.next();
                        }
                        if (catalog == null) {
                            catalog = utils.userChooseCatalog(root);
                        }
                        catalog.appendCatalog(new Catalog(catalog.getLocation(), name));
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

            } else if (command == 2) {
                String name = null;
                Catalog catalog = null;
                Long size = null;
                while (true) {
                    try {
                        if (name == null) {
                            System.out.println("Enter catalog name: ");
                            name = scanner.next();
                        }
                        if (catalog == null) {
                            catalog = utils.userChooseCatalog(root);
                        }
                        if (size == null) {
                            System.out.println("Enter size: ");
                            size = Long.parseLong(scanner.next());
                        }

                        catalog.appendFile(new File(catalog, name, size));
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            } else if (command == 3) {
                try {
                    ArrayList<Catalog> catalogs = utils.getListOfAllCatalogs(root);
                    if (catalogs.isEmpty())
                        catalogs.addFirst(root);
                    for (Catalog catalog : catalogs) {
                        System.out.println(catalog.getName() + " catalog size: " + catalog.getSize());
                        for (File file : catalog.getFiles()) {
                            System.out.println("  " + file.getName());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (command == 4) {
                Catalog catalog = null;
                String extention = null;
                Boolean isRecurse = null;
                while (true) {
                    try {
                        if (catalog == null) {
                            catalog = utils.userChooseCatalog(root);
                        }
                        if (extention == null) {
                            System.out.println("Enter file extension: ");
                            extention = scanner.next();
                        }
                        if (isRecurse == null) {
                            System.out.println("Recursion?(true/false): ");
                            isRecurse = scanner.nextBoolean();
                        }
                        for (File file : catalog.findFilesByExtension(extention, isRecurse)) {
                            System.out.println(file.getName() + " file size: " + file.getSize());
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
}
