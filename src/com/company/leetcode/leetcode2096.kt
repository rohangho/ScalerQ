package com.company.leetcode


object leetcode2096 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        val root = TreeNode(3)
        root.left = TreeNode(1)
        root.right = TreeNode(2)
//        root.left?.left = TreeNode(4)
////        root.left?.right = TreeNode(5)
//        root.right?.left = TreeNode(6)
//        root.right?.right = TreeNode(7)

        println(getDirections(root,2,1))
    }


    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        var leftStringBuilder = StringBuilder()
        var rightStringBuilder = StringBuilder()
        getPath(root,startValue,leftStringBuilder)
        getPath(root,destValue,rightStringBuilder)

        var common =  true
        while (common){
            if(leftStringBuilder.isNotEmpty()  && rightStringBuilder.isNotEmpty()) {
                if (leftStringBuilder[0] == rightStringBuilder[0]) {
                    leftStringBuilder.deleteCharAt(0)
                    rightStringBuilder.deleteCharAt(0)
                } else
                    common = false
            }
            else
                break
        }


        for (i in 0..leftStringBuilder.length-1)
        {
            if(leftStringBuilder[i] == 'L' || leftStringBuilder[i] == 'R')
                leftStringBuilder[i] = 'U'
        }

        return  leftStringBuilder.append(rightStringBuilder).toString()


    }


    private fun getPath(root: TreeNode?, value: Int,path: StringBuilder): Boolean{
        if(root == null)
            return false
        if(root.`val` == value)
            return true
        path.append("L")
        var found = getPath(root.left,value,path)
        if(found == true)
            return  true
        path.deleteCharAt(path.length-1)
        path.append("R")
         found = getPath(root.right,value,path)
        if(found == true)
            return  true
        path.deleteCharAt(path.length-1)
        return false
    }
}

