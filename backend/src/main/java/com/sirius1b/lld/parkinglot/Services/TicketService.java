package parkinglot.Services;

import parkinglot.DTOs.IssueTicketDTO;
import parkinglot.Models.Ticket;

public interface TicketService {

    public Ticket issueTicket(IssueTicketDTO issueTicketDTO);
}
