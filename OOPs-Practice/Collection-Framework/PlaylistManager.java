import java.util.LinkedList;

public class PlaylistManager {
    private LinkedList<String> recentlyPlayed = new LinkedList<>();
    private final int MAX_LIMIT = 10;

    // 1. Add song to the top of the playlist
    public void playSong(String song) {
        // If song already exists, remove it first so it can be re-added to the top
        if (recentlyPlayed.contains(song)) {
            recentlyPlayed.remove(song);
        }

        // 2. Add new song to the beginning
        recentlyPlayed.addFirst(song);

        // 3. Remove the oldest song (at the end) if limit is exceeded
        if (recentlyPlayed.size() > MAX_LIMIT) {
            recentlyPlayed.removeLast();
        }
        System.out.println("Now playing: " + song);
    }

    // 4. Search for a song
    public boolean searchSong(String song) {
        return recentlyPlayed.contains(song);
    }

    // 5. Display the history
    public void displayPlaylist() {
        System.out.println("\n--- Recently Played Songs ---");
        if (recentlyPlayed.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            for (int i = 0; i < recentlyPlayed.size(); i++) {
                System.out.println((i + 1) + ". " + recentlyPlayed.get(i));
            }
        }
    }

    public static void main(String[] args) {
        PlaylistManager engine = new PlaylistManager();

        // Simulate playing songs
        String[] songs = {"Song A", "Song B", "Song C", "Song D", "Song E", 
                          "Song F", "Song G", "Song H", "Song I", "Song J", "Song K"};

        for (String song : songs) {
            engine.playSong(song);
        }

        engine.displayPlaylist();
        
        System.out.println("\nSearching for 'Song C': " + (engine.searchSong("Song C") ? "Found" : "Not Found"));
    }
}