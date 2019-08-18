class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        """
        思路：使用Stack来保存每位数字，当遇到栈顶元素大于当前元素的时候，（左边大于右边），直接弹出栈顶元素
        特殊情况：删除完毕后全部为0
                 删除完毕后高位还有0
                 删除完毕后，字符串变为空
                 如果一个没有删除的话，直接删除后面k个
        """
        if len(num) == k:
            return '0'
        
        stack = list()
        for index, value in enumerate(num):
            #判断时候满足条件
            #1、栈不为空  2、栈顶元素大于当前元素  3、删除的元素个数
            while len(stack) != 0 and stack[-1] > value and k > 0:
                stack.pop()
                k -= 1
                
            stack.append(value)
            
        #特殊情况处理
        offest = 0
        while offest < len(stack) and stack[offest] == '0':
            offest+=1
            
        if offest == len(stack):
            return '0'
        
        #没有完全删除元素
        leng = len(stack)
        if k > 0:
            leng = leng - k
            
        #生成结果
        fin = stack[offest:leng]
        fin2 = [str(i) for i in fin]
        fin3 = ''.join(fin2)
        return fin3
        