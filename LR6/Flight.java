package LR6;

class Flight {
    private String airplaneName;
    private String fromPlace;
    private String toPlace;
    int count_places_in_airplane;

    Flight(String airplaneName,
           String from_place,
           String toPlace,
           int count_places_in_airplane) {
        this.airplaneName = airplaneName;
        this.fromPlace = from_place;
        this.toPlace = toPlace;
        this.count_places_in_airplane = count_places_in_airplane;
    }

    public Flight() {
        this("undefined", "undefined", "undefined", 0);
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getFromPlace() {
        return this.fromPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getToPlace() {
        return this.toPlace;
    }
};