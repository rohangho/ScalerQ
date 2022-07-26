package com.company

import kotlin.math.floor
import kotlin.math.sqrt

/**
 * Question Not clear and not working code
 */

object LeetCode1620 {

    @JvmStatic
    fun main(args: Array<String>) {
        println( bestCoordinate(arrayOf( intArrayOf(0,1,2),intArrayOf(2,1,2),intArrayOf(1,0,2),intArrayOf(1,2,2)),1))
       // println( bestCoordinate(arrayOf( intArrayOf(1,2,13),intArrayOf(2,1,7),intArrayOf(0,1,9)),2))
       // println( bestCoordinate(arrayOf( intArrayOf(2,1,9),intArrayOf(0,1,9)),2))
      //  println( bestCoordinate(arrayOf( intArrayOf(42,0,0)),7))
    }

    fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
        var distanceArray = ArrayList<ArrayList<Int>> ()
        for (i in towers.indices)
        {
           var  bufferDistanceArray = ArrayList<Int>()
            for (j in towers.indices)
            {
                bufferDistanceArray.add(findDistance(towers[i][0],towers[i][1],towers[j][0],towers[j][1]))
            }
            distanceArray.add(bufferDistanceArray)
        }
        var max = 0;
        var validPosition =  ArrayList<IntArray>()
        var bufferMax = -1
        for (i in towers.indices)
        {
            var sum = -1;
            for (j in distanceArray[i].indices)
            {
                if(distanceArray[i][j]<=radius)
                {
                    sum = (sum + floor((towers[j][2]/(1+ sqrt(distanceArray[i][j].toDouble())))).toInt())
                }
            }
            if(sum>=max)
            {
                max = sum
                if(bufferMax<max)
                {
                    validPosition.clear()
                    validPosition.add(intArrayOf(towers[i][0],towers[i][1]))
                }
                else if(bufferMax == max)
                    validPosition.add(intArrayOf(towers[i][0],towers[i][1]))

            }
        }

        if(validPosition.size>1) {
            var min = Int.MAX_VALUE
            var y = Int.MAX_VALUE
            var bufferPosition = -1
            for (i in validPosition.indices) {
                if (min > validPosition[i][0]) {
                    min = validPosition[i][0]
                    y = validPosition[i][1]
                    bufferPosition = i
                    continue
                }
                if (min == validPosition[i][0]) {
                    if (y > validPosition[i][1]) {
                        min = validPosition[i][0]
                        y = validPosition[i][1]
                        bufferPosition = i
                    }
                }

            }


            return intArrayOf(validPosition[bufferPosition][0], validPosition[bufferPosition][1])
        }
        else if (validPosition.size == 1)
            return intArrayOf(validPosition[0][0], validPosition[0][1])
        else
            return intArrayOf(0,0)

    }


    private fun findDistance(x1: Int, y1: Int, x2: Int, y2: Int):Int
    {
        return ((((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1))).toDouble()).toInt()
    }
}


