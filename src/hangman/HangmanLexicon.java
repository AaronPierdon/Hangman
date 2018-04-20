/*
 * Developers: Aaron Pierdon
 * Date: Apr 18, 2018
 * Description :
 * 
 */

package hangman;


public class HangmanLexicon {

    public int getWordCount(){
        return 10;
    }
    
    public String getWord(int index) throws Exception{
        switch(index){
            case 0: return "BUOY";
            case 1: return "MELODY";
            case 2: return "SEXY";
            case 3: return "PYROMANIAC";
            case 4: return "TRUE";
            case 5: return "SHUTTLE";
            case 6: return "IMPULSE";
            case 7: return "DIAMOND";
            case 8: return "SHIVA";
            case 9: return "PRESIDENT";
            default: throw new Exception("getWord: Illegal index");
        }
    }
}
