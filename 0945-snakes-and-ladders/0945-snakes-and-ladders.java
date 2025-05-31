class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] moves = new int[n * n];
        Arrays.fill(moves, -1);

        // Flatten the board
        int idx = 0;
        boolean leftToRight = true;
        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    moves[idx++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    moves[idx++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.offer(0); // start from square 1 (index 0)
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n * n - 1) return steps;

                for (int i = 1; i <= 6 && curr + i < n * n; i++) {
                    int next = curr + i;
                    if (moves[next] != -1) {
                        next = moves[next] - 1;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}