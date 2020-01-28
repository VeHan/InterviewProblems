1. [18.四数之和](https://leetcode-cn.com/problems/4sum)  
解题思路：双指针往中间夹  
练习次数：✅12.29

2. [560.和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)  
解题思路：  
(1) 双层循环 O(n^2) 可能会超出时间限制  
(2) sum[j] - sum[i] = sum[i-j]，sum数组为累加结果的序列。用map存储(sum, sum_count)，sum_count为累加结果为sum出现的次数。 O(n)  
练习次数: ✅12.29

3. [283.移动零](https://leetcode-cn.com/problems/move-zeroes/submissions/)  
[解题思路](leetcode/leetcode_238.md)  
练习次数：✅12.29

4. [11.盛水最多的容器]()
[解题思路] 夹逼法
练习次数：✅2019.12.31

5. [42.接雨水]
[解题思路](leetcode/code/42.接雨水.py)   夹逼法
练习次数：✅2019.12.30

# 栈
1. [20.有效的括号](https://leetcode-cn.com/problems/valid-parentheses)  
[解题思路](leetcode/code/20.有效的括号.py) 使用栈匹配括号  
练习次数：✅2020.1.20  

2. [155.最小栈](https://leetcode-cn.com/problems/min-stack/)
[解题思路]  
[解法一](leetcode/code/155.最小栈.py) 每次push和pop求一次最小值，效率低一点 
[解法二](leetcode/code/155.最小栈_解法2.py)辅助栈法，创建一个辅助栈专门来放最小值

3. [84]


# 哈希表、映射、集合
1. [242.有效的异位词](https://leetcode-cn.com/problems/valid-anagram/)
[解题] (leetcode/code/242.有效的异位词.py) 字典
练习次数: ✅2020.1.28

2. [49.字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
[解题] (leetcode/code/49.字母异位词分组.py)
练习次数: ✅2020.1.28

3. [1.两数之和](https://leetcode-cn.com/problems/two-sum/description/)
[解题] (leetcode/code/1.两数只和.py)