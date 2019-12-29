18. [四数之和](https://leetcode-cn.com/problems/4sum)  
解题思路：双指针往中间夹  
练习次数：✅12.29

560. [和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)  
解题思路：  
(1) 双层循环 O(n^2) 可能会超出时间限制  
(2) sum[j] - sum[i] = sum[i-j]，sum数组为累加结果的序列。用map存储(sum, sum_count)，sum_count为累加结果为sum出现的次数。 O(n)  
练习次数: ✅12.29

283. [移动零](https://leetcode-cn.com/problems/move-zeroes/submissions/)
解题思路: 

