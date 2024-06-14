package com.company.leetcode


object LeetcodeAdd2No {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val a = ListNode(9)
        val b = ListNode(9)
        val c = ListNode(9)
        a.next = b
        b.next = c

        val a1 = ListNode(3)
        val b1 = ListNode(2)
        val c1 = ListNode(1)
        a1.next = b1
        b1.next = c1




        print(addTwoNumbers(a1, a))


    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): String {
        var FirstHead = l1
        var SecondHead = l2
        var carry = 0
        var string = ""

        while (FirstHead != null || SecondHead != null) {
            val sum = (FirstHead?.`val` ?: 0) + (SecondHead?.`val` ?: 0)
            if (sum <= 9) {
                string += sum + carry
                carry = 0
            } else {
                string += (sum + carry) % 10
                carry = sum / 10
            }
            FirstHead = FirstHead?.next
            SecondHead = SecondHead?.next
        }

        return if (carry > 0)
            (string + carry).reversed()
        else
            string.reversed()

    }
}