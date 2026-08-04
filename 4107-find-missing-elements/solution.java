class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[101];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            visited[num] = true;
        }
        for(int i=min; i<=max; i++) if(!visited[i]) result.add(i);
        return result;
    }
}