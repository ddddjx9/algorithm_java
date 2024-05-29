package algorithm;

public class MagicSquare {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Magic square of order " + n + ":");
        generateMagicSquare(n);

        n = 5;
        System.out.println("\nMagic square of order " + n + ":");
        generateMagicSquare(n);

        n = 7;
        System.out.println("\nMagic square of order " + n + ":");
        generateMagicSquare(n);
    }

    public static void generateMagicSquare(int n) {
        int[][] magicSquare = new int[n][n];
        int num = 1;
        int i = 0;
        int j = n / 2;

        while (num <= n * n) {
            magicSquare[i][j] = num;
            num++;
            int newi = (i - 1 + n) % n;
            int newj = (j + 1) % n;
            if (magicSquare[newi][newj] != 0) {
                i = (i + 1) % n;
            } else {
                i = newi;
                j = newj;
            }
        }

        printMagicSquare(magicSquare);
    }

    public static void printMagicSquare(int[][] square) {
        for (int[] row : square) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
