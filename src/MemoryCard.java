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

      do {
        System.out.println("1.Βασικό");
        System.out.println("2.Διπλάσιο");
        System.out.println("3.Τρίο");
        System.out.println("4.Έξοδος");

        i = s.nextInt();

        switch(i) {
                case 1 : System.out.println("1!");
                  break;
                case 2 : System.out.println("2!");
                  break;
                case 3 : System.out.println("3!");
                  break;
                case 4 : System.out.println("Bye!");
                  break;
                default : System.out.println("Λάθος επιλογή!");
                  break;
      }

      } while (i != 4 );


    }
}
