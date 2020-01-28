#
# @lc app=leetcode.cn id=49 lang=python
#
# [49] 字母异位词分组
#

# @lc code=start
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        _dict = {}
        for s  in strs:
           sorted_str = "".join(sorted(s))
           _dict[sorted_str] = _dict.get(sorted_str, []) + [s]
        return _dict.values()
# @lc code=end

