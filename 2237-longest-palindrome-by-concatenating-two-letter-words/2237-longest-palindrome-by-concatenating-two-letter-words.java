class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int length = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (String word : freq.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (!word.equals(rev)) {
                if (freq.containsKey(rev)) {
                    int pairCount = Math.min(freq.get(word), freq.get(rev));
                    length += pairCount * 4;
                    freq.put(word, freq.get(word) - pairCount);
                    freq.put(rev, freq.get(rev) - pairCount);
                }
            } else {
                int count = freq.get(word);
                length += (count / 2) * 4;
                if (count % 2 == 1) {
                    hasMiddle = true;
                }
            }
        }

        if (hasMiddle) {
            length += 2;
        }

        return length;
    }
}