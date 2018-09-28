/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangmanspring;

import com.sg.hangmanspring.dao.HangmanDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nstep
 */
@Controller
public class HangManController {

    char[] wrongLetters = new char[6];
    HangmanDao hangManWords = new HangmanDao();
    int numberOfGames = 0;
    int numberOfWrongGuesses = 0;
    int numberOfCorrectGuess = 0;
    int daoLetters = 0;
    String loserMessage = "";
    List<String> stringOfLetters = new ArrayList<>();
    List<String> lettersGuessed = new ArrayList<>();
    
    String word = new String();

    @PostMapping("/sendLetter")
    public String sendLetter(HttpServletRequest request) {

        
        
        char guessedLetter = request.getParameter("input").charAt(0);
        boolean isCorrect = false;
        for (int i = 0; i < word.length(); i++) {
            
            if (guessedLetter == word.charAt(i)) {
                numberOfCorrectGuess++;
               isCorrect = true;
                stringOfLetters.set(i, request.getParameter("input"));
                
            } 
        } 
        
        if(isCorrect == false ) {
            numberOfWrongGuesses++;
            lettersGuessed.add(request.getParameter("input"));
        }
        
       
        if(numberOfWrongGuesses == 6) {
            loserMessage = "You lost, and killed the dude, the word was " + word
                    + "click play again to play again" ;
            
            
            
        }
        
        return "redirect:/";
    }

    @GetMapping("/")
    public String getWord(Model model) {
        model.addAttribute("lettersGuessed", lettersGuessed);
        model.addAttribute("loserMessage", loserMessage);
        model.addAttribute("word", stringOfLetters);
        return "index";
    }

    @PostMapping("/word")
    public String postWord(HttpServletRequest request) {
        word = hangManWords.getWord();
        stringOfLetters = new ArrayList<>();
        for (int x = 0; x < word.length(); x++) {
            stringOfLetters.add("_ ");

        }
        return "redirect:/";
    }
}
