package ch5;

/**
 * Created by lipingxiong on 10/8/15.
 */
public class pairWiseSwap {
    int swapBit(int x){
        return ( ((x&0xaaaaaaaa) >>>1) |
                ((x&0x55555555) <<1));
    }
}
