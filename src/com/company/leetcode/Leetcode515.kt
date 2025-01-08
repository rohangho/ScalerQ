package com.company.leetcode

import org.w3c.dom.css.Counter
import java.util.LinkedList
import java.util.Queue
import java.util.logging.Level
import kotlin.math.max

object Leetcode515 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        val a = TreeNode(1)
        val b = TreeNode(1)
        a.left = b

        println(largestValues(a))
    }

    fun largestValues(root: TreeNode?): List<Int> {

        if(root == null)
         return emptyList()
        else {
            val output = mutableListOf<Int>()
            for (i in 0..heightofTree(root))
                output.add(Int.MIN_VALUE)

            var queue = LinkedList<QueueVale>()
            queue.push(QueueVale(root, 1))
            while (queue.isNotEmpty()) {
                output[queue.peek().counter - 1] = max(output[queue.peek().counter - 1], queue.peek().root!!.`val`)
                val currentQueueTop = queue.peek()
                queue.pop()
                if (currentQueueTop.root!!.left != null)
                    queue.push(QueueVale(currentQueueTop.root.left, currentQueueTop.counter + 1))
                if (currentQueueTop.root!!.right != null)
                    queue.push(QueueVale(currentQueueTop.root.right, currentQueueTop.counter + 1))
            }

            return output
        }

    }



    fun heightofTree(root: TreeNode?): Int
    {
        if(root == null)
            return -1
        val left = heightofTree(root.left)
        val rigt = heightofTree(root.right)
        return Math.max(left,rigt)+1
    }


    data class QueueVale(val root: TreeNode?, val counter: Int)
}