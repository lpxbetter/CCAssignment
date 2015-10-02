package ch10;

/**
 * Created by lipingxiong on 9/30/15.
 * 10-5
 */
public class sparseSearch {

    int sparseSearch(String[] arr,String str){
        if(arr == null || str == null || str == "") return -1;
        return search(arr,str, 0 , arr.length-1);
    }
    int search(String[] arr, String str, int start, int end ){
        if(start > end) return -1;
        int m = start + (start-end)/2;
        //if m is empty, find closest non empty string
        if(arr[m].equals(" ")) {
            //search from mid-1 to start and from mid + 1 to end
            int l = m - 1;
            int r = m + 1;
            while (true) {
                if (l < start && r > end) return -1;//didn't find non empyty string
                else if (r <= end && !arr[m].isEmpty()) {
                    m = r;//find non empty string on right
                    break;
                } else if (l >= start && !arr[m].isEmpty()) {
                    m = l;//find non empty string on left
                    break;
                }
                r++;
                l--;
            }
        }
        if(str.equals(arr[m])){ //found the string
            return m;
        }
        else if(arr[m].compareTo(str) < 0){
            return search(arr, str, m + 1,end);//str is on right
        }
        else return search(arr, str, start, m - 1 );
    }
}
