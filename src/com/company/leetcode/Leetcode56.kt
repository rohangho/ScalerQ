package com.company.leetcode

import kotlin.math.max

object Leetcode56 {

    @JvmStatic
    fun main(string: Array<String>) {
        println(merge(arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(15,18), intArrayOf(8,10))))
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy { it[0] })
        var result: MutableList<IntArray> = mutableListOf()
        for(i in intervals.indices)
        {
            if(result.size>0)
            {
                if(intervals[i][0]>result[result.size-1][0] && intervals[i][0]<=result[result.size-1][1])
                    result[result.size-1][1] = max(result[result.size-1][1],intervals[i][1])
                else
                    result.add(intervals[i])
            }
            else
                result.add(intervals[i])
        }
        return result.toTypedArray()

    }

}
