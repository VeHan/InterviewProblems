# 解法一：双层循环，时间复杂度O(n^2)
# 解法二：双指针，第一个循环先把非零的数赋值好，第二个循环赋值剩下的0
```
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i, j = 0, 0
        for i in range(0, len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1
        while j < len(nums):
            nums[j] = 0       
            j += 1
                
```
# 解法三： 双指针滚雪球，碰到非零的数就交换
```
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i,j = 0,0
        for i in range(i, len(nums)):
            if nums[i] != 0:
                nums[j], nums[i] = nums[i], nums[j]
                j += 1
```
