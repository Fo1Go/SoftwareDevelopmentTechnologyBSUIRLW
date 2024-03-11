package LR6;

public class Ticket {
    private int reservationTime = 10 * 60;
    private Flight flight;
    private Client person;
    private int countTickets;
    private boolean is_paid;

    public Ticket(Flight flight, Client person, int countTickets) {
        this.setClient(person);
        this.setFlight(flight);
        this.countTickets = countTickets;
        this.is_paid = false;
    }

    public int getCountTickets() {
        return this.countTickets;
    }

    public void setCountTickets(int cntTickets) {
        this.countTickets = cntTickets;
    }

    public void setFlight(Flight flt) {
        this.flight = flt;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setClient(Client prs) {
        this.person = prs;
    }

    public Client getClient() {
        return this.person;
    }

    public boolean getPaidStatus() {
        return this.is_paid;
    }

    public void setPaidStatus(boolean status) {
        this.is_paid = status;
    }

    public boolean isReservationOut() {
        if (this.is_paid) return false;
        return this.reservationTime <= 0;
    }

    public void reservationTimeDecrease(int time) {
        if (!this.is_paid) this.reservationTime -= time;
    }

    public int getReservationTime() {
        return this.reservationTime;
    }

    public void setReservationTime(int reservation) {
        this.reservationTime = reservation;
    }

    public String toString() {
        return "(" + reservationTime + ", "
                + flight.getFromPlace() + ", "
                + flight.getToPlace() + ")";
    }
}

