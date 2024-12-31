package parkinglot.Models;

/**
 * Payment
 */
public class Payment {

    private String paymentId; 
    private Double amount;
    private PaymentMode mode; 
    private PaymentStatus status;
    private String billId;

    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public PaymentMode getMode() {
        return mode;
    }
    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }
    public PaymentStatus getStatus() {
        return status;
    }
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
    public String getBillId() {
        return billId;
    }
    public void setBillId(String billId) {
        this.billId = billId;
    }    
}