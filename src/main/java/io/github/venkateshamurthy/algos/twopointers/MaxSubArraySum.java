package io.github.venkateshamurthy.algos.twopointers;

import java.util.Arrays;
import java.util.Random;

/**
 * private it means only that instance method can access. and not from outside
 * public it can be accessed by other instance method
 * static means class fields or class methods
 */

public class MaxSubArraySum {
    private static final class Result {
        final long maxSum;
        final int left;
        final int right;
        public Result(long sum, int left, int right) {
            this.maxSum = sum;
            this.left=left;
            this.right=right;
        }
        public String toString() {
            return "maxSum="+maxSum+",left="+left+",right="+right;
        }
    }

    /** Kadane's algorithm maximum sub sum in an array.*/
    private static Result maxSumSubarray(int[] nums) {
        long currentSum = 0;
        long maxSum = 0;
        int left = 0;
        int right = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            if (currentSum > maxSum) { // keep restting right as long as currentSum increases
                maxSum = currentSum;
                right = i;
            } else if (currentSum < 0) {  //start new window
                currentSum = 0;
                right = left = i + 1 ;
                maxSum = currentSum;
            }
        }
        return new Result(maxSum, left, right);
    }

    private static Result maxSumSubarray(int[] nums, int W) {
        // Calculate the sum of the first k elements
        long maxSum = 0;
        int  right = 0;
        for (int i = 0; i < W; i++) {
            maxSum += nums[i];
        }
        // So we have for i E [0, W-1] the maxSum is calculated
        right = W - 1;            // right = W - 1
        long currentSum = maxSum; // take this as currentSum

        for (int i = W; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - W];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                right = i;
            }
        }
        // (right - left) + 1 = W --> left = right + 1 - W
        return new Result(maxSum, right + 1 - W, right);
    }

    public static void main(String[] args) {
        // nums:[-2, -5, -2, -5, 1, 1, 2, 3, -4, -1]
        int[] nums = new Random(10L)
                .ints(10, -5, 5)
                .toArray();
        int W = 4; // Window size
        System.out.println("Input:" + Arrays.toString(nums));
        System.out.println("Input:" + maxSumSubarray(nums));
        System.out.println("Input:" + maxSumSubarray(nums, W));
    }
}