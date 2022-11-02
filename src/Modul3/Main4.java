package Modul3;

import java.util.Scanner;

public class Main4 {
    public static double[] x = {1, 2, 3, 4, 5, 6, 7, 8};
    public static double[] y = {1.5577, 1.2131, 0.9447, 0.7358, 0.5730, 0.4462, 0.3476, 0.2706};

    public static double Proses(double X, int z) {
        int i;
        int j;
        int k;
        double[][] mat = new double[z][z];
        for (i = 0; i < z; i++) {
            mat[0][i] = y[i];
        }
        for (i = 1; i < z; i++) {
            for (j = 0; j < z - i; j++) {
                mat[i][j] = (mat[i - 1][j + 1] - mat[i - 1][j]) / (x[j + i] - x[j]);
            }
        }
        double hasil = mat[0][0];
        for (i = 1; i < z; i++) {
            double tmp = mat[i][0];
            for (k = 0; k <= i - 1; k++) {
                tmp = tmp * (X - x[k]);
            }
            hasil = hasil + tmp;
        }
        return hasil;
    }

    public static void main(String[] args) {
        int pil;
        int z = 0;
        System.out.print("\tBeda Terbagi Newton");
        System.out.print("\n");
        System.out.print("-----------------------------");
        System.out.print("\n");
        System.out.print("Pilihan\n1. Setengah Data\n2. Seluruh Data\nPilih: ");
        Scanner scanner = new Scanner(System.in);
        pil = scanner.nextInt();
        switch (pil) {
            case 1 -> z = 4;
            case 2 -> z = 8;
        }
        System.out.print("\nDiketahui: ");
        System.out.print("\n");
        System.out.print("\t-> Data x dan y ");
        System.out.print("\n");
        System.out.print("\t___________________");
        System.out.print("\n");
        System.out.print("\t|  x  |     y     |");
        System.out.print("\n");
        System.out.print("\t-------------------");
        System.out.print("\n");
        for (int i = 0; i < z; i++) {
            System.out.print("\t|  ");
            System.out.print(x[i]);
            System.out.print("  |  ");
            System.out.printf("%-7f", y[i]);
            System.out.printf("%s", "  |");
            System.out.printf("%s", "\n");
        }
        System.out.printf("%s", "\t-------------------");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\nDitanya:");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\t-> nilai f(x=4.5) ?");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\nJawab:");
        System.out.printf("%s", "\n");
        double hasil = Proses(4.5, z);
        System.out.printf("%s", "\t->f(x=4.5)= ");
        System.out.printf("%s", hasil);
    }
}

