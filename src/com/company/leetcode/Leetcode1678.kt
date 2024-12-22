package com.company.leetcode

import java.util.Stack

object Leetcode1678 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        print(interpret("(al)G(al)()()G"))
    }

    fun interpret(command: String): String {
        val commandToCharArray = command.toCharArray()
        var output =""
        val stack = Stack<Char>()
        for(i in commandToCharArray.indices)
        {
            if(commandToCharArray[i]=='G')
                output+= commandToCharArray[i].toString()
            else if(commandToCharArray[i]=='(')
                stack.push(commandToCharArray[i])
            else if(commandToCharArray[i]==')')
            {
                if(stack.peek() == '(') {
                    stack.pop()
                    output+="o"
                }
                else
                {
                    stack.clear()
                    output+="al"
                }
            }
            else
                stack.push(commandToCharArray[i])
        }
        return output
    }

}