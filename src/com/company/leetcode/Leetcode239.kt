package com.company.leetcode

object Leetcode239 {


    @JvmStatic
    fun main(args:Array<String>)
    {
        print(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7),3))
    }

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

        val resultArray  = mutableListOf<Int>()
        var maxPosition  = -1

        for(i in 0..nums.size-k)
        {
            var j = i
            var maxNo = Int.MIN_VALUE
            if(maxPosition == -1 || maxPosition == i-1) {
                while (j <= i + k - 1) {
                    if (maxNo < nums[j]) {
                        maxNo = nums[j]
                        maxPosition = j
                    }
                    j++
                }
                resultArray.add(maxNo)
            }
            else
            {
                if(resultArray[resultArray.size-1]<nums[i+k-1])
                {

                    maxPosition = i+k-1
                    resultArray.add(nums[i+k-1])
                }
                else
                {
                    resultArray.add(resultArray[resultArray.size-1])
                }
            }

        }

        return resultArray.toIntArray()

    }

}