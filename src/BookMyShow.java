import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    private final MovieController movieController;
    private final TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.BANGALORE, "BAHUBALI");
        bookMyShow.createBooking(City.DELHI, "AVENGERS");
        bookMyShow.createBooking(City.BANGALORE, "HEllo");
    }

    private void createBooking(City userCity, String movieName) {
        // 1. Search for movies by location
        List<Movie> movies = movieController.getMovieByCity(userCity);

        // 2. Select the movie the user wants to see
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
                break; // Found the movie, exit loop
            }
        }

        if (interestedMovie == null) {
            System.out.println("Movie not found in the specified city.");
            return;
        }

        // 3. Get all shows of this movie in the specified city
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        if (showsTheatreWise.isEmpty()) {
            System.out.println("No shows available for the selected movie " + interestedMovie.getMovieName() + " in the city " + userCity);
            return;
        }

        // 4. Select a particular show the user is interested in
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();

        if (runningShows.isEmpty()) {
            System.out.println("No shows available for the selected movie " + interestedMovie.getMovieName() + " in the selected theatre.");
            return;
        }

        Show interestedShow = runningShows.get(0);

        System.out.println("Booking Details");
        System.out.println("Movie name: " + interestedMovie.getMovieName());
        System.out.println("City: " + userCity);
        System.out.println("Theatre: " + entry.getKey().getTheatreId());
        System.out.println("Show time: " + interestedShow.getShowStartTime() + ":00");

        // 5. Select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();

        if (bookedSeats.contains(seatNumber)) {
            System.out.println("Seat already booked, try a different seat.");
            return;
        }

        // Seat is available, proceed with booking
        bookedSeats.add(seatNumber);

        // Create booking
        Booking booking = new Booking();
        List<Seat> myBookedSeats = new ArrayList<>();
        for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
            if (screenSeat.getSeatId() == seatNumber) {
                myBookedSeats.add(screenSeat);
            }
        }

        if (myBookedSeats.isEmpty()) {
            System.out.println("Invalid seat number.");
            return;
        }

        booking.setBookedSeats(myBookedSeats);
        booking.setShow(interestedShow);

        // Create payment (simulate payment for now)
        Payment payment = new Payment();
        payment.setPaymentId(generatePaymentId()); // Ensure this method generates a unique ID
        payment.setAmount(myBookedSeats.stream().mapToInt(Seat::getPrice).sum()); // Calculate total price based on booked seats
        payment.setPaymentMethod("Credit Card"); // Example payment method
        payment.setStatus("Completed"); // Simulate payment as completed

        booking.setPayment(payment);

        // Handle the payment process
        System.out.println("Total price for booking: " + payment.getAmount());
        System.out.println("Payment details: " + payment);
        System.out.println("Booking successful!");

    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createMovies() {
        Movie avengers = new Movie(1, "AVENGERS", 128);
        Movie bahubali = new Movie(2, "BAHUBALI", 130);

        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(bahubali, City.BANGALORE);
        movieController.addMovie(bahubali, City.DELHI);
    }

    private void createTheatre() {
        // Retrieve movies
        Movie avengerMovie = movieController.getMovie("AVENGERS");
        Movie bahubaliMovie = movieController.getMovie("BAHUBALI");

        // Create screens
        List<Screen> screensForTheatre1 = createScreens();
        List<Screen> screensForTheatre2 = createScreens();

        // Create shows
        List<Show> inoxShows = List.of(
                createShow(1, screensForTheatre1.get(0), avengerMovie, 14),
                createShow(2, screensForTheatre2.get(0), bahubaliMovie, 20)
        );

        List<Show> pvrShows = List.of(
                createShow(3, screensForTheatre1.get(0), avengerMovie, 10),
                createShow(4, screensForTheatre2.get(0), bahubaliMovie, 16)
        );

        // Create and add theatres
        Theatre inoxTheatre = new Theatre(1, "123 Main St Bangalore", City.BANGALORE, screensForTheatre1, inoxShows);
        Theatre pvrTheatre = new Theatre(2, "456 Elm St Delhi", City.DELHI, screensForTheatre2, pvrShows);

        theatreController.addTheatre(City.BANGALORE, inoxTheatre);
        theatreController.addTheatre(City.DELHI, pvrTheatre);
    }


    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        List<Seat> seatsForScreen1 = createSeats();
        Screen screen1 = new Screen(1, seatsForScreen1);
        screens.add(screen1);
        return screens;
    }

    private Show createShow(int showId, Screen screen, Movie movie, int showStartTime) {
        return new Show(showId, movie, screen, showStartTime, new ArrayList<>());
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=0; i<40; i++) {
            Seat seat = new Seat(i, i/10, SeatCategory.SILVER, 120);
            seats.add(seat);
        }
        for(int i=40; i<70; i++) {
            Seat seat = new Seat(i, i/10, SeatCategory.GOLD, 150);
            seats.add(seat);
        }
        for(int i=70; i<100; i++) {
            Seat seat = new Seat(i, i/10, SeatCategory.PLATINUM, 200);
            seats.add(seat);
        }
        return seats;
    }

    private int generatePaymentId() {
        return (int) (Math.random() * 1000);
    }
}
