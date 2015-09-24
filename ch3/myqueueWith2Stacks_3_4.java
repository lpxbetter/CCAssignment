import java.util.Stack;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class myqueueWith2Stacks_3_4<T> {
    Stack<T> stackOldest, stackNewest;
    public myqueueWith2Stacks_3_4(){
        this.stackOldest = new Stack<>();
        this.stackNewest = new Stack<>();
    }
    public T push(T t){
        stackNewest.push(t);
        return t;
    }
    public T pop(){
        if (stackOldest.isEmpty()) {
            this.shift();
        }
        return stackOldest.pop();
    }
    private void shift(){
        while( !stackNewest.isEmpty()){
            stackOldest.push( stackNewest.pop() );
        }
    }
    public T peek(){
        if(stackOldest.isEmpty()){
            this.shift();
        }
        return stackOldest.peek();
    }
}
