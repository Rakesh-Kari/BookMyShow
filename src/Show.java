import java.util.ArrayList;
import java.util.List;

public class Show {

    private int showId;
    private Movie movie;
    private Screen screen;
    private int showStartTime;
    private List<Integer> bookedSeats;

    // Default constructor
    public Show() {
        this.bookedSeats = new ArrayList<>();
    }

    // Parameterized constructor
    public Show(int showId, Movie movie, Screen screen, int showStartTime, List<Integer> bookedSeats) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
        this.bookedSeats = new ArrayList<>(bookedSeats);
    }

    // Getter for showId
    public int getShowId() {
        return showId;
    }

    // Setter for showId
    public void setShowId(int showId) {
        this.showId = showId;
    }

    // Getter for movie
    public Movie getMovie() {
        return movie;
    }

    // Setter for movie
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // Getter for screen
    public Screen getScreen() {
        return screen;
    }

    // Setter for screen
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    // Getter for showStartTime
    public int getShowStartTime() {
        return showStartTime;
    }

    // Setter for showStartTime
    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    // Getter for bookedSeats
    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    // Setter for bookedSeats
    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = new ArrayList<>(bookedSeats);
    }

    // Method to add a booked seat
    public void addBookedSeat(int seatId) {
        if (!bookedSeats.contains(seatId)) {
            bookedSeats.add(seatId);
        }
    }

    // Method to remove a booked seat
    public void removeBookedSeat(int seatId) {
        bookedSeats.remove(Integer.valueOf(seatId));
    }
}
