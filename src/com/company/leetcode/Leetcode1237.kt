package com.company.leetcode

object Leetcode1237 {

    @JvmStatic
    fun main(args: Array<String>) {

            println()
    }



    fun findSolution(customfunction:CustomFunction, z:Int):List<List<Int>> {
        var output:ArrayList<List<Int>> = ArrayList()
        for(i in 0..1000)
        {
            for (j in 1000 downTo 0)
            {
                if(customfunction.f(i,j) == z) {
                   output.add(listOf(i,j))
                }
            }
        }
        return output;
    }

}


class CustomFunction {
         // Returns f(x, y) for any given positive integers x and y.
         // Note that f(x, y) is increasing with respect to both x and y.
         // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         fun f(x:Int, y:Int):Int {
             return 7;
         }
     }