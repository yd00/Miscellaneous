/**
 *
 * @author yd00
 */
public class AsciiPassword {
    public static void main(String[] args){
        //A-Z   65-90; a-z   97-122, space 32
        String password_ascii = "796115110113721110141108", password_actual = "";
        int code = 0, password_ascii_length = password_ascii.length();
        for(int i=password_ascii_length-1; i>=0; i--){
            code = code * 10 + Character.getNumericValue(password_ascii.charAt(i));
            if((code>=65 && code<=90) || (code>=97 && code<=122) || code==32){
                password_actual += Character.toString(code);
                code = 0;
            }
        }
        
        System.out.println("password: " + password_actual);
    }
}
