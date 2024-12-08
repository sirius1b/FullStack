package parkinglot.Models;



public class Gate {

    private String gateId;
    private String parkingLotId;
    private String gateNo; 
    private GateType type; 
    private GateStatus status;
    
    public String getGateId() {
        return gateId;
    }
    public void setGateId(String gateId) {
        this.gateId = gateId;
    }
    public String getParkingLotId() {
        return parkingLotId;
    }
    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
    public String getGateNo() {
        return gateNo;
    }
    public void setGateNo(String gateNo) {
        this.gateNo = gateNo;
    }
    public GateType getType() {
        return type;
    }
    public void setType(GateType type) {
        this.type = type;
    }
    public GateStatus getStatus() {
        return status;
    }
    public void setStatus(GateStatus status) {
        this.status = status;
    }

    
    


}