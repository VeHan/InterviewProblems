#
# @lc app=leetcode.cn id=11 lang=python
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left = 0
        right = len(height) - 1 
        max_result = 0

        while left < right:
            if height[left] < height[right]:
                max_result = max(max_result, (right - left) * height[left] )
                left += 1
            else:
                max_result = max(max_result, (right - left) * height[right] )
                right -= 1
        return max_result
        
# @lc code=end


