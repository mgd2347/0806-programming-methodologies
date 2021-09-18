//algorithm to validate the citizen id card number

import java.util.Scanner;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    System.out.println("Enter your citizen card number:");
    Scanner reader = new Scanner(System.in);
    String ccString = reader.nextLine();
    reader.close();

    char[] ccChar = new char[ccString.length()];
    int[] ccNum = new int[ccString.length()];
    int sum = 0;

    HashMap<Character, Integer> ccValid = new HashMap<Character, Integer>();
    ccValid.put('A', 10);
    ccValid.put('B', 11);
    ccValid.put('C', 12);
    ccValid.put('D', 13);
    ccValid.put('E', 14);
    ccValid.put('F', 15);
    ccValid.put('G', 16);
    ccValid.put('H', 17);
    ccValid.put('I', 18);
    ccValid.put('J', 19);
    ccValid.put('K', 20);
    ccValid.put('L', 21);
    ccValid.put('M', 22);
    ccValid.put('N', 23);
    ccValid.put('O', 24);
    ccValid.put('P', 25);
    ccValid.put('Q', 26);
    ccValid.put('R', 27);
    ccValid.put('S', 28);
    ccValid.put('T', 29);
    ccValid.put('U', 30);
    ccValid.put('V', 31);
    ccValid.put('W', 32);
    ccValid.put('X', 33);
    ccValid.put('Y', 34);
    ccValid.put('Z', 35);

    if (ccString.length() == 12) {
      for (int i = 0; i < ccString.length(); i++) {
        ccChar[i] = Character.toUpperCase(ccString.charAt(i));
      }
      for (int i = 0; i < 9; i++) {
        ccNum[i] = Integer.parseInt(String.valueOf(ccChar[i]));
      }
      ccNum[9] = ccValid.get(ccChar[9]);
      ccNum[10] = ccValid.get(ccChar[10]);
      ccNum[11] = Integer.parseInt(String.valueOf(ccChar[11]));

      for (int i = 0; i < 12; i += 2) {
        ccNum[i] *= 2;
        if (ccNum[i] > 9) {
          ccNum[i] -= 9;
        }
      }
      for (int i = 0; i < 12; i++) {
        sum += ccNum[i];
      }
      System.out.println(sum);

      if (sum % 10 == 0) {
        System.out.println("Valid citizen card number.");
      } else {
        System.out.println("Invalid citizen card number.");
      }
    } else {
      System.out.println("Invalid size for citizen card number, it should have 12 characters.");
    }
  }
}
