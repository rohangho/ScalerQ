package com.company.leetcode

import kotlin.math.abs

object LeetCode41 {

    @JvmStatic
    fun main(args: Array<String>){
        print(firstMissingPositive(intArrayOf(1,2,0)))
    }

    fun firstMissingPositive(nums: IntArray): Int {
        for (i in nums.indices)
        {
            if(nums[i]<0)
                nums[i]=0
        }

        for(i in nums.indices)
        {
            if(abs(nums[i])-1>=0 && abs(nums[i])-1<nums.size)
            {
                if(nums[abs(nums[i])-1]>0)
                    nums[abs(nums[i])-1] *= -1
                else if (nums[abs(nums[i])-1] == 0)
                    nums[abs(nums[i])-1] = -1 * (nums.size-1)
            }

        }
        var count = -1
        for(i in 1..nums.size)
        {
            if(nums[i-1] >= 0) {
                count = i
                break
            }
        }
        return if(count ==-1)
            nums.size+1
        else
            count

    }

}