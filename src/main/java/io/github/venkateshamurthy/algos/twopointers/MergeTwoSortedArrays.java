package io.github.venkateshamurthy.algos.twopointers;

import java.util.Arrays;

public class MergeTwoSortedArrays  {
    public int[] merge(int[] a, int[] b) {
        //Arrays.sort(a); Arrays.sort(b);
        int[] c = new int[a.length + b.length];
        System.out.println("c:"+Arrays.toString(c));

        int left = 0,  right = 0, index = 0;
        // Copy from a or be depending on which ever is smaller
        while(left < a.length && right < b.length)
            c[index++] = a[left] < b[right] ? a[left++ ] : b[right++];

        while( left < a.length)  c[index++]  = a[left++ ];
        while(right < b.length)  c[index++]  = b[right++];
        return c;
    }
    public static void main(String[] args) {
        MergeTwoSortedArrays obj = new MergeTwoSortedArrays();
        int[] result = obj.merge(new int[]{11, 12, 25, 26},  // <- left
                                 new int[]{13, 14, 27, 28}); // <- right
        //                                 11, 12, 13, 14, 25, 26, 27, 28
        System.out.println(Arrays.toString(result));
    }
}
