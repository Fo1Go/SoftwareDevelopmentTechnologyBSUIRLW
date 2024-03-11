package LR6;

import java.util.ArrayList;

public class ThreadCheckReservation extends Thread {
    private int duration = 5;
    private ArrayList<Ticket> tickets = null;
    public ThreadCheckReservation(ArrayList<Ticket> tickets, int duration) {
        this.duration = duration;
        this.tickets = tickets;
    }
    public void run() {
        Ticket ticket;
        while (true) {
            try {
                Thread.sleep(duration * 1000L);

                if (tickets.isEmpty()) {
                    continue;
                }

                for (int index = 0; index < tickets.size(); index++) {
                    ticket = tickets.get(index);

                    ticket.reservationTimeDecrease(duration);
                    if (ticket.isReservationOut()) {
                        System.out.println("This ticket is out of reservation: " + ticket);
                        tickets.remove(index);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("ERROR!");
            }
        }
    }
}
