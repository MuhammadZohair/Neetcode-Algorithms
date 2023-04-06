package Kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
class ConcatenationOfArray {

    @Test
    fun concatenationOfArray() {
        val nums = intArrayOf(1, 3, 2, 1)
        Assertions.assertArrayEquals(getConcatenation(nums), intArrayOf(1, 3, 2, 1, 1, 3, 2, 1))
        Assertions.assertArrayEquals(getConcatenationBest(nums), intArrayOf(1, 3, 2, 1, 1, 3, 2, 1))
    }

    /**
     * Note: This method was written best to my knowledge
     *
     * @param nums the nums
     * @return the int [ ]
     */
    fun getConcatenation(nums: IntArray): IntArray? {
        val n = nums.size
        val ans = IntArray(n * 2)
        for (i in 0 until n) {
            ans[i] = nums[i]
            ans[i + n] = nums[i]
        }
        return ans
    }

    /**
     * Note: This method is based on the best solutions I found over the
     * internet in terms of Time and Space complexity.
     *
     * @param nums the nums
     * @return the int [ ]
     */
    fun getConcatenationBest(nums: IntArray): IntArray? {
        val arr = IntArray(nums.size * 2)
        System.arraycopy(nums, 0, arr, 0, nums.size)
        System.arraycopy(nums, 0, arr, nums.size, nums.size)
        return arr
    }
}