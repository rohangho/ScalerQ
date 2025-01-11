package com.company.leetcode

object Leetcode852 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        println(peakIndexInMountainArray(intArrayOf(0,1,5,20)))
    }

    fun peakIndexInMountainArray(arr: IntArray): Int {

        var low = 0
        var high = arr.size-1
        var mid = -1
        while (low<=high){
             mid = (low+high)/2
            if(mid > 0 && mid < arr.size-1) {
                if (arr[mid - 1] > arr[mid] && arr[mid + 1] < arr[mid]) {
                    high = mid - 1
                } else if (arr[mid - 1] < arr[mid] && arr[mid + 1] > arr[mid])
                    low = mid + 1
                else {
                    break
                }
            }
            else if(mid == 0)
            {
                if ( arr[mid + 1] < arr[mid]) {
                    break
                } else if ( arr[mid + 1] > arr[mid]) {
                    mid = mid + 1
                    break
                }
            }
            else if(mid == arr.size-1)
            {
                if ( arr[mid -1] < arr[mid]) {
                    break
                } else if ( arr[mid - 1] > arr[mid]) {
                    mid = mid - 1
                    break
                }
            }
        }

        return mid

    }
}