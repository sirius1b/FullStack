package parkinglot.Models;

import java.util.List;

public class Floor {

    
    private String floorId;
    private String parkingLotId;
    private FloorStatus status;
    private List<ParkingSlot> slots;

    
    public String getFloorId() {
        return floorId;
    }
    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }
    public String getParkingLotId() {
        return parkingLotId;
    }
    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    public FloorStatus getStatus() {
        return status;
    }
    public void setStatus(FloorStatus status) {
        this.status = status;
    }
    public List<ParkingSlot> getSlots() {
        return slots;
    }
    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }
    

    
}
