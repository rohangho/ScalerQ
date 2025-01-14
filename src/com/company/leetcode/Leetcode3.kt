package com.company.leetcode

import kotlin.math.max

object Leetcode3 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        println(lengthOfLongestSubstring("pwwkew"))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var map = mutableMapOf<Char, Boolean>()
        var start = 0
        var maxSize = Int.MIN_VALUE
        for( i in 0..s.length-1)
        {
            if(map.contains(s[i]))
            {
                maxSize = max(maxSize,map.size)
                while (map.contains(s[i]))
                {
                    map.remove(s[start])
                    start++
                }
                map.put(s[i],true)
            }
            else
            {
                map.put(s[i],true)
            }
        }
        return max(maxSize,map.size)

    }

}