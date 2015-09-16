package hw1;

import java.util.HashMap;

/**
 * Created by lipingxiong on 9/13/15.
 */
public class isPermutation_1_2 {
    /*
    If s and t are permutation, then they have same character count.So I use a map to store the count of each character;
    First count the number of character in s, and then when every time it occur in t, reduce the count by 1.
    IF the count of one char is 0, then remove it from the map.
    If they are permutation,then the map will be empty.
     */

    public static boolean permutation(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int count = map.containsKey(c) ? (map.get(c) + 1) : 1  ;
            map.put(c, count);
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)) return false;// t has character that's not in s
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0){
                map.remove(c);
            }
        }
        return map.size()==0; // Finally, size of map should be 0
    }
    public static void main(String[] args){
        System.out.println(permutation("abca","aabc") );
        System.out.println(permutation("abca", "a"));
        System.out.println(permutation("", "a"));
        System.out.println(permutation("a", ""));
        System.out.println(permutation("", ""));
        System.out.println(permutation("abc", "ab"));
        System.out.println(permutation("abc", "abcd"));
    }
}
