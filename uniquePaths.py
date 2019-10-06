//62. 不同路径
//Python
def uniquePaths(self, m: int, n: int) -> int:
    pre = [1] * n
    cur = [1] * n
    for i in range(1, m):
        for j in range(1, n):
            cur[j] = pre[j] + cur[j-1]
        pre = cur[:]
    return pre[-1]
