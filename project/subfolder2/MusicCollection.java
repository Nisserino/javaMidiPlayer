package subfolder2;
import java.io.File;
import java.io.IOException;


public class MusicCollection {

    public File[] midiFiles;
    public String[] songs;
    
    private void populate() {
        try {
            File dir = new File("./project/subfolder/songs/");
            int amount = dir.list().length;
            this.midiFiles = new File[amount];
            this.songs = new String[amount];
            int count = 0;
            for (File f: dir.listFiles()) {
                this.midiFiles[count] = f.getCanonicalFile();
                this.songs[count] = f.getName();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public MusicCollection() {
        populate();

    }
}
