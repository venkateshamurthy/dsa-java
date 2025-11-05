package io.github.venkateshamurthy.algos.twopointers;

import java.util.Arrays;
import java.util.Objects;

public class ReverseString {
    public char[] reverseChars(char[] chars) {
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp    = chars[left];
            chars[left]  = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return chars;
    }
    public String reverseString(String s) {
        return new String(reverseChars(s.toCharArray()));
    }
}
