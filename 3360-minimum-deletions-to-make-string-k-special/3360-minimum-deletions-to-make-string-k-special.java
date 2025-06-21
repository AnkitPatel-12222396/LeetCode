class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs);
        int n = freqs.size();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int target = freqs.get(i);
            int deletions = 0;
            for (int j = 0; j < n; j++) {
                if (freqs.get(j) < target) {
                    deletions += freqs.get(j);
                } else if (freqs.get(j) > target + k) {
                    deletions += freqs.get(j) - (target + k);
                }
            }
            res = Math.min(res, deletions);
        }
        return res;
    }
}