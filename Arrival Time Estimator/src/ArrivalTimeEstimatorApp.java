/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 07-10-23
 * Arrival Time Estimator
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArrivalTimeEstimatorApp {

   
    public static void main(String[] args) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        
        System.out.println("Arrival Time Estimator");
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")){
        
            String dDate = Console.getString("\nDeparture date (YYYY-MM-DD): ");
            String dTime = Console.getString("Departure time (HH:MM): ");
            int miles = Console.getInt("Enter miles: ");
            int milesPerHour = Console.getInt("Enter miles per hour: ");
            
            Date departureDateTime = new Date();
            try {
                departureDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dDate + " " + dTime);
            } catch (Exception e) {
                System.out.println("Invalid date/time format.");
                continue;
            }

            long travelTimeMinutes = Math.round((double) miles / milesPerHour * 60);

            Date estimatedArrivalTime = new Date(departureDateTime.getTime() + travelTimeMinutes * 60 * 1000);

            long hours = travelTimeMinutes / 60;
            long minutes = travelTimeMinutes % 60;

            System.out.println("\nEstimated travel time");
            System.out.println("Hours: " + hours);
            System.out.println("Minutes: " + minutes);
            System.out.println("Estimated date of arrival: " + dateFormat.format(estimatedArrivalTime));
            System.out.println("Estimated time of arrival: " + timeFormat.format(estimatedArrivalTime) + "\n");

            
            choice = Console.getString("Continue? (y/n): ");
        }

        System.out.println("\nBye!");
    }
    
}
