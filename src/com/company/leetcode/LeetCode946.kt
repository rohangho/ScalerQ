package com.company.leetcode

import java.util.Stack

object LeetCode946 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(validateStackSequences(intArrayOf(1,0), intArrayOf(1,0)))
    }

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        val removePoppedList:MutableList<Int> = mutableListOf()
        for (i in pushed.indices) {
            stack.push(pushed[i])
            for (j in popped.indices) {
                if (!removePoppedList.contains(j) && stack.isNotEmpty()) {
                    if (stack.peek() == popped[j]) {

                        stack.pop()
                        removePoppedList.add(j)

                    } else
                        break
                } else
                    continue
            }
        }

        return stack.empty()
    }
}