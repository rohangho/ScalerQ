package com.company.leetcode

object LeetCode73 {

    @JvmStatic
    fun main(args: Array<String>) {

        val a = intArrayOf(0,1,2,0)
        val b = intArrayOf(3,4,5,2)
        val c = intArrayOf(1,3,1,5)

        println(setZeroes(arrayOf(a,b,c) ))
    }
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val iPosition = mutableListOf<Int>()
        val jposition = mutableListOf<Int>()

        for(i in matrix.indices)
        {
            for(j in matrix.get(i).indices)
            {
                  if(matrix[i][j] == 0) {
                      iPosition.add(i)
                      jposition.add(j)
                  }
            }
        }

        for(i in iPosition.indices)
            makeRowColZero(matrix,iPosition.get(i),jposition.get(i))
    }

    private fun makeRowColZero(matrix: Array<IntArray>, row: Int, column: Int) {
        for(i in matrix[row].indices)
        {
            matrix[row][i] = 0
        }
        for(i in matrix.indices)
        {
            matrix[i][column]=0
        }
        println("Donme")
    }

}