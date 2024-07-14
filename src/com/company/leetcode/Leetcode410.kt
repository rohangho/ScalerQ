package com.company.leetcode

object Leetcode410 {


    @JvmStatic
    fun main(args:Array<String>)
    {
        print(splitArray(intArrayOf(7,2,5,10,8),2))
    }




    fun splitArray(nums: IntArray, k: Int): Int {


        var lowestPossible = nums.maxOrNull()
        var highestPossible = nums.sum()
        var result = highestPossible

        while (lowestPossible!! <= highestPossible)
        {
            val mid =((lowestPossible-highestPossible)/2)+lowestPossible
            if(splitPossible(mid,nums,k))
            {
                result = mid
                highestPossible = mid-1
            }
            else
            {
                lowestPossible = mid+1
            }
        }

        return result
    }

    private fun splitPossible(mid: Int, nums: IntArray, k: Int): Boolean {
        var subArray =0
        var sum = 0
        for (i in nums.indices)
        {
            sum += nums[i]
            if(sum>=mid)
            {
                subArray+=1
                sum =  nums[i]
            }

        }
        return subArray+1<=k
    }


}