package memorycard;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  Board b;


  public Game (int x, int y, int times) {
    //b = new Board(x,y);

    getCoordinates();

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

}
