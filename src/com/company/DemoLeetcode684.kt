package com.company

object DemoLeetcode684 {

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            findRedundantConnection( arrayOf(intArrayOf(3,4),
                intArrayOf(1,2),
                intArrayOf(2,4),
                intArrayOf(3,5),
                intArrayOf(2,5)
            )))
    }


    private fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        var parentArray = ArrayList<Int>()
        var rankArray = ArrayList<Int>()

        for(i in 0..edges.size) {
           if(i>0)
           { rankArray.add(1)
            parentArray.add(i)
            }
            else
           {
               rankArray.add(0)
               parentArray.add(0)
           }
        }
        var output: IntArray = intArrayOf()
        for(i in edges.indices)
        {
            val edge1 = edges[i][0]
            val edge2 = edges[i][1]

            if(parentArray[edge1] == parentArray[edge2]) {
                output = edges[i]
                break
            }
            else
            {
                if( rankArray[parentArray[edge1]]>= rankArray[parentArray[edge2]])
                {
                    rankArray[parentArray[edge1]] = rankArray[parentArray[edge1]]+ rankArray[edge2]
                    for(i in parentArray.indices)
                    {
                        if(parentArray[i]==edge2)
                            parentArray[edge2] = parentArray[edge1]
                    }

                }else{

                    rankArray[parentArray[edge2]] = rankArray[parentArray[edge2]]+ rankArray[edge1]
                    for(i in parentArray.indices)
                    {
                        if(parentArray[i]==edge1)
                            parentArray[edge1] = parentArray[edge2]
                    }

                }
            }
        }
        return output
    }
}