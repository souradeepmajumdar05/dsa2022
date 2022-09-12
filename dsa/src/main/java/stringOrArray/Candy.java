package stringOrArray;

public class Candy {
    public static void main(String[] args){
        System.out.println(candy(new int[]{1,0,2}));
    }
    public static int candy(int[] ratings) {
        int sum=0;
        int[] output = new int[ratings.length];
        for(int i=0 ;i<output.length;i++){
            output[i]=1;
        }
        for (int i=1 ;i< ratings.length ; i++){
            if (ratings[i]>ratings[i-1]){
                output[i]=Math.max(output[i-1]+1,output[i]);
            }
        }
        for (int i=ratings.length-2 ;i>=0 ; i--){
            if (ratings[i]>ratings[i+1]){
                output[i]=Math.max(output[i+1]+1,output[i]);
            }
        }
        for (int i:output){
            sum+=i;
        }
        return sum;
    }
}
