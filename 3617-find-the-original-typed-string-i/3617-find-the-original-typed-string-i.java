class Solution {
    public int possibleStringCount(String word) {
        List<int[]> groups = new ArrayList<>();
        int n = word.length(), i = 0;

        // Grouping characters
        while (i < n) {
            char ch = word.charAt(i);
            int j = i;
            while (j < n && word.charAt(j) == ch) j++;
            groups.add(new int[]{ch, j - i});
            i = j;
        }

        Set<String> possibleStrings = new HashSet<>();
        possibleStrings.add(word); // Original word is always valid

        // Try reducing each group (only one time per word)
        for (int idx = 0; idx < groups.size(); idx++) {
            int[] group = groups.get(idx);
            char ch = (char) group[0];
            int len = group[1];

            if (len >= 2) {
                for (int l = 1; l < len; l++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < groups.size(); k++) {
                        char c = (char) groups.get(k)[0];
                        int count = groups.get(k)[1];
                        if (k == idx) count = l;
                        for (int m = 0; m < count; m++) sb.append(c);
                    }
                    possibleStrings.add(sb.toString());
                }
            }
        }

        return possibleStrings.size();   
    }
}