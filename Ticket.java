import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private static int nextTicketId = 1;

    private int ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private int floorNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private boolean active;

    public Ticket(Vehicle vehicle, ParkingSlot slot, int floorNumber) {
        this.ticketId = nextTicketId;
        nextTicketId++;
        this.vehicle = vehicle;
        this.slot = slot;
        this.floorNumber = floorNumber;
        this.entryTime = LocalDateTime.now();
        this.active = true;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.active = false;
    }

    public long getParkingHours() {
        LocalDateTime endTime = exitTime;

        if (endTime == null) {
            endTime = LocalDateTime.now();
        }

        long minutes = Duration.between(entryTime, endTime).toMinutes();
        long hours = minutes / 60;

        if (minutes % 60 != 0) {
            hours++;
        }

        if (hours == 0) {
            hours = 1;
        }

        return hours;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean isActive() {
        return active;
    }
}
