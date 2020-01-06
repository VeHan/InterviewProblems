#
# @lc app=leetcode.cn id=155 lang=python
#
# [155] 最小栈
#

# @lc code=start
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.min_num_index = -1
        self.stack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack.append(x)
        if self.min_num_index == -1 or x < self.stack[self.min_num_index]:
            self.min_num_index = len(self.stack) - 1
        
    def pop(self):
        """
        :rtype: None
        """
        ret = None
        if self.stack:
            ret = self.stack[-1]
            del self.stack[-1]
            
            if self.min_num_index >= len(self.stack):
                self.min_num_index = -1
                if self.stack:
                    self.min_num_index = 0
                    min_num = self.stack[0]
                    for i, num in enumerate(self.stack):
                        if num < min_num:
                            min_num = num
                            self.min_num_index = i
                
        return ret
                    


        

    def top(self):
        """
        :rtype: int
        """
        ret = None
        if self.stack:
            ret = self.stack[-1]
        return ret
        

    def getMin(self):
        """
        :rtype: int
        """
        if self.min_num_index == -1:
            return None
        return self.stack[self.min_num_index]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

