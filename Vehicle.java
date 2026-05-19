public abstract class Vehicle {
    private String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public abstract VehicleType getType();
}
