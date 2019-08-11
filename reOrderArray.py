# -*- coding:utf-8 -*-
class Solution:
    def reOrderArray(self, array):
        # write code here
        arr1 = []
        arr2 = []
        for value in array:
            if value % 2 == 1:
                arr1.append(value)
            else:
                arr2.append(value)
                
        self = arr1 + arr2
        return self