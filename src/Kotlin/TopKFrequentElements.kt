package Kotlin

import org.junit.jupiter.api.Test

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentElements {

    @Test
    fun topKFrequentElementsTest() {
        val array = arrayOf(4, 1, -1, 2, -1, 2, 3)

        println(topKFrequent(array.toIntArray(), 2))

    }

    private fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()

        nums.forEach {
            map.put(it, map.computeIfPresent(it) { _, value -> value + 1 } ?: 0)
        }

        return map.toList().sortedByDescending { it.second }.slice(0 until k).toMap().keys.toIntArray()
    }

    fun topKFrequentBest(nums: IntArray, k: Int): IntArray {
        val res = mutableListOf<Int>()

        val count = hashMapOf<Int, Int>()

        val freq = MutableList<MutableList<Int>>(nums.size + 1) {
            mutableListOf()
        }

        for (n in nums) {
            count[n] = count.getOrDefault(n, 0) + 1
        }

        for ((n, c) in count) {
            freq[c].add(n)
        }

        for (i in freq.size - 1 downTo 0) {
            for (n in freq[i]) {
                res.add(n)
                if (res.size == k) {
                    return res.toIntArray()
                }
            }
        }

        return intArrayOf()
    }
}