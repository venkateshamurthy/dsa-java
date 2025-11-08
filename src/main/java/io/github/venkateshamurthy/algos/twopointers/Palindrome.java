package io.github.venkateshamurthy.algos.twopointers;

public class Palindrome {
    public boolean isPalindrome(String s) {
        //kuravaruk
        // len:9 index:0-8
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }

        return true;
    }

    public boolean isPalindrome(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right])
                return false;
            left++; right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Palindrome solution = new Palindrome();
        System.out.println(solution.isPalindrome("aha"));
        System.out.println(solution.isPalindrome("abba"));
        System.out.println(solution.isPalindrome("kuravaruk"));
        System.out.println(solution.isPalindrome("aha".toCharArray()));
        System.out.println(solution.isPalindrome("abba".toCharArray()));
        System.out.println(solution.isPalindrome("kuravaruk".toCharArray()));
    }
}
