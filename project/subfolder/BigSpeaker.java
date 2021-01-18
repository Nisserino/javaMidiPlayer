package subfolder;

import java.util.Scanner;

import subfolder2.MusicCollection;

public class BigSpeaker extends MusicCollection implements Speaker {
    private Player player = new Player();
    public int song = 0; // song currently playing
    private Thread thread = new Thread(this.player);
    private boolean ran = false; //check to see if thread started

    public void getSongs() {
        System.out.println("Songs\n");
        for (int i = 0; i < this.midiFiles.length; i++) {
            if (i == this.song) {
                System.out.println(i + ": " + this.songs[i] + "*");
            }
            else {
                System.out.println(i + ": " +this.songs[i]);
            }
        }
        System.out.println("");
    }
    
    public void songByNum(Scanner sc, ControlLoop cl) {
        this.song = cl.loop(this.songs, sc);
        stopMusic();
        playMusic();
    }

    @Override
    public void playMusic() {
        this.player.song = this.midiFiles[this.song];
        if (this.ran) {
            this.player.playMusic();
        }
        else {
            this.ran = true;
            this.thread.start();
        }
        
    }

    @Override
    public void stopMusic() {
        if (this.ran) {
        this.player.stop();
        }
    }


    @Override
    public void prevSong() {
        if (this.song <= 0) {
            System.out.println("This is the first song");
        } else {
            this.song -= 1;
        }
        stopMusic();
        playMusic();
    }

    @Override
    public void skipSong() {
        if (this.song >= this.midiFiles.length -1) {
            System.out.println("This was the last song");
        } else {
            this.song += 1;
        }
        stopMusic();
        playMusic();
    }


    public BigSpeaker() {

    }

}
