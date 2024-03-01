package LR5;

// Используя Collection Framework (соответствующий интерфейс и Stream API)
// 21. На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
//  добавление/удаление числа;
// поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class LR5 {
    public static void main(String[] args) {
        boolean is_running = true;
        String number;
        System.out.println("Enter numbers through enter: ");
        advancedArrayList<Double> input = new advancedArrayList<Double>();
        while(is_running) {
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextLine();

            if(Objects.equals(number, " ") || Objects.equals(number, "")) {
                is_running = false;
            } else {
                input.addLast(Double.parseDouble(number));
            }
        }
        System.out.println("Your input: ");
        Arrays.stream(input.toArray()).forEach(a -> System.out.print(a + " "));
//        System.out.println(Arrays.toString(input.toArray()));
        System.out.println("\nEnter real number, what closest number you want to find: ");
        Scanner scanner = new Scanner(System.in);
        Double closeToNumber = scanner.nextDouble();
        Double result = input.findMostCloseToNumberByModule(closeToNumber);
        System.out.println(result);
    }
}
