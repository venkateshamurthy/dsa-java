package io.github.venkateshamurthy.algos.twopointers;

import static io.github.venkateshamurthy.Utils.swapRange;

//REVERSE ENTIRELY AND THEN REVERSE EACH WORD
public class ReverseWordsInString {
    public static String reverse(String  sentence){
        char[] arr = sentence.toCharArray();
        swapRange(arr, 0, arr.length - 1);
        System.out.println("Reversed totally  :-->"+new String(arr));

        int left = 0, right = 0;
        while( right < arr.length ) {
            // Find and increase right till white space comes or till end
            while(right < arr.length && arr[right] != ' ') right++;

            //then reverse this segment (or word only); because right is at whitespace
            swapRange(arr, left, right - 1);

            // now scan all whitespaces until you get a letter or till end
            while(right < arr.length && arr[right] == ' ') right++;

            //start with left and right at same point
            left = right;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String sentence = "I am   for  very           good reasons very tenacious";
        System.out.println("Forward words only:-->"+sentence);
        System.out.println("Reverse words only:-->"+reverse(sentence));
    }
}
