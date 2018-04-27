/*
 * Developers: Aaron Pierdon
 * Date: Apr 19, 2018
 * Description :
 * 
 */

package hangman;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;



public class HangmanCanvas extends GCanvas{

    private static final int SCAFFOLD_HEIGHT = 360;
    private static final int BEAM_LENGTH = 144; 
    private static final int ROPE_LENGTH = 18; 
    private static final int HEAD_RADIUS = 36;
    private static final int BODY_LENGTH = 144;
    private static final int ARM_OFFSET_FROM_HEAD = 28;
    private static final int UPPER_ARM_LENGTH = 72;
    private static final int LOWER_ARM_LENGTH = 44;
    private static final int HIP_WIDTH = 36;
    private static final int LEG_LENGTH = 108;
    private static final int FOOT_LENGTH = 28;
    
    private int xStart, yStart;
    
    GLabel theWord;
    private String notedChars;
    
    public HangmanCanvas(){
        notedChars = "Incorect Guesses: ";
        theWord = new GLabel("");
        this.add(theWord, 210, 800);

    }
    
    public void reset(){

        xStart = 112;
        yStart = 90;
        
        
        GLine scaffold = new GLine(xStart,  yStart, xStart, yStart + 360);
        GLine beam = new GLine(xStart, yStart, xStart + 144, yStart);
        GLine rope = new GLine(xStart + 144, yStart, xStart + 144, yStart + 18);
        
        this.add(scaffold);
        this.add(beam);
        this.add(rope);

    }
    
    public void displayWord(String word){
        theWord.setLabel("The word so far " + word);
        
    }
    
    public void noteIncorrectGuess(char letter, int guessCount){
        notedChars += letter;
        
        GLabel label = new GLabel(notedChars);
        this.add(label, 210, 820);
        
        switch(guessCount){
            // Draw last foot
            case 0: {
                GLine foot = new GLine(xStart + 136, yStart + 100, xStart + 128, yStart + 100);
                this.add(foot);
            }
            
            // Draw foot
            case 1: {
                GLine foot = new GLine(xStart + 152, yStart + 100, xStart + 160, yStart + 100);
                this.add(foot);
            }
            
            // Draw leg
            case 2: {
                GLine leg = new GLine(xStart + 152, yStart + 70, xStart + 152, yStart + 100);
                this.add(leg);
            }
            
            // Draw leg
            case 3: {
                GLine leg = new GLine(xStart + 136, yStart + 70, xStart + 136, yStart + 100);
                this.add(leg);
            }
            
            // Draw Arm
            case 4: {
                GLine arm = new GLine(xStart + 144, yStart + 40, xStart + 124, yStart + 40);
                this.add(arm);
            }
            
            // Draw Arm
            case 5: {
                GLine arm = new GLine(xStart + 144, yStart + 40, xStart + 164, yStart + 40);
                this.add(arm);
            }
            
            //Draw torso
            case 6: {
                
                GLine body = new GLine(xStart + 144, yStart + 30, xStart + 144, yStart + 70);
                GLine hips = new GLine(xStart + 136, yStart + 70, xStart + 152, yStart + 70);
                this.add(body);
                this.add(hips);
            }
            
            // Draw head
            case 7: {
                GOval oval = new GOval(xStart + 138, yStart + 18, 12, 12);
                this.add(oval);

            }
        }
    }
    
    
    
    
}
