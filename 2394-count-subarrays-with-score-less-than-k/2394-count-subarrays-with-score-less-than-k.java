class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0, right = 0;    // window is [left, right)
        long sum = 0;               // sum of nums[left..right-1]
        long count = 0;

        while (left < n) {
            // Extend right as far as valid
            while (right < n && (sum + nums[right]) * (right - left + 1) < k) {
                sum += nums[right++];
            }

            // All subarrays starting at left and ending before right are valid
            count += right - left;

            // Slide window forward
            if (right == left) {
                // Couldn't include nums[left] at all
                right++;
            } else {
                sum -= nums[left];
            }
            left++;
        }

        return count;
    }
}