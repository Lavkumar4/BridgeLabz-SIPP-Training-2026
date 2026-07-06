import java.util.Arrays;

class Athlete {
    String name;
    int score;

    String(name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " (" + score + ")";
    }
}

public class SportsMeetSorter {

    // 1. BUBBLE SORT (Descending Order)
    public static void bubbleSort(Athlete[] athletes) {
        int n = athletes.length;
        int totalSwaps = 0;
        boolean isAlreadySorted = true; // Best case flag

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                // For descending order, swap if the current score is less than the next
                if (athletes[j].score < athletes[j + 1].score) {
                    Athlete temp = athletes[j];
                    athletes[j] = athletes[j + 1];
                    athletes[j + 1] = temp;
                    
                    totalSwaps++;
                    swapped = true;
                    isAlreadySorted = false; // If a swap occurs, it wasn't pre-sorted
                }
            }
            // Optimization: If no two elements were swapped in the inner loop, break
            if (!swapped) {
                break;
            }
        }

        System.out.println("--- Bubble Sort Results ---");
        System.out.println("Total Swaps: " + totalSwaps);
        System.out.println("Was Array Already Sorted? " + isAlreadySorted);
    }

    // 2. INSERTION SORT (Descending Order)
    public static void insertionSort(Athlete[] athletes) {
        int n = athletes.length;
        int totalShifts = 0;

        for (int i = 1; i < n; i++) {
            Athlete key = athletes[i];
            int j = i - 1;

            // Shift elements that are smaller than the key to the right
            while (j >= 0 && athletes[j].score < key.score) {
                athletes[j + 1] = athletes[j];
                j--;
                totalShifts++;
            }
            athletes[j + 1] = key;
        }

        System.out.println("--- Insertion Sort Results ---");
        System.out.println("Total Shifts/Operations: " + totalShifts);
    }

    public static void main(String[] args) {
        // Simulating 50 athletes with scores
        Athlete[] athletesForBubble = new Athlete[50];
        Athlete[] athletesForInsertion = new Athlete[50];
        
        for (int i = 0; i < 50; i++) {
            int randomScore = (int) (Math.random() * 90) + 10; // Scores between 10 and 100
            athletesForBubble[i] = new Athlete("Athlete_" + (i + 1), randomScore);
        }
        // Clone the array to ensure an identical dataset for comparison
        System.arraycopy(athletesForBubble, 0, athletesForInsertion, 0, 50);

        // Run Bubble Sort
        bubbleSort(athletesForBubble);
        
        // Display Top 3 Medalists from the sorted Bubble Sort array
        System.out.println("\n🥇 Top 3 Medalists 🥇");
        System.out.println("Gold   : " + athletesForBubble[0]);
        System.out.println("Silver : " + athletesForBubble[1]);
        System.out.println("Bronze : " + athletesForBubble[2]);
        System.out.println("---------------------------\n");

        // Run Insertion Sort
        insertionSort(athletesForInsertion);
    }
}