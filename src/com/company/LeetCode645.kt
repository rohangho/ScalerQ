package com.company

import java.util.Stack

object LeetCode645 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(findErrorNums(intArrayOf(1,1)))
    }

    fun findErrorNums(nums: IntArray): IntArray {
        var bufferArrayList = ArrayList<Int>()
        for (i in 0..nums.size)
            bufferArrayList.add(0)

        for(i in nums.indices)
            bufferArrayList[nums[i]] = bufferArrayList[nums[i]] +1

        var multiple = 0
        var missing = 0

        for (i in 1 until bufferArrayList.size)
        {
            if(bufferArrayList[i]==0)
                missing = i
            if(bufferArrayList[i]==2)
                multiple = i
        }

        return intArrayOf(multiple,missing)
    }
}