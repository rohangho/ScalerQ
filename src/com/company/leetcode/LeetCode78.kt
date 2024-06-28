package com.company.leetcode


object LeetCode78 {

    @JvmStatic
    fun main(args: Array<String>)
    {

    }

    fun subsets(nums: IntArray): List<List<Int>> {
        var index =0
        val subset: MutableList<Int> = mutableListOf()
        val res: MutableList<MutableList<Int>> = mutableListOf()
        solve(nums,res,subset,index)

        return res
    }

    private fun solve(nums: IntArray, result: MutableList<MutableList<Int>>, subset: MutableList<Int>, index: Int) {
        result.add(subset)

        for (i in index..nums.size-1)
        {
            subset.add(nums[i])
            solve(nums,result,subset,i+1)
            subset.remove(nums[i])
        }

    }
}