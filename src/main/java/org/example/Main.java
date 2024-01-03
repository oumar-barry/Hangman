package org.example;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String wordToGuess = randomWord();
        System.out.println(" ===== HANGMAN ===== ");
        final int lifepoint = 10;
        GuessGame game = new GuessGame(wordToGuess, lifepoint);
        System.out.println("A vous de jouer !!! ");
        boolean playing = true;
        do {
            playIt(game);
            if(game.hasWon() || game.hasLost()){
                playing = false;
                System.out.println("Voulez vous rejouer : Oui / Non ?");
                char letter  = scanLetter();

                if(letter == 'O' || letter == 'o'){
                    wordToGuess = randomWord();
                    game = new GuessGame(wordToGuess,lifepoint);
                    System.out.println("A vous de jouer !!! ");
                    playing = true;

                } else {
                    System.out.println("Aurevoir !!!!");
                }

            }
        } while(playing);

    }

    public static String randomWord(){
        String[] words = "bonjour bonsoir manger partir".split(" ");
        return words[new Random().nextInt(words.length)];
    }

    public static void playIt(GuessGame game){
        while(true){
            System.out.println(game);
            char letter = scanLetter();
            if(game.guessLetter(letter)){
                System.out.println("bien joueé !!! ");

            } else {
                System.out.println("Oups raté  !!! ");

            }

            if(game.hasWon()){
                System.out.println("Bravo !!! ");
                System.out.println(game);
                break;
            }

            if (game.hasLost()){
                System.out.println("Vous avez perdu  ");
                System.out.println(game);
                break;
            }
        }
    }

    public static Character scanLetter(){
        char letter = ' ';
        do {
            String input = new Scanner(System.in).nextLine();
            if(input.length() == 1){
                letter = input.charAt(0);
            }
        } while(letter == ' ');
        return letter;
    }
}