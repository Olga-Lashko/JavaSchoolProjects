/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 10-28-23
 * Movie Rating App
 */
public class Movie {
    
    private String title;
    private int year;
    private double rating;
    
    public Movie(){
        title = "";
        year = 0;
        rating = 0;
    }
    
    public Movie(String title, int year, double rating){
        this.title = title;
        this.year = year;
        this.rating = rating;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
     
    public void setYear(int year){
        this.year = year;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setRating(double rating){
        this.rating = rating;
    }
    
    public double getRating(){
        return rating;
    }
    
}


