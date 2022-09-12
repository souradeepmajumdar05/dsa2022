package amazon;

public class MinimumNumberofSwapstoMake {
    public int minSwaps(String s)
    {
        int ones=0;
        int zeros=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='0')
                zeros++;
            else
                ones++;
        }
        if(Math.abs(ones-zeros)>1)
            return -1;
        if(ones>zeros)
        {
            return countNums(s,'1');
        }
        else if(zeros>ones)
        {
            return countNums(s,'0');
        }
        else
        {
            return Math.min(countNums(s,'0'),countNums(s,'1'));
        }
    }
    public int countNums(String s, char num)
    {
        int count=0;
        for(int i=0; i<s.length(); i+=2)
        {
            if(s.charAt(i)!=num)
                count++;
        }
        return count;
    }
}
