package parkinglot.Repositories;

import java.util.HashMap;
import java.util.Map;

import parkinglot.Models.Ticket;

public class TicketRepository {
    
    Map<String, Ticket> tickets; 

    
    TicketRepository (){
        tickets = new HashMap<>();
    }


    public Ticket addTicket(String slotId, String vehicleId, String gateId, String customerId){
        Ticket t = new Ticket();
        t.setCustomerId(customerId);
        t.setEntryGateId(gateId);
        t.setVehicleId(vehicleId);
        t.setSlotId(slotId);

        t.setTicketId("12345"); 
        tickets.put("12345", t);
        return t;
    }

    
}
