import java.util.HashMap;
import java.util.Map;

public class SimpleFeeCalculator implements FeeCalculator {
    private Map<VehicleType, Integer> pricePerHour;

    public SimpleFeeCalculator() {
        this.pricePerHour = new HashMap<VehicleType, Integer>();
        addPrice(VehicleType.BIKE, 10);
        addPrice(VehicleType.CAR, 20);
        addPrice(VehicleType.TRUCK, 50);
    }

    public void addPrice(VehicleType vehicleType, int price) {
        pricePerHour.put(vehicleType, price);
    }

    public int calculateFee(Ticket ticket) {
        Integer price = pricePerHour.get(ticket.getVehicle().getType());

        if (price == null) {
            return 0;
        }

        return (int) ticket.getParkingHours() * price;
    }
}
