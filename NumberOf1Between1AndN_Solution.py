# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        # write code here
        result = 0
        for value in range(1,n+1):
            ret = str(value)
            result += ret.count('1')
            
        return result