package com.company.leetcode

import java.util.Arrays
import java.util.Collections
import kotlin.math.max
import kotlin.math.min

object Leetcode2895 {


    @JvmStatic
    fun main(args: Array<String>)
    {
        println(minProcessingTime(listOf(121,99),listOf(287,315,293,260,333,362,69,233)))
    }

    fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {
        Collections.sort(tasks)
       val  tasks = tasks.reversed()
        Collections.sort(processorTime)
       var output = Int.MIN_VALUE

        for(i in 1..processorTime.size)
        {
            var max = 0
            for(j in ((i-1)*4)..(i*4)-1)
            {
                max = max(max,processorTime[i-1]+tasks[j])
            }
           output = max(output,max)

        }

        return output
    }

}