public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Min-heap to keep track of top k elements with index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]
        );

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) pq.poll();
        }

        // Collect the top-k elements with their original indices
        List<int[]> topK = new ArrayList<>(pq);
        topK.sort(Comparator.comparingInt(a -> a[1])); // Maintain original order

        // Prepare result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }
        return result;
    }
}