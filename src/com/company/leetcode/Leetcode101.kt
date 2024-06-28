package com.company.leetcode

object Leetcode101 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        print("Hiiii")
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        return solve(root?.left,root?.right)
    }

    private fun solve(left: TreeNode?, right: TreeNode?): Boolean {
        if(left == null || right ==null)
            return left == right
         return (left.`val` == right.`val` && solve(left.left,right.right) && solve(left.right, right.left))

    }
}