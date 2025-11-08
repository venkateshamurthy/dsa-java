package io.github.venkateshamurthy.algos.twopointers;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public String longestUniqueSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, max = 0;
        int startOfMax = 0;
        Set<Character> set = new LinkedHashSet<>();

        while (right < n) {
            char c = s.charAt(right);

            // shrink the window if duplicate found
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            if ((right - left + 1) > max) {
                max = right - left + 1;
                startOfMax = left;
            }

            right++;
        }

        // Return the substring, or print the set if you prefer
        String longest = s.substring(startOfMax, startOfMax + max);
        System.out.println("Longest unique substring: " + longest);
        return longest;
    }

    public static void main(String[] args) {
        String s = "abcabdcebbfg";
        String longest = new LongestUniqueSubstring().longestUniqueSubstring(s);
        System.out.println(longest.length()); // Output: 3 (the substring is "abc")
    }
}
