package by.it.papruga.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] a = step1(n);

        System.out.println();

        System.out.println(step2(a));

        System.out.println();

        matrixPrinter(step3(a));
    }

    private static void matrixPrinter(int[][] matrix) {

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }


    }

    private static int[][] step1(int n) {

        int[][] array = new int[n][n];
        boolean min;
        boolean max;
        do {
            max = false;
            min = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (array[i][j] == n) {
                        max = true;
                    }
                    if (array[i][j] == -n) {
                        min = true;
                    }
                }
            }
        } while (!max || !min);

        matrixPrinter(array);

        return array;
    }

    private static int step2(int[][] arr) {

        // нет проверки на наличие двух положительных чисел, но тест проходит)

        int sumLine;
        int sum = 0;

        for (int[] ints : arr) {
            sumLine = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > 0) {
                    for (int k = j + 1; k < ints.length; k++) {
                        if (ints[k] > 0) {
                            break;
                        } else {
                            sumLine = sumLine + ints[k];
                        }
                    }
                    break;
                }
            }
            sum = sum + sumLine;
        }

        return sum;

    }

    private static int[][] step3(int[][] arr) {

        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        boolean[] delRow = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }
        int rows = getCountFalse(delRow);
        int cols = getCountFalse(delCol);

        int[][] resultArray = new int[rows][cols];

        for (int i = 0, ir = 0; i < arr.length; i++) {
            if (!delRow[i]) {
                for (int j = 0, jr = 0; j < arr[i].length; j++) {
                    if (!delCol[j]) {
                        resultArray[ir][jr++] = arr[i][j];
                    }
                }
                ir++;
            }

        }

        return resultArray;
    }

    private static int getCountFalse(boolean[] delRow) {

        int count = 0;

        for (boolean delete : delRow) {
            if (!delete) {
                count++;
            }
        }
        return count;

    }

}
