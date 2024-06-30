package com.company.leetcode

import java.util.LinkedList
import java.util.Queue

object Leetcode2059 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(minimumOperations(intArrayOf(2,8,16),0,1))
    }

    data class QueueContains(
        val element:Int,
        val count:Int
    )

    fun minimumOperations(nums: IntArray, start: Int, goal: Int): Int {
        var queue : Queue<QueueContains> = LinkedList()
        val count = 1
        var min = Int.MAX_VALUE
        for(i in nums.indices)
        {
            queue.add(QueueContains(start+nums[i],count))
            queue.add(QueueContains(start-nums[i],count))
            queue.add(QueueContains(start.xor(nums[i]),count))
        }

        while (queue.isNotEmpty())
        {
            println("calculating")
            if(queue.peek().element==goal)
            {
                min = min.coerceAtMost(queue.peek().count)
                break
            }
            else
            {
                val currentElement = queue.peek()
                for(i in nums.indices) {
                    queue.add(QueueContains(currentElement.element + nums[i], currentElement.count+1))
                    queue.add(QueueContains(currentElement.element - nums[i], currentElement.count+1))
                    queue.add(QueueContains(currentElement.element.xor(nums[i]), currentElement.count+1))
                }
                queue.remove()
            }
        }

       return if(min == Int.MAX_VALUE)
         -1
        else
            min

    }

}