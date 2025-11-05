package io.github.venkateshamurthy.algos.twopointers;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0,  left = 0,  right = 0;
        Set<Character> set = new LinkedHashSet<>();

        while(right < s.length() ){
            char c = s.charAt(right);
            if ( ! set.add(c)) { left++; set.remove(c);}
            max = Math.max(max, right - left);
            right++;
        }
        System.out.println("set:"+set);
        return Math.max(max, right - left);
    }
    public static void main(String[] args) {
        String s = "abcabdcebbfg";
        int length = new LongestUniqueSubstring().lengthOfLongestSubstring(s);
        System.out.println(length); // Output: 3 (the substring is "abc")
    }
}
