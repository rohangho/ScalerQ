package com.company.leetcode

import kotlin.math.min

object Leetcode1625 {


    @JvmStatic
    fun main(args:Array<String>)
    {
       println(findLexSmallestString("5525",9,2))
    }

    fun add(s:String,a:Int):String
    {
        val charArray = s.toCharArray()
        for(i in charArray.indices)
        {
            if(i%2==1)
            {
                charArray[i] = ((charArray[i].digitToInt()+a)%10).digitToChar()
            }
        }
        return charArray.concatToString()
    }

    var answer = ""

    fun rotate(s:String,b:Int):String
    {
        val size= s.length
        val resultArray= s.toCharArray().copyOf()

        for(i in s.toCharArray().indices)
        {
            resultArray[(i+b)%size]= s.toCharArray()[i]
        }
        return resultArray.concatToString()
    }

    fun ifVisited(a:Int,b:Int,s:String,set: MutableSet<String>)
    {
        if(set.contains(s)) return
        set.add(s)
        answer = min(answer.toInt(),s.toInt()).toString()
        ifVisited(a,b, add(s,a),set)
        ifVisited(a,b, rotate(s,b),set)
    }

    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        answer = s
        val set:MutableSet<String> = mutableSetOf()
        ifVisited(a,b,s,set)
        return answer
    }


}