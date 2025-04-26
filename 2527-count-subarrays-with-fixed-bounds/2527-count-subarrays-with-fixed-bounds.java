public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minPos = -1, maxPos = -1, badPos = -1;
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                badPos = i;
            }
            if (nums[i] == minK) {
                minPos = i;
            }
            if (nums[i] == maxK) {
                maxPos = i;
            }
            count += Math.max(0, Math.min(minPos, maxPos) - badPos);
        }
        return count;
    }
}
