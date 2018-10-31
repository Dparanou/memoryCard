/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;

/**
 *
 * @author dimitra
 */
public class Card {
    private String letter;
    private boolean exposed = false;

    public Card(String letter) {
        this.letter = letter;
    }

    public String getCard() {
      return exposed ? "-" : this.letter;
    }

    public void expose() {
      this.exposed = true;
    }

    public boolean equals(Card c) {
      return this.letter == c.letter;
    }
}
