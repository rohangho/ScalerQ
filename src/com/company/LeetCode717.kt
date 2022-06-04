package com.company

object LeetCode717 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(isOneBitCharacter(intArrayOf(1,1,1,0)))
    }

    fun isOneBitCharacter(bits: IntArray): Boolean {
        var i =0
        var output = false
        while (true)
        {
            if(i==bits.size-1) {
                output = true
                break
            }
            if(i >bits.size-1)
            {
                output = false
                break
            }

            i += if( bits[i] == 0)
                1
            else
                2
        }
        return output;
    }
}