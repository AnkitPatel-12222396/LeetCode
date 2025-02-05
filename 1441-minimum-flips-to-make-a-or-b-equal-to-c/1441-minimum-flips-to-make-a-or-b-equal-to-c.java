public class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1; // Get the i-th bit of a
            int bitB = (b >> i) & 1; // Get the i-th bit of b
            int bitC = (c >> i) & 1; // Get the i-th bit of c
            
            if (bitC == 0) {
                if (bitA == 1) flips++; // Flip bitA to 0
                if (bitB == 1) flips++; // Flip bitB to 0
            } else {
                if (bitA == 0 && bitB == 0) {
                    flips++; // Flip either a or b to 1
                }
            }
        }
        
        return flips;
    }
}
