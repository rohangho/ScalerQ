package com.company.leetcode

object Leecode1664 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(waysToMakeFair(intArrayOf(2,1,6,4)))
    }


    fun waysToMakeFair(nums: IntArray): Int {
        if(nums.size>=2) {
            val evenSumArray = mutableListOf<Int>()
            val oddSumArray = mutableListOf<Int>()
            for (i in nums.indices) {
                evenSumArray.add(0)
                oddSumArray.add(0)
            }
            evenSumArray[0] = nums[0]
            evenSumArray[1] = nums[0]
            oddSumArray[0] = 0
            oddSumArray[1] = nums[1]

            for (i in 2..nums.size - 1) {
                if (i % 2 == 0) {
                    evenSumArray[i] = evenSumArray[i - 1] + nums[i]
                    oddSumArray[i] = oddSumArray[i - 1]
                } else {
                    oddSumArray[i] = oddSumArray[i - 1] + nums[i]
                    evenSumArray[i] = evenSumArray[i - 1]
                }
            }

            var counter = 0

            for (i in 0..nums.size - 1) {
                var oddSum = -1
                var evenSum = -1
                if (i == 0) {
                    evenSum = oddSumArray[oddSumArray.size - 1]
                    oddSum = evenSumArray[evenSumArray.size - 1] - evenSumArray[i]
                } else {
                    evenSum = evenSumArray[i - 1] + oddSumArray[nums.size - 1] - oddSumArray[i]
                    oddSum = oddSumArray[i - 1] + evenSumArray[nums.size - 1] - evenSumArray[i]
                }
                if (oddSum == evenSum)
                    counter++
            }
            return counter
        }
        else
            return 0
    }
}