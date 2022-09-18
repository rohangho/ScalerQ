package com.company.leetcode


object LeetCode556 {


    @JvmStatic
    fun main(args: Array<String>) {
        println(nextGreaterElement(2147483486))
    }

    fun nextGreaterElement(n: Int): Int {

        if(n/10 == 0)
            return -1

        val nToCharArray = n.toString().toCharArray()
        val arrayListOfNumber = ArrayList<Int>()
        for (i in nToCharArray.indices)
            arrayListOfNumber.add(Integer.parseInt(nToCharArray[i].toString()))

        return if(checkDescending(arrayListOfNumber))
            -1
        else {
            addTwoNumber(arrayListOfNumber)
        }

    }

     fun addTwoNumber(arrayListOfNumber: ArrayList<Int>): Int {

         var pointer1 = arrayListOfNumber.size-1
         var pointer2 = arrayListOfNumber.size-1

        for (i in (arrayListOfNumber.size-1).downTo(1))
        {
            if(arrayListOfNumber[i] >= arrayListOfNumber[i-1])
            {
                pointer1 = i-1
                break;
            }
        }

        while (pointer2>pointer1)
         {
             if(arrayListOfNumber[pointer2]<arrayListOfNumber[pointer1])
                 pointer2--
             else
             {
                 val buffer = arrayListOfNumber[pointer2]
                 arrayListOfNumber[pointer2] = arrayListOfNumber[pointer1]
                 arrayListOfNumber[pointer1] = buffer
                 break;
             }
         }

         sortWithIndex(arrayListOfNumber,pointer1+1)

        var joinSum=""
        for (i in arrayListOfNumber.indices)
            joinSum += arrayListOfNumber[i]

        return Integer.parseInt(joinSum,11)
    }

    fun sortWithIndex(intArray: ArrayList<Int>, startIndex:Int): ArrayList<Int> {
        val bufferArray = ArrayList<Int>()
        for (i in startIndex until intArray.size)
            bufferArray.add(intArray[i])

        bufferArray.sort()
        var counter =0;
        for (i in 0 until intArray.size)
        {
            if(i<(intArray.size-bufferArray.size))
                continue
            else {
                intArray[i] = bufferArray[counter]
                counter++
            }
        }
        return intArray
    }

     fun checkDescending(arrayListOfNumber: ArrayList<Int>): Boolean {
        var count = 0;
        for (i in 0..arrayListOfNumber.size-2)
        {
            if(arrayListOfNumber[i] >= arrayListOfNumber[i+1])
                count++
        }
        return count == arrayListOfNumber.size-1
    }
}