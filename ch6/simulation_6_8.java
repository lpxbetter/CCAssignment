package ch6;

/**
 * Created by lipingxiong on 10/8/15.
 */
public class simulation_6_8 {
    int countDrops=0;
    int breakingPoint=0;
    boolean drop(int floor){
        countDrops++;
        return floor >= breakingPoint;
    }
    int findBreakingPoint(int floors){
        int interval=14;
        int previousFloor=0;
        int egg1=interval;

        while(!drop(egg1) && egg1 <= floors){
            interval -= 1;
            previousFloor = egg1;
            egg1 += interval;
        }
        int egg2 = previousFloor + 1;
        while (egg2 < egg1 && egg2 <= floors && !drop(egg2)){
            egg2+=1;
        }
        return egg2 > floors ? -1 : egg2;
    }
}
