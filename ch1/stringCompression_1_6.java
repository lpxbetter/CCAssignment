package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 abcc
 */
public class stringCompression_1_6 {
    public static String stringCompression(String s){
        if(s==null || s.length()==0) return s;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char pre = s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == pre){
                count++;
            }
            else{ //new char ;  a1
                sb.append(pre); // pre char
                sb.append(count);// count of previous count
                pre = s.charAt(i);//update previous char
                count = 1;
            }
        }
        sb.append(pre);
        sb.append(count);
        if(sb.length() == 2 * s.length()){//each char is unique,just return original s
            return s;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(stringCompression("abcc"));
        System.out.println(stringCompression("abc"));
        System.out.println(stringCompression("a"));
        System.out.println(stringCompression(""));
    }
}
