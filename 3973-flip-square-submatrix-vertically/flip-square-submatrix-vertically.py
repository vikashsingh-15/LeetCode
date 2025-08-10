class Solution:
    def reverseSubmatrix(self, grid: List[List[int]], x: int, y: int, k: int) -> List[List[int]]:
        for i in range(k // 2):  # Only need to go halfway
            top_row = x + i
            bottom_row = x + (k - 1 - i)
            
            for j in range(k):
                col = y + j
                grid[top_row][col], grid[bottom_row][col] = grid[bottom_row][col], grid[top_row][col]
        
        return grid

        