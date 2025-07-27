class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        // If array has only one element
        if (n == 1) {
            return nums[0];
        }
        // Checking the first element
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        // Checking the last element
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // Check if nums[mid] is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            /* If the first occurrence of a pair is at an even index,
                and the second occurrence is at an odd index, then the single element
                is to the right of this pair.
                Example: [1,1,2,2,3,4,4]
                Indices:  0,1,2,3,4,5,6
                If mid is at an even index (e.g., 2 for '2'), and nums[mid] == nums[mid+1],
                it means the single element is to the right.
            */
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                /* If mid is even and matches (mid+1), or mid is odd and matches (mid-1),
                    it means we are in the "left part" where pairs are correctly formed.
                    The single element must be on the right.
                */
                l = mid + 1;
            } else {
                /* Otherwise, we are in the "right part" where a pair is broken,
                    or mid itself could be the single element (already checked above).
                    The single element must be on the left (including mid).
                */
                r = mid - 1;
            }
        }
        return -1;
    }
}
