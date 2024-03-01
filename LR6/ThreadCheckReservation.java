package LR6;

import java.util.ArrayList;
//import java.util.concurrent.Semaphore;

public class ThreadCheckReservation extends Thread {
//    private final static Semaphore sem = new Semaphore(1, true);
    private int duration = 5;
    private ArrayList<Ticket> tickets = null;

    void setDuration(int dur) {
        this.duration = dur;
    }

    int getDuration() {
        return this.duration;
    }

    void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    ArrayList<Ticket> getTickets() {
        return this.tickets;
    }

    public void run() {
        try {
//            sem.acquire();
            while (true) {
                Thread.sleep(this.duration * 1000);
                if (tickets.isEmpty()) {
                    return;
                }
                for (int index = 0; index < tickets.size(); index++) {
                    this.tickets.get(index).reservationTimeDecrease(duration);
                    System.out.println(tickets.get(index).toString());
                    if (tickets.get(index).isReservationOut()) {
                        System.out.println("This ticket is out of reservation: " + tickets.get(index).toString());
                        tickets.remove(index);
                    }
                }
            }
//            sem.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
