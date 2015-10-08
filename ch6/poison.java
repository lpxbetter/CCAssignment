package ch6;

import java.util.ArrayList;

/**
 * Created by lipingxiong on 10/8/15.
 */
public class poison {
    int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips){
        runTests(bottles, strips);
        ArrayList<Integer> positive = getPositiveOnDay(strips,7);
        return setBits(positive);
    }
    void runTest(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips){
        for(Bottle bottle:bottles){
            int id = bottle.getId();
            int bitIndex =0;
            while(id>0){
                if((id&1)==1){
                    testStrips.get(bitIndex).addDripOnDay(0, bottle);
                }
                bitIndex++;
                id>>=1;
            }
        }
    }
    ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day){
        ArrayList<Integer> positive = new ArrayList<>();
        for(TestStrip testStrip:testStrips){
            int id = testStrip.getId();
            if(testStrip.isPositiveOnDay(day)){
                positive.add(id);
            }
        }
        return positive;
    }
    int setBits(ArrayList<Integer> positive){
        int id =0;
        for(Integer bitIndex:positive){
            id |= 1<<bitIndex;
        }
        return id;
    }
}
