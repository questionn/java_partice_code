# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):
        # write code here
        if pHead1 == None:
            return pHead2
        if pHead2 == None:
            return pHead1
        
        #使用一个额外空间
        head = ListNode(-1)
        root = head
        
        while pHead1 and pHead2:
            if pHead1.val < pHead2.val:
                head.next = ListNode(pHead1.val)
                head = head.next
                pHead1 = pHead1.next
            else:
                head.next = ListNode(pHead2.val)
                head = head.next
                pHead2 = pHead2.next
                
        
        if pHead1 != None:
            head.next = pHead1
            
        if pHead2 != None:
            head.next = pHead2
            
        return root.next