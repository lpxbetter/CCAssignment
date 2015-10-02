package ch10;

//import java.util.BitSet;

/**
 * Created by lipingxiong on 10/1/15.
 * 10.8
 */
public class findDuplicates {
    void findDuplicates(int[] arr,int N){
        BitSet bs = new BitSet(N);
        for(int i=0;i<arr.length;i++){
            int num = arr[i] - 1;
            if(bs.get(num)){
                System.out.println(num);
            }
            else{
                bs.set(num);
            }
        }
    }
    class BitSet{
        int[] bitset;
        public BitSet(int size){
            bitset = new int[(size>>5)+1]; // divide by 32, int has 4 bytes,which is 32 bits
        }
        boolean get(int num){
            int intIndex = (num>>5); // divide 32, find the index of int
            int bitOffset = (num & 0X1F); // mod 32, find the offset inside the int
            return (bitset[intIndex] & (1<< bitOffset)) != 0;
        }
        void set(int num){
            int intIndex = (num>>5);
            int bitOffset = (num & 0X1F);
            bitset[intIndex] |= 1<< intIndex; // set to 1
        }
    }

}
