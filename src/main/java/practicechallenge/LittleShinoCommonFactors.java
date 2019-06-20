package practicechallenge;

import java.util.Scanner;

public class LittleShinoCommonFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int count=0;
        for(int i = 1 ; i < b ; i++) {
            if((a%i)==0 && (b%i)==0) {
                count++;
            }
        }

        System.out.println(count);
    }
}