package com.company.leetcode

import java.util.Collections
import java.util.LinkedList
import java.util.Queue

object Leetcode200 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        numIslands(arrayOf(charArrayOf('1','1','0','0','0'),charArrayOf('1','1','0','0','0'),
            charArrayOf('0','0','1','0','0'),charArrayOf('0','0','0','1','1')))
    }

    fun numIslands(grid: Array<CharArray>): Int {

        var counter= 0
        var mutableGrid = updaterow(grid)

        for(i in 0..mutableGrid.size-1)
        {
            for(j in mutableGrid[i].indices)
            {
                if(mutableGrid[i][j] == '1')
                {
                    counter++
                    mutableGrid = convertAdjacent(i,j,mutableGrid)
                }
            }
        }
       return counter

    }

    private fun updaterow(arrays: Array<CharArray>): Array<CharArray> {

        var myNewArray = Array(arrays.size + 2) { CharArray(arrays.getOrNull(0)?.size?.plus(2) ?: 1) }
        for(i in 0..myNewArray.size-1)
        {
            for(j in 0..myNewArray[i].size-1)
            {
                myNewArray[i][j]='0'
            }
        }

        for(i in 0..arrays.size-1)
        {
            for (j in 0..arrays[0].size-1)
            {
                myNewArray[i+1][j+1] = arrays[i][j]
            }
        }

        return myNewArray

    }

    private fun convertAdjacent(row: Int, column: Int, grid: Array<CharArray>):Array<CharArray> {
        var mutableGrid = grid
        val myQueue : Queue<Pair<Int,Int>> = LinkedList()
        myQueue.add(Pair(row,column))
        mutableGrid[row][column] = '0'
        while(myQueue.isNotEmpty())
        {
            val current = myQueue.remove()
            mutableGrid[current.first][current.second] = '0'
                if(grid[current.first-1][current.second] == '1')
                    myQueue.add(Pair(current.first-1, current.second))
                if(grid[current.first+1][current.second] == '1')
                    myQueue.add(Pair(current.first+1, current.second))
                if(grid[current.first][current.second+1] == '1')
                    myQueue.add(Pair(current.first, current.second+1))
                if(grid[current.first][current.second-1] == '1')
                    myQueue.add(Pair(current.first, current.second-1))
            }

        return mutableGrid

    }

}

