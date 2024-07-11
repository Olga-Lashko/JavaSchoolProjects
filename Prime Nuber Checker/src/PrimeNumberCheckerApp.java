/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 10-7-23
 * Prime Nuber Checker
 */
import java.util.ArrayList;


public class PrimeNumberCheckerApp {


    public static void main(String[] args) {
        
        String prompt = "\nPlease enter an integer between 1 and 5000: ";
        String choicePrompt = "\nTry again? (y/n): ";
        String greeting = "Prime Number Checker";
        System.out.println(greeting);
        
        
        // create array for lines should be written to a file
        ArrayList<String> stringsFile = new ArrayList<>();
        stringsFile.add(greeting);//add line in text file 
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        
            int num = Console.getInt(prompt, 1, 5000);
            stringsFile.add(prompt + num);//add line in text file
            
            //create array of factors
            ArrayList<Integer> factors = new ArrayList<>();
            
            for (int i = 1; i<= 5000; i++) {
                if (num % i == 0){
                    factors.add(i);
                }
            }
            int factorsSize = factors.size();
            
            //check if number is prime
            if (factorsSize == 2){
                String isPrime = num + " is a prime number.";
                System.out.println(isPrime);
                stringsFile.add(isPrime);//add line to text file
            }
            else{
                String isNotPrime = num + " is NOT a prime number.";
                System.out.println(isNotPrime);
                stringsFile.add(isNotPrime);//add line to text file
                
                //build line with factors
                StringBuilder sb = new StringBuilder("It has " + factorsSize + " factors: ");
                for(int f:factors){
                   sb.append(f).append(" "); 
                }
                String fSize = sb.toString();
                
                stringsFile.add(fSize);//add line to text file
                
                System.out.println(fSize);//print factors
            }
            
            choice = Console.getString(choicePrompt);
            stringsFile.add(choicePrompt + choice);//add line to text file
        }
        System.out.println("\nBye!");
        stringsFile.add("\nBye!");
        
        
        IO.saveStrings(stringsFile); // save lines to file
    }
  
}
