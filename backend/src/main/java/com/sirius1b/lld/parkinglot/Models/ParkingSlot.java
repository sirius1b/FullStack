package parkinglot.Models;

import java.util.List;

public class ParkingSlot {

    private String slotId; 
    private String floorId;
    private List<VehicleType> allowedTypes;
    private SlotStatus status;
    
    public String getSlotId() {
        return slotId;
    }
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }
    public String getFloorId() {
        return floorId;
    }
    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }
    public List<VehicleType> getAllowedTypes() {
        return allowedTypes;
    }
    public void setAllowedTypes(List<VehicleType> allowedTypes) {
        this.allowedTypes = allowedTypes;
    }
    public SlotStatus getStatus() {
        return status;
    }
    public void setStatus(SlotStatus status) {
        this.status = status;
    }


    
}
