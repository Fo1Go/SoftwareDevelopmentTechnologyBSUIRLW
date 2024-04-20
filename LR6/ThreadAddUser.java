package LR6;

import java.util.ArrayList;
import java.util.Random;

public class ThreadAddUser extends Thread {
    private final ArrayList<Ticket> tickets;
    private final ArrayList<Client> clients;
    private final ArrayList<Flight> flights;
    private final int time_in_reservation;

    public ThreadAddUser(int time_in_reservation, ArrayList<Ticket> tickets, ArrayList<Client> clients, ArrayList<Flight> flights) {
        this.time_in_reservation = time_in_reservation;
        this.tickets = tickets;
        this.clients = clients;
        this.flights = flights;
    }

    public void run() {
        try {
            Thread.sleep(time_in_reservation * 1000L);

            Random rd = new Random();
            int age = rd.nextInt(37) + 19;
            double money = rd.nextDouble() * (50000 - 5000) + 5000;
            int countTickets = rd.nextInt(4) + 1;
            int randomFlight = rd.nextInt(flights.size());

            Client client = new Client(Double.toString(money), age, money);
            Ticket ticket = new Ticket(flights.get(randomFlight), client, countTickets);

            clients.add(client);
            tickets.add(ticket);
            System.out.println("Reservation: " + ticket);
        } catch (InterruptedException e) {
            System.out.println("ERROR!");
        }
    }
}
