

package parkinglot.Models;

/**
 * Bill
 */
public class Bill {

    private String billId; 
    private String ticketId;
    private String exitGateId; 
    private Double amount;
    
    public String getBillId() {
        return billId;
    }
    public void setBillId(String billId) {
        this.billId = billId;
    }
    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    public String getExitGateId() {
        return exitGateId;
    }
    public void setExitGateId(String exitGateId) {
        this.exitGateId = exitGateId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }


    

    
}