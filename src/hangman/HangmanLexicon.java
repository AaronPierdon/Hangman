/*
 * Developers: Aaron Pierdon
 * Date: Apr 18, 2018
 * Description :
 * 
 */

package hangman;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;


public class HangmanLexicon {

    
    ArrayList<String> words;
    File wordSource;
    
    public HangmanLexicon(String url){
        words = new ArrayList<>();
        wordSource = new File(System.getProperty("user.home") + "\\desktop\\file.txt");
        iniLexicon(url);
    }
    
    private void iniLexicon(String urlStr){
        
        
        
        try{
            URL url = new URL(urlStr);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            FileOutputStream fis = new FileOutputStream(wordSource);
            byte[] buffer = new byte[1024];
            int count = 0;
            while((count = bis.read(buffer, 0, 1024)) != -1){
                fis.write(buffer, 0, count);
            }
            
            fis.close();
            bis.close();
                    
        FileReader fileReader = new FileReader(wordSource);
        BufferedReader buff = new BufferedReader(fileReader);
        
        String line;
        while((line = buff.readLine()) != null){
            words.add(line.toUpperCase());
        }
            
        }catch(Exception e){}


    }
    
    public int getWordCount(){
        return words.size();
    }
    
    public String getWord() throws Exception{
        int wordIndex = new Random().nextInt(words.size() - 1);
        
        return words.get(wordIndex);
    }
}
