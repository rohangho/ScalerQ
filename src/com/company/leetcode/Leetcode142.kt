package com.company.leetcode

object Leetcode142

{
    @JvmStatic
    fun main(args:Array<String>)
    {
       print("main")
    }

    fun detectCycle(head: LeetcodeAdd2No.ListNode?): LeetcodeAdd2No.ListNode? {
        var slow = head
        var fast = head
        while (fast!=null || fast?.next!= null)
        {
            slow = slow?.next
            fast = fast.next?.next
            if(fast == slow)
            {
                slow = head
                while (fast!=slow){
                    slow = slow?.next
                    fast = fast?.next
                }
                return slow
            }
        }
        return null
    }
}