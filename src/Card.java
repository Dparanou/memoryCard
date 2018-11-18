/*
 * Η κλάση Card δημιουργεί μια κάρτα με ένα χαρακτηριστικό γράμμα της αγγλικής αφλαβήτου, ελέγχει την ομοιότητά της
 * με άλλη κάρτα, την εμφανίζει στον χρήστη είτε αν την έχει μαντέψει σωστά είτε για μερικά δευτερόλεπτα αν την έχει
 * μαντέψει λάθος.
 */
package memorycard;

import java.util.Random;
import java.util.ArrayList;

public class Card {
    private char letter;
    private boolean exposed = false;
    private boolean selected = false;

    public Card(char letter) {
        this.letter = letter;
    }

    //Εμφανίζει τις κάρτες που έχουν μαντευτεί σωστά με το γράμμα τους και όλες τις υπόλοιπες με '*'
    public char print() {
      return exposed ? this.letter : "*".charAt(0);
      // return exposed ? "*".charAt(0) : this.letter;
    }

    //Εμφανίζει τις κάρτες που έχει επιλέξει ο χρήστης με το γράμμα τους, για μικρό χρονικό διάστημα, και όλες τις υπόλοιπες με '*'
    public char printSelectedLetter() {
      return selected ? this.letter : "*".charAt(0);
    }

    public char getLetter() {
      return this.letter;
    }

    public void setSelecedF() {
      selected = false;
    }

    public void setSelecedT() {
      selected = true;
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
        letters.add(c.getLetter());
      }

      return letters;
    }
}
