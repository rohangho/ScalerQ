package com.company.leetcode

object Leetcode494 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        print("Hiiii")
    }

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return solveTarget(nums,0,target,0)
    }

    private fun solveTarget(nums:IntArray,i: Int, target: Int,currentTotal:Int): Int {
        // add the base condition
        return solveTarget(nums,i+1,target,currentTotal+nums[i])+
                solveTarget(nums,i+1,target,currentTotal-nums[i])
    }

}