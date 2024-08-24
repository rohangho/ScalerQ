package com.company.leetcode

object Leetcode2747 {

    @JvmStatic
    fun main(args:Array<String>)
    {
        println(countServers(3, arrayOf(intArrayOf(2,4), intArrayOf(2,1), intArrayOf(1,2),intArrayOf(3,1)),2, intArrayOf(3,4)))
    }

    fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
        val result:MutableList<Int> = mutableListOf()
        var dummyMap : HashMap<Int,MutableList<Int>> = HashMap()
       for(i in logs.indices)
       {
           if(dummyMap.contains(logs[i][1]))
           {
               if(!dummyMap[logs[i][1]]!!.contains(logs[i][0])) {
                   dummyMap[logs[i][1]]!!.add(logs[i][0])
               }
           }
           else {
               val mutableList :MutableList<Int> = mutableListOf()
               mutableList.add(logs[i][0])
               dummyMap[logs[i][1]] = mutableList
           }
       }
        for(i in queries.indices)
        {
            val timeStart = queries[i]-x
            val timeEnd = queries[i]
            val dummyArray:MutableList<Int> = mutableListOf()
            for (i in timeStart..timeEnd)
            {
                dummyMap[i]?.let {
                    for (j in it.indices) {
                        if (!dummyArray.contains(dummyMap[i]!![j])) {
                            dummyArray.add(dummyMap[i]!![j])
                        }
                    }
                }
            }
            result.add( n-dummyArray.size)
        }

        return result.toIntArray()


    }


}
