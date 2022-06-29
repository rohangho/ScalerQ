package com.company

/**
 *Move all the negative to front and positive to back in an array without usinf any other data structure and maintaining the order of the array
 * {1,2,-2,9,-1} -> {-2,-1,1,2,9}
 */

object DemoPosNegPositionKeep {
    @JvmStatic
    fun main(args: Array<String>) {
        println(solveArray(intArrayOf(-1,2,-3,-9,10)))
    }

    private fun solveArray(arrayOfInt: IntArray): IntArray {
        var pointer1 = 0
        var pointer2 = 0
        while(pointer2<arrayOfInt.size-1) {
            while (pointer2 <= arrayOfInt.size - 1) {
//                if (arrayOfInt[pointer2] < 0 && pointer1 == pointer2) {
//                    pointer1 += 1
//                    pointer2 += 1
//                } else if (arrayOfInt[pointer2] < 0 && pointer1 != pointer2) {
//                    break
//                } else {
//                    pointer2 += 1
//                }

                if(arrayOfInt[pointer2]<0 )
                    if(pointer1 == pointer2)
                    {
                        pointer1+= 1
                        pointer2 += 1
                    }
                else
                    break
                else if(arrayOfInt[pointer2]>0)
                    pointer2++;


            }
            if( pointer2 == arrayOfInt.size)
                break
           else if (pointer2 < arrayOfInt.size) {
                var bufferPointer2 = pointer2
                while (pointer2 - pointer1 > 0) {
                    var buffer = arrayOfInt[pointer2]
                    arrayOfInt[pointer2] = arrayOfInt[pointer2 - 1]
                    arrayOfInt[pointer2 - 1] = buffer
                    pointer2 -= 1
                }
                pointer1++
                pointer2 = bufferPointer2
            }

        }

            return  arrayOfInt

    }
}