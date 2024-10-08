package com.company.leetcode

import kotlin.math.abs

object Leetcode2535 {


    @JvmStatic
    fun main(args:Array<String>)
    {
        println(differenceOfSum(intArrayOf(1,15,6,3)))
    }

    fun differenceOfSum(nums: IntArray): Int {
        var sum =0
        var digitSum = 0
        for(i in nums.indices) {
            sum += nums[i]
            digitSum += getDigitSum(nums[i])
        }

        return abs( sum-digitSum)


    }

    private fun getDigitSum(i: Int): Int {
        var buffer =0
        var holder = i
        while (holder!=0)
        {
            buffer += holder%10
            holder /= 10
        }

        return buffer
    }

}