package LR6;

class Ticket {
    private int reservationTime = 10 * 60;
    private Flight flight;
    private Client person;
    private boolean is_paid = false;

    public Ticket(Flight flight, Client person) {
        this.flight = flight;
        this.person = person;
    }

    public Ticket() {
        this.flight = null;
        this.person = null;
    }

    public boolean isPaid() {
        return this.is_paid;
    }

    public void payTheBill() {
        this.is_paid = true;
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
};