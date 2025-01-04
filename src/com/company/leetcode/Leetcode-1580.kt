package com.company.leetcode

object `Leetcode-1580` {
    @JvmStatic
    fun main(args: Array<String>)
    {
        print(maxBoxesInWarehouse(intArrayOf(1,2,2,3,4), intArrayOf(3,4,1,2)))
    }



    fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
        val minimumLeftArray = mutableListOf<Int>()
        minimumLeftArray.add(warehouse[0])
        for(i in 1..warehouse.size-1)
            minimumLeftArray.add(warehouse[i].coerceAtMost(minimumLeftArray[i - 1]))

        var minimumRightArray = mutableListOf<Int>()
        for (i in 0..warehouse.size-1)
            minimumRightArray.add(Int.MAX_VALUE)
        minimumRightArray[warehouse.size-1] = warehouse[warehouse.size-1]
        for(i in warehouse.size-2 downTo 0)
            minimumRightArray[i] = warehouse[i].coerceAtMost(minimumRightArray[i+1])
        val effectiveArray = mutableListOf<Int>()
        for (i in 0..warehouse.size-1)
        {
            effectiveArray.add(minimumLeftArray[i].coerceAtLeast(minimumRightArray[i]))
        }
        boxes.sort()
        effectiveArray.sort()
        var result = 0
        var index = 0
        for (box in boxes)
        {
            while (index<warehouse.size && effectiveArray[index]<box)
                index++

            if(index == warehouse.size)
                break
            result++
            index++
        }
        return result
    }
}