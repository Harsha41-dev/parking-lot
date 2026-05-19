import java.util.List;

public interface SlotSelectionStrategy {
    ParkingLocation findSlot(List<ParkingFloor> floors, Vehicle vehicle);
}
