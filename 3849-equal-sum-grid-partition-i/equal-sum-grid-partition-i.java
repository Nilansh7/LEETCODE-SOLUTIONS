class Solution {
    public boolean canPartitionGrid(int[][] grid){
        long sum = 0;
        for (int[] row : grid)
            for (int num : row)
                sum += num;
        if(sum % 2 != 0) return false;
        long target = sum / 2;
        long curr = 0;
        for (int[] row : grid) {
            long currRow = 0;
            for (int num : row) {
                currRow += num;
            }
            curr += currRow;
            if(curr == target) return true;
            if(curr > target) break;
        }
        
        curr = 0;
        for(int j = 0; j < grid[0].length; j++){
            long currCol = 0;
            for(int i = 0; i < grid.length; i++){
                currCol += grid[i][j];
            }
            curr += currCol;
            if(curr == target) return true;
            if(curr >= target) break;
        }
        return false;
    }
}