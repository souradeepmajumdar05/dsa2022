package dynamicPrograming;

public class EdithDistance {

    public static void main(String []args){
        //System.out.println(minDistance("horse","ros"));
        System.out.println(minDistance("intention","execution"));
    }
    public static int minDistance(String word1, String word2) {
        Integer [][]cache = new Integer[word1.length()+1][word2.length()+1];

        //initialising
        for(int i=0;i<word1.length()+1;i++){
            for(int j=0;j<word2.length()+1;j++){
                cache[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int j = word2.length() ; j>=0;j--){
            //cache[word1.length()][word2.length()-j]=j;
            cache[word1.length()][j]=word2.length()-j;
        }
        //print(cache);
        for(int j = word1.length() ; j>=0;j--){
            cache[j][word2.length()]=word1.length()-j;
        }
        //print(cache);
        ///////////////////////////////////////////
        for(int i=word1.length()-1;i>=0;i--){
            for(int j=word2.length()-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j))                {
                    cache[i][j]=cache[i+1][j+1];
                }else{
                    cache[i][j]=1+Math.min(cache[i+1][j],Math.min(cache[i][j+1],cache[i+1][j+1]));
                }
            }
        }
        print(cache);
        return cache[0][0];
    }

    private static void print(Integer[][] cache) {
        for(int i=0;i<cache.length;i++){
            for(int j=0;j<cache[0].length;j++){
                System.out.print(cache[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
