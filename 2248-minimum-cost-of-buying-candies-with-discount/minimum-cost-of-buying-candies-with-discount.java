class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length == 1) return cost[0];
        Arrays.sort(cost);
        int i, sum = 0;
        for(i = cost.length - 1; i > 0; i -= 3) {
            sum += cost[i] + cost[i - 1];
        }
        if (i == 0) sum += cost[0];
        return sum;
    }
}