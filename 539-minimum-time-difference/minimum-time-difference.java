class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> vec = new ArrayList<>();
        for (String timePoint : timePoints) {
            int h = Integer.parseInt(timePoint.substring(0, 2));
            int m = Integer.parseInt(timePoint.substring(3));
            int mins = h * 60 + m;
            vec.add(mins);
        }
        Collections.sort(vec);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < vec.size(); i++) {
            res = Math.min(vec.get(i) - vec.get(i - 1), res);
        }
        return Math.min(res, 1440 + vec.get(0) - vec.get(vec.size() - 1));
    }
}