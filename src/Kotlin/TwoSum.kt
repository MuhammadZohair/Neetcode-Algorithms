package Kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
class TwoSum {

    @Test
    fun twoSum() {
        val nums1 = intArrayOf(2, 7, 11, 15)
        val target1 = 9
        Assertions.assertArrayEquals(twoSum(nums1, target1), intArrayOf(2, 7))
        Assertions.assertArrayEquals(twoSumBest(nums1, target1), intArrayOf(2, 7))
    }

    /**
     * Note: This method was written best to my knowledge
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val targetArray = IntArray(2)

        for (i in 0..nums.size) {
            for (j in 0..nums.size) {
                if (nums[i] == nums[j]) continue
                if (nums[i] + nums[j] == target) {
                    targetArray[0] = i
                    targetArray[1] = j
                    return targetArray
                }
            }
        }
        return targetArray
    }

    /**
     * Note: This method is based on the best solutions I found over the
     * internet in terms of Time and Space complexity.
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
    fun twoSumBest(nums: IntArray, target: Int): IntArray? {
        val prevMap = HashMap<Int, Int>()
        for (i in nums.indices) {
            val num = nums[i]
            val diff = target - num
            if (prevMap.containsKey(diff)) {
                return intArrayOf(prevMap[diff]!!, i)
            }
            prevMap[num] = i
        }
        return intArrayOf()
    }
}