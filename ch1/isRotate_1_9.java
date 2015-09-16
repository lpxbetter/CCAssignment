package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
public class isRotate_1_9 {
    public static boolean isRotation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m<0 || m !=n ) return false;
        String s1s1 = s1+s1;
        return isSubString(s1s1,s2);
    }
    private static boolean isSubString(String s1, String s2){
        return s1.contains(s2);
    }
}
