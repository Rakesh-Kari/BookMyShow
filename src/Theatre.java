import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private int theatreId;
    private String address;
    private City city;
    private List<Screen> screens;
    private List<Show> shows;

    // Default constructor
    public Theatre() {
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    // Parameterized constructor
    public Theatre(int theatreId, String address, City city, List<Screen> screens, List<Show> shows) {
        this.theatreId = theatreId;
        this.address = address;
        this.city = city;
        this.screens = new ArrayList<>(screens);
        this.shows = new ArrayList<>(shows);
    }

    // Getter for theatreId
    public int getTheatreId() {
        return theatreId;
    }

    // Setter for theatreId
    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for city
    public City getCity() {
        return city;
    }

    // Setter for city
    public void setCity(City city) {
        this.city = city;
    }

    // Getter for screens
    public List<Screen> getScreens() {
        return screens;
    }

    // Setter for screens
    public void setScreens(List<Screen> screens) {
        this.screens = new ArrayList<>(screens);
    }

    // Getter for shows
    public List<Show> getShows() {
        return shows;
    }

    // Setter for shows
    public void setShows(List<Show> shows) {
        this.shows = new ArrayList<>(shows);
    }

    // Method to add a screen
    public void addScreen(Screen screen) {
        if (!screens.contains(screen)) {
            screens.add(screen);
        }
    }

    // Method to remove a screen
    public void removeScreen(Screen screen) {
        screens.remove(screen);
    }

    // Method to add a show
    public void addShow(Show show) {
        if (!shows.contains(show)) {
            shows.add(show);
        }
    }

    // Method to remove a show
    public void removeShow(Show show) {
        shows.remove(show);
    }
}
