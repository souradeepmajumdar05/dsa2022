package stringOrArray;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("["));
        System.out.println(isValid("]"));
    }
    public static boolean isValid(String s) {
        Stack<String> stack=new Stack<>();
        for (int i=0; i<s.length() ;i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(' ){
                stack.add(s.charAt(i)+"");
            }
            else{
                if(stack.size()>0){
                    if(s.charAt(i)=='}' && !(stack.peek().equals("{"))){
                        return false;
                    }
                    else if(s.charAt(i)==']' && !(stack.peek().equals("["))){
                        return false;
                    }
                    else if(s.charAt(i)==')' && !(stack.peek().equals("("))){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else{
                    return false;
                }

            }
        }
        return stack.size()==0?true:false;
    }
}
