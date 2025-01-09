package com.company.leetcode

object Leetcode938 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        val a = TreeNode(10)
        val b = TreeNode(5)
        val c = TreeNode(15)
        val d = TreeNode(3)
        val e = TreeNode(7)
        val f = TreeNode(18)
        a.left = b
        a.right = c
        b.left = d
        b.right = e
        c.right = f
       print(rangeSumBST(a,7,15))
    }


    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {

        return solve(root,low,high)
    }

    fun solve(root: TreeNode?,low: Int,high: Int):Int
    {
        return if(root == null)
            0
        else {
            if(root.`val`< low)
                solve(root.right,low,high)
            else if(root.`val`>high)
                solve(root.left,low,high)
            else
                solve(root.left,low,high)+solve(root.right,low,high)+root.`val`


        }
    }
}