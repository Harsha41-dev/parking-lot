public class ParkingLocation {
    private ParkingFloor floor;
    private ParkingSlot slot;

    public ParkingLocation(ParkingFloor floor, ParkingSlot slot) {
        this.floor = floor;
        this.slot = slot;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public ParkingSlot getSlot() {
        return slot;
    }
}
