/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 30-09-23
 * Pig Latin Translator App
 */
import java.util.ArrayList;


public class PigLatinTranslatorApp {

 
    public static void main(String[] args) {
        System.out.println("Pig Latin Translator");
        
        // create array for original and translated text
        ArrayList<String> stringsFile = new ArrayList<>();
        
        String again = "y";  
        while(again.equalsIgnoreCase("y")){
            System.out.println("");
           
            String str1 = Console.getString("Enter a line: ");// enter text to translate
           
            stringsFile.add(str1);// add original line
            stringsFile.add(Translator.translatedString(str1)); // add translated line
            IO.saveStrings(stringsFile); // save lines to file
            
            Translator.printTranslatedString(str1); // print translated line
            
            System.out.println("");
            again = Console.getString("Another line? (y/n): ");
        }
        System.out.println("\nBye!");
    }
    

}
