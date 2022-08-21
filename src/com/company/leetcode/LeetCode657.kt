package com.company.leetcode

object LeetCode657 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(judgeCircle("LL"))
    }

    fun judgeCircle(moves: String): Boolean {

        var leftCounter =0
        var rightCounter =0;
        var upCounter =0;
        var downCounter =0;
        val movesInChar = moves.toCharArray()
        for(i in movesInChar.indices)
        {
           if(movesInChar[i] == 'L')
               leftCounter += 1
            if(movesInChar[i] == 'R')
                rightCounter += 1
            if(movesInChar[i] == 'U')
                upCounter += 1
            if(movesInChar[i] == 'D')
                downCounter += 1
        }

        return leftCounter == rightCounter && upCounter == downCounter
    }
}