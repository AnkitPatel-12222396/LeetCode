class Solution {
    private int tryRotationMatching(int number, int[] first, int[] second) {
        int count = 0;
        for (int i = 0; i < first.length; ++i) {
            if (first[i] == number) continue;
            else if (second[i] == number) count++;
            else return Integer.MAX_VALUE;
        }
        return count;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotations = Integer.MAX_VALUE;
        for (int number = 1; number <= 6; number++) {
            int countTops = tryRotationMatching(number, tops, bottoms);
            int countBottoms = Integer.MAX_VALUE;
            if (countTops != Integer.MAX_VALUE) {
                countBottoms = tryRotationMatching(number, bottoms, tops);
            }
            minRotations = Math.min(minRotations, Math.min(countTops, countBottoms));
        }
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;  
    }
}