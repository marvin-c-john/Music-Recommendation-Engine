import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;


public class SongRepository {

    HashMap<String, Song> songs = new HashMap<>();
    VectorService vectorService = new VectorService();

    public SongRepository() {
        addSong(new Song("Snooze", "SZA", Genre.RNB, 0.45, 0.55, 0.70, 78, 0.65, 0.10));
        addSong(new Song("Good Days", "SZA", Genre.RNB, 0.50, 0.60, 0.80, 90, 0.55, 0.05));
        addSong(new Song("Broken Clocks", "SZA", Genre.RNB, 0.55, 0.65, 0.75, 95, 0.45, 0.08));
        addSong(new Song("Saturn", "SZA", Genre.RNB, 0.40, 0.50, 0.85, 72, 0.70, 0.15));
        addSong(new Song("Nobody Gets Me", "SZA", Genre.RNB, 0.35, 0.40, 0.90, 68, 0.75, 0.05));

        addSong(new Song("Session 32", "Summer Walker", Genre.RNB, 0.30, 0.45, 0.80, 70, 0.80, 0.05));
        addSong(new Song("Girls Need Love", "Summer Walker", Genre.RNB, 0.55, 0.70, 0.75, 98, 0.40, 0.10));
        addSong(new Song("Playing Games", "Summer Walker", Genre.RNB, 0.50, 0.65, 0.70, 92, 0.45, 0.08));
        addSong(new Song("Come Thru", "Summer Walker", Genre.RNB, 0.45, 0.60, 0.85, 85, 0.50, 0.12));
        addSong(new Song("Body", "Summer Walker", Genre.RNB, 0.60, 0.80, 0.65, 100, 0.35, 0.05));

        addSong(new Song("The Color Violet", "Tory Lanez", Genre.RNB, 0.65, 0.70, 0.75, 110, 0.30, 0.10));
        addSong(new Song("Lady Of Namek", "Tory Lanez", Genre.RNB, 0.60, 0.75, 0.70, 108, 0.35, 0.08));
        addSong(new Song("Hurts Me", "Tory Lanez", Genre.RNB, 0.50, 0.55, 0.80, 80, 0.60, 0.05));
        addSong(new Song("Say It", "Tory Lanez", Genre.RNB, 0.55, 0.65, 0.78, 95, 0.45, 0.07));
        addSong(new Song("LUV", "Tory Lanez", Genre.RNB, 0.70, 0.85, 0.60, 105, 0.40, 0.05));

        addSong(new Song("Under The Influence", "Chris Brown", Genre.RNB, 0.80, 0.85, 0.70, 115, 0.35, 0.05));
        addSong(new Song("No Guidance", "Chris Brown", Genre.RNB, 0.75, 0.80, 0.72, 98, 0.40, 0.05));
        addSong(new Song("Back To Sleep", "Chris Brown", Genre.RNB, 0.60, 0.70, 0.68, 85, 0.50, 0.08));
        addSong(new Song("Take You Down", "Chris Brown", Genre.RNB, 0.55, 0.60, 0.75, 90, 0.45, 0.05));
        addSong(new Song("With You", "Chris Brown", Genre.RNB, 0.50, 0.55, 0.85, 88, 0.55, 0.05));

        addSong(new Song("Don't", "Bryson Tiller", Genre.RNB, 0.45, 0.60, 0.80, 75, 0.65, 0.05));
        addSong(new Song("Exchange", "Bryson Tiller", Genre.RNB, 0.50, 0.65, 0.78, 80, 0.60, 0.05));
        addSong(new Song("Right My Wrongs", "Bryson Tiller", Genre.RNB, 0.40, 0.50, 0.88, 70, 0.70, 0.08));
        addSong(new Song("Sorrows", "Bryson Tiller", Genre.RNB, 0.35, 0.45, 0.90, 68, 0.75, 0.05));
        addSong(new Song("Whatever She Wants", "Bryson Tiller", Genre.RNB, 0.60, 0.75, 0.65, 95, 0.50, 0.05));

        addSong(new Song("Call Out My Name", "The Weeknd", Genre.RNB, 0.50, 0.55, 0.90, 72, 0.60, 0.05));
        addSong(new Song("Die For You", "The Weeknd", Genre.RNB, 0.55, 0.60, 0.88, 80, 0.55, 0.05));
        addSong(new Song("After Hours", "The Weeknd", Genre.RNB, 0.65, 0.70, 0.80, 95, 0.50, 0.05));
        addSong(new Song("Earned It", "The Weeknd", Genre.RNB, 0.60, 0.65, 0.85, 85, 0.45, 0.05));
        addSong(new Song("Often", "The Weeknd", Genre.RNB, 0.70, 0.75, 0.75, 100, 0.40, 0.05));

        addSong(new Song("Location", "Khalid", Genre.RNB, 0.45, 0.60, 0.80, 90, 0.55, 0.05));
        addSong(new Song("Better", "Khalid", Genre.RNB, 0.50, 0.65, 0.78, 92, 0.50, 0.05));
        addSong(new Song("Talk", "Khalid", Genre.RNB, 0.55, 0.70, 0.75, 100, 0.45, 0.05));
        addSong(new Song("Young Dumb & Broke", "Khalid", Genre.RNB, 0.65, 0.80, 0.70, 105, 0.35, 0.05));
        addSong(new Song("Saved", "Khalid", Genre.RNB, 0.40, 0.55, 0.85, 85, 0.60, 0.05));

        addSong(new Song("Best Part", "Daniel Caesar", Genre.RNB, 0.35, 0.50, 0.92, 70, 0.80, 0.05));
        addSong(new Song("Get You", "Daniel Caesar", Genre.RNB, 0.45, 0.60, 0.88, 78, 0.65, 0.05));
        addSong(new Song("Japanese Denim", "Daniel Caesar", Genre.RNB, 0.40, 0.55, 0.90, 72, 0.75, 0.05));
        addSong(new Song("Always", "Daniel Caesar", Genre.RNB, 0.30, 0.45, 0.95, 65, 0.85, 0.05));
        addSong(new Song("Valentina", "Daniel Caesar", Genre.RNB, 0.50, 0.65, 0.80, 90, 0.60, 0.05));
    }


    public void addSong(Song song){
        songs.put(song.getId(), song);
        song.setVector(vectorService.toVector(song));
    }

    public void delete(Song song){
        songs.remove(song.getId());
    }

    public ArrayList<Song> getAllSongs(){
        return new ArrayList<>(songs.values());
    }

    public Song getRandomSong(){
        List<Song> list = new ArrayList<>(songs.values());
        Collections.shuffle(list);
        return list.getFirst();

    }


}
