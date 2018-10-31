package memorycard;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  Board b;

  public Game (int x, int y, int times) {
    b = new Board(x,y, times);

    while (!shouldFinish()) {
      b.prettyPrint();
      System.out.println("Κάνε μια προσπάθεια!");

      int[] coords = getCoordinates();
      if (b.tryMatch(coords[0], coords[1], coords[2], coords[3])) {
        System.out.println("Τα πέτυχες :)");
      }
      else {
        System.out.println("Aπέτυχες :(");
      }
    }
  }

  public void getCoordinates() {
      Scanner s = new Scanner(System.in);

      System.out.print("Δώσε την γραμμή και την στήλη της 1 κάρτας: ");
      String choice1= s.nextLine();
      System.out.println();

      System.out.print("Δώσε την γραμμή και την στήλη της 2 κάρτας: ");
      String choice2= s.nextLine();
      System.out.println();

      String[] cons = choice1.split(" ");
      //cons = choice2.split(" ");

      for(int i = 0 ; i < cons.length ; i++) {
        System.out.print(cons[i]);
      }
  }

  public boolean shouldFinish() {
    return b.allCardsExposed();
  }
}
