class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        songs = new String[capacity];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count++] = song;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(p.getSongs()[0]); // still Song A
        System.out.println(p.getSongCount()); // 2
    }
}