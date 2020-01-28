#
# @lc app=leetcode.cn id=242 lang=python
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        _dict = {}
        for ch in s:
            count = _dict.get(ch, 0)
            count += 1
            _dict[ch] = count
        for ch in t:
            count = _dict.get(ch, 0)
            count -= 1
            _dict[ch] = count
        for k in _dict:
            if _dict[k] != 0:
                return False
        return True
        
# @lc code=end

