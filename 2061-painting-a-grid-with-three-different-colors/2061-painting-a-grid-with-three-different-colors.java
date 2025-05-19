class Solution {
    static final int MOD = 1_000_000_007;
    static List<int[]> validStates = new ArrayList<>();
    static Map<String, Integer> stateIndex = new HashMap<>();
    static List<Integer>[] transitions;

    public int colorTheGrid(int m, int n) {
        validStates.clear();
        stateIndex.clear();

        generateStates(m, new int[m], 0);

        int k = validStates.size();
        transitions = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (isCompatible(validStates.get(i), validStates.get(j))) {
                    transitions[i].add(j);
                }
            }
        }

        int[] dp = new int[k];
        Arrays.fill(dp, 1);  // First column

        for (int col = 1; col < n; col++) {
            int[] newDp = new int[k];
            for (int i = 0; i < k; i++) {
                for (int j : transitions[i]) {
                    newDp[j] = (newDp[j] + dp[i]) % MOD;
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int val : dp) result = (result + val) % MOD;
        return result;
    }

    private void generateStates(int m, int[] current, int index) {
        if (index == m) {
            validStates.add(Arrays.copyOf(current, m));
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (index == 0 || current[index - 1] != color) {
                current[index] = color;
                generateStates(m, current, index + 1);
            }
        }
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}