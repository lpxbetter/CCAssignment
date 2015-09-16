package hw1;

import java.util.HashSet;

/**
 * Created by lipingxiong on 9/14/15.
 The number of characters that occur odd times should be <=1
 */
public class palindromPermutation_1_4 {
    public static boolean canPermutePalindrome(String s) {
        if(s==null) return false;
        if(s.length() <= 1) return true;
        s = s.toLowerCase(); // convert to lower case
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' ') continue;// ignore spaces
            if(set.contains(c)) set.remove(c);
            else  set.add(c);
        }
        return set.size()<=1;
    }
    public static void main(String[] args){
        System.out.println(canPermutePalindrome("TactCoa") );
        System.out.println(canPermutePalindrome("Tact  Coa"));
    }
}
