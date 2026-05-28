class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> currentBag, int[] nums, boolean[] used) {
        if(currentBag.size() == nums.length) {
            result.add(new ArrayList<>(currentBag));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            currentBag.add(nums[i]);
            backtrack(result, currentBag, nums, used);
            currentBag.remove(currentBag.size() - 1);
            used[i] = false;
        }
    }
}