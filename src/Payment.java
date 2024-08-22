public class Payment {

    private int paymentId;
    private double amount;
    private String paymentMethod; // e.g., "Credit Card", "Debit Card", "PayPal"
    private String status; // e.g., "Pending", "Completed", "Failed"
    private Booking booking; // Reference to the associated booking

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(int paymentId, double amount, String paymentMethod, String status, Booking booking) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.booking = booking;
    }

    // Getter and Setter for paymentId
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter and Setter for paymentMethod
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for booking
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", booking=" + booking +
                '}';
    }
}
