package org.example;
import java.util.ArrayList;
import java.util.List;

public class GuessGame {
    private List<Character> secretWord = new ArrayList<>();
    private List<Character> guessWord = new ArrayList<>();
    private int lifepoint;
    public GuessGame(String wordToGuess, int lifepoint) {
        for(char c : wordToGuess.toCharArray()){
            this.secretWord.add(c);
        }

        this.lifepoint = lifepoint;
        for(int i = 1; i <= wordToGuess.length(); i++){
            this.guessWord.add('_');
        }

    }

    @Override
    public String toString(){
        return "\n Vies : " + lifepoint + " \n Mot : " + guessWord;
    }

    public boolean hasWon() {
        return !this.guessWord.contains('_');
    }

    public boolean hasLost(){
        return lifepoint <= 0;
    }

    public boolean guessLetter(char letter) {
        int index = 0;
        if(secretWord.contains(letter) && !guessWord.contains(letter)){
            for(char c : secretWord){
                if(c == letter){
                    this.guessWord.set(index, letter);
                }
                index++;
            }
            return true;
        } else {
            lifepoint--;
            return false;
        }
    }


}
