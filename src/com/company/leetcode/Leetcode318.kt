package com.company.leetcode

import kotlin.math.max

object Leetcode318 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        println(maxProduct(arrayOf("a","aa","aaa","aaaa")))
    }

    fun maxProduct(words: Array<String>): Int {

        var result = 0
        for (i in 0..words.size-2)
        {
            val hashmap = words[i].toHashMap()
            for (j in i+1..words.size-1)
            {
                val size = words[j].length
                var count  =0
                for(k in words[j].toCharArray())
                {
                    if(!hashmap.contains(k))
                        count++
                    else
                        break
                }

                if(count == size)
                    result = max(result,words[i].length*words[j].length)

            }
        }

        return result

    }

    }

private fun String.toHashMap(): HashMap<Char, Int> {

    val hashMapChar = HashMap<Char,Int>()
        for(i in this.toCharArray())
        {
            if(!hashMapChar.contains(i))
                hashMapChar[i] = 1
        }
    return hashMapChar

}
