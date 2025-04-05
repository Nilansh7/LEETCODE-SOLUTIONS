class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0];
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (canPlace(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canPlace(int[] position, int m, int minDist) {
        int count = 1, last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= minDist) {
                count++;
                last = position[i];
            }
        }
        return count >= m;
    }
}
