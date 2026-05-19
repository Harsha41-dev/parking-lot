import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> floors;
    private List<Ticket> tickets;
    private SlotSelectionStrategy slotSelectionStrategy;
    private FeeCalculator feeCalculator;

    public ParkingLot(
        String name,
        SlotSelectionStrategy slotSelectionStrategy,
        FeeCalculator feeCalculator
    ) {
        this.name = name;
        this.slotSelectionStrategy = slotSelectionStrategy;
        this.feeCalculator = feeCalculator;
        this.floors = new ArrayList<ParkingFloor>();
        this.tickets = new ArrayList<Ticket>();
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingLocation location = slotSelectionStrategy.findSlot(floors, vehicle);

        if (location == null) {
            return null;
        }

        ParkingSlot slot = location.getSlot();
        ParkingFloor floor = location.getFloor();

        slot.park(vehicle);

        Ticket ticket = new Ticket(vehicle, slot, floor.getFloorNumber());
        tickets.add(ticket);

        return ticket;
    }

    public ParkingBill removeVehicle(int ticketId) {
        Ticket ticket = findActiveTicket(ticketId);

        if (ticket == null) {
            return null;
        }

        ticket.closeTicket();
        ticket.getSlot().removeVehicle();

        int amount = feeCalculator.calculateFee(ticket);
        return new ParkingBill(ticket, amount);
    }

    public String getName() {
        return name;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    private Ticket findActiveTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == ticketId && ticket.isActive()) {
                return ticket;
            }
        }

        return null;
    }
}
