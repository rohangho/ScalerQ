package com.company.leetcode

import kotlin.math.abs

object Leetcode979 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print("Hello")
    }
    private var result = 0

    fun distributeCoins(root: TreeNode?): Int {

        solveNode(root)
        return result

    }

    private fun solveNode(root: TreeNode?): Int
    {
        if (root == null) return 0

        val left = solveNode(root.left)
        val right = solveNode(root.right)

        result += abs(left) + abs(right)

        return root.`val` + left + right - 1
    }


}