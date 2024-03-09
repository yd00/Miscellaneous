import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yd00
 */
public class ConcaveSubsequence {
    public static void main(String[] args){
//        int[] num = getInput();
        int[] num = {4, 2, 6, 5, 3, 1};
//        int[] num = {3, 1, 5, 2, 4};
//        int[] num = {100, 10, 25, 11, 200};
        int count = 0;
        boolean legit = true, nonZeroFound = false;

        List<String> masks = new ArrayList<>();
        for(int start=0; start<num.length-2; start++){
            for(int end=start+2; end<num.length; end++){
                masks = generateMasks(end-start-1);
                for(String mask : masks){
                    char[] maskAsArray = mask.toCharArray();
                    int[] numCopy = num.clone();
                    nonZeroFound = false;
                    legit = true;
                    
                    for(int c=0; c<maskAsArray.length; c++){
                        if(maskAsArray[c] == '0'){
                            numCopy[start+c+1] = 0;
                        }
                        
//                        legit = true;
                        if(!nonZeroFound)
                            nonZeroFound = numCopy[start+c+1] > 0 ? true : false;
                        if(numCopy[start] < numCopy[start+c+1] || numCopy[end] < numCopy[start+c+1]){
                            legit = false;
                            break;
                        }
                    }
                    
                    if(legit && nonZeroFound){
                        count++;
                        System.out.print("- ");
                        for(int k=start; k<=end; k++){
                            System.out.print(numCopy[k] > 0 ? numCopy[k] + " " : "");
                        }
                        System.out.println("");
                    }
                }
            }
        }
        System.out.println("\nCount of subsequences: " + count);
    }
    
    
    private static int[] getInput(){
        System.out.print("How many non-zero numbers are to be inputted: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            System.out.print(i+1 + ": ");
            num[i] = scan.nextInt();
        }
        System.out.println("");
        return num;
    }
    
    private static List<String> generateMasks(int n){
        int maskLength = (int)Math.pow(2, n) - 1;
        List<String> masks = new ArrayList<>();
        for(int i=0; i<maskLength; i++){
            masks.add(String.format("%" + n + "s", Integer.toBinaryString(i+1)).replaceAll(" ", "0"));
        }
        return masks;
    }
}
