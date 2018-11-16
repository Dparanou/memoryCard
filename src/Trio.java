package memorycard;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class Trio extends Game {
  BoardTrio board;

  public Trio (int x, int y, int times) {
    super(x,y,times);
    board = new BoardTrio(x,y, times);
    int count = 0;

    board.prettyPrint();
    while (!shouldFinish()) {
      ++count;
      System.out.println("Κάνε μια προσπάθεια!");

      int[] coords = getCoordinates();
      if (board.tryMatch(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5])) {
        System.out.println("Τα πέτυχες :)");
        board.prettyPrint();
      }
      else {
        System.out.println("Aπέτυχες :(");
        try {
          board.prettyPrint2();
          Thread.sleep(2000);
          clearScreen();
          board.setPointsF(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
          board.prettyPrint();
        }
        catch( InterruptedException e) {
          System.err.println(e.getMessage());
        }
      }
    }

    System.out.println("Το παιχνίδι τελείωσε! Το τελείωσες σε " + count + " κινήσεις.");
  }

  public int[] getCoordinates() {
      int[] coords1 = getCoordinateData("Δώσε την γραμμή και την στήλη της 1 κάρτας:");
      int[] coords2 = getCoordinateData("Δώσε την γραμμή και την στήλη της 2 κάρτας:");
      int[] coords3 = getCoordinateData("Δώσε την γραμμή και την στήλη της 3 κάρτας:");

      if (coords1[0] == coords2[0] && coords2[0] == coords3[0] && coords1[1] == coords2[1] && coords2[1] ==coords3[1]) {
        System.out.println("Not the same coordinates!");
      }

      int[] allCoordinates = {coords1[0], coords1[1], coords2[0], coords2[1], coords3[0], coords3[1]};

      return allCoordinates;
  }
}
