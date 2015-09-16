package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 */
public class oneEditDistance_1_5 {
    /*
1. If S matches all characters in T, then check if there is an extra character at the end of T. (Append operation)
2. If  n – m  == 1, that means we must skip this non-matching character only in T and make sure the remaining characters between S and T are exactly matching. (Insert operation)
3. If  n – m  == 0, then we skip both non-matching characters in S and T and make sure the remaining characters between S and T are exactly matching.
            (Modify operation)
    */
    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m>n) return isOneEditDistance(t,s);
        if(n-m > 1) return false;
        int i = 0;
        while(i<m && s.charAt(i) == t.charAt(i)) i++; //compare s and t until they are not the same
        int diff = n-m;
        if(i==m) return diff>0?true:false;
        if(diff == 0) i++; //s and t move at the same time
        while(i<m && s.charAt(i) == t.charAt(i+diff)) i++;
        return i==m ? true:false;//all the remaining are the same
    }
    public static void main(String[] args){
        System.out.println(isOneEditDistance("abcde","abxde") );
        System.out.println(isOneEditDistance("abcde", "abcdef"));
        System.out.println(isOneEditDistance("abcde","abde") );
        System.out.println(isOneEditDistance("abcde","abd") );
    }

}
