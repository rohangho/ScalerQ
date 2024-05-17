package com.company.leetcode

import com.company.leetcode.LeetCode2261.countDistinct

object `Leetocde 740` {

    @JvmStatic
    fun main(args: Array<String>) {
        println(deleteAndEarn(intArrayOf(2,2,3,3,3,4)))
    }

    fun deleteAndEarn(nums: IntArray): Int {
        nums.sort()
        val hashmap = HashMap<Int,Int>()
        for (i in nums.indices)
        {
            if(hashmap.contains(nums[i]) ) {
                hashmap[nums[i]] = hashmap[nums[i]]!! + 1
            }
            else {
                hashmap[nums[i]] = 1
            }
        }
        val newArray= nums.distinct()
        var variable1 =0
        var variable2 =0

        for (i in newArray.indices)
        {
            val current = newArray[i]*hashmap[newArray[i]]!!
            if(i>0 && newArray[i] == newArray[i-1]+1)
            {
                val temp = variable2
                variable2 = (current + variable1).coerceAtLeast(variable2)
                variable1 = temp

            }
            else
            {
                val temp = variable2
                variable2 += current
                variable1 = temp
            }
        }

        return variable2

    }
}