import java.util.LinkedList;

class MusicPlaylist {
    private LinkedList<String> history = new LinkedList<>();
    private final int MAX_LIMIT = 10;

    // 1 & 2. Add song to the beginning
    public void playSong(String songName) {
        // अगर गाना पहले से है, तो उसे हटाकर आगे ले आएं (optional improvement)
        history.remove(songName);

        // गाना शुरुआत में जोड़ें
        history.addFirst(songName);

        // 3. Remove oldest if size > 10
        if (history.size() > MAX_LIMIT) {
            String removed = history.removeLast();
            System.out.println("⚠️ Limit reached. Removed oldest song: " + removed);
        }
        System.out.println("▶️ Playing: " + songName);
    }

    // 4. Search for a song
    public void searchSong(String songName) {
        if (history.contains(songName)) {
            System.out.println("🔍 Found: '" + songName + "' is in your recent history.");
        } else {
            System.out.println("❌ '" + songName + "' not found in recent history.");
        }
    }

    // 5. Display history
    public void displayHistory() {
        System.out.println("\n--- Recently Played (Top 10) ---");
        if (history.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
        System.out.println("--------------------------------\n");
    }
}

public class MusicApp {
    public static void main(String[] args) {
        MusicPlaylist myPlaylist = new MusicPlaylist();

        // Adding songs
        myPlaylist.playSong("Shape of You");
        myPlaylist.playSong("Blinding Lights");
        myPlaylist.playSong("Levitating");
        
        // Display history
        myPlaylist.displayHistory();
        
        // Search
        myPlaylist.searchSong("Shape of You");
    }
}