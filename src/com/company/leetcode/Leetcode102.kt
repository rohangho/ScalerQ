package com.company.leetcode

import java.util.LinkedList
import java.util.Queue

object Leetcode102 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        val a = TreeNode(7)
        a.left = null
        a.right = null

        val b = TreeNode(15)
        b.left = null
        b.right = null

        val c = TreeNode(20)
        c.left = b
        c.right = a

        val e = TreeNode(9)
        c.left = null
        c.right = null

        val d = TreeNode(3)
        d.left = e
        d.right = c


        println(levelOrder( d))
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val result:MutableList<MutableList<Int>> = mutableListOf()
        val counter = 0
        val queue: Queue<CustomQueue> = LinkedList()
        queue.add(CustomQueue(root,counter))
        while (queue.isNotEmpty())
        {
            val currentTop = queue.poll()
            currentTop.root?.left?.let {
                queue.add(CustomQueue(currentTop.root.left,currentTop.count+1))
            }
            currentTop.root?.right?.let {
                queue.add(CustomQueue(currentTop.root.right,currentTop.count+1))
            }

            if(result.size <= currentTop.count)
                result.add(currentTop.count, mutableListOf(currentTop.root!!.`val`))
            else
               result[currentTop.count].add(currentTop.root!!.`val`)
        }

        return result

    }


    data class CustomQueue(val root: TreeNode?,val count:Int)

}