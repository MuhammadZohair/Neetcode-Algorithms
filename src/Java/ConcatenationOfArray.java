package Java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * Given an integer array nums of length n, you want to create an array ans of length 2n
 * where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 1000
 * 1 <= nums[i] <= 1000
 * <p>
 * Link: https://leetcode.com/problems/concatenation-of-array/
 */
public class ConcatenationOfArray {


    @Test
    public void concatenationOfArray() {
        int[] nums = new int[]{1, 3, 2, 1};

        Assertions.assertArrayEquals(getConcatenation(nums), new int[]{1, 3, 2, 1, 1, 3, 2, 1});
        Assertions.assertArrayEquals(getConcatenationBest(nums), new int[]{1, 3, 2, 1, 1, 3, 2, 1});
    }

    /**
     * Note: This method was written best to my knowledge
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    /**
     * Note: This method is based on the best solutions I found over the
     * internet in terms of Time and Space complexity.
     *
     * @param nums the nums
     * @return the int [ ]
     */
    public int[] getConcatenationBest(int[] nums) {
        int[] arr = new int[nums.length * 2];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        System.arraycopy(nums, 0, arr, nums.length, nums.length);

        return arr;
    }
}
