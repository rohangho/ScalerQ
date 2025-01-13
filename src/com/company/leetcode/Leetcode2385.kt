package com.company.leetcode

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.mutableMapOf

object Leetcode2385 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        val a = TreeNode(2)
        val b = TreeNode(1)
        val c = TreeNode(3)

        b.left = a
        b.right = c

        print(amountOfTime(b,1))
    }

    data class QueueContain(val number:Int,val distance: Int)

    fun amountOfTime(root: TreeNode?, start: Int): Int {

        generateAdjacency(root)
        val queue: Queue<QueueContain> = LinkedList()
        map[start]?.forEach {
           queue.add(QueueContain(it,1))
        }

        var counter = 0
        var visited = mutableListOf<Int>()
        visited.add(start)
        while (queue.isNotEmpty())
        {
            counter = queue.peek().distance
            visited.add(queue.peek().number)
            map[queue.peek().number]?.forEach {
                if(!visited.contains(queue.peek().number))
                    queue.add(QueueContain(it,queue.peek().distance+1))
            }

            queue.poll()
        }

        return counter

    }

    var map = mutableMapOf<Int, MutableSet<Int>>()

    private fun generateAdjacency(node: TreeNode?) {
        if(node?.left != null)
        {
            if(map.contains(node.`val`))
                map[node.`val`]?.add(node.left!!.`val`)
            else
                map.put(node.`val`,mutableSetOf(node.left!!.`val`))
            map.put(node.left!!.`val`,mutableSetOf(node.`val`))

            generateAdjacency(node.left)
        }
        if (node?.right!=null)
        {
            if(map.contains(node.`val`))
                map[node.`val`]?.add(node.right!!.`val`)
            else
                map.put(node.`val`,mutableSetOf(node.right!!.`val`))
            map.put(node.right!!.`val`,mutableSetOf(node.`val`))

            generateAdjacency(node.right)
        }

    }

}