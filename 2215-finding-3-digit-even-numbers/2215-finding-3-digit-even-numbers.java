class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new TreeSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int d1 = digits[i];
                    int d2 = digits[j];
                    int d3 = digits[k];

                    if (d1 == 0) continue;        // Skip leading zero
                    if (d3 % 2 != 0) continue;    // Must be even

                    int number = d1 * 100 + d2 * 10 + d3;
                    resultSet.add(number);
                }
            }
        }

        // Convert TreeSet to int[]
        int[] result = new int[resultSet.size()];
        int idx = 0;
        for (int num : resultSet) {
            result[idx++] = num;
        }
        return result;
    }
}