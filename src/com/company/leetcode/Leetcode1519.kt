package com.company.leetcode

import java.util.Stack

object Leetcode1519 {
    @JvmStatic
    fun main(args: Array<String>)
    {
        print(countSubTrees(5, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,3),intArrayOf(0,4)), "aabab"))
    }

    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val result = IntArray(n)
        val graph = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        val visited = BooleanArray(n)
        fun dfs(node: Int): IntArray {
            visited[node] = true
            val charCounts = IntArray(26)
            charCounts[labels[node] - 'a']++

            for (neighbor in graph[node]) {
                if (!visited[neighbor]) {
                    val childCounts = dfs(neighbor)
                    for (i in 0..25) {
                        charCounts[i] += childCounts[i]
                    }
                }
            }
            result[node] = charCounts[labels[node] - 'a']
            return charCounts
        }
        dfs(0)
        return result


    }


}