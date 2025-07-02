class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int possibleStringCount(String word, int k) {
        // STEP-1: Make runs array
        int n = word.length();
        List<Integer> runs = new ArrayList<>();
        runs.add(1);
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                runs.set(runs.size() - 1, runs.get(runs.size() - 1) + 1);
            } else {
                runs.add(1);
            }
        }
        
        // Step-2: Count total combinations
        int totalCombinations = 1;
        for (int freq : runs) {
            totalCombinations = (int)((long)totalCombinations * freq % MOD);
        }
        
        if (runs.size() >= k) {
            return totalCombinations;
        }
        
        // STEP-3: Count number of strings of different sizes formed by including all runs
        int[] count = new int[k];
        int[] newCount = new int[k];
        int[] prefixSum = new int[k];
        count[0] = 1; // 1 way to form an empty string by not including any character
        
        for (int freq : runs) {
            // Update PrefixSum array
            prefixSum[0] = count[0];
            for (int i = 1; i < k; ++i) {
                prefixSum[i] = (prefixSum[i - 1] + count[i]) % MOD;
            }
            
            // Make a new run
            for (int i = 1; i < k; ++i) {
                int right = prefixSum[i - 1];
                int left = 0;
                if (i - 1 - freq >= 0) {
                    left = prefixSum[i - 1 - freq];
                }
                newCount[i] = (right - left + MOD) % MOD;
            }
            
            // Swap count and newCount
            int[] temp = count;
            count = newCount;
            newCount = temp;
            // Reset newCount to 0
            Arrays.fill(newCount, 0);
        }
        
        int invalidCombinations = 0;
        for (int i = 0; i < k; ++i) {
            invalidCombinations = (invalidCombinations + count[i]) % MOD;
        }
        
        return (totalCombinations - invalidCombinations + MOD) % MOD;
    }
}