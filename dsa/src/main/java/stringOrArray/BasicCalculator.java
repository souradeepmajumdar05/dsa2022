package stringOrArray;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args){
        //System.out.println(calculate("1 + 1"));
        //System.out.println(calculate(" 2-1 + 2 "));
        //System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        //System.out.println(calculate("2147483647"));
        System.out.println(calculate("  30"));
    }
    public static int calculate(String s) {
        int output=0;
        int sign=1;
        Stack<Integer> charStack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))) {
                double curNum= s.charAt(i)-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    curNum=curNum*10+s.charAt(i+1)-'0';
                    i++;
                }
                curNum=curNum*sign;
                output+=curNum;
            }else if (s.charAt(i)=='+'){
              sign = 1;
            }else if (s.charAt(i)=='-'){
                sign = -1;
            }else if (s.charAt(i)=='('){
                charStack.add(output);
                charStack.add(sign);
                output=0;
                sign=1;
            }else if (s.charAt(i)==')'){
                int prevSign=charStack.pop();
                output = output*prevSign;
                int prevAns=charStack.pop();
                output=output+prevAns;
            }
        }
        return output;
    }
}
