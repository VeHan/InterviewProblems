#
# @lc app=leetcode.cn id=1 lang=python
#
# [1] 两数之和
#

# @lc code=start
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        _dict = {}
        for i, num in enumerate(nums):
            if (target - num) in _dict:
                return [_dict[target - num], i]
            else:
                _dict[num] = i
        return []
# @lc code=end

