/*
 * Developers: Aaron Pierdon
 * Date: Apr 19, 2018
 * Description :
 * 
 */

package hangman;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import java.awt.Dimension;
import java.awt.Graphics;



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
    
    
    public void reset(){

        int xStart = 112;
        int yStart = 90;
        
        
        GLine scaffold = new GLine(xStart,  yStart, xStart, yStart + 360);
        GLine beam = new GLine(xStart, yStart, xStart + 144, yStart);
        
        this.add(scaffold);
        this.add(beam);

    }
    
    public void displayWord(String word){
        System.out.println(this.getWidth());
    }
    
    public void notIncorrectGuess(char letter){
    
    }
    
    
    
    
}
