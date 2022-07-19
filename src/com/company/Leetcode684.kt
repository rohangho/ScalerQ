package com.company

import java.util.Stack

object Leetcode684 {

    @JvmStatic
    fun main(args: Array<String>) {

       println(findRedundantConnection(arrayOf(intArrayOf(1,2),intArrayOf(1,3),intArrayOf(2,3))))
    }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray? {
        val adjancyList = ArrayList<ArrayList<Int>>()

        for (i in edges.indices)
            adjancyList.add(ArrayList())

        for (i in edges.indices)
        {

            if(checkIfConnected(edges[i],adjancyList))
                return edges[i]
            else
            {
                adjancyList[edges[i][0]-1].add(edges[i][1]-1)
                adjancyList[edges[i][1]-1].add(edges[i][0]-1)
            }
        }
        return null
    }

    private fun checkIfConnected(edges: IntArray, adjancyList: ArrayList<ArrayList<Int>>): Boolean {
       if(adjancyList[edges[0]-1].contains(edges[1]-1) || adjancyList[edges[1]-1].contains(edges[0]-1))
           return true
        else
       {
           val bufferStack = Stack<Int>()
           var bufferArrayTrack = ArrayList<Int>()
           for(i in adjancyList[edges[0]-1].indices) {
               bufferStack.add(adjancyList[edges[0] - 1][i])
               bufferArrayTrack.add(edges[0] - 1)
           }
           while (bufferStack.isNotEmpty())
           {
               val currentTop = bufferStack.peek()
               if(currentTop.equals(edges[1]-1))
                   return true
               else
               {
                   bufferStack.pop()
                   for (j in adjancyList[currentTop].indices) {
                       if(!bufferArrayTrack.contains(adjancyList[currentTop][j])) {
                           bufferStack.add(adjancyList[currentTop][j])
                           bufferArrayTrack.add(currentTop)
                       }
                   }
               }
           }
       }
        return false
    }
}