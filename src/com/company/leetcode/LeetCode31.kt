package com.company.leetcode

import com.company.leetcode.leetcode49.groupAnagrams

object LeetCode31 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(nextPermutation(intArrayOf(1,2,3,4,3,2,3,4,2)))
    }

    fun nextPermutation(nums: IntArray): Unit {
        nums.reverse()
        var dipPoint = -1
        var point = Int.MIN_VALUE
       for(i in nums.indices)
       {
           if(point<= nums[i])
           {
              point = nums[i]
           }
           else
           {
               dipPoint = i
               break
           }
       }
        if(dipPoint == -1)
            nums.sort()
        else
        {
            swapArr(dipPoint,nums)
        }
        nums.reverse()
        nums.sort(nums.lastIndex-dipPoint+1,nums.lastIndex)
        println(nums)

    }

    private fun swapArr(dipPoint: Int, nums: IntArray) {
        val a = nums[dipPoint-1]
        nums[dipPoint-1] = nums[dipPoint]
        nums[dipPoint]=a
    }
}