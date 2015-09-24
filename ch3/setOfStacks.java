import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class setOfStacks {
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;
    public setOfStacks(int capacity){
        this.capacity = capacity;
    }
    public Stack getLastStack(){
        if(stacks.size()==0) return null;
        return stacks.get(stacks.size()-1);
    }

    public void push(int v){ // if last stack is full, need to create a new stack
        Stack last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(v);
        }
        else{
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop(){
        Stack last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int v = last.pop();
        if(last.size == 0)  stacks.remove(stacks.size()-1);
        return v;
    }

}
