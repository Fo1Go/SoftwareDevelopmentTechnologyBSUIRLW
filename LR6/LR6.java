package LR6;

//Разработать многопоточное приложение. Использовать возможности,
// предоставляемые пакетом java.util.concurrent. Не использовать слово synchronized.
// Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
// 21. Сервис покупки билетов. Имеется перечень рейсов на определенное направление.
// Пользователи совершают бронирование.
// Бронирование можно корректировать в сторону увеличения и уменьшения количества билетов.
// Бронирование действует 10 минут. Если не поступает оплата в течение этого времени, другой пользователь
// может забронировать эти же билеты.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class LR6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Client> allClients = new ArrayList<Client>();
        allClients.add(new Client("Usevalad", 18, 8 * 60));
        allClients.add(new Client("NN", 25, 12 * 60));

        Flight[] flights = {
                new Flight("Boing 777889", "Minsk", "Astana", 122),
                new Flight("Boing 777889", "Minsk", "Astana", 122),
                new Flight("Boing 777889", "Kiev", "Moscow", 122),
                new Flight("Boing 777889", "Berlin", "Minsk", 122),
                new Flight("Boing 777889", "Copenhagen", "Minsk", 122),
                new Flight("Boing 777889", "Moscow", "Minsk", 122)
        };
        ArrayList<Flight> allFlight = new ArrayList<Flight>(Arrays.stream(flights).toList());
        ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
        allTickets.add(new Ticket(allFlight.getFirst(), allClients.getFirst()));
        System.out.println("All tickets: ");
        allTickets.forEach(System.out::println);
        int duration = 1;
        String userInput;
        System.out.println("HELLO MY DEAR FRIEND!!!");
        Thread thread = newThread(allTickets, duration);
        do {
            if (!thread.isAlive()) {
                (thread = newThread(allTickets, duration)).start();
            }
            userInput = scanner.nextLine();
        } while (!Objects.equals(userInput, "/q"));
    }

    public static Thread newThread(ArrayList<Ticket> allTickets, int duration) {
        ThreadCheckReservation thread = new ThreadCheckReservation();
        thread.setDuration(duration);
        thread.setTickets(allTickets);
        return new Thread(thread);
    }
}
