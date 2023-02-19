package Kotlin

object ContainsDuplicate {
    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 2, 3, 4, 4)
        println(containsDuplicate(nums))
    }

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
}