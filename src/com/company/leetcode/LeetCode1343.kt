package com.company.leetcode

object LeetCode1343 {

    @JvmStatic
    fun main(args: Array<String>) {
        println( numOfSubarrays(intArrayOf(2,2,2,2,5,5,5,8),3,4))
    }

    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {

        var pointerOne = 0
        var pointerTwo = k-1
        var counter = 0

        while (pointerTwo<=arr.size-1)
        {
            var sum = 0
            for (i in pointerOne..pointerTwo)
            {
                sum += arr[i]
            }
            if(sum/k>=threshold)
                counter++

            pointerOne++
            pointerTwo++
        }
        return counter
    }
}


