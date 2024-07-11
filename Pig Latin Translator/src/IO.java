/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 30-09-23
 * Pig Latin Translator App
 */
import java.io.*;
import java.util.ArrayList;


public class IO {
    
    
    private File translateFile = null;
    
    private static final String FILENAME = "rossetapig.txt";
 
    public static void saveStrings(ArrayList<String> lines) {
        IO file = new IO();
        file.checkFile();
        try (PrintWriter writer = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(FILENAME)))) {
            for(String line : lines){
                    writer.write(line + "\n");
                }   
        }
        catch(IOException e){
            System.out.println("Error :" + e);
        }
    }

    public void checkFile(){
        try{
            translateFile = new File(FILENAME);
            
            if(!translateFile.exists())
                translateFile.createNewFile();
        }catch(IOException e){
            System.out.println("Error :" + e);
        }
    }
        
    
}
