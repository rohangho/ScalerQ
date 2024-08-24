package com.company.leetcode


object Leetcode2077 {

    @JvmStatic
    fun main(args:Array<String>)
    {

        println(numberOfPaths(5, arrayOf(intArrayOf(1,2),intArrayOf(5,2),intArrayOf(4,1),intArrayOf(2,4),
            intArrayOf(3,1),intArrayOf(3,4))))
    }

//    fun numberOfPaths(n: Int, corridors: Array<IntArray>): Int {
//
//        val adjacencyMap :MutableMap<Int,MutableList<Int>> = mutableMapOf()
//        for (i in 1..n)
//        {
//            adjacencyMap[i] = mutableListOf()
//        }
//
//        for(i in corridors.indices)
//        {
//            adjacencyMap[corridors[i][0]]?.add(corridors[i][1])
//            adjacencyMap[corridors[i][1]]?.add(corridors[i][0])
//        }
//        var result = 0
//
//        adjacencyMap.forEach{ (key, value) ->
//            val stack:Stack<Pair<Int,Int>> = Stack()
//            value.forEach {
//                stack.push(Pair(it,1))
//            }
//           while (stack.isNotEmpty())
//           {
//               val currentTop = stack.peek()
//               stack.pop()
//               if(currentTop.second == 2)
//               {
//                   if( adjacencyMap[currentTop.first]!!.contains(key))
//                   {
//                       result ++
//                   }
//               }
//               else {
//                   adjacencyMap[currentTop.first]!!.forEach { currentVal ->
//                       if (currentVal != key && currentTop.second < 3)
//                           stack.push(Pair(currentVal, currentTop.second + 1))
//                   }
//               }
//
//           }
//        }
//        return result
//    }


    private fun numberOfPaths(n: Int, corridors: Array<IntArray>): Int {
        val g: Array<MutableSet<Int>?> = arrayOfNulls<MutableSet<Int>>(n + 1)
        for (i in 0..n) {
            g[i] = HashSet()
        }
        for (c in corridors) {
            val a = c[0]
            val b = c[1]
            g[a]!!.add(b)
            g[b]!!.add(a)
        }
        var ans = 0
        for (c in 1..n) {
            val nxt = ArrayList(g[c])
            val m = nxt.size
            for (i in 0 until m) {
                for (j in i + 1 until m) {
                    val a = nxt[i]
                    val b = nxt[j]
                    if (g[b]!!.contains(a)) {
                        ++ans
                    }
                }
            }
        }
        return ans / 3
    }

}