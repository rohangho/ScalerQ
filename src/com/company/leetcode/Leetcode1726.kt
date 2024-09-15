package com.company.leetcode

object Leetcode1726 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(tupleSameProduct(intArrayOf(1,2,5,4,10)))
    }

    fun tupleSameProduct(nums: IntArray): Int {
        val hashMap: MutableMap<Int,MutableList<Int>> = hashMapOf()
        var i =0
        while (i<nums.size-1)
        {
            for (j in i + 1..nums.size - 1)
            {
                if(hashMap.contains(nums[i] * nums[j]))
                {
                    if(!hashMap[nums[i] * nums[j]]!!.contains(nums[i]) && !hashMap[nums[i] * nums[j]]!!.contains(nums[j])
                    ) {
                        hashMap[nums[i] * nums[j]]!!.add(nums[i])
                        hashMap[nums[i] * nums[j]]!!.add(nums[j])
                    }

                }
                else
                {
                    hashMap[nums[i] * nums[j]] = mutableListOf(nums[i],nums[j])
                }
            }
            i++
        }
        var count  =0
        hashMap.forEach{ (key, value) ->
            // THis solution is wrong instead of doing this we need to add the permutation logic is the  there is more
            // that 4 number persent in the list
            if(value.size == 4)
                count += 8

        }
        return count
    }

}