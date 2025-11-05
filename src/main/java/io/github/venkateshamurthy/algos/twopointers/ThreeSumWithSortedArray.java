package io.github.venkateshamurthy.algos.twopointers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumWithSortedArray {
    private static final Logger log = LoggerFactory.getLogger(ThreeSumWithSortedArray.class);

    public int[] threeSum(int[] nums, int target) {
        Arrays.sort(nums);//this is the key factor; you need to sort before or ensure you have recieved sorted array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if     (sum > target) right--;
                else if(sum < target)  left++;
                else  return new int[]{i, left, right};
            }
        }
        return null;
    }
    public List<List<Integer>> threeSums(int[] nums, int target) {
        Arrays.sort(nums); //this is the key factor; you need to sort before or ensure you have recieved sorted array
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if     (sum > target) right--; //inward right if sum is greater
                else if(sum < target)  left++;
                else  result.add(List.of(i, left, right));
                //Well now this is critical you need to inward both left and right otherwise infinite loop!!!
                left++;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumWithSortedArray solution = new ThreeSumWithSortedArray();
        log.info("answer:{}",  solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}, 0));
        List<List<Integer>> result = solution.threeSums(new int[]{-1, 0, 1, 2, -1, -4}, 0);
        //                                                         0  1  2  3   4   5
        log.info("answer:{}",  result.toString());

    }
}
