package com.company.leetcode

import java.util.Objects

object leetcode49 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(groupAnagrams(arrayOf("")))
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hashMap = HashMap<String,ArrayList<String>>()
        val outputArray : ArrayList<List<String>> = ArrayList()

        for(i in strs.indices) {
            val sortedArray = String( strs[i].toCharArray().sortedArray())
            if(hashMap.contains(sortedArray))
                hashMap[sortedArray]?.add(strs[i])
            else {
                val bufferList= ArrayList<String>()
                bufferList.add(strs[i])
                hashMap[sortedArray] = bufferList
            }
        }
        hashMap.forEach {
            outputArray.add(it.value)
        }
        return outputArray

    }


}