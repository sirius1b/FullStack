
package parkinglot.Models;

import java.util.List;
import java.util.Map;

class Parkinglot{

    private String parkingLotId; 
    
    private String address; 

    private Map<VehicleType, Integer> availableCapacity; 

    private List<Gate> gates;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<VehicleType, Integer> getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Map<VehicleType, Integer> availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    
    


}