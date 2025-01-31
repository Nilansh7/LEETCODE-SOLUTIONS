import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2;
        int maxIsland = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSize.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    int newSize = 1;

                    for (int[] dir : new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}}) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            uniqueIslands.add(grid[ni][nj]);
                        }
                    }

                    for (int id : uniqueIslands) {
                        newSize += islandSize.get(id);
                    }
                    
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int size = 1;

        size += dfs(grid, i + 1, j, id);
        size += dfs(grid, i - 1, j, id);
        size += dfs(grid, i, j + 1, id);
        size += dfs(grid, i, j - 1, id);

        return size;
    }
}
