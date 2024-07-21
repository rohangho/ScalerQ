package com.company.leetcode

import kotlin.math.max

object Leetcode1014 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(maxScoreSightseeingPair(intArrayOf(8,1,5,2,6)))
    }

    fun maxScoreSightseeingPair(values: IntArray):Int {

        var iValue = values[0]
        var max  = Int.MIN_VALUE
        for (i in 1..values.size-1)
        {
            val jValue = values[i]-i
            max = max(max,iValue+jValue)
            iValue = max(values[i]+i,iValue)
        }

        return max

    }


}