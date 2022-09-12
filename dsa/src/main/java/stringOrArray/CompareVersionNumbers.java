package stringOrArray;

public class CompareVersionNumbers {
    public static void main(String[] args){
        //System.out.println(compareVersion("1.01","1.001"));
        System.out.println(compareVersion("0.1","1.1"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] arr1=version1.split("\\.");
        String[] arr2=version2.split("\\.");
        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Integer.parseInt(arr1[i])<Integer.parseInt(arr2[i])){
                    return -1;
                }else if (Integer.parseInt(arr1[i])>Integer.parseInt(arr2[i])){
                    return 1;
                }
            }else if(i<arr1.length && Integer.parseInt(arr1[i])!=0){
                return 1;
            }else if(i<arr2.length && Integer.parseInt(arr2[i])!=0){
                return -1;
            }
            i++;
        }
        return 0;
    }
}
