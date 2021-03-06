import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lipingxiong on 9/22/15.
 */
class minStack_3_2 {
    ArrayList<Integer> stack = new ArrayList<>();
    ArrayList<Integer> minStack = new ArrayList<>();

    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty() || x <= minStack.get(minStack.size()-1) ){
            minStack.add(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int tmp = stack.remove(stack.size()-1);
        if( !minStack.isEmpty() && (tmp == minStack.get(minStack.size()-1))){
            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        if(minStack.isEmpty()) return 0;
        return minStack.get(minStack.size()-1);
    }
}
