class Solution:
    def FindKthToTail(self, head, k):
        # write code here
        cur = head
        count = 0
        while cur != None:
            count += 1
            cur = cur.next
        
        if k > count:
            return None
        
        tmp = head
        num = count - k
        while num > 0:
            tmp = tmp.next
            num -= 1
            
        self = tmp
        return self