package hw1;

/**
 * Created by lipingxiong on 9/14/15.
 Write a method to replace all spaces in a string with'%20'. You may assume that the string has
 sufficient space at the end of the string to hold the additional characters, and
 that you are given the "true" length of the string. (Note: if imple- menting in Java, please use a character array
 so that you can perform this opera- tion in place.)
 EXAMPLE
 Input: "Mr John Smith Output: "Mr%20Dohn%20Smith"
 */

public class replaceSpaces_1_3 {
    public static void replaceSpaces(char[] str, int length) {
        int count = 0;//how many count
        for(int i=0;i<length;i++){ // length: true length
            if(str[i] ==' ') count++;
        }
        // the length after replace
        int newLen = length + 2*count;
        newLen--; //last index should be length -1
        for(int i=length-1;i>=0;i--){
            if(str[i] != ' '){
                str[newLen--] = str[i];
            }
            else{ // %20
                str[newLen--] = '0';
                str[newLen--] = '2';
                str[newLen--] = '%';
            }
        }
        System.out.println(str);
    }
    public static void main(String[] args){
        replaceSpaces("Mr   ".toCharArray(),3);
//        System.out.println();
    }
}
