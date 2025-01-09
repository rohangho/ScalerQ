package com.company.leetcode

import com.company.leetcode.Leetcode1669.ListNode

object Leetcode876 {

    @JvmStatic
    fun main(args: Array<String>)
    {
        val a  = ListNode(1)
        val b  = ListNode(2)
        val c  = ListNode(3)
        val d  = ListNode(4)
        val e  = ListNode(5)
        val f  = ListNode(6)
        a.next = b
        b.next = c
        c.next = d
        d.next = e
        e.next  = f
        f.next = null
        print(middleNode(a))
    }

    fun middleNode(head: ListNode?): ListNode? {
        var startSlow = head
        var startFast = head
        while (startFast?.next!=null)
        {
           startSlow = startSlow?.next
           startFast = startFast?.next?.next

        }

        return startSlow

    }

}