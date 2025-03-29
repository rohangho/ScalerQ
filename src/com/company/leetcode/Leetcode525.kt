package com.company.leetcode

import kotlin.math.max

object Leetcode525 {

    @JvmStatic
    fun main(args: Array<String>) {
        print(findMaxLength(intArrayOf(0,0, 0, 0, 1, 1, 1, 0,1)))
    }

    fun findMaxLength(nums: IntArray): Int {
        val countArray = mutableListOf<Int>()
        var sum = 0;
        for (i in nums.indices) {
            sum += if (nums[i] == 0)
                -1
            else
                1
            countArray.add(sum)
        }
        var longest = Int.MIN_VALUE
        val map = mutableMapOf<Int, Int>()

        for (i in countArray.indices) {
            if (countArray[i] == 0)
                longest = max(longest, i + 1)
            else {
                if (map.contains(countArray[i]))
                    longest = max(longest, i - map[countArray[i]]!!)
                else
                    map[countArray[i]] = i
            }
        }
        return if (longest >= 0)
            longest
        else
            0
    }
}