package dynamicPrograming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] costUpdated = new int[cost.length+1];
        for(int i=0;i<cost.length ;i++){
            costUpdated[i]=cost[i];
        }
        costUpdated[costUpdated.length-1]=0;
        for(int i =costUpdated.length-3 ; i>=0 ; i--){
            costUpdated[i]+=Math.min(costUpdated[i+1],costUpdated[i+2]);
        }
        return Math.min(costUpdated[0],costUpdated[1]);
    }
}
