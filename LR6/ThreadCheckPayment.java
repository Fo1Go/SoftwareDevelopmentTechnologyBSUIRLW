package LR6;

import java.util.ArrayList;
import java.util.Random;

public class ThreadCheckPayment extends Thread {
    private ArrayList<Ticket> tickets = null;
    private int duration = 5;

    public ThreadCheckPayment(ArrayList<Ticket> tickets, int duration) {
        this.tickets = tickets;
        this.duration = duration;
    }

    public void run() {
        Random rd = new Random();
        int timeToCheck = this.duration;
        Ticket ticket;
        Client client;
        Flight flight;
        while (true) {
            try {
                Thread.sleep(timeToCheck * 1000L);

                if (tickets.isEmpty()) {
                    continue;
                }

                for (int index = 0; index < this.tickets.size(); index++) {
                    ticket = this.tickets.get(index);
                    client = ticket.getClient();
                    flight = ticket.getFlight();

                    if ((client.getBalance() - ticket.getCountTickets() * flight.getCostOneTicket()) > 0 &&
                            !ticket.getPaidStatus()) {
                        if (rd.nextInt(0, 10) == 0) {
                            System.out.println("Client - " + client.getName() + " is paid his ticket " + ticket);
                            ticket.setPaidStatus(true);
                            client.setBalance(client.getBalance() - ticket.getCountTickets() * flight.getCostOneTicket());
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("ERROR!");
            }
        }
    }
}
