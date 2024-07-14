package com.company.leetcode

import java.util.*

object Leetcode402 {

    @JvmStatic
    fun main(args: Array<String>) {
        print(removeKdigits("1432219", 3))
    }


    fun removeKdigits(num: String, k: Int): String {
        var numArray = num.toInt().getDigit()
        val stack = Stack<Int>()
        var counter = 1
        for (i in numArray.indices) {
            if (counter > k) {
                stack.push(numArray[i])
                continue
            }
            if (stack.empty())
                stack.push(numArray[i])
            else {
                if (stack.peek() <= numArray[i]) {
                    stack.push(numArray[i])
                } else {
                    while (true) {
                        if(stack.peek()>numArray[i] && counter<=k)
                        {
                            stack.pop()
                            counter++
                        }
                        else
                            break
                    }
                    stack.push(numArray[i])
                }
            }
        }
        var result = ""

        while (stack.isNotEmpty())
            result += stack.pop().toString()

        if(k-counter>0)
            result = result.substring(0,result.length-(k-counter))

        return result.reversed()

    }

    private fun Int.getDigit(): MutableList<Int> {
        var number = this
        val list = mutableListOf<Int>()
        while (number > 0) {
            val last = number % 10
            list.add(last)
            number /= 10

        }
        return list.reversed() as MutableList
    }
}
