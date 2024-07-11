/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 30-09-23
 * Pig Latin Translator App
 */
import java.util.Scanner;

public class Console {
    
    private static final Scanner sc = new Scanner(System.in);

     public static String getString(String prompt){
        String str;
        while(true){
            System.out.print(prompt);
            str = sc.nextLine();
            if(!str.isEmpty()) {
                break;
            }else{
                System.out.println("String should not to be empty");
                
            }
        }
        return str;
    }
}