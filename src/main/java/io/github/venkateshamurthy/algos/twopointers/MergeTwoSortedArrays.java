package io.github.venkateshamurthy.algos.twopointers;

public class MergeTwoSortedArrays  {
    public int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int left = 0,  right = 0, index = 0;
        // Copy from a or be depending which ever is smaller
        while(left < a.length && right < b.length)
            c[index++] = a[left] < b[right] ? a[left++] : b[right++];

        while(left<a.length)c[index++]  = a[left++];
        while(right<b.length)c[index++] = b[right++];
        return c;
    }
}
