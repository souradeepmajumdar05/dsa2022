package stringOrArray;

public class GasStation {

    public static  void main(){

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumg=0;
        for(int n:gas){
            sumg+=n;
        }
        int sumc=0;
        for(int n:cost){
            sumc+=n;
        }
        if(sumg<sumc)
            return -1;

        int total=0;
        int res=0;
        for(int i=0;i<gas.length;i++){
            total+=(gas[i]-cost[i]);
            if(total<0){
                total=0;
                res=i+1;
            }

        }
        return res;
    }
}
