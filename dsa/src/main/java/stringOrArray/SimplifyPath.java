package stringOrArray;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args){
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/"));
    }
    public static String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        StringBuilder cur = new StringBuilder();
        path=path+"/";
        for(int i=0; i<path.length();i++){
            if(path.charAt(i)=='/'){
                if(cur.toString().equals("..")){
                    if(!stack.empty())
                        stack.pop();
                }
                else if(!cur.toString().equals("") && !cur.toString().equals(".")){
                    stack.add(cur.toString());
                }
                cur=new StringBuilder();
            }else{
                cur.append(path.charAt(i));
            }
        }
        cur=new StringBuilder();
        if(stack.empty())
            return "/";
        while(!stack.empty()){
            cur.insert(0,stack.pop());
            cur.insert(0,"/");
        }
        return cur.toString();
    }
}
