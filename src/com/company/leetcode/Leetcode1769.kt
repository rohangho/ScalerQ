package com.company.leetcode

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object Leetcode1769 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(minOperations("001011"))
    }


    fun minOperations(boxes: String): IntArray {

        val array:MutableList<Int> = mutableListOf()
        for (i in boxes.toCharArray().indices)
            array.add(0)

        for (i in boxes.toCharArray().indices)
        {
            var sum = 0
            for(j in boxes.toCharArray().indices) {
                if (i != j) {
                    if(boxes[j] =='1')
                    {
                       sum += max(i,j)- min(i,j)
                    }
                }
            }
            array[i] = sum
        }
        return array.toIntArray()
    }

}