public class Car extends Vehicle {
    public Car(String number) {
        super(number);
    }

    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
