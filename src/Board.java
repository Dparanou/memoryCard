/*
 * Η κλάση Board αποτελεί τον πίνακα με τις κάρτες μας. Δημιουργεί, εμφανίζει και ελέγχει την ομοιότητα 2
 * καρτών του πίνακα.
 */
package memorycard;

import java.util.Collections;
import java.util.ArrayList;

public class Board {
    private int[] size;
    private Card[][] board;

    public Board(int x, int y, int occurences) {
      this.size = new int[]{x, y};
      this.board = new Card[x][y];

      this.generateNew(occurences);
    }

    public boolean allCardsExposed() {
      for (int i = 0; i < size[0]; ++i) {
        for (int j = 0; j < size[1]; ++j) {
          if (!board[i][j].isExposed()) {
            return false;
          }
        }
      }

      return true;
    }

    //Δημιουργία πίνακα με τυχαία γράμματα και ανακάτεμα καρτών
    public void generateNew(int occurences) {
      //System.out.println("Calling generate random");
      ArrayList<Card> cards = new ArrayList<>();
      int cardsCount = (int) (size[0] * size[1]) / occurences;

      for (int i = 0; i < cardsCount; ++i) {
        Card c = Card.generateRandom(cards);
        for (int j = 0; j < occurences; ++j) {
          cards.add(c);
        }
      }

      Collections.shuffle(cards);

      int counter = 0;
      for (int i = 0; i < size[0]; ++i) {
        for (int j = 0; j < size[1]; ++j) {
          this.board[i][j] = cards.get(counter);
          ++counter;
        }
      }
    }

    //Έλεγχος σωστών συντεταγμένων
    public boolean verifyCoordinates(int x, int y) {
      return x >= 0 && x < size[0] && y >= 0 && y < size[1];
    }

    //Εμφάνιση του πίνακα με τις σωστά μαντεμένες κάρτες ανοιχτές και τις κλειστές που πρέπει να βρεθούν
    public void prettyPrint() {
      for (int i = 0; i < size[0]; ++i) {
        for (int j = 0; j < size[1]; ++j) {
          System.out.print(board[i][j].print());
          System.out.print("    ");
        }
        System.out.println();
        System.out.println();
      }
    }

    //Εμφάνιση του πίνακα με τις κάρτες που έχουν επιλεγεί ανοιχτές
    public void prettyPrint2() {
      for (int i = 0; i < size[0]; ++i) {
        for (int j = 0; j < size[1]; ++j) {
          System.out.print(board[i][j].printSelectedLetter());
          System.out.print("    ");
        }
        System.out.println();
        System.out.println();
      }
    }

    //Έλεγχος ισοδυναμίας καρτών, έτσι ώστε να είναι μόνιμα εμφανείς. Διαφορετικά, επιλογή των καρτών για παροδική εμφάνιση.
    public boolean tryMatch(int x1, int y1, int x2, int y2) {
      if (board[x1][y1].equals(board[x2][y2])) {
        board[x1][y1].expose();
        board[x2][y2].expose();

        return true;
      }
      board[x1][y1].setSelecedT();
      board[x2][y2].setSelecedT();

      return false;
    }

    //Κλείσιμο τον επιλεγμένων καρτών
    public void setPointsF(int x1, int y1, int x2, int y2) {
      board[x1][y1].setSelecedF();
      board[x2][y2].setSelecedF();
    }
}
