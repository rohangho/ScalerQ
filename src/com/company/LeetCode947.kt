package com.company

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

object LeetCode947 {
    @JvmStatic
    fun main(args: Array<String>) {
       println(
           removeStones( arrayOf(intArrayOf(4,4),
           intArrayOf(5,5),
           intArrayOf(3,1),
           intArrayOf(1,4),
           intArrayOf(1,1),
               intArrayOf(2,3),
               intArrayOf(0,3),
               intArrayOf(2,4),
               intArrayOf(3,5),
           )))
    }


    private fun removeStones(stones: Array<IntArray>): Int {
        if(stones.size>1) {
            var noofRow = 0
            var noOfColumn = 0

            var rowArray: ArrayList<Int> = ArrayList()
            var columnArray: ArrayList<Int> = ArrayList()

            for (i in stones.indices) {
                if (noofRow < stones[i][0])
                    noofRow = stones[i][0]
                if (noOfColumn < stones[i][1])
                    noOfColumn = stones[i][1]
            }

            for (i in 0..noofRow)
                rowArray.add(0)
            for (i in 0..noOfColumn)
                columnArray.add(0)

            var globalCounter = 1

            for(i in stones.indices)
            {
                if(rowArray[stones[i][0]] == 0)
                {
                    rowArray[stones[i][0]] = globalCounter
                    globalCounter ++
                }
                if(columnArray[stones[i][1]] == 0)
                {
                    columnArray[stones[i][1]] = globalCounter
                    globalCounter ++
                }
            }

            var counter =0
            while (counter<2) {
                for (i in stones.indices) {
                    val min = Math.min(rowArray[stones[i][0]], columnArray[stones[i][1]])
                    rowArray[stones[i][0]] = min
                    columnArray[stones[i][1]] = min
                }
                counter++
            }


            return  stones.size - (findUnique(rowArray,columnArray).toInt())

        }
        else
            return 0

    }

    private fun findUnique(rowArray: ArrayList<Int>, columnArray: ArrayList<Int>): Long {
        var newJoinArray: ArrayList<Int> = ArrayList()
        newJoinArray = rowArray
        newJoinArray.addAll(columnArray)

        newJoinArray = newJoinArray.filter { it>0 } as ArrayList<Int>
        return newJoinArray.stream().distinct().count()

    }



}