package com.company.leetcode

import com.company.leetcode.Leetcode1669.ListNode

object Leetcode2 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        var a = ListNode(9)
        var b = ListNode(9)
        var c = ListNode(9)
        var g = ListNode(9)
        var h = ListNode(9)
        var i = ListNode(9)
        a.next = b
        b.next = c
        c.next = g
        g.next = h
        h.next = i
        i.next = null
        var d = ListNode(9)
        var e = ListNode(9)
        var f = ListNode(9)
        d.next = e
        e.next = f
        f.next = null



//        var a = ListNode(0)
//        a.next = null
//        var b = ListNode(0)
//        b.next = null




        print(addTwoNumbers(a,d))
    }


    fun addTwoNumbers( l1: ListNode?, l2: ListNode?): ListNode? {

        var l1copy = l1
        var l2copy = l2
        var resut: ListNode? = null
        var start = resut
        var carryOver  =0

        while (l1copy != null || l2copy!=null)
        {
            if(resut == null)
            {
                val one = l1copy?.`val` ?: 0
                val two = l2copy?.`val`?:0
                resut = ListNode((one+two+carryOver)%10)
                carryOver = (one+two+carryOver)/10
                start = resut
            }
            else
            {
                val one = l1copy?.`val` ?: 0
                val two = l2copy?.`val`?:0
                resut.next = ListNode((one+two+carryOver)%10)
                resut = resut.next
                carryOver =(one+two+carryOver)/10
            }
            l1copy = l1copy?.next
            l2copy = l2copy?.next
        }

        if(carryOver != 0)
            resut?.next = ListNode(carryOver)

        return start

    }

}