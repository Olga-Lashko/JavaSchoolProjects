/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 10-28-23
 * Movie Rating App
 */
import java.util.List;
import java.util.function.Predicate;

public class MovieRatingsApp {

    public static void main(String[] args) {
        MovieCollection movieCollection = new MovieCollection(); // Create new MovieCollection
        System.out.println("Welcome to the Movie Ratings application!");

        int choice = 0;

        while (choice != 6) {
            menu();
            choice = Console.getInt("Choose a menu option: ", 1, 6);

            switch (choice) {
                case 1 -> addMovie(movieCollection);
                case 2 -> viewTop(movieCollection);
                case 3 -> viewRecent(movieCollection);
                case 4 -> viewAll(movieCollection);
                case 5 -> viewRatings(movieCollection);
            }
        }
        System.out.println("Goodbye!");
    }

    public static void menu() {
        System.out.println("""
                           
                -----------------------
                What do you want to do?
                -----------------------""");
        System.out.println("""
                1 - Enter a movie
                2 - View top rated movies
                3 - View most recent movies
                4 - View all movies
                5 - View ratings
                6 - Quit application
                """);
    }
    
    //add movies to collection
    public static void addMovie(MovieCollection movieCollection) { 
        int choice = Console.getInt("\nHow many movies do you want to enter? ");

        for (int i = 1; i <= choice; i++) {
            System.out.println(" \nMovie #" + i + "\n----------");
            Movie movie = new Movie();//create new Movie object
            movie.setTitle(Console.getString("Enter title: "));
            movie.setYear(Console.getInt("Enter year: "));
            movie.setRating(Console.getDouble("Enter rating between 1 and 5 (decimals OK): ", 1, 5));

            movieCollection.add(movie);
        }
    }
    
    //view movies with rating 4 and more
    public static void viewTop(MovieCollection movieCollection) {
        double topRating = 4.0;
        Predicate<Movie> topRatedPredicate = movie -> movie.getRating() >= topRating;
        List<Movie> topRatedMovies = movieCollection.filterMovies(topRatedPredicate);

        System.out.println("\nMovies rated 4.0 or higher\n-----------------------");
        for (Movie movie : topRatedMovies) {
            System.out.println(movie.getTitle() + " (" + movie.getYear() + ") Rating: " + movie.getRating());
        }
    }
    
    //view most recent movies (last 5 years)
    public static void viewRecent(MovieCollection movieCollection) {
        int currentYear = 2023; // Current year
        int recentYears = 5; // how recent the movies should be
        int recentYear = currentYear - recentYears;

        Predicate<Movie> recentMoviesPredicate = movie -> movie.getYear() >= recentYear;
        List<Movie> recentMovies = movieCollection.filterMovies(recentMoviesPredicate);

        System.out.println("\nMost Recent Movies\n-----------------------");
        for (Movie movie : recentMovies) {
            System.out.println(movie.getTitle() + " (" + movie.getYear() + ") - Rating: " + movie.getRating());
        }
    }
    
    //view all movies
    public static void viewAll(MovieCollection movieCollection) {
        System.out.println("\nAll Movies:\n-----------------------");
        List<Movie> allMovies = movieCollection.filterMovies(movie -> true);
        for (Movie movie : allMovies) {
            System.out.println(movie.getTitle() + " (" + movie.getYear() + ") - Rating: " + movie.getRating());
        }
    }
    
    //view lowes, highest and average ratings
    public static void viewRatings(MovieCollection movieCollection) {
        double lowestRating = movieCollection.getLowestRating();
        double highestRating = movieCollection.getHighestRating();
        double averageRating = movieCollection.getAverageRating();
        int num = movieCollection.getSize();

        System.out.println("\nMovie rating data\n-----------------------");
        System.out.println("Number of movies: " + num);
        System.out.println("Lowest Rating: " + lowestRating);
        System.out.println("Highest Rating: " + highestRating);
        System.out.println("Average Rating: " + averageRating);
    }
}