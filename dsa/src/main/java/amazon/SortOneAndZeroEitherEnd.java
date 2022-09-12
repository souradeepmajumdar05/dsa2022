package amazon;

import java.util.HashSet;
import java.util.Set;

public class SortOneAndZeroEitherEnd {
    public static void main(String[] args) {
        //System.out.println(sort(new int[]{1,1,1,0,0,0}));
        //System.out.println(sort(new int[]{0,0,0,1,1,1}));
        System.out.println(sort(new int[]{0,0,0,0,1,0,1,0,0}));
        System.out.println(sort(new int[]{0,0,1,0,1,0}));
        System.out.println(sort(new int[]{0,1,0,1,0,0}));
    }
    public static int sort(int [] arr){
        int count =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                count++;
            }
        }
        if(count==1){
            return 0;
        }
        int[] arr2=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i]=arr[i];
        }
        int lcount=sortOnLeft(arr);
        int rcount=sortOnRight(arr2);

        return lcount<rcount?lcount:rcount;
    }

    private static int sortOnLeft(int[] arr) {
        int count =0;
        boolean flag=true;
        Set<Integer> visited = new HashSet<>();
        while (flag)
        {
            int zeroPos=-1;
            for (int i=0 ;i<arr.length;i++){
                if(arr[i]==0 && zeroPos==-1)
                {
                    zeroPos=i;
                }
                else if(arr[i]==1 && !visited.contains(i))
                {
                    count+=i-zeroPos;
                    arr[i]=0;
                    arr[zeroPos]=1;
                    visited.add(zeroPos);
                    zeroPos=-1;
                    i=-1;
                }
                else if(i==arr.length-1){
                    flag=false;
                }
            }

        }
        return count;
    }
    private static int sortOnRight(int[] arr) {
        int count =0;
        boolean flag=true;
        Set<Integer> visited = new HashSet<>();
        while (flag)
        {
            int zeroPos=-1;
            for(int i=arr.length-1;i>=0;i--)
            {
                if(arr[i]==0 && zeroPos==-1)
                {
                    zeroPos=i;
                }
                else if(arr[i]==1 && !visited.contains(i))
                {
                    count+=zeroPos-i;
                    arr[i]=0;
                    arr[zeroPos]=1;
                    visited.add(zeroPos);
                    zeroPos=-1;
                    i=-1;
                }
                else if(i==0){
                    flag=false;
                }
            }

        }
        return count;
    }
}
