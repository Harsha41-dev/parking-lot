public class ParkingSlot {
    private int slotNumber;
    private VehicleType allowedVehicleType;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSlot(int slotNumber, VehicleType allowedVehicleType) {
        this.slotNumber = slotNumber;
        this.allowedVehicleType = allowedVehicleType;
        this.occupied = false;
    }

    public boolean canPark(Vehicle vehicle) {
        return !occupied && vehicle.getType() == allowedVehicleType;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.occupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
