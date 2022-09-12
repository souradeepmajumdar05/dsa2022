package stringOrArray;

public class StringToInteger {
    public static void main(String [] args){
       System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));
       System.out.println(myAtoi("-91283472332"));
                                     //2147483648   =10
    }
    public static int myAtoi(String s) {
        char[] ch = s.toCharArray();
       int res=0;
       int i=0;
       while(i<ch.length && ch[i]==' '){
            i++;
       }
       if(i>=ch.length) return 0;
       int sign=1;
       if(ch[i]=='+'||ch[i]=='-'){
           sign = (ch[i]=='+')?+1:-1;
           i++;
       }
       if(i>=ch.length) return 0;

       for(int j=0 ;j<ch.length && ch[j]>='0'&&ch[j]<='9';j++){
            res=res*10+Integer.parseInt(ch[j]+"");
       }
       return res*sign;

    }
}
