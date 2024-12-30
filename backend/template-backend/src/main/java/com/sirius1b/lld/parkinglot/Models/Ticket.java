

package parkinglot.Models;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId; 
    private String SlotId;
    private LocalDateTime entryTime; // app. type would be dataTime someting
    private String entryGateId; // entryGateId;
    private String vehicleId;  
    private String customerId;
    
    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    public String getSlotId() {
        return SlotId;
    }
    public void setSlotId(String slotId) {
        SlotId = slotId;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
    public String getEntryGateId() {
        return entryGateId;
    }
    public void setEntryGateId(String entryGateId) {
        this.entryGateId = entryGateId;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    } 
    
    

}