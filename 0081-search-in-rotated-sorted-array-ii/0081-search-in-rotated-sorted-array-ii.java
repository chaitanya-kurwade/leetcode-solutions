class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int i = l++;
            if(nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}