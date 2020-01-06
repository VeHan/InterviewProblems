#
# @lc app=leetcode.cn id=20 lang=python
#
# [20] 有效的括号
#

# @lc code=start
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        _dict = {'(': ')','{': '}','[': ']'}
        stack = []
        for ch in s:
            if stack and _dict.get(stack[-1]) == ch:
                del stack[-1]
            else:
                stack.append(ch)
        return len(stack) == 0

        
# @lc code=end

