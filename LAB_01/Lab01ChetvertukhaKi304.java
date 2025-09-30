import java.io.*;
import java.util.*;

/**
 * Клас Lab1ChetvertukhaKI304
 * Формує квадрат n×n з лівою заштрихованою трикутною частиною.
 */
public class Lab01ChetvertukhaKi304 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in);
             PrintWriter fout = new PrintWriter(new File("MyFile.txt"))) {

            System.out.print("Введіть розмір квадратної матриці: ");
            int n = in.nextInt();
            in.nextLine(); // зчитуємо кінець рядка

            System.out.print("Введіть символ-заповнювач: ");
            String filler = in.nextLine();

            if (filler.length() == 0) {
                System.out.println("Не введено символ-заповнювач. Завершення.");
                return;
            }
            if (filler.length() > 1) {
                System.out.println("Забагато символів-заповнювачів. Завершення.");
                return;
            }
            char fillChar = filler.charAt(0);

            char[][] arr = new char[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j <= (n - 1) / 2.0 - Math.abs(i - (n - 1) / 2.0)) {
                        arr[i][j] = fillChar;
                    } else {
                        arr[i][j] = ' ';
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }
                System.out.println();
                fout.println();
            }

            System.out.println("Результат збережено у MyFile.txt");

        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом: " + e.getMessage());
        }
    }
}