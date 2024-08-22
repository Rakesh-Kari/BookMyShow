import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityViceTheatres;
    List<Theatre> allTheatres;

    public TheatreController() {
        cityViceTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        allTheatres.add(theatre);
        List<Theatre> Theatres = cityViceTheatres.getOrDefault(city, new ArrayList<>());
        Theatres.add(theatre);
        cityViceTheatres.put(city, Theatres);
    }

    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreViceShows = new HashMap<>();
        List<Theatre> theatres = cityViceTheatres.get(city);
        if(theatres != null) {
            for(Theatre theatre: theatres) {
                List<Show> givenMovieShows = new ArrayList<>();
                List<Show> shows = theatre.getShows();

                for(Show show: shows) {
                    if(show.getMovie().getMovieId() == movie.getMovieId()) {
                        givenMovieShows.add(show);
                    }
                }
                if(!givenMovieShows.isEmpty()) {
                    theatreViceShows.put(theatre, givenMovieShows);
                }
            }
        }
        return theatreViceShows;
    }

    public void removeTheatre(Theatre theatre, City city) {
        List<Theatre> theatres = cityViceTheatres.get(city);
        if(theatres != null) {
            theatres.remove(theatre);
            if(theatres.isEmpty()) {
                cityViceTheatres.remove(city);
            } else {
                cityViceTheatres.put(city, theatres);
            }
        }
        allTheatres.remove(theatre);
    }

    public List<Theatre> getAllTheatresByCity(City city) {
        return cityViceTheatres.getOrDefault(city, new ArrayList<>());
    }

    public Theatre getTheatreById(int theatreId) {
        for(Theatre theatre: allTheatres) {
            if(theatre.getTheatreId() == theatreId) {
                return theatre;
            }
        }
        return null;
    }

    public void updatedTheatre(Theatre updatedTheatre, City city) {
        List<Theatre> theatres = cityViceTheatres.get(city);
        if(theatres != null) {
            for(int i=0; i<theatres.size(); i++) {
                if(theatres.get(i).getTheatreId() == updatedTheatre.getTheatreId()) {
                    theatres.set(i, updatedTheatre);
                    break;
                }
            }
            cityViceTheatres.put(city, theatres);
        }

        for(int i=0; i< theatres.size(); i++) {
            if(allTheatres.get(i).getTheatreId() == updatedTheatre.getTheatreId()) {
                allTheatres.set(i, updatedTheatre);
                break;
            }
        }
    }

    List<Show> getShowsByTheatre(Theatre theatre) {
        return theatre.getShows();
    }

}
