package com.company.leetcode

object Leetcode1291 {

    @JvmStatic
    fun main(argd: Array<String>)
    {
      print(sequentialDigits(10,100000000))
    }


    fun sequentialDigits(low: Int, high: Int): List<Int> {

        var sizeSliding = low.getSize()
        var element = 0
        var totalPossible = "123456789"
        var output = mutableListOf<Int>()
        var pointer =0
        var  pointer1 = pointer+sizeSliding
        while (element<high)
        {
            if(pointer1> totalPossible.length)
            {
                sizeSliding++
                pointer = 0
                pointer1 = 0+sizeSliding
            }
            else
            {
                if(totalPossible.substring(pointer,pointer1).toLong()>low) {
                    output.add(totalPossible.substring(pointer, pointer1).toInt())
                    element = totalPossible.substring(pointer, pointer1).toInt()
                }
                pointer++
                pointer1++
            }
        }
        output.removeAt(output.size-1)

        return output

    }

}

private fun Int.getSize():Int {
    return this.toString().length
}
