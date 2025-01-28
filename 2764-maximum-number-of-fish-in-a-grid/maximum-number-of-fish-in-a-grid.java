class Solution {
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j, visited));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        int fishCount = grid[row][col];

        fishCount += dfs(grid, row + 1, col, visited);
        fishCount += dfs(grid, row - 1, col, visited);
        fishCount += dfs(grid, row, col + 1, visited);
        fishCount += dfs(grid, row, col - 1, visited);

        return fishCount;
    }
}
