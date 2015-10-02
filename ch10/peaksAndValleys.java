package ch10;

/**
 * Created by lipingxiong on 10/1/15.
 * 10.11
 */
public class peaksAndValleys{
    void peakValley(int[] arr){
        for(int i=1;i<arr.length;i+=2) {
            int maxIndex = getMaxIndex(arr, i - 1, i, i + 1);

            if(i!=maxIndex){
                swap(arr,i,maxIndex);
            }
        }
    }
    int getMaxIndex(int[] arr, int a, int b, int c){
        int len = arr.length;
        int aValue = a >=0 && a<len ? arr[a]:Integer.MIN_VALUE;
        int bValue = b >=0 && b<len ? arr[b]:Integer.MIN_VALUE;
        int cValue = c >=0 && c<len ? arr[c]:Integer.MIN_VALUE;
        int max = Math.max(aValue,Math.max(bValue,cValue));
        if(aValue == max) return a;
        else if(bValue ==max ) return b;
        else return c;
    }

    public void swap(int [] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
