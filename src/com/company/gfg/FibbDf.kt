package com.company.gfg

object FibbDf {



    @JvmStatic
    fun main(args: Array<String>) {
        println(findNthFibonacci(7))
    }

    fun findNthFibonacci(number: Int): Int {
        val bufferArray = IntArray(number+1)
        bufferArray[0] = 1
        bufferArray[1] = 1

        for (i in 2 until number)
        {
            bufferArray[i] = bufferArray[i-1]+bufferArray[i-2]
        }
        return bufferArray[number-1]
    }




}