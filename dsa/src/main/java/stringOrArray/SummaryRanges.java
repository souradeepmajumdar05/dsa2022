package stringOrArray;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<>();

        int start =0;
        for(int i=0 ;i<nums.length;i++){

            if(i+1<nums.length && nums[i]+1==nums[i+1]){
                continue;
            }
            if(start==i){
                res.add(nums[i]+"");
            }
            else{
                res.add(nums[start]+"->"+nums[i]);
            }
            start=i+1;
        }
        return res;
    }
}
