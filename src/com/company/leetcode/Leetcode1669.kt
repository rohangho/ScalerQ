package com.company.leetcode

object Leetcode1669 {


    @JvmStatic
    fun main(args:Array<String>)
    {
        val a = ListNode(10)
        val b = ListNode(1)
        a.next = b
        val c = ListNode(13)
        b.next = c
        val d = ListNode(6)
        c.next = d
        val e = ListNode(9)
        d.next = e
        val f = ListNode(5)
        e.next = f
        f.next = null
        val g = ListNode(10000)
        val h = ListNode(10001)
        g.next = h
        val i = ListNode(10002)
        h.next = i
        i.next = null


        println(mergeInBetween(a,3,4,g))
    }

    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        val begin  = list1
        var head = list1
        var counter =0
        var pointer1:ListNode? = null
        var pointer2:ListNode? = null
        while (head != null)
        {
                if (counter == a - 1)
                    pointer1 = head
            if(counter == b+1)
                pointer2 = head
            counter++
            head = head.next
        }
        pointer1?.next = list2
        head = list1
        while (head!=null) {
            if(head.next == null) {
                head.next = pointer2
                break
            }
            head = head.next
        }
        return begin
    }



    class ListNode(var `val`: Int) {
             var next: ListNode? = null
         }

}