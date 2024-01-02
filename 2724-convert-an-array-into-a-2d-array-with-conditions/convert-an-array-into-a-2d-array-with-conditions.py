class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        result = []
        index_map = {}

        max_freq = 0
        for num in nums:
            index_map[num] = index_map.get(num, 0) + 1
            max_freq = max(max_freq, index_map[num])

        # Initialize the result list with empty lists
        for i in range(max_freq):
            result.append([])

        # Iterate over the keys of the index_map
        for key in index_map.keys():
            value = index_map[key]

            # Add the key to the corresponding rows in the result list
            while value > 0:
                result[value - 1].append(key)
                value -= 1

        return result 
        