package amazon;

public class MonoTOnic {
    public static void main(String [] args){
        int A[] =new int[]{5,4,6};
        boolean isincr = true;
        boolean isdec = true;
        int n=A.length;
        for (int i = 0; i < n- 1; ++i) {
            if (A[i] > A[i+1])
                isincr = false;
            if (A[i] < A[i+1])
                isdec = false;
        }
        System.out.println(isincr || isdec);
    }
}
