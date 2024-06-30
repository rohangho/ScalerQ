package com.company.leetcode

import kotlin.math.abs

object Leetcode1975 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        println(maxMatrixSum(arrayOf(intArrayOf(1,2,3), intArrayOf(-1,-2,-3), intArrayOf(1,2,3))))
    }


    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        val negative:MutableList<Int> = mutableListOf()
        var s =0
        for (i in matrix.indices)
        {
            for(j in matrix[i].indices)
            {
                s += abs(matrix[i][j])
                if(matrix[i][j]<0) {
                    negative.add(matrix[i][j])

                }
            }
        }
        if(negative.size%2==0)
        {
            return s.toLong()
        }
        else
        {
            negative.sort()
            s += negative[negative.size-1]
            return s.toLong()
        }
    }
}