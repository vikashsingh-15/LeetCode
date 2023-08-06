//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][]) {
        int N = grid.length;
        return solveSudokuUtil(grid, N);
    }

    // Helper function to solve Sudoku using backtracking.
    static boolean solveSudokuUtil(int grid[][], int N) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Find the first empty cell (cell with value 0).
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // If there is no empty cell, the Sudoku is solved.
        if (isEmpty) {
            return true;
        }

        // Try all digits from 1 to 9 in the empty cell.
        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                // If placing the current number in the cell is safe, update the grid.
                grid[row][col] = num;

                // Recursively try to solve the remaining Sudoku.
                if (solveSudokuUtil(grid, N)) {
                    return true;
                }

                // If the current placement doesn't lead to a solution,
                // backtrack and try the next number.
                grid[row][col] = 0;
            }
        }

        // No solution found for the current configuration.
        return false;
    }

    // Helper function to check if it's safe to place 'num' at position (row, col).
    static boolean isSafe(int grid[][], int row, int col, int num) {
        int N = grid.length;

        // Check if 'num' is not present in the current row and column.
        for (int i = 0; i < N; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }

        // Check if 'num' is not present in the current 3x3 subgrid.
        int subgridStartRow = row - row % 3;
        int subgridStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[subgridStartRow + i][subgridStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
