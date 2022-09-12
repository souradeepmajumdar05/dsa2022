package stringOrArray;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        //System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
        //System.out.println(findMedianSortedArrays(new int[]{100000}, new int[]{100001}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = total / 2;
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        double l = 0;
        double r = A.length - 1;
        while (true) {
            int i = (int) Math.floor((l + r) / 2);   //median for A
            int j = (int) Math.floor(half - i -2);  //median for B
            int Aleft = i >= 0 ? A[i] : -1000000;
            int Aright = i + 1 < A.length ? A[i + 1] : 1000000;
            int Bleft = j >= 0 ? B[j] : -1000000;
            int Bright = j + 1 < B.length ? B[j + 1] : 1000000;

            if (Aleft <= Bright && Bleft <= Aright) {
                //odd
                if (total % 2 == 1) {
                   return Math.min(Aright, Bright);
                }
                //even
                double value=(Math.max(Aleft, Bleft) + Math.min(Aright, Bright));
                return value/ 2;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }

        }
    }
}
