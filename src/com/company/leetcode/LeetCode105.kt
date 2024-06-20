package com.company.leetcode



object LeetCode105 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        print("Hiii")
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return solveTree(preorder,inorder,0,inorder.size-1)

    }

    var count = 0

    private fun solveTree(preorder: IntArray, inorder: IntArray, start: Int, end: Int):TreeNode? {
        if(start>end)
            return null
        val treeNode = TreeNode(preorder[count++])
        if(start == end)
            return treeNode
        val index = search(treeNode.`val`,inorder)
        treeNode.left = solveTree(preorder,inorder,start,index-1)
        treeNode.right = solveTree(preorder,inorder,index+1,end)
    }

    private fun search(i: Int, inorder: IntArray): Int {
        return inorder.indexOf(i)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}