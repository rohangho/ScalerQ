package com.company.leetcode

object `Leetcode 777` {


    @JvmStatic
    fun main(args: Array<String>)
    {
        print(canTransform("RXXLRXRXL","XRLXXRRLL"))
    }


    fun canTransform(start: String, result: String): Boolean {

        var pointer1 = 0

        var pointer2 = 0
        var output = false

        while (true)
        {
           while (start.length>pointer1 && start[pointer1] =='X')
               pointer1++
            while (result.length>pointer2 && result[pointer2]=='X')
                pointer2++

            if(pointer1 == start.length-1 || pointer2==result.length-1) {
                return pointer1 == start.length-1 || pointer2==result.length-1
            }
            if(start[pointer1]!=result[pointer2])
                return false
            if(start[pointer1] =='R' && pointer1>pointer2)
                return false
            if(start[pointer1] == 'L' && pointer2>pointer1)
                return false
           pointer1++
            pointer2++
        }
    return  output


    }


}