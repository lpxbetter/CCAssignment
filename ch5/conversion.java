package ch5;

/**
 * Created by lipingxiong on 10/8/15.
 *   1. Calculate XOR of A and B.
 a_xor_b = A ^ B
 2. Count the set bits in the above calculated XOR result.
 getBitsCnt(a_xor_b)
 */
public class conversion {
    public int conversion(int A, int B){
        int a_xor_b = A ^ B; //XOR of two number will have set bits only at those places where A differs from B.
        return getBitsCnt(a_xor_b); //No of bits need to flipped = set bit count in a_xor_b
    }
    private int getBitsCnt(int n){
        int count = 0;
        while(n!=0){
            n &= (n-1);
            count++;
        }
        return count;
    }
}
