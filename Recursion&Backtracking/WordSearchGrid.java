public class WordSearchGrid {

    public boolean exists(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Try starting the search from every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(grid, word, 0, r, c, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] grid, String word, int idx, int r, int c, boolean[][] visited) {
        // Base Case 1: Entire word successfully matched
        if (idx == word.length()) {
            return true;
        }

        // Base Case 2: Out of bounds check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }

        // Base Case 3: Cell already visited in current path OR character mismatch
        if (visited[r][c] || grid[r][c] != word.charAt(idx)) {
            return false;
        }

        // 1. Choose: Mark cell as visited
        visited[r][c] = true;

        // 2. Explore: Try all 4 directions (Down, Up, Right, Left)
        boolean found = backtrack(grid, word, idx + 1, r + 1, c, visited)
                     || backtrack(grid, word, idx + 1, r - 1, c, visited)
                     || backtrack(grid, word, idx + 1, r, c + 1, visited)
                     || backtrack(grid, word, idx + 1, r, c - 1, visited);

        // 3. Un-choose (Backtrack): Reset visited state for future paths
        visited[r][c] = false;

        return found;
    }
}

/**

(r, c) = 'E' [idx=0]
                           visited[r][c] = true
                                    |
            +-----------------------+-----------------------+
            |                       |                       |
       (r+1, c) 'R'            (r-1, c) 'X'            (r, c+1) 'R'
      [idx=1, Match]         [idx=1, Mismatch]       [idx=1, Match]
     visited[r+1][c]=true          ❌ Return               ...
            |
    +-------+-------+
    |               |
(r+2, c) 'R'    (r+1, c+1) 'A'
[idx=2, Match]  [idx=2, Mismatch]
    |               ❌ Return
    v
Base Case: idx == 3 
      ✅ TRUE
	  /**