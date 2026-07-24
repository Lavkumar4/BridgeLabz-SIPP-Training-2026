import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SensorPlacement {

    public List<List<String>> placeSensors(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] sensorCol = new int[n]; // sensorCol[row] stores column index for that row
        backtrack(n, 0, sensorCol, result);
        return result;
    }

    private void backtrack(int n, int row, int[] sensorCol, List<List<String>> result) {
        // Base Case: Successfully placed sensors in all N rows
        if (row == n) {
            result.add(buildGrid(n, sensorCol));
            return;
        }

        // Try placing a sensor in each column for the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, sensorCol)) {
                sensorCol[row] = col;                     // Choose
                backtrack(n, row + 1, sensorCol, result); // Explore
                // Implicit Un-choose: sensorCol[row] gets overwritten in next iteration
            }
        }
    }

    private boolean isSafe(int row, int col, int[] sensorCol) {
        for (int r = 0; r < row; r++) {
            // Check same column
            if (sensorCol[r] == col) return false;

            // Check both diagonals: |r1 - r2| == |c1 - c2|
            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row)) return false;
        }
        return true;
    }

    // Helper method to format the output grid
    private List<String> buildGrid(int n, int[] sensorCol) {
        List<String> grid = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] rowChars = new char[n];
            Arrays.fill(rowChars, '.');
            rowChars[sensorCol[r]] = 'S'; // 'S' represents a sensor
            grid.add(new String(rowChars));
        }
        return grid;
    }
}

/**

Row 0
                  /           /           \           \
             col=0       col=1             col=2       col=3
             /               \                 \           \
         Row 1              Row 1             ...         ...
       /   |   \   \        /  |  \  \
     c=0  c=1  c=2 c=3    c=0 c=1 c=2 c=3
      ❌   ❌   |   ❌     ❌  ❌  ❌  |
             [0,2]                     [1,3]
               |                         |
             Row 2                     Row 2
            /  |  \                   /  |  \
          c=0 c=1 c=3               c=0 c=2 c=3
           |   ❌  ❌                ❌  ❌  ❌ (Pruned)
         [0,2,0]
           |
         Row 3 -> No safe cols (Pruned)
		 /**