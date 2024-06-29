package com.company.leetcode

object Leetcode226 {

    class TreeNode(var `val`: Int) {
             var left: TreeNode? = null
             var right: TreeNode? = null
         }


    @JvmStatic
    fun main(args:Array<String>)
    {
        println("sdffdv")
    }
    fun invertTree(root: TreeNode?): TreeNode? {

        if(root == null )
            return null

        val left = root.left
        root.left = root.right
        root.right = left
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}