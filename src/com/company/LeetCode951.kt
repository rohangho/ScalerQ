package com.company

object LeetCode951 {

    @JvmStatic
    fun main(args: Array<String>) {
       println(flipEquiv(TreeNode1(1),TreeNode1(null)))
    }

    private fun flipEquiv(root1: TreeNode1?, root2: TreeNode1?): Boolean {
        if(root1 == null && root2 == null)
            return true
        if((root1 == null && root2 != null) ||(root2 == null && root1 != null))
            return false


        else{


            return (flipEquiv(root1?.left,root2?.left) == flipEquiv(root1?.right,root2?.right)) ||
                    (flipEquiv(root1?.left,root2?.right) == flipEquiv(root1?.right,root2?.left))
        }

    }
}


 class TreeNode1(var `val`: Int?) {
         var left: TreeNode1? = null
         var right: TreeNode1? = null
     }