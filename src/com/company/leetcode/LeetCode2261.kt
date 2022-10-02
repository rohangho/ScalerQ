package com.company.leetcode


object LeetCode2261 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(countDistinct(intArrayOf(2,3,3,2,2,2),2,2))
    }

    /**
     * Copied from some where else
     */
    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
        val hs = HashSet<String>()
        for (i in nums.indices) {
            var cnt = 0
            val sb = StringBuilder()
            for (j in i until nums.size) {
                if (nums[j] % p == 0) {
                    cnt++
                }
                if (cnt > k) {
                    break
                }
                sb.append(nums[j].toString() + ",")
                hs.add(sb.toString())
            }
        }
        return hs.size
    }


}