package misc;

public class Keyboarerror {
    public static void main(String[] arr){
        System.out.println(solve(5,"aabbc"));
        System.out.println(solve(6,"aaabaa"));
        System.out.println(solve(5,"ccccc"));
    }

    public static int solve(int n, String s){
        // Write your code here
        int result = 0;
        char buff=s.charAt(0);
        int x=1,cv=1;
        for(int i=1;i<n;i++){
            if(buff==s.charAt(i)){
                cv+=1;
            }
            else{
                x*=cv;
                cv=1;
                buff=s.charAt(i);
            }
        }
        return x*cv;

    }
}
