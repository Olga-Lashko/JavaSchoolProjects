/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 30-09-23
 * Pig Latin Translator App
 */
public class Translator {
    
    
    private static String toLowerCase(String s){ //Convert each word to lowercase
        
        String toLower = s.toLowerCase();
        return toLower;
    }
    
    
    private static String[] splitString( String s){
        
        String newStr = toLowerCase(s);
        String[] splitInput = newStr.split(" ");
        return splitInput;
    }
    
    
    private static String[] removePunctuation(String s){
    
        String[] str = splitString(s);
        String[] newStr = str;
        
        for(int i = 0; i < str.length; i++){ //cut last character
            if(str[i].endsWith(",") || str[i].endsWith(".")
                    || str[i].endsWith("?") || str[i].endsWith("!")){
                newStr[i] = str[i].substring(0, str[i].length()-1);
            }
        }
        return newStr;
    }
    
    
    private static String[] translate(String s){
    
        String[] str = removePunctuation(s);
        String[] newStr = str;
        
        for (int i = 0; i < str.length; i++) {
            String letter = String.valueOf(str[i].charAt(0)); // 1-st leter of every word in array
            
            if (str[i].contains("@") || str[i].contains("$") || str[i].contains("#")){
                newStr[i] = str[i];
            
            } else if ("a".equals(letter) || "e".equals(letter)  
                    || "o".equals(letter)  || "i".equals(letter) 
                    || "u".equals(letter) || (str[i].contains("y") && !"y".equals(letter)) ) {
                
                StringBuilder sb = new StringBuilder(str[i]);
                sb.append("way");
                newStr[i] = sb.toString();
                
            } else if (!"a".equals(letter) || !"e".equals(letter)  
                    || !"o".equals(letter)  || !"i".equals(letter) 
                    || !"u".equals(letter) ){
                
                StringBuilder sb = new StringBuilder(newStr[i]);
                
                for(int j = 0; j < str[i].length(); j++ ){
                    String l = String.valueOf(str[i].charAt(j));  //letters in each word   
                    
                    if(!"a".equals(l) && !"e".equals(l)  
                            && !"o".equals(l)  && !"i".equals(l) 
                            && !"u".equals(l)){
                        sb.deleteCharAt(0);
                        sb.append(l);
                    } 
                    else {
                       sb.append("ay"); 
                       newStr[i] = sb.toString();
                       break;
                    }
                }
            }
        }
        
        return newStr;
    }
  
    
    public static String translatedString(String s){
        
        String[] strings = translate(s);
        StringBuilder sb = new StringBuilder();
        for(String string:strings){
            sb.append(string).append(" "); 
        }
        String str = sb.toString();
        return str;
    }
    
    
    public static void printTranslatedString(String s){
       
        System.out.println(translatedString(s));
    }
    
    
}
