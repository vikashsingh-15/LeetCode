class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * n
        ans = 1  # Initialize ans to 1 since the minimum LIS is always 1

        for i in range(1, n):
            maxx = 0
            for j in range(0, i):
                if nums[j] < nums[i]:
                    maxx = max(maxx, dp[j])

            dp[i] = maxx + 1
            ans = max(ans, dp[i])

        return ans
