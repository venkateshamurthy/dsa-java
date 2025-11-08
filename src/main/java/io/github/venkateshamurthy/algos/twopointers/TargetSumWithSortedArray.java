package io.github.venkateshamurthy.algos.twopointers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TargetSumWithSortedArray {
    static Logger log = LoggerFactory.getLogger(TargetSumWithSortedArray.class);
    /** numbers are sorted. and given a target find the indexes.*/
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while ( i < j ) {                         // i cannot bethe same as j as otherwise its the same number
            long sum = numbers[i] + numbers[j];   // remember to keep the sum in a long as sum might exceed int boundary
            if      (sum > target)  j-- ;         // so move j to left
            else if (sum < target)  i++ ;         // so move i to right
            else return new int[]{i + 1, j + 1};  // all good return i and j with unit based indexing
        }
        return null;         // not good ; so return -1s or null
    }

    public int[] twoSumByForLoop(int[] numbers, int target) {
        for(int i = 1, j = numbers.length; i < j;) {
            long sum = numbers[i - 1] + numbers[j - 1]; // remember to keep the sum in a long as sum might exceed int boundary
            if      (sum > target) j--;                 // so move j to left
            else if (sum < target) i++;                 // so move i to right
            else return new int[]{i, j};                // all good return i and j with zer based index
        }
        return null;                                    // not good ; so return -1s or null
    }


    public static void main(String[] args) {
        TargetSumWithSortedArray problem = new TargetSumWithSortedArray();
        int[] nums = new int[] {1, 2, 4, 6, 8, 10, 12, 16};
        //                      0  1  2  3  4   5   6   7
        //                      i-->                 <--j
        log.info("twoSum :{}", problem.twoSum(nums, 28));
        log.info("twoSum :{}", problem.twoSum(nums, 30));
        log.info("twoSum :{}", problem.twoSum(new int[]{2, 7, 11, 15}, 9));
        log.info("twoSum :{}", problem.twoSum(new int[]{2, 3, 4}, 6));
        log.info("twoSum :{}", problem.twoSum(new int[]{-1, 0}, -1));
        log.info("\n");
        log.info("twoSumByForLoop :{}", problem.twoSumByForLoop(nums, 28));
        log.info("twoSumByForLoop :{}", problem.twoSumByForLoop(nums, 30));
        log.info("twoSumByForLoop :{}", problem.twoSumByForLoop(new int[]{2, 7, 11, 15}, 9));
        log.info("twoSumByForLoop :{}", problem.twoSumByForLoop(new int[]{2, 3, 4}, 6));
        log.info("twoSumByForLoop :{}", problem.twoSumByForLoop(new int[]{-1, 0}, -1));
    }
}
