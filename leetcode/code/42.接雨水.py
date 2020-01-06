#
# @lc app=leetcode.cn id=42 lang=python
#
# [42] 接雨水
#

# @lc code=start
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 3: return 0

        left, right = 0, len(height) - 1 
        lmax, rmax = height[left], height[right]

        volumn = 0
        while left < right:
            lmax, rmax = max(lmax, height[left]), max(rmax, height[right])
            if lmax < rmax:
                volumn += (lmax - height[left])
                left += 1
            else:
                volumn += (rmax - height[right])
                right -= 1
        return volumn
            
# @lc code=end

