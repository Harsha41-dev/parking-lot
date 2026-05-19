public class Truck extends Vehicle {
    public Truck(String number) {
        super(number);
    }

    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
