/*
 * Η κλάση BoardTrio αποτελεί τον πίνακα για τον τρίτο τύπου παιχνιδιού, καθώς χρειάζεται να αντιμετωπίσει 3 συντεταγμένες κάθε
 * φορά. Κληρονομεί από την κλάση Board, γι´αυτό υπάρχουν μόνο οι συναρτήσεις που είναι διαφορετικές.
 */
package memorycard;

import java.util.Collections;
import java.util.ArrayList;

public class BoardTrio extends Board {
    private int[] size;
    private Card[][] board;

    public BoardTrio(int x, int y, int occurences) {
      super(x,y,occurences);
      this.size = new int[]{x, y};
      this.board = new Card[x][y];

      this.generateNew(occurences);
    }

    //Έλεγχος ισοδυναμίας 3 καρτών, έτσι ώστε να είναι μόνιμα εμφανείς. Διαφορετικά, επιλογή των καρτών για παροδική εμφάνιση.
    public boolean tryMatch(int x1, int y1, int x2, int y2, int x3, int y3) {
      if (board[x1][y1].equals(board[x2][y2]) && board[x1][y1].equals(board[x3][y3])) {
        board[x1][y1].expose();
        board[x2][y2].expose();
        board[x3][y3].expose();

        return true;
      } else {
        board[x1][y1].setSelecedT();
        board[x2][y2].setSelecedT();
        board[x3][y3].setSelecedT();

        return false;
      }
    }

    ////Κλείσιμο τον επιλεγμένων καρτών
    public void setPointsF(int x1, int y1, int x2, int y2, int x3, int y3) {
        board[x1][y1].setSelecedF();
        board[x2][y2].setSelecedF();
        board[x3][y3].setSelecedF();
    }
}
