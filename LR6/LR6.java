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
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LR6 {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Boing 777889", "Minsk", "Astana", 122, 1000));
        flights.add(new Flight("Boing 777889", "Minsk", "Astana", 122, 1000));
        flights.add(new Flight("Boing 777889", "Kiev", "Moscow", 122, 1000));
        flights.add(new Flight("Boing 777889", "Berlin", "Minsk", 122, 1000));
        flights.add(new Flight("Boing 777889", "Copenhagen", "Minsk", 122, 1000));
        flights.add(new Flight("Boing 777889", "Moscow", "Minsk", 122, 1000));

        ArrayList<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int time = ThreadLocalRandom.current().nextInt(5, 61);
            Thread TUSER = newThreadCheckInToReservation(time, tickets, clients, flights);
            TUSER.start();
        }

        int durationCheckReservation = 1;
        int durationCheckPayment = durationCheckReservation * 10;
        String userInput;
        Thread t1 = newThreadCheckReservation(tickets, durationCheckReservation);
        Thread t2 = newThreadCheckPayment(tickets, durationCheckPayment);
        t1.start();
        t2.start();
        System.out.println("Enter 1 to watch all tickets: ");
        boolean is_running = true;
        Scanner scanner = new Scanner(System.in);
        while (is_running) {
            userInput = scanner.next();
            if (userInput.equals("/q")) {
                is_running = false;
                break;
            } else if (userInput.charAt(0) == '1') {
                watchAllTickets(tickets);
            } else if (userInput.charAt(0) == '2') {
                watchAllClients(clients);
            } else {
                System.out.println("Unknown command!");
            }
        }

    }

    public static Thread newThreadCheckReservation(ArrayList<Ticket> allTickets, int duration) {
        ThreadCheckReservation thread = new ThreadCheckReservation(allTickets, duration);
        return new Thread(thread);
    }

    public static Thread newThreadCheckPayment(ArrayList<Ticket> allTickets, int duration) {
        ThreadCheckPayment thread = new ThreadCheckPayment(allTickets, duration);
        return new Thread(thread);
    }

    public static Thread newThreadCheckInToReservation(int time_in_reservation,
                                     ArrayList<Ticket> tickets,
                                     ArrayList<Client> clients,
                                     ArrayList<Flight> flights) {
        ThreadAddUser thread = new ThreadAddUser(time_in_reservation, tickets, clients, flights);
        return new Thread(thread);
    }

    public static void watchAllTickets(List<Ticket> tickets) {
        System.out.println("All tickets:");
        tickets.forEach(n -> System.out.println(n.toString() + " Is paid?: " + n.getPaidStatus()));
    }

    public static void watchAllClients(List<Client> clients) {
        System.out.println("All tickets:");
        clients.forEach(n -> System.out.println(n.toString()));
    }
}
