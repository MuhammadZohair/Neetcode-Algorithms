package Kotlin

import org.junit.jupiter.api.Test
import java.util.stream.Collectors

object GroupAnagrams {

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

        map.forEach { println(" ${it.key} -> ${it.value}") }

        return ArrayList(map.values)

    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.toList().sorted() == t.toList().sorted()
    }

    fun groupAnagramsBest(strs: Array<String>): List<List<String>> {
        var map = mutableMapOf<String, MutableList<String>>()
        val ans: MutableList<List<String>> = mutableListOf()
        for (i in strs) {
            var arr = i.toCharArray()
            arr.sort()
            map[String(arr)]?.add(i) ?: map.put(String(arr), mutableListOf(i))
        }

        for (i in map) {
            ans.add(i.value)
        }

        return ans
    }
}