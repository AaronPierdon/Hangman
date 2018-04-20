/*
 * Developers: Aaron Pierdon
 * Date: Apr 19, 2018
 * Description :
 * 
 */

package hangman;

import acm.graphics.GRect;
import acm.program.ConsoleProgram;
import java.awt.Dimension;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.control.SplitPane;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.JSplitPane;






public class HangmanProgram extends ConsoleProgram{

    private HangmanCanvas canvas;
    final HangmanLexicon WORDS = new HangmanLexicon();
    String theWord;
    String incompleteWord;
    int guessCount;

    
    public void startGame(){
        theWord = getWord();
        if(theWord.length() > 0){
            
            init();
        
            // Set up guess counter
            guessCount = 8;
            startGame(theWord);
            
        } else
            System.exit(0);
    }
    
    @Override
    public void init(){
        JFrame frame = new JFrame();
        frame.setSize(1024, 900);
        canvas = new HangmanCanvas();
        add(canvas);
        canvas.reset();
        frame.add(this);
        frame.setVisible(true);
        this.setVisible(true);
        canvas.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.displayWord("Goola");
        
    }
    
    @Override
    public void run(){
        
    }
    
    public String getWord(){
        
        try{
            return WORDS.getWord(new Random().nextInt(9));
        
        }catch(Exception e){
            
            this.println("Error finding a word. Closing program...");
        }
        
        return "";
    }
    
    public void startGame(String theWord){
        // Welcome message

        
        this.println("Hello! This is a word-guessing game called hangman.\n"
                + "You will need to replace all dashes with letters. Each letter you guess correctly"
                + " will be displayed in the word.");
        
        
        incompleteWord = new String();
        
        // Generate dashes
        for(int numOfDashes = theWord.length(); numOfDashes > 0; numOfDashes--){
            incompleteWord += "-";
        }
        

        
        
        String guess = new String();
        
        
        while(guessCount > 0 && incompleteWord.contains("-")){
            
            guess = getGuess();
            
            
            // Don't progress until only one letter has been input
            while(guess.length() != 1){ 
               this.println("Please just input one letter.");
                guess = getGuess();

            }

            processGuess(guess);

            
        }
        
        if(!incompleteWord.contains("-"))
            this.println("You win");
        else if(incompleteWord.contains("-") && guessCount <= 0)
            this.println("You lose");
        
    }
    
    public  String getGuess(){
                this.println("You have " + guessCount + " remaining.");
                this.println("The word so far is: " + incompleteWord);
                this.print("Your guess: ");
                return this.readLine();
    }
    
    public  void processGuess(String guess){
        guess = guess.toUpperCase();
        char charGuess = guess.charAt(0);
        
        if(!incompleteWord.contains(guess) && theWord.contains(guess)){
            uncoverLetters(charGuess);
            
        }else if(!theWord.contains(guess)){
            guessCount--;
        
        }
    }
    
    public  void uncoverLetters(char charGuess){
        char[] incompleteChars = incompleteWord.toCharArray();
        
        for(int counter = theWord.length(); counter > 0; counter--){
            if(theWord.charAt(counter - 1) == charGuess){
                incompleteChars[counter - 1] = charGuess;
            }
        }
        
        incompleteWord = new String(incompleteChars);
    }
    
}


