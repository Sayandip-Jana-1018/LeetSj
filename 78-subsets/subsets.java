class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> currentBag, int[] nums, int index) {
        result.add(new ArrayList<>(currentBag));
        for(int i=index; i<nums.length; i++) {
            currentBag.add(nums[i]);
            backtrack(result, currentBag, nums, i+1);
            currentBag.remove(currentBag.size()-1);
        }
    }
}