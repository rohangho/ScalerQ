package com.company.leetcode

object Leetcode15 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(threeSum(intArrayOf(-1,0,1,2,-1,-4)))
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i],
                                nums[left], nums[right]))

                        left++
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++
                        }
                        right--
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--
                        }
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }

        return result
    }
}