package ch10;

/**
 * Created by lipingxiong on 9/30/15.
 * 10-4
 */

public class sortedSearch {
    int search(listy list, int x){
        int i  = 0;
        while(list.elementAt(i) != -1 && list.elementAt(i) < x){
            i *= 2;
        }
        //when listy[i] > x, do binary seach
        return binarySearch(list, x, i / 2, i);
    }
    int binarySearch(listy list, int x , int low, int high){
        int mid ;
        while(low < high){
            mid = low + (high - low)/2;
            int midElem = list.elementAt(mid);
            if(midElem > x || midElem == -1){
                high = mid - 1;
            }
            else if(midElem < x) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}

