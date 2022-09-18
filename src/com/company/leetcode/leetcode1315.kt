package com.company.leetcode

import java.util.*
import kotlin.collections.ArrayList

object leetcode1315 {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }



    @JvmStatic
    fun main(args: Array<String>) {

        var treeNode1 = TreeNode(6)
        var treeNode2 = TreeNode(7)
        var treeNode3 = TreeNode(8)
        var treeNode4 = TreeNode(2)
        var treeNode5 = TreeNode(7)
        var treeNode6 = TreeNode(1)
        treeNode1.left = treeNode2
        treeNode1.right = treeNode3
        treeNode2.left = treeNode4
        treeNode2.right = treeNode5
        treeNode3.right = treeNode6
        treeNode3.left = null

        println(sumEvenGrandparent(treeNode1))
    }

    var sum  = 0
    fun sumEvenGrandparent(root: TreeNode?): Int {

       if(root==null || (root.left == null && root.right == null))
           return -1
        else
       {
           var queue: Queue<TreeNode> = LinkedList()
           queue.add(root)
           while (queue.isNotEmpty())
           {
               if(queue.peek().`val`% 2 == 0) {
                   queue.peek()?.let {
                       calculateSum(queue.peek())
                   }?:run {
                       queue.remove()
                   }

               }
               queue.peek().left?.let {
                   queue.add(it)
               }
               queue.peek().right?.let {
                   queue.add(it)
               }
               queue.remove()
           }
       }

        return sum

    }

     fun calculateSum(node: leetcode1315.TreeNode?) {
        val bufferArray : ArrayList<TreeNode?> = ArrayList()
         node?.left?.let {
             bufferArray.add(it)
         }
         node?.right?.let {
             bufferArray.add(it)
         }
        for (i in 0 until bufferArray.size)
        {
            bufferArray[i]?.left?.let {
                sum += it.`val`
            }
            bufferArray[i]?.right?.let {
                sum += it.`val`
            }
        }
    }

}


