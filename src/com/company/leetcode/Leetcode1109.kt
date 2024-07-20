package com.company.leetcode



object Leetcode1109 {

    @JvmStatic
    fun main(args:Array<String>)
    {
      println(corpFlightBookings(arrayOf(intArrayOf(1,2,10),intArrayOf(2,3,20),intArrayOf(2,5,25)),5))
    }

    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val diff = IntArray(n + 1)

        for (booking in bookings) {
            val start = booking[0] - 1
            val end = booking[1]
            val seats = booking[2]
            diff[start] += seats
            diff[end] -= seats
        }

        val ans = IntArray(n)
        var sum = 0
        for (i in diff.indices) {
            sum += diff[i]
            if (i < n) {
                ans[i] = sum
            }
        }
        return ans
    }


}