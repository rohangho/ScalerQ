package com.company.leetcode

import java.util.Stack
import kotlin.intArrayOf

object leetcode496 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        print(nextGreaterElement(intArrayOf(2,4), intArrayOf(1,2,3,4)))
    }

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

        var map = mutableMapOf<Int, Int>()
        for (i in nums1.indices)
            map[nums1[i]] = -1

        val output  = mutableListOf<Int>()


        var stack  = Stack<Int>()
        for(i in nums2.indices) {
            if(stack.isEmpty && map.contains(nums2[i]))
                stack.push(nums2[i])
            else if( stack.isNotEmpty())
            {
                if(nums2[i]<stack.peek() && map.contains(nums2[i]))
                {
                    stack.push(nums2[i])
                }
                else if(nums2[i]>stack.peek())
                {
                    while(stack.isNotEmpty()  )
                    {
                        if( stack.peek()<nums2[i]) {
                            map[stack.peek()] = nums2[i]
                            stack.pop()
                        }
                        else {
                            break
                        }

                    }
                    if(map.contains(nums2[i]))
                        stack.push(nums2[i])
                }
            }
        }
        map.forEach { (key,vlue) ->
            output.add(vlue)
        }

        return output.toTypedArray().toIntArray()

    }

}