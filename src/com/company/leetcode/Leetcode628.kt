package com.company.leetcode

import kotlin.math.max

object Leetcode628 {


    @JvmStatic
    fun main(args: Array<String>)
    {
        print(maximumProduct(intArrayOf(3,4,0,0,-1,-5)))
    }



    fun maximumProduct(nums: IntArray): Int {
        var noOfNegative = 0
       val  sortedNums = nums.sorted()

        for (i in sortedNums.indices)
        {
            if(sortedNums[i]>=0)
                break
            else
                noOfNegative++
        }

        return if(noOfNegative>=2) {
            max((sortedNums[0]*sortedNums[1]*sortedNums[sortedNums.size-1]),(sortedNums[sortedNums.size-1] * sortedNums[sortedNums.size-2] * sortedNums[sortedNums.size-3]))
        } else {
            sortedNums[sortedNums.size-1] * sortedNums[sortedNums.size-2] * sortedNums[sortedNums.size-3]
        }


    }

}