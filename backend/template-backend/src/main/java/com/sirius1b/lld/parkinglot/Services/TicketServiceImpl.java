package parkinglot.Services;

import parkinglot.DTOs.IssueTicketDTO;
import parkinglot.Models.Customer;
import parkinglot.Models.ParkingSlot;
import parkinglot.Models.SlotStatus;
import parkinglot.Models.Ticket;
import parkinglot.Models.Vehicle;
import parkinglot.Repositories.CustomerRepository;
import parkinglot.Repositories.TicketRepository;
import parkinglot.Repositories.VehicleRepository;

public class TicketServiceImpl implements TicketService {

    VehicleRepository vehicleRepository; 
    TicketRepository ticketRepository; 
    CustomerRepository customerRepository;


    @Override
    public Ticket issueTicket(IssueTicketDTO issueTicketDTO) {
        
        Customer customer = customerRepository.getById(issueTicketDTO.getCustomerId());

        // get vehicle
        
        Vehicle vehicle = getVehicle(issueTicketDTO);
        
        ParkingSlot slot = findSlot(issueTicketDTO);
        
        // get slot 
        // get customer 
        slot.setStatus(SlotStatus.ASSIGNED);
        Ticket ticket = createTicket(customer, vehicle, slot, issueTicketDTO);
        // assign slot to customer
        // return ticket 
        return ticket;
    }


    private Ticket createTicket(Customer customer, Vehicle vehicle, ParkingSlot slot, IssueTicketDTO issueTicketDTO) {
        return ticketRepository.addTicket(slot.getSlotId(), vehicle.getVehicleId(), issueTicketDTO.getGateId(), customer.getCustomerId());
    }


    private ParkingSlot findSlot(IssueTicketDTO issueTicketDTO) {
        // TODO Auto-generated method stub
        //issueTicketDTO.getParkingLotId();
        // based on partking lot, find the slot from it, strategy & factory  TODO
        // TODO
        throw new UnsupportedOperationException("Unimplemented method 'findSlot'");
    }


    private Vehicle getVehicle(IssueTicketDTO issueTicketDTO) {

        if (issueTicketDTO.getVehicleId() != null){
            vehicleRepository.getById(issueTicketDTO.getVehicleId());
        }
        Vehicle vehicle = vehicleRepository.addVehicle(issueTicketDTO.getVehicleNo(), issueTicketDTO.getVehicleType());

        return vehicle;
    }
    
}
