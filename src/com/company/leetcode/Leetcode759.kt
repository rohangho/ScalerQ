package com.company.leetcode


import kotlin.math.max
import kotlin.math.min

object Leetcode759 {




    @JvmStatic
    fun main(args: Array<String>) {
        println(employeeFreeTime(arrayListOf(arrayListOf(Interval(1,2),Interval(5,6),Interval(1,3),Interval(4,10)))))
    }


    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>):ArrayList<Interval> {
        var lowest = Int.MAX_VALUE
        var highest = Int.MIN_VALUE
        for (i in schedule[0].indices)
        {
            lowest = min(lowest,schedule[0][i].start)
            highest = max(highest,schedule[0][i].end)
        }
        val hashmap = HashMap<Int,MutableList<Int>>()
        for (i in lowest..highest)
            hashmap[i]= emptyList<Int>().toMutableList()

        for(i in schedule[0].indices) {
            hashmap.get(schedule[0][i].start)!!.add(i+1)
            hashmap.get(schedule[0][i].end)!!.add(i+1)
        }
        var calculateList = ArrayList<Int>()
        var ouput = ArrayList<Interval>()
        val dummy = ArrayList<Int>()
        var buffer = -1
        for (i in hashmap.keys)
        {
            for (j in hashmap[i]!!.indices)
            {
                if(dummy.contains(hashmap[i]!![j]))
                    dummy.remove(hashmap[i]!![j])
                else
                    dummy.add(hashmap[i]!![j])
            }
            if(buffer == 0 && dummy.isNotEmpty())
            {
                calculateList.add(i)
                buffer = -1
            }
            if(dummy.isEmpty() && hashmap[i]!!.isEmpty() && buffer == -1) {
                calculateList.add(i)
                buffer = 0
            }
            if(dummy.isEmpty() && hashmap[i]!!.isNotEmpty()) {
                calculateList.add(i)
                buffer =0
            }
        }
       if(calculateList.size%2!=0)
           calculateList.removeLast()

        for( i in calculateList.indices step 2) {
            ouput.add(Interval(calculateList[i], calculateList[i + 1]))

        }
        return ouput
    }

}



data class Interval(val start:Int, val end:Int)