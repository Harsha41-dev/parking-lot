public class ParkingLotDemo {
    public static void main(String[] args) {
        SlotSelectionStrategy slotSelectionStrategy = new FirstAvailableSlotStrategy();
        FeeCalculator feeCalculator = new SimpleFeeCalculator();

        ParkingLot parkingLot = new ParkingLot(
            "City Mall Parking",
            slotSelectionStrategy,
            feeCalculator
        );

        ParkingDisplay display = new ParkingDisplay();

        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSlot(new ParkingSlot(1, VehicleType.BIKE));
        floor1.addSlot(new ParkingSlot(2, VehicleType.CAR));
        floor1.addSlot(new ParkingSlot(3, VehicleType.CAR));
        floor1.addSlot(new ParkingSlot(4, VehicleType.TRUCK));

        ParkingFloor floor2 = new ParkingFloor(2);
        floor2.addSlot(new ParkingSlot(1, VehicleType.BIKE));
        floor2.addSlot(new ParkingSlot(2, VehicleType.CAR));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        Vehicle car = new Car("DL-01-AB-1234");
        Vehicle bike = new Bike("DL-02-CD-5678");
        Vehicle truck = new Truck("DL-03-EF-9000");

        Ticket carTicket = parkingLot.parkVehicle(car);
        display.printParkingResult(carTicket, car);

        Ticket bikeTicket = parkingLot.parkVehicle(bike);
        display.printParkingResult(bikeTicket, bike);

        Ticket truckTicket = parkingLot.parkVehicle(truck);
        display.printParkingResult(truckTicket, truck);

        display.showAvailableSlots(parkingLot);

        if (carTicket != null) {
            ParkingBill bill = parkingLot.removeVehicle(carTicket.getTicketId());
            display.printBill(bill);
        }

        display.showAvailableSlots(parkingLot);
    }
}
