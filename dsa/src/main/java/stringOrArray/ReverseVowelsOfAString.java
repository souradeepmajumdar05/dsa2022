package stringOrArray;

public class ReverseVowelsOfAString {
    public static void main(String[] args){
        System.out.print(reverseVowels("hello"));
    }
    public static String reverseVowels(String s) {
        String vowels="aeiuoAEIOU";
        int i=0,j=s.length()-1;
        char[] arr=s.toCharArray();
        while(i<j){
            if(!vowels.contains(String.valueOf(arr[i]))){
                i++;
                continue;
            }else if(!vowels.contains(String.valueOf(arr[j]))){
                j--;
                continue;
            }
            char t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
        return new String(arr);
    }
}
