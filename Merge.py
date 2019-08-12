import math
import random

def mergeSort(A, left, right):
    mid = (left+right)//2
    if left < right:
        mergeSort(A, left, mid)
        mergeSort(A, mid+1, right)
        merge( A, left, mid, right)

    return A

def merge(A, left, mid, right):
    tmp = []

    i = left
    j = mid+1

    while i <= mid and j <= right:
        if A[i] <= A[j]:
            tmp.append(A[i])
            i += 1
        else:
            tmp.append(A[j])
            j += 1


    while i < mid+1:
        tmp.append(A[i])
        i += 1

    while j <= right:
        tmp.append(A[j])
        j += 1

    #赋值
    for value in tmp:
        A[left] = value
        left +=1

if __name__ == '__main__':
    a = [6,2,3,-1,2342,1,3,4,2,2]
    lenght = len(a) - 1
    mergeSort(a, 0, lenght)
    print(a)
