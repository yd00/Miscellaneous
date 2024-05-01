import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class FlipVowels {
    public static void main(String[] args){
        System.out.print("Please enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //String text = "aeiouAEIOU";
        StringBuilder textBuilder = new StringBuilder(text);
        
        int end = text.length()-1;
        for(int start=0; start<text.length()/2; start++){
            if(String.valueOf(text.charAt(start)).matches("[aeiouAEIOU]")){
                while(end>=text.length()/2 && end>start){
                    if(String.valueOf(text.charAt(end)).matches("[aeiouAEIOU]")){
                        char temp = text.charAt(start);
                        textBuilder.setCharAt(start, text.charAt(end));
                        textBuilder.setCharAt(end, temp);
                        end--;
                        break;
                    }
                    end--;
                }
            }
        }
        System.out.println("result: " + textBuilder.toString());
    }
}
