public class Bike extends Vehicle {
    public Bike(String number) {
        super(number);
    }

    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
