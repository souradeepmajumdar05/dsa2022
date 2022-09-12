package stringOrArray;

import java.util.Arrays;

public class ThreeSomeClosest {
    public static void main(String [] args){
        System.out.println(threeSomeClosest(new int[]{-1,2,1,-4},1));
    }

    private static int threeSomeClosest(int[] numbs, int target) {
        int res=0;
        int min=Integer.MAX_VALUE;
        Arrays.sort(numbs);
        for(int i=0;i<numbs.length;i++){
            int j=i+1;
            int k=numbs.length-1;
            while(j<k){
                int sum = numbs[i]+numbs[j]+numbs[k];
                int diff=Math.abs(target-sum);
                if(diff==0) return sum;
                if(diff<min) {
                    min=diff;
                    res=sum;
                }
                if(sum<=target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return res;
    }
}
