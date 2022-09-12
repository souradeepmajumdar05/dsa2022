package stringOrArray;

public class AddBinary {
    public static void main(String[] args){
        System.out.println(addBinary("11","1"));
        //System.out.println(addBinary("1010","1011"));
    }
    public static String addBinary(String a, String b){
        StringBuilder sb =new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while(i>=0||j>=0||carry==1){
            int digitA=i<0?0:a.charAt(i--)-'0';
            int digitB=j<0?0:b.charAt(j--)-'0';
            sb.insert(0,(digitA+digitB+carry)%2);
            carry=(digitA+digitB+carry)/2;
        }
        return sb.toString();
    }
}
