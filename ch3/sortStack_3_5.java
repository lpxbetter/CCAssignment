import java.util.Stack;

/**
 * Created by lipingxiong on 9/22/15.
 */
public class sortStack_3_5 {
    Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> s2 = new Stack<>();
        while( !s.isEmpty()){
            int tmp = s.pop();
            while(!s2.isEmpty() && s2.peek() > tmp){
                s.push(s2.pop());
            }
            s2.push(tmp);
        }
        return s;
    }
}
