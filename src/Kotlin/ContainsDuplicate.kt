package Kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Problem:
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * <p>
 * Link: https://leetcode.com/problems/contains-duplicate/
 */
object ContainsDuplicate {

    /**
     * Contains duplicate best.
     */
    @Test
    fun containsDuplicateTest() {
        val test1 = intArrayOf(1, 2, 3, 4, 4)
        val test2 = intArrayOf(1, 2, 3, 4)
        val test3 = intArrayOf(1)
        val test4 = intArrayOf(1, 1)
        val test5 = intArrayOf()
        val test6: IntArray? = null
        val test7 = intArrayOf(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
            53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78,
            79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103,
            104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124,
            125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145,
            146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166,
            167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187,
            188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208,
            209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229,
            230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250,
            251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 264, 268, 269, 270
        )
        val test8 = intArrayOf(0, 2147483647)
        Assertions.assertTrue((containsDuplicate(test1)))
        Assertions.assertFalse(containsDuplicate(test2))
        Assertions.assertFalse(containsDuplicate(test3))
        Assertions.assertTrue(containsDuplicate(test4))
        Assertions.assertFalse(containsDuplicate(test5))
        Assertions.assertTrue(containsDuplicate(test7))
        Assertions.assertFalse(containsDuplicate(test8))

        Assertions.assertTrue(containsDuplicateBest(test1))
        Assertions.assertFalse(containsDuplicateBest(test2))
        Assertions.assertFalse(containsDuplicateBest(test3))
        Assertions.assertTrue(containsDuplicateBest(test4))
        Assertions.assertFalse(containsDuplicateBest(test5))
        Assertions.assertTrue(containsDuplicateBest(test7))
        Assertions.assertFalse(containsDuplicateBest(test8))
    }

    /**
     * Note: This method was written best to my knowledge
     *
     * @param nums the integer list input
     * @return true if the integer array contains duplicates,
     * else return false
     */
    private fun containsDuplicate(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false

        val freqTable = HashMap<Int, Int>()

        for (num in nums) {
            freqTable.merge(num, 1) { a: Int?, b: Int? -> Integer.sum(a!!, b!!) }
        }
        for ((_, value) in freqTable) {
            if (value > 1) return true
        }
        return false
    }

    /**
     * Note: This method is based on the best solutions I found over the
     * internet in terms of Time and Space complexity.
     *
     * @param nums the integer list input
     * @return true if the integer array contains duplicates,
     * else return false
     */
    fun containsDuplicateBest(nums: IntArray): Boolean {
        val hs = HashSet<Int>()
        for (e in nums)
            if (!hs.add(e)) return true
        return false
    }
}