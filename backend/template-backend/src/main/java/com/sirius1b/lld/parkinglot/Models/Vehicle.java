

package parkinglot.Models;

public class Vehicle {

    private String vehicleId; 
    private VehicleType type;
    private String vehicleNo ; 
    

    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }
    public String getVehicleNo() {
        return vehicleNo;
    }
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    } 
    
    
}