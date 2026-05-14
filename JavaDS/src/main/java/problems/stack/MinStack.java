package problems.stack;

import java.util.Stack;

//O(1) for all operations
public class MinStack {
    public Stack<Integer> minStack;
    public Stack<Integer> maxStack;

    public MinStack(){
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int val){
        maxStack.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop(){
        if(!maxStack.isEmpty()){
            maxStack.pop();
            minStack.pop();
        }
    }

    public int top(){
        return maxStack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String args[]){
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        minStack.pop();

        System.out.print(minStack.getMin());
    }
}
