package com.company.leetcode

object Leetcode347 {

    @JvmStatic
    fun main(args:Array<String>){
        print(topKFrequent(intArrayOf(3,0,1,0),1))
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var map = mutableMapOf<Int,Int>()

        for(i in nums.indices)
        {
            if(map.keys.contains(nums[i]))
                map[nums[i]] = map[nums[i]]!! + 1
            else
                map[nums[i]] = 1
        }

       val a =  map.entries.sortedBy {
            it.value
        }.reversed()

        var count = 1
        var result = mutableListOf<Int>()

        a.forEach{
            if(count <=k) {
                result.add(it.key)
                count ++
            }
        }


        return result.toIntArray()


    }



}