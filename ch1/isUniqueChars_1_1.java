package hw1;

/**
 * Created by lipingxiong on 9/13/15.
 */
//    1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
public class isUniqueChars_1_1 {
   /*
   Method1: Use a array to store the status of each character
   Assume the character set is ASCII character set which has 256 unique characters.
    */
    public boolean isUniqueChars(String str){
        if(str.length() > 256) return false;
        boolean[] mark = new boolean[256];
        for(int i=0;i<str.length();i++){
            if(mark[str.charAt(i)]) return false; //find repeated character
            mark[str.charAt(i)]=true; //
        }
        return true;
    }
    /*
    Method2: Donot use additional data structure, use bit vector. Assume the letter is from a-z, just use one signle int
    to store the status of each letter. There are 26 characters, one int has 4bytes, 32bits. so it's enough to
    represent the status of 26 characters.
     */
    public boolean isUniqueChars2(String str){
        int marker = 0;
        for(int i=0;i< str.length();i++){
            int shift = str.charAt(i)-'a'; // shift is 0-25
            //check whether the corresponding position of marker is alreay 1,if is, then repeated character found
            if((marker & (1<<shift)) > 0){
                return false;
            }
            marker |= 1<<shift;//when one char occur, the corresponding position of marker will be set to 1
        }
        return true;
    }

}
