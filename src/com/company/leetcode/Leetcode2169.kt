package com.company.leetcode

import kotlin.math.max
import kotlin.math.min

object Leetcode2169 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(countOperations(2,3))
    }

    fun countOperations(num1: Int, num2: Int): Int {

        var num1Copy = num1
        var num2Copy = num2
        var count =0

        while (num2Copy!=0 && num1Copy!=0)
        {
            val max = max(num2Copy,num1Copy)
            val min = min(num2Copy,num1Copy)
            num2Copy = max - min
            num1Copy = min
            count+=1
        }

        return count
    }

}