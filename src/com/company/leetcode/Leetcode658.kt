package com.company.leetcode

import java.lang.Math.abs
import java.util.*
import kotlin.collections.ArrayList

object Leetcode658 {

    @JvmStatic
    fun main(args: Array<String>) {

      println(findClosestElements(intArrayOf(-2,-1,1,2,3,4,5),7,3))
    }


     fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {

        val output = ArrayList<Int>()
        if(x <= arr[0])
        {
            for (i in 0 until k)
                output.add(arr[i])
        }
        else if(x >= arr[arr.size-1]) {
            var counter = k
            for (i in arr.size - 1 downTo 0) {
                if(counter != 0) {
                    output.add(arr[i])
                }
                else
                    break
                counter -= 1
            }
        }

        else
        {
            var counter = k
            val position = indexodfindPosition(arr,x)
            var pointerLeft = position-1
            var pointerRight = position

            while (counter > 0)
            {
                if(pointerLeft >= 0 && pointerRight <= arr.size-1) {
                    if (x - arr[pointerLeft] < arr[pointerRight] - x) {
                        output.add(arr[pointerLeft])
                        pointerLeft--
                        counter--
                    } else if (x - arr[pointerLeft] > arr[pointerRight] - x) {
                        output.add(arr[pointerRight])
                        pointerRight++
                        counter--
                    } else if (x - arr[pointerLeft] == arr[pointerRight] - x && arr[pointerLeft] < arr[pointerRight]) {
                        output.add(arr[pointerLeft])
                        pointerLeft--
                        counter--
                    } else {
                        output.add(arr[pointerRight])
                        pointerRight++
                        counter--
                    }
                }
                else
                {
                    if(pointerLeft < 0)
                    {
                       for (i in 0 until counter)
                       {
                           output.add(arr[pointerRight])
                           pointerRight++
                           counter--
                       }
                    }
                    else
                    {
                        for (i in 0 until counter)
                        {
                            output.add(arr[pointerLeft])
                            pointerLeft--
                            counter--
                        }
                    }
                }
            }

        }
         output.sort()

        return output
    }

     fun indexodfindPosition(arr: IntArray, x: Int): Int {
        var position = -1
        var min = Integer.MAX_VALUE
        for (i in arr.indices)
        {
            if(kotlin.math.abs(x - arr[i]) <min)
            {
                min = x-arr[i]
                position = i
            }
        }

        return position

    }
}