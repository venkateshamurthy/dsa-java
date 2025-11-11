package io.github.venkateshamurthy.algos.twopointers;

import java.util.Arrays;

public class ReverseString {
    public char[] reverseChars(char[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp    = arr[left];
            arr[left]  = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        // swapRange(arr, 0, arr.length - 1);
        return arr;
    }
    public String reverseString(String s) {
        return Arrays.toString(reverseChars(s.toCharArray()));
    }
}
