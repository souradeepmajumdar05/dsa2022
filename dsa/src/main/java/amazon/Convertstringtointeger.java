package amazon;

public class Convertstringtointeger {
    public static void convert(String s)
    {
        int num = 0;
        int n = s.length();
        for(int i = 0; i < n; i++)
            num = num * 10 + ((int)s.charAt(i) - 48);

        System.out.print(num);
    }
    public static void main(String[] args)
    {
        String s = "123";
        convert(s);
    }
}
