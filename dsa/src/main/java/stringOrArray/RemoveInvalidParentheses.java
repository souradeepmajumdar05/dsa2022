package stringOrArray;

import java.util.*;


////not working// not abale to to make it wor will get it back
public class RemoveInvalidParentheses {
    public static void main(String[] args){
        List<String> result=removeInvalidParentheses("()())()");
        //List<String> result=removeInvalidParentheses("(a)())()");
        for(int i=0; i<result.size() ;i++){
            System.out.println(result.get(i));
        }
    }
    static Set<String> set= new HashSet<>();
    static int  totalLength=0;
    public static List<String> removeInvalidParentheses(String s) {
        totalLength=checkActualLength(s);
        dfs(0,s,"",0,0);
        return new ArrayList<>(set);
    }

    private static int checkActualLength(String s) {
        int len=0 ,i=0;
        Stack<Character> stack= new Stack<>();
        while(i<s.length()){
            if(s.charAt(i)!=')'){
                stack.add('(');
            }
            else if(!stack.empty() ){
                stack.pop();
                int count=0;
                while(!stack.empty() && stack.peek()!='('){
                    stack.pop();
                    count++;
                }
                len=len+2+count;
            }
            i++;
        }
        return len;
    }

    private static void dfs(int j,String s ,String newString,int open,int close) {
        if(set.contains(newString)){
            return;
        }
        if (newString.length()==totalLength){
            set.add(newString);
        }

        while(j<s.length()){
            if(s.charAt(j)!=')'){
                StringBuilder sb =new StringBuilder();
                while(s.charAt(j)!=')'){
                    sb.insert(0,s.charAt(j));
                    j++;
                }
                dfs(j,s,newString+sb.toString(),open+1,close);
                open--;
                dfs(j+1,s,newString+sb.toString(),open+1,close);
                open--;
            }
            else{
                close++;
                if(open==close){
                    dfs(j+1,s,newString+s.charAt(j),open,close);
                    dfs(j+2,s,newString+s.charAt(j),open,close);
                }
                close--;
                j++;
            }

        }
    }
}
