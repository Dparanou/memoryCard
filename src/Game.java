package memorycard;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  Board board;

  public Game (int x, int y, int times) {
    board = new Board(x,y, times);

    while (!shouldFinish()) {
      board.prettyPrint();
      System.out.println("Κάνε μια προσπάθεια!");

      int[] coords = getCoordinates();
      if (board.tryMatch(coords[0], coords[1], coords[2], coords[3])) {
        System.out.println("Τα πέτυχες :)");
      }
      else {
        System.out.println("Aπέτυχες :(");
      }
    }
  }

  public int[] getCoordinates() {
      Scanner s = new Scanner(System.in);

      System.out.print("Δώσε την γραμμή και την στήλη της 1 κάρτας: ");
      String choice1= s.nextLine();
      System.out.println();

      System.out.print("Δώσε την γραμμή και την στήλη της 2 κάρτας: ");
      choice1 += " " + s.nextLine();
      System.out.println();

      String[] cons = choice1.split(" ");

      int[] coord = new int[cons.length];

      for (int i = 0 ; i < cons.length ; i++) {
        coord[i] = Integer.parseInt(cons[i]);
        System.out.println(coord[i]);
      }

      return coord;

  }

  public boolean shouldFinish() {
    return board.allCardsExposed();
  }
}
