package LR1;

//В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика,
// дату получения задания, а также дату сдачи задания.
// Для работы с динамическим массивом вводить его с клавиатуры и необходимо использовать
// утилитный класс Arrays и его стандартные методы. В заданиях на числа объект можно
// создавать в виде массива символов. Ввести n чисел с консоли (1-15 вариант добавлять
// новый элемент в начало списка, 16-30 – в конец списка).
// 21. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class LR1 {
    public static void main(String[] args) {

        boolean is_running = true;
        String number;
        System.out.println("Enter numbers through enter: ");
        ArrayList<String> user_input = new ArrayList<>();
        while(is_running) {
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextLine();
            if(Objects.equals(number, " ") || Objects.equals(number, "")) {
                is_running = false;
            } else {
                user_input.addLast(number);
            }
        }
        System.out.println("Вы ввели: ");
        System.out.println(Arrays.toString(user_input.toArray()) + "\n");

        int matrix_size = (int) Math.ceil(Math.sqrt(user_input.size()));
        System.out.println("Matrix size is " + matrix_size);
        String symbol;
        System.out.println("-".repeat(15));
        for(int row = 0; row < matrix_size; row++) {
            for(int col = 0; col < matrix_size; col++) {
                if(user_input.size() > matrix_size*row+col) {
                    symbol = user_input.get(matrix_size * row + col) + " ";
                } else {
                    symbol = "- ";
                }
                System.out.print(symbol);
            }
            System.out.print("\n");
        }
        System.out.println("-".repeat(15));

        System.out.println("Автор: Usevalad Prastsiakou https://github.com/fo1go ");
        System.out.println("Дата получения: 09.02.2024");
        System.out.println("Дата сдачи: " + LocalDateTime.now().toString());
    }
}