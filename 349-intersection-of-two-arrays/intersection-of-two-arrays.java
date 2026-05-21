class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int num: nums1) set1.add(num);

        List<Integer> array = new ArrayList<>();
        for(int num: nums2) {
            if(set1.contains(num)) {
                array.add(num);
                set1.remove(num);
            }
        }
        int[] result = new int[array.size()];
        for(int i=0; i<array.size(); i++) {
            result[i] = array.get(i);
        }
        return result;
    }
}