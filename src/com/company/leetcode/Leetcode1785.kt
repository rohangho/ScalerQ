package com.company.leetcode

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


object Leetcode1785 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(minElements(intArrayOf(1,-1,1),1000000,-1000000000))
    }

    fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
        var remaining = calculateRemaing(goal,nums)
        var counter = 0
        while (remaining!=0)
        {
            if(remaining>=limit)
            {
                counter += remaining / limit
                remaining -= ((remaining / limit) * limit)
            }
            else {
                counter++
                remaining = 0
            }
        }
        return counter
    }

    private fun calculateRemaing(goal: Int, nums: IntArray): Int {
        val sum = nums.sum()
        return if((goal<0 && sum<0))
            abs(min(goal,sum) - max(goal,sum))
        else if(goal>=0 && sum>=0)
            max(goal,sum) - min(goal,sum)
        else
            abs(max(goal,sum) +abs(min(goal,sum)))
    }
}