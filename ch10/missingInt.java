package ch10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by lipingxiong on 9/30/15.
 10.7
 */
public class missingInt {
    String filename = "";
    long numberOfInts = ((long)(Integer.MAX_VALUE)) + 1;
    byte[] BV = new byte[ (int) (numberOfInts/8)]; // bit vector

    void findMissingInt() throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader(filename));
        while(in.hasNext()){
            int n = in.nextInt();
            BV[n/8] |= 1<< (n%8);
        }
        for(int i=0;i<BV.length;i++){
            for(int j=0;j<8;j++) {
                if ((BV[i] & (1 << j)) == 0) {
                    System.out.println(i*8 + j);
                }
            }
            return;
        }
    }
}
