/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;

import java.util.Scanner;

public class MemoryCard {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int i;
      Scanner s = new Scanner(System.in);
      Game g;

      do {
        System.out.println("1.Βασικό");
        System.out.println();
        System.out.println("2.Διπλάσιο");
        System.out.println();
        System.out.println("3.Τρίο");
        System.out.println();
        System.out.println("4.Έξοδος");
        System.out.println();

        i = s.nextInt();
        System.out.println();

          switch(i) {
                  case 1 :
                    g = new Game(4,6,2);
                    break;

                  case 2 :
                    g = new Game(6,8,2);
                    break;

                  case 3 :
                    g = new Game(6,6,3);
                    break;

                  case 4 :
                    System.out.println("Bye!");
                    break;

                  default :
                    System.out.println("Λάθος επιλογή!");
                    System.out.println();
                    break;
        }

      } while (i != 4 );
    }
}
