package com.company.leetcode


object LeetCode121 {

    @JvmStatic
    fun main(args: Array<String>) {
       println(maxProfit(intArrayOf(5,4,3,2,1)))
    }

    fun maxProfit(prices: IntArray): Int {
        var output = 0
        var basePointer = 0

        for (i in prices.indices)
        {
            if(prices[basePointer] == prices[i])
                continue
            else if(prices[basePointer]>prices[i])
                basePointer = i
            else
                output = Math.max(output,prices[i]-prices[basePointer])

        }

        return output
    }
}