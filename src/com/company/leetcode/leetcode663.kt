package com.company.leetcode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


object leetcode663 {

    @JvmStatic
    fun main(args: Array<String>) {
        val a = TreeNode(2)
        val b = TreeNode(1)
        a.left = b
        val c = TreeNode(2)
        b.right = c
        val d = TreeNode(1)
        c.left = d
        val e = TreeNode(2)
        d.right = e
        println(checkEqualTree(a))
    }

    fun checkEqualTree(root: TreeNode?): Boolean {
        val treeInList = ArrayList<Int>()

        val total = sum(root, treeInList)
        if (total % 2 != 0)
            return false
        treeInList.removeLast()

        return treeInList.contains(total / 2)

    }

    private fun sum(root: TreeNode?, treeInList: ArrayList<Int>): Int {
        if (root == null)
            return 0
        val left = sum(root.left, treeInList)
        val right = sum(root.right, treeInList)
        treeInList.add(left + right + root.`val`)
        return (left + right + root.`val`)
    }
}


