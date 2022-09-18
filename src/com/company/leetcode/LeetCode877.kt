package com.company.leetcode

import kotlin.math.max

object LeetCode877 {



    @JvmStatic
    fun main(args: Array<String>) {
        println(stoneGame(intArrayOf(5,3,4,5)))
    }

    fun stoneGame(piles: IntArray): Boolean {
        val storeArray = Array(piles.size) { IntArray(piles.size) }
        for (i in piles.indices)
        {
            for (j in piles.indices)
                storeArray[i][j] = -1
        }

        return piles.sum()/2 <= getMaxByAlice(storeArray,piles,0,piles.size-1)

    }

    fun getMaxByAlice(storeArray:Array<IntArray>,piles: IntArray, left:Int, right:Int): Int
    {
       return  if(left>right)
            0
        else {
            var leftSum = 0;
            var rightSum = 0;
            if((right-left)%2==0 ) {
                leftSum = piles[left]
                rightSum = piles[right]
            }
           if(storeArray[left][right] != -1)
               return storeArray[left][right]
           storeArray[left][right]= max((getMaxByAlice(storeArray,piles, left + 1, right) + leftSum), (getMaxByAlice(storeArray,piles, left, right - 1) + rightSum))
            storeArray[left][right]
        }
    }
}