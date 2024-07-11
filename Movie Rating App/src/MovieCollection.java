/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 10-28-23
 * Movie Rating App
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MovieCollection {
    private ArrayList<Movie> movieList;
    
    public MovieCollection() {
        movieList = new ArrayList<>();
    }
    
    public void add(Movie movie) {
        movieList.add(movie);
    }
    
    public List<Movie> filterMovies(Predicate<Movie> condition) {
        return movieList.stream()
            .filter(condition)
            .toList();
    }
    
    
    public double getLowestRating() {
        return movieList.stream()
            .mapToDouble(movie -> movie.getRating())
            .reduce(Double.MAX_VALUE, (min, rating) -> Math.min(min, rating));
    }
    

    public double getHighestRating() {
        return movieList.stream()
            .mapToDouble(movie -> movie.getRating())
            .reduce(Double.NEGATIVE_INFINITY, (a, b) -> Double.max(a, b));
    }
    

    public double getAverageRating() {
        double sum = movieList.stream()
            .mapToDouble(movie -> movie.getRating())
            .reduce(0.0, (a, b) -> a + b);
    
        long count = movieList.size();

        if (count > 0) {
            return sum / count;
        } else {
            return 0.0;
        }
    }
    
    public int getSize() {
        return movieList.size();
    }
}
