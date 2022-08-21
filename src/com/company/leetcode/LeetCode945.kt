package com.company.leetcode

import java.util.*
import kotlin.collections.ArrayList

object LeetCode945 {
    @JvmStatic
    fun main(args: Array<String>) {
       println(minIncrementForUnique(intArrayOf(13,4,12,5,3,16,11,6,11,0,2,7,19,10,1,15,15,15,11,13)))
    }


    private fun minIncrementForUnique(nums: IntArray): Int {
        val listOfInCounter= ArrayList<Int>()
        Arrays.sort(nums)
        var minValue = nums[nums.size-1]
        var output = 0

        for (i in 0..(minValue+nums.size))
           listOfInCounter.add(0)

        for(i in nums.indices)
            listOfInCounter[nums[i]] = listOfInCounter[nums[i]] +1

        for(i in listOfInCounter.indices)
        {
            if(listOfInCounter[i] > 1)
            {
                var noOfInc = listOfInCounter[i]-1
                var currentPosition = i+1
                while (noOfInc!=0)
                {
                    if(listOfInCounter[currentPosition] ==0)
                    {
                        output =output + currentPosition - i
                        listOfInCounter[currentPosition] = 1
                        noOfInc--
                    }
                    currentPosition += 1
                }
            }
        }
        return output
    }
}