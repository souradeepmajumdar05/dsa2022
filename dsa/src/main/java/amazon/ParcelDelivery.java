package amazon;

public class ParcelDelivery {
    public static void main(String[] args) {
        System.out.println(days(new int[]{2,3,4,3,3},0));
    }
    public static int days(int[] parcel, int count){
        //find min every time
        int min = Integer.MAX_VALUE;
        for(Integer i : parcel)
        {
            if(i == 0)
                continue;

            min = Math.min(min,i);
        }
        // if min is default which means all zeros
        if(min == Integer.MAX_VALUE)
            return count;

        // decrement parcel
        for(int i  = 0; i < parcel.length; i++)
        {
            if (parcel[i] == 0)
                continue;

            parcel[i] -= min;
        }
        return days(parcel, ++count);
    }
}
