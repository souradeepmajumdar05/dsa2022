package stringOrArray;

public class MinStack {
    public static void main(String[] args){
        MinStack minStack=new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    static int[] minStack;
    public MinStack() {

    }

    public static void push(int val) {
        if(minStack==null){
            minStack=new int[1];
            minStack[0]=val;
            return;
        }
        int[] temp =new int[minStack.length+1];
        if(minStack[minStack.length-1]<val){
            int j= temp.length-1;
            for(int i=0;i<minStack.length;i++){
                temp[j--]=minStack[i];
            }
            temp[j--]=val;
            minStack=temp;
        }
        else{
            int j=temp.length-1;
            for(int i=1;i<minStack.length;i++){
                if(val<minStack[i]){
                    temp[j--]=val;
                    temp[j--]=minStack[i];
                }
                else{
                temp[j--]=minStack[i];
                }
            }
            minStack=temp;
        }
    }

    public static void pop() {
        int[] temp =new int[minStack.length-1];

        for(int i=0;i<temp.length;i++){
            temp[i]=minStack[i];
        }
        minStack=temp;
    }

    public static int top() {
        if(minStack.length==0)
            return -1;
        return minStack[minStack.length-1];
    }

    public static int getMin() {
        if(minStack.length==0)
            return -1;
        return minStack[minStack.length-1];
    }
}
