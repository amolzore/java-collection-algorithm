package practicechallenge;

import java.util.HashMap;
import java.util.Scanner;

public class ColoringGrids {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int grid = scanner.nextInt();
        int colors = scanner.nextInt();
        HashMap gridMap = new HashMap();

        for(int i = 0; i < colors ; i++) {
            gridMap.put(i,i);
            gridMap.put(grid-i,i);
        }

        gridMap.values().forEach(System.out::println);
    }
}
