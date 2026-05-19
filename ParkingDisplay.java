public class ParkingDisplay {
    public void printParkingResult(Ticket ticket, Vehicle vehicle) {
        if (ticket == null) {
            System.out.println("No free slot found for " + vehicle.getType());
            System.out.println();
            return;
        }

        System.out.println("Vehicle parked successfully.");
        System.out.println("Ticket id: " + ticket.getTicketId());
        System.out.println("Vehicle number: " + ticket.getVehicle().getNumber());
        System.out.println("Floor: " + ticket.getFloorNumber());
        System.out.println("Slot: " + ticket.getSlot().getSlotNumber());
        System.out.println();
    }

    public void printBill(ParkingBill bill) {
        if (bill == null) {
            System.out.println("Invalid or closed ticket.");
            System.out.println();
            return;
        }

        Ticket ticket = bill.getTicket();

        System.out.println("Vehicle removed successfully.");
        System.out.println("Ticket id: " + ticket.getTicketId());
        System.out.println("Vehicle number: " + ticket.getVehicle().getNumber());
        System.out.println("Total fee: Rs. " + bill.getAmount());
        System.out.println();
    }

    public void showAvailableSlots(ParkingLot parkingLot) {
        System.out.println("Available slots in " + parkingLot.getName() + ":");

        for (ParkingFloor floor : parkingLot.getFloors()) {
            System.out.println("Floor " + floor.getFloorNumber() + ":");

            for (ParkingSlot slot : floor.getSlots()) {
                if (!slot.isOccupied()) {
                    System.out.println(
                        "  Slot " + slot.getSlotNumber() + " for " + slot.getAllowedVehicleType()
                    );
                }
            }
        }

        System.out.println();
    }
}
