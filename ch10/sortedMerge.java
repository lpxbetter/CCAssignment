package ch10;

/**
 * Created by lipingxiong on 10/1/15.
 10.1
 */
public class sortedMerge {
    void merge(int[] a, int[] b,int lenA, int lenB) {
        int i = lenA - 1;
        int j = lenB - 1;
        int k = lenA + lenB - 1;
        while (j > 0) {
            if (i >= 0 && a[i] > b[i]) {
                a[k] = a[i--];
            } else a[k] = b[j--];
        }
        k--;
    }
}
