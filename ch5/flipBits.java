package ch5;

/**
 * Created by lipingxiong on 10/7/15.
 */
public class flipBits {

//  0 to be replaced with 1 to get
// longest continuous sequence of 1s in a binary array
// If there is no 0 in array, then
// it returns -1.

    public static void main(String[] args){
//        System.out.println(Integer.toBinaryString(3));
//        System.out.println(convert2Binary(8));
        System.out.println(longestSequence(1775));
    }
    public static int longestSequence(int n){
        int[] arr = convert2Binary(n);
        return maxOnes(arr,arr.length);
    }

    private static int[] convert2Binary(int x){
        String string = (Integer.toBinaryString(x));

        int[] array = new int[string.length()];

        for (int i=0; i < string.length(); i++) {
            array[i] = Integer.parseInt(string.substring(i,i+1));
//            System.out.println(array[i]);
        }
        return array;
    }

    private static int maxOnes(int arr[], int n) {
        int max_count = 0;  // for maximum number of 1 around a zero
        int prev_zero = -1;  // index of previous zero
        int prev_prev_zero = -1; // index of previous to previous zero

        for (int curr = 0; curr < n; ++curr) {
            // If current element is 0, then calculate the difference between curr and prev_prev_zero
            if (arr[curr] == 0) {

                if (curr - prev_prev_zero - 1 > max_count) {
                    max_count = curr - prev_prev_zero -1 ;
                }
                prev_prev_zero = prev_zero;
                prev_zero = curr;
            }
        }

        // Check for the last encountered zero
        if (n - prev_prev_zero > max_count) {
            max_count = n - prev_prev_zero - 1;
        }

        return max_count;
    }
}