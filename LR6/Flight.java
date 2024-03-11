package LR6;

public class Flight {
    private String airplane_name;
    private String from_place;
    private String to_place;
    private int count_places_in_airplane;
    private int leftFreePlaces;
    private double costOneTicket;
    public Flight(String airplane_name,
                  String from_place,
                  String to_place,
                  int count_places_in_airplane,
                  int costOneTicket) {
        this.airplane_name = airplane_name;
        this.from_place = from_place;
        this.to_place = to_place;
        this.count_places_in_airplane = count_places_in_airplane;
        this.costOneTicket = costOneTicket;
    }
    Flight() {
        this("undefined", "undefined", "undefined", 0, 1000);
    }

    public int getLeftFreePlaces() {
        return this.leftFreePlaces;
    }

    public void setLeftFreePlaces(int count) {
        this.leftFreePlaces = count;
    }

    public double getCostOneTicket() {
        return this.costOneTicket;
    }

    public void setCostOneTicket(double cost) {
        this.costOneTicket = cost;
    }

    public void setFromPlace(String place) {
        this.from_place = place;
    }

    public String getFromPlace() {
        return this.from_place;
    }

    public void setToPlace(String place) {
        this.from_place = place;
    }

    public String getToPlace() {
        return this.to_place;
    }

    public int getCountPlaces() {
        return this.count_places_in_airplane;
    }

    public void setCountPlaces(int count) {
        this.count_places_in_airplane = count;
    }
};
