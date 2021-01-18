package subfolder;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Player implements Runnable {
    public File song;
    private boolean playing;
    private boolean pause = false;

    Sequencer sequencer;

    Player() {
    }

    @Override
    public void run() {
        this.playing = true; // might remove and use while(true);

        while (playing) {
            while (!this.pause) {
                play(this.song);

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stop() {
        this.pause = true;
        this.sequencer.stop();
    }

    public void playMusic() {
        this.pause = false;
    }

    public void play(File song) {
        try {
            this.sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (this.sequencer==null) {
                System.err.println("this.sequencer device not supported");
                return;
            } 
            this.sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(this.song);
                this.sequencer.setSequence(sequence); // load it into this.sequencer
                this.sequencer.start();  // start the playback

                while (true) {
                    if (!this.sequencer.isRunning()) {
                        this.sequencer.stop();
                        break;
                    
                }

            }
        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
