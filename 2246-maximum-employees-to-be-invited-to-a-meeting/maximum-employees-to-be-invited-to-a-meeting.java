class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[favorite[i]]++;
        }

        boolean[] visited = new boolean[n];
        int[] chainLength = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            int fav = favorite[curr];
            chainLength[fav] = Math.max(chainLength[fav], chainLength[curr] + 1);
            if (--indegree[fav] == 0) {
                queue.add(fav);
            }
        }

        int maxCycle = 0;
        int chainSum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cycleLength = 0;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = favorite[curr];
                    cycleLength++;
                }
                if (cycleLength == 2) {
                    chainSum += cycleLength + chainLength[i] + chainLength[favorite[i]];
                } else {
                    maxCycle = Math.max(maxCycle, cycleLength);
                }
            }
        }

        return Math.max(maxCycle, chainSum);
    }
}
