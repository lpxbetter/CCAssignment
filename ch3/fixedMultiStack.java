import java.util.EmptyStackException;

/**
 * Created by lipingxiong on 9/22/15.
 */
/*
Method1: fixed division, split the array to three parts
Method2: Flexible division, when one stack exceeds its initial capcity, we grow the allowable capacity and shift elements as necessary.
 */
public class fixedMultiStack {
//Method 1: fixed division
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values; // values of all stacks
    private int[] sizes; // size of each stack

    public fixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }
    public void push(int stackNum, int value) throws FullStackException{
        if(isFull(stackNum)){
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];//get top elem
        values[topIndex] = 0;//reset the value, clear
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)]; // get the top elem
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    //given the number of the stack, return the index of the top elem
    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }
}
