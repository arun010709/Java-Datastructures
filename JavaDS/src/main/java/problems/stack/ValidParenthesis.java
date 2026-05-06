package problems.stack;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String args[]){
        String str="{[()]}";

        System.out.print("Is valid parenthesis "+isValidParenthesis(str));
        
    }

    private static boolean isValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for(Character c:str.toCharArray()){
            if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
