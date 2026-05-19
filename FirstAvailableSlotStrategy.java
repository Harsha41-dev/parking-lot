import java.util.List;

public class FirstAvailableSlotStrategy implements SlotSelectionStrategy {
    public ParkingLocation findSlot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSlot slot : floor.getSlots()) {
                if (slot.canPark(vehicle)) {
                    return new ParkingLocation(floor, slot);
                }
            }
        }

        return null;
    }
}
