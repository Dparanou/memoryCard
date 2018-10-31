package memorycard;

import java.util.Collections;
import java.util.ArrayList;

public class Board {
    private int[] size;
    private boolean exposed = false;
    private Card[][] board;

    public Board(int x, int y) {
      this.size = new int[]{x, y};
      this.board = new Card[x][y];

      this.generateNew();
    }

    public void generateNew() {
      ArrayList<Card> cards = new ArrayList<>();
      int cardsCount = (int) (size[0] * size[1]) / 2;

      for (int i = 0; i < cardsCount; ++i) {
        Card c = Card.generateRandom(cards);
        cards.add(c);
        cards.add(c);
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

    public void prettyPrint() {
      for (int i = 0; i < size[0]; ++i) {
        for (int j = 0; j < size[1]; ++j) {
          System.out.print(board[i][j].get());
          System.out.print("    ");
        }
        System.out.println();
        System.out.println();
      }
    }

    public void expose() {
      this.exposed = true;
    }
}
