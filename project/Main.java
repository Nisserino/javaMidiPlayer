

import subfolder.*;
// could I just extend excercise.subfolder.main?
public class Main {
    
    public static void main(String[] args) {
        ControlLoop CL = new ControlLoop();
        BigSpeaker speaker = new BigSpeaker();
        //print welcome message
        
        
        CL.mainLoop(speaker);
    }
}
