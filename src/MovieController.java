import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    private Map<City, List<Movie>> cityViceMovies;
    private List<Movie> allMovies;

    public MovieController() {
        cityViceMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityViceMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityViceMovies.put(city, movies);
    }

    public Movie getMovie(String movieName) {
        for(Movie movie: allMovies) {
            if(movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMovieByCity(City city) {
        return cityViceMovies.getOrDefault(city, new ArrayList<>());
    }

    public void removeMovie(Movie movie, City city) {
        List<Movie> movies = cityViceMovies.get(city);
        if (movies != null) {
            movies.remove(movie);
            if (movies.isEmpty()) {
                cityViceMovies.remove(city);
            } else {
                cityViceMovies.put(city, movies);
            }
        }
        allMovies.remove(movie);
    }

    public void updatedMovie(Movie updatedMovie, City city) {
        List<Movie> movies = cityViceMovies.get(city);
        if(movies != null) {
            for(int i=0; i<movies.size(); i++) {
                if(movies.get(i).getMovieId() == updatedMovie.getMovieId()) {
                    movies.set(i, updatedMovie);
                    break;
                }
            }
            cityViceMovies.put(city, movies);
        }

        for(int i=0; i<allMovies.size(); i++) {
            if(allMovies.get(i).getMovieId() == updatedMovie.getMovieId()) {
                allMovies.set(i, updatedMovie);
                break;
            }
        }
    }

    public Movie getMovieById(int movieId) {
        for(Movie movie: allMovies) {
            if(movie.getMovieId() == movieId)
                return movie;
        }
        return null;
    }

    public void deleteMovieById(int movieId) {
        Movie movieToDelete = getMovieById(movieId);
        if(movieToDelete != null) {
            for(List<Movie> movies: cityViceMovies.values()) {
                movies.removeIf(movie -> movie.getMovieId() == movieId);
            }
            cityViceMovies.values().removeIf(List::isEmpty);
            allMovies.remove(movieToDelete);
        }
    }

}
