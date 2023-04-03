package Java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Problem:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * <p>
 * Link: https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    @Test
    public void twoSum() {

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        Assertions.assertArrayEquals(twoSum(nums1, target1), new int[]{2, 7});
        Assertions.assertArrayEquals(twoSumBest(nums1, target1), new int[]{2, 7});
    }

    /**
     * Note: This method was written best to my knowledge
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] targetArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if ((nums[i] + nums[j]) == target) {
                    targetArray[0] = i;
                    targetArray[1] = j;
                    return targetArray;
                }
            }
        }
        return targetArray;
    }

    /**
     * Note: This method is based on the best solutions I found over the
     * internet in terms of Time and Space complexity.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    public int[] twoSumBest(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), i};
            }

            prevMap.put(num, i);
        }

        return new int[]{};
    }
}