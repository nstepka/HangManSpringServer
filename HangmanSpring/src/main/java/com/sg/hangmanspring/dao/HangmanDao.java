/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hangmanspring.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nstep
 */
public class HangmanDao {

    List<String> wordsToGuess = new ArrayList<String>();
     
    public void wordsToGuess() {
    wordsToGuess.add("phones");
    wordsToGuess.add("arrays");
    wordsToGuess.add("carrot");
    
    }     
            
   public String getWord() {
       return "arrays";
       
   }
    
}
