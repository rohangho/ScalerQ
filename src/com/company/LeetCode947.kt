package com.company

import java.util.*
import kotlin.collections.ArrayList

object LeetCode947 {
    @JvmStatic
    fun main(args: Array<String>) {
       println(
           removeStones( arrayOf(intArrayOf(0,1),
           intArrayOf(1,2),
           intArrayOf(1,3),
           intArrayOf(3,3),
           intArrayOf(2,3),
               intArrayOf(0,2),
           )))
    }


    fun removeStones(stones: Array<IntArray>): Int {
        var noofRow =0
        var noOfColumn = 0

        var rowArray:ArrayList<Int> = ArrayList()
        var columnArray:ArrayList<Int> =ArrayList()

        for(i in stones.indices)
        {
            if(noofRow<stones[i][0])
                noofRow = stones[i][0]
            if(noOfColumn<stones[i][1])
                noOfColumn = stones[i][1]
        }

        for(i in 0..noofRow)
            rowArray.add(0)
        for(i in 0..noOfColumn)
            columnArray.add(0)


        for (i in stones.indices)
            rowArray[stones[i][0]] = rowArray[stones[i][0]] +1


        for (i in stones.indices)
            columnArray[stones[i][1]] = columnArray[stones[i][1]] +1


        var counter = 0
        for(i in stones.indices)
        {
            if(rowArray[stones[i][0]]>1 )
            {
                rowArray[stones[i][0]] =  rowArray[stones[i][0]]-1
                columnArray[stones[i][1]] =  columnArray[stones[i][1]]-1
                counter += 1
            }
            else if( columnArray[stones[i][1]]>1)
            {
                columnArray[stones[i][1]] =  columnArray[stones[i][1]]-1
                rowArray[stones[i][0]] =  rowArray[stones[i][0]]-1
                counter += 1
            }

        }
        return counter

    }
}