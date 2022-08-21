package com.company.leetcode

class TreeNode(var a: Int) {
         var left: TreeNode? = null
        var right: TreeNode? = null
     }



object LeetCode108 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(sortedArrayToBST(intArrayOf(-10,-3,0,4)))
    }



    private fun sortedArrayToBST(nums: IntArray): TreeNode? {
         if(nums.isEmpty())
           return null
        else {

            var mid = nums.size/2
            var treeNode = TreeNode(nums[mid])
            treeNode?.left = sortedArrayToBST(sendLeftArray(mid,nums))
            treeNode?.right = sortedArrayToBST(sendRightArray(mid,nums))
            return treeNode
        }

    }

    private fun sendRightArray(mid: Int, nums: IntArray): IntArray {
        val rightArray = IntArray((nums.size-1)-mid)
        for ((counter, i) in (mid+1 until nums.size).withIndex())
        { rightArray[counter] = nums[i]
        }

        return rightArray
    }

    private fun sendLeftArray(mid: Int, nums: IntArray): IntArray {
        val leftArray = IntArray(mid)
        for((counter, i) in (0 until mid).withIndex()) {
            leftArray[counter] = nums[i]
        }
        return leftArray
    }


}