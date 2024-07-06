package com.company.leetcode

import kotlin.math.max

object `LeetCode 3200` {

    @JvmStatic
    fun main(args:Array<String>)
    {
       println( maxHeightOfTriangle(4,4))
    }


    fun maxHeightOfTriangle(red: Int, blue: Int): Int {
        var height = 1
        var height1 = 1
        var red1 = red
        var blue1 = blue
        while (red1 > 0 || blue1 > 0)
        {
            if(height%2==0)
            {
                if(red1<height)
                    break
                else
                    red1 -= (height)


            }
            else
            {
               if(blue1<height)
                   break
                else
                    blue1 = blue1-(height)

            }
            height++
        }
         red1 = red
         blue1 = blue

        while (red1 > 0 || blue1 > 0)
        {
            if(height1%2==0)
            {
                if(blue1<height1)
                    break
                else
                blue1 = blue1-(height1)
            }
            else
            {  if(red1<height1)
                break
            else
                red1=red1-(height1)
            }
            height1++
        }

        return max(height-1,height1-1)

    }




}