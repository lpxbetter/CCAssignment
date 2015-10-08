package ch5;

/**
 * Created by lipingxiong on 10/7/15.
 * 5.1
 */
public class insertionBits {
    int insertionBits(int n,int m,int i,int j){
        int allOnes = ~0;
        int left = allOnes << (j+1); //create left part of mask
        int right = ((1<<i) - 1); // right part of mask
        int mask = left | right;
        int n_cleared = n & mask; // use mask to clear j-i part of n
        int m_shifted = m<<i; // move m to right pos
        return n_cleared | m_shifted; //insert m to n
    }
}
