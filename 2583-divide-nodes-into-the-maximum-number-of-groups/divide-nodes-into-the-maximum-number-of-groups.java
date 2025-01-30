import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, 0);
        
        int result = 0;
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(graph, color, i, component)) {
                    return -1;
                }
                result += findMaxGroups(graph, component);
            }
        }
        
        return result;
    }

    private boolean isBipartite(List<List<Integer>> graph, int[] color, int start, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int findMaxGroups(List<List<Integer>> graph, List<Integer> component) {
        int maxGroups = 0;
        for (int node : component) {
            maxGroups = Math.max(maxGroups, bfsDepth(graph, node));
        }
        return maxGroups;
    }

    private int bfsDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
