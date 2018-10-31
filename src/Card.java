package memorycard;

import java.util.Random;
import java.util.ArrayList;

public class Card {
    private char letter;
    private boolean exposed = false;

    public Card(char letter) {
        this.letter = letter;
    }

    public char get() {
      return exposed ? "-".charAt(0) : this.letter;
    }

    public void expose() {
      this.exposed = true;
    }

    public boolean isExposed() {
      return this.exposed;
    }

    public boolean equals(Card c) {
      return this.letter == c.letter;
    }

    public static Card generateRandom(ArrayList<Card> existingCards) {
      String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      ArrayList<Character> existingLetters = getLettersFromCards(existingCards);
      char randomLetter = 'A';

      while (existingLetters.contains(randomLetter)) {
        Random r = new Random();
        randomLetter = alphabet.charAt(r.nextInt(alphabet.length()));
      }

      return new Card(randomLetter);
    }

    public static ArrayList<Character> getLettersFromCards(ArrayList<Card> cards) {
      ArrayList<Character> letters = new ArrayList<Character>();

      for (Card c : cards) {
        letters.add(c.get());
      }

      return letters;
    }
}
