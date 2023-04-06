package Kotlin

import org.junit.jupiter.api.Test
import java.util.stream.Collectors

object GroupAnagrams {

    @JvmStatic
    fun main(args: Array<String>) {
        val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

        println(groupAnagrams(strs))
    }

    @Test
    fun groupAnagramsTest() {
        val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

        println(groupAnagrams(strs))

    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, List<String>>()
        val arrayList = ArrayList(listOf(*strs))

        for (currentKey in strs) {
            val currentList: MutableList<String> = ArrayList()
            for (str in strs) {
                if (isAnagram(currentKey, str)) {
                    currentList.add(str)
                    arrayList.remove(str)
                }
            }
            arrayList.remove(currentKey)
            val key =
                currentKey.chars().sorted().mapToObj { c: Int -> c.toChar().toString() }.collect(Collectors.joining())
            map[key] = currentList
        }

        return ArrayList(map.values)

    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.toList().sorted() == t.toList().sorted()
    }

    fun groupAnagramsBest(strs: Array<String>): List<List<String>> {
        val res: HashMap<String, MutableList<String>> = hashMapOf()

        for (s in strs) {
            val count = IntArray(26)

            for (c in s) {
                val index = c - 'a'
                count[index] += 1
            }

            res[count.joinToString()] = res.getOrDefault(count.joinToString(), mutableListOf()).also { it.add(s) }
        }

        return res.values.toList()
    }
}