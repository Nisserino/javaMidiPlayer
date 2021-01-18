package subfolder;

import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ControlLoop {
    private String[] menu = {"Play", "Stop", "Next", "Prev", "Show songs", "Song by number", "Quit"};

    private int getNumber(String[] options, Scanner sc){
        int num;
        for (int i = 0; i <= options.length -1; i++) {

            System.out.printf("%d: %s\n", i, options[i]);
        };

      
        try{
            num = sc.nextInt();
            if (num <= options.length - 1 && num >= 0){
                return num;
            }
            else{
                System.out.println("No.");
                return getNumber(options, sc);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("No.!");
            sc.nextLine();
            return getNumber(options, sc);
        }
        catch (NoSuchElementException e) {
            System.out.println("No.!");
            return getNumber(options, sc);
        }
    };

    public int loop(String[] options, Scanner sc){
        int value;
        value = getNumber(options, sc);
        return value;
    }

    private void menuActions(int action, BigSpeaker speaker, Scanner sc) {
        switch (action) {
            case 0: {
                speaker.playMusic();
                break;
            }
            case 1: {
                speaker.stopMusic();
                break;
            }
            case 2: {
                speaker.skipSong();
                break;
            }
            case 3: {
                speaker.prevSong();
                break;
            }
            case 4: {
                speaker.getSongs();
                break;
            }
            case 5: {
                speaker.songByNum(sc, this);
                break;
            }
            case 6: {
                System.exit(0);
                break;
            }
            default :{
                System.out.println("missed cases");
            }
        }
    }


    public void mainLoop(BigSpeaker speaker) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menuActions(loop(this.menu, sc), speaker, sc);
        }
        
    };
}
