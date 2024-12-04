package com.company.leetcode

import java.util.*

object Leetcode1642 {

    @JvmStatic
    fun main(args:Array<String>)
    {
       print(furthestBuilding(intArrayOf(1,5,1,2,3,4,10000),4,1))
    }

    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {

        var counter = 0
        var noOfBrick = bricks
        var noOfLadder = ladders

        var maxHeap = PriorityQueue<Int>(Collections.reverseOrder())


        for(i in 1..heights.size-1)
        {
            val current = heights[i-1]
            if(current<heights[i])
            {
                if(heights[i]-current<=noOfBrick)
                {
                    noOfBrick -= heights[i]-current
                    maxHeap.add(heights[i]-current)
                    counter++
                    continue
                }
                else if(noOfLadder>0)
                {

                    if(maxHeap.size>0)
                    {
                        val element = maxHeap.poll()
                        if(element>heights[i]-current ) {
                            noOfBrick += element
                            if (heights[i] - current <= noOfBrick) {
                                noOfBrick -= heights[i] - current
                                maxHeap.add(heights[i] - current)
                                counter++
                            }
                        }
                        else
                        {
                            maxHeap.add(element)
                            counter++
                        }
                        noOfLadder--
                    }
                    else
                    {
                        noOfLadder--
                        counter++
                    }

                    continue
                }
                else
                    break
            }
            else
                counter++
        }
        return counter
    }
}