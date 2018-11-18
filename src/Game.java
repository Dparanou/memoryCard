/*
 * Η κλάση Game χειρίζετε τους κανόνες του παιχνιδιού. Ελέγχει για την σωστή είσοδο στοιχείων απο τον χρήστη, ελέγχει τα μηνυμάτα
 * προς αυτόν και τις χρονικές στιγμές που πρέπει να εμφανιστούν οι κατάλληλοι πίνακες.
 */
package memorycard;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class Game {
  Board board;

  public Game (int x, int y, int times) {
    board = new Board(x,y, times);
    int count = 0;

    board.prettyPrint();
    while (!shouldFinish()) {
      ++count;
      System.out.println("Κάνε μια προσπάθεια!");

      int[] coords = getCoordinates();
      if (board.tryMatch(coords[0], coords[1], coords[2], coords[3])) {
        System.out.println("Τα πέτυχες :)");
        board.prettyPrint();
      }
      else {
        System.out.println("Aπέτυχες :(");
        try {
          board.prettyPrint2(); //Εμφάνιση πίνακα με τις κάρτες που έχει επιλέξει ο χρήστης αλλά δεν ταιριάζουν
          Thread.sleep(2000); //Αναμονή 2"
          clearScreen(); //Καθαρισμός οθόνης
          board.setPointsF(coords[0], coords[1], coords[2], coords[3]);//Κλείσιμο καρτών που έχει επιλέξει ο χρήστης
          board.prettyPrint(); // Κανονική εμφάνιση πίνακα με τις κάρτες που έχει μαντέψει σωστά μέχρι στιγμής(εάν έχει βρεί)
        }
        catch( InterruptedException e) {
          System.err.println(e.getMessage());
        }
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

      while (coords1[0] == coords2[0] && coords1[1] == coords2[1]) {
        System.out.println("Ίδιες συντεταγμένες!");

        coords1 = getCoordinateData("Δώσε την γραμμή και την στήλη της 1 κάρτας:");
        coords2 = getCoordinateData("Δώσε την γραμμή και την στήλη της 2 κάρτας:");
      }

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

  // Ολοκλήρωση παιχνιδιού, όταν όλες οι κάρτες είναι εμφανείς
  public boolean shouldFinish() {
    return board.allCardsExposed();
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
