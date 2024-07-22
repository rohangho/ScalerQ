package com.company.leetcode

import kotlin.math.max

object Leetcode1011 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(shipWithinDays(intArrayOf(10,50,100,100,50,100,100,100),5))
    }

    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var max = Int.MIN_VALUE
        var sum = 0

        for (i in weights.indices)
        {
            max = max(max,weights[i])
            sum += weights[i]
        }

        var lowest = max
        var highest = sum
        var result = 0

        while (lowest<highest)
        {
            val mid = (lowest+highest)/2
            if(solveWithDays(weights,mid,days))
            {
                result = mid
                highest = mid-1
            }
            else
                lowest = mid+1

        }

        return result
    }

    private fun solveWithDays(weights: IntArray, capacity: Int,days: Int): Boolean {
        var dayRequired = 0
        var sum =0
        for (i in weights.indices)
        {
            sum += weights[i]
            if(sum>capacity)
            {
                dayRequired++
                sum = weights[i]
            }

        }

        return dayRequired+1 <= days

    }

}