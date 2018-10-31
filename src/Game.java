package memorycard;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Game {
  Board board;

  public Game (int x, int y, int times) {
    board = new Board(x,y, times);
    int count = 0;

    while (!shouldFinish()) {
      ++count;
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

    System.out.println("Το παιχνίδι τελείωσε! Το τελείωσες σε " + count + " κινήσεις.");
  }

  public int[] getCoordinateData(String userMessage) {
    Scanner scanner = new Scanner(System.in);
    String choice;
    int[] coords = new int[2];
    boolean goodData = true;

    do {
      if (!goodData) {
        System.out.println("Εβαλες λάθος συντεταγμένες. Δοκίμασε ξανά.");
      }

      System.out.print(userMessage);

      choice = scanner.nextLine();
      String[] splitted = choice.split(" ");

      if (splitted.length != 2) {
        goodData = false;
        continue;
      }

      for (int i = 0; i < splitted.length; ++i) {
        coords[i] = Integer.parseInt(splitted[i]);
      }

      goodData = board.verifyCoordinates(coords[0], coords[1]);
    }
    while (!goodData);

    return coords;
  }

  public int[] getCoordinates() {
      int[] coords1 = getCoordinateData("Δώσε την γραμμή και την στήλη της 1 κάρτας:");
      int[] coords2 = getCoordinateData("Δώσε την γραμμή και την στήλη της 2 κάρτας:");

      int[] allCoordinates = {coords1[0], coords1[1], coords2[0], coords2[1]};

      return allCoordinates;
  }

  public void printArray(int[] arr) {
      for (int i = 0; i < arr.length; ++i) {
        System.out.print(arr[i]);
        System.out.print(" ");
      }
  }
  public void printArray(int[][] arr) {
      for (int i = 0; i < arr.length; ++i) {
        for (int j = 0; j < arr[0].length; ++j) {
          System.out.print(arr[i][j]);
        }
        System.out.println();
      }
  }

  public boolean shouldFinish() {
    return board.allCardsExposed();
  }
}
