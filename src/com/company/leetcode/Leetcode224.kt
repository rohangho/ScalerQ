package com.company.leetcode

import java.util.Stack

object Leetcode224 {

    @JvmStatic
    fun main(ards: Array<String>)
    {
        print(calculate("(1+(4+5+2)-3)+(6+8)"))
    }

    fun calculate(s: String): Int {
        var stoCharArray  = s.toCharArray()
        var myStack  = Stack<Char>()
        myStack.push(stoCharArray[0])
        var i = 1
        var output = 0

        while (!myStack.isEmpty())
        {
            if(i>stoCharArray.size-1)
            {
                output =  solveStack(myStack)
                break
            }
            else if(stoCharArray[i].equals(')')) {
                i++
                var string = ""
                while (myStack.peek()!='(')
                    string = string+myStack.pop()
                myStack.pop()
                var bracketSum = calculate(string.reversed())
                if(bracketSum<0)
                {
                    myStack.pop()
                    myStack.push('-')
                    }
                myStack.push(bracketSum.toChar())
            }
            else
            {
                myStack.push(stoCharArray[i])
                i++
            }
        }

        return output

    }

    private fun solveStack(myStack: Stack<Char>): Int {
        val reversedStackToList = myStack.reversed()
        var sum = 0
        var operatorToPreform = ""

        for (i in reversedStackToList.indices)
        {
            if(reversedStackToList[i].isDigit())
            {
               if(operatorToPreform.isEmpty())
               {
                   sum = reversedStackToList[i].digitToInt()
               }
                else
               {
                   sum = operatorSolve(sum,operatorToPreform,reversedStackToList[i])
               }
                operatorToPreform = ""
            }
            else
            {
                operatorToPreform = reversedStackToList[i].toString()
            }
        }

        return sum
    }

    private fun operatorSolve(currentSum: Int, operatorToPreform: String, element: Char): Int {
        return if(operatorToPreform == "+")
            currentSum+element.digitToInt()
        else
            currentSum-element.digitToInt()
    }

}

