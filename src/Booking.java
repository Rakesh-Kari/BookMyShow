import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Show show;
    private List<Seat> bookedSeats = new ArrayList<>();
    private Payment payment;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor
    public Booking(Show show, List<Seat> bookedSeats, Payment payment) {
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
    }

    // Getter and Setter for show
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    // Getter and Setter for bookedSeats
    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    // Getter and Setter for payment
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "show=" + show +
                ", bookedSeats=" + bookedSeats +
                ", payment=" + payment +
                '}';
    }
}
