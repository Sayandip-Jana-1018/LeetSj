class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> currentBag, int[] nums, int index) {
        result.add(new ArrayList<>(currentBag));
        for(int i = index; i<nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue; // Skip this one, but keep the loop going!
            }
            currentBag.add(nums[i]);
            backtrack(result, currentBag, nums, i+1);
            currentBag.remove(currentBag.size() - 1);
        }
    }
}