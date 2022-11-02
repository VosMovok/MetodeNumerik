package Modul3;

import java.util.Scanner;

public class Main2 {
    static int a;
    static double[] x = {1, 2, 3, 4, 5, 6, 7, 8};
    static double[] y = {1.5577, 1.2131, 0.9447, 0.7358, 0.5730, 0.4462, 0.3476, 0.2706};
    static double[] xy = new double[8], x2 = new double[8], x2y = new double[8], x3 = new double[8], x4 = new double[8];
    static double xt = 0, yt = 0, xyt = 0, x2t = 0, x2yt = 0, x3t = 0, x4t = 0;
    static double det, detA1, detA2, detA3, A0, A1, A2;

    public static void main(String[] args) {
        System.out.print("[[Model y= a0x^2+ a1x+ a2]]");
        System.out.print("\n");
        System.out.print("\t-> Data x dan y ");
        System.out.print("\n");
        System.out.print("\t___________________");
        System.out.print("\n");
        System.out.print("\t|  x  |     y     |");
        System.out.print("\n");
        System.out.print("\t-------------------");
        System.out.print("\n");
        for (int i = 0; i < 8; i++) {
            System.out.print("\t|  ");
            System.out.print(x[i]);
            System.out.print("  |  ");
            System.out.printf("%-7f", y[i]);
            System.out.printf("%s", "  |");
            System.out.printf("%s", "\n");
            xt = xt + x[i];
            yt = yt + y[i];
        }
        System.out.printf("%s", "\t-------------------");
        System.out.printf("%s", "\n");
        for (int k = 1; k < 8; k++) {
            xy[k] = x[k] * y[k];
            x2y[k] = x[k] * x[k] * y[k];
            x2[k] = x[k] * x[k];
            x3[k] = x[k] * x[k] * x[k];
            x4[k] = x[k] * x[k] * x[k] * x[k];
            xyt = xyt + xy[k];
            x2yt = x2yt + x2y[k];
            x2t = x2t + x2[k];
            x3t = x3t + x3[k];
            x4t = x4t + x4[k];
        }
        System.out.print("\n\tHasilPerhitungan :");
        System.out.print("\n");
        System.out.print("n \t\t= 8 ");
        System.out.print("\n");
        System.out.print("sigma x \t= ");
        System.out.print(xt);
        System.out.print("\n");
        System.out.print("sigma y \t= ");
        System.out.print(yt);
        System.out.print("\n");
        System.out.print("sigma x^2 \t= ");
        System.out.print(x2t);
        System.out.print("\n");
        System.out.print("sigma x^3 \t= ");
        System.out.print(x3t);
        System.out.print("\n");
        System.out.print("sigma x^4 \t= ");
        System.out.print(x4t);
        System.out.print("\n");
        System.out.print("sigma xy \t= ");
        System.out.print(xyt);
        System.out.print("\n");
        System.out.print("sigma x^2y \t= ");
        System.out.print(x2yt);
        System.out.print("\n");
        det = ((8 * x2t * x4t) + (xt * x3t * x2t) + (x2t * xt * x3t)) - ((xt * xt * x4t) + (8 * x3t * x3t) + (x2t * x2t * x2t));
        System.out.print("Determinan \t= ");
        System.out.print(det);
        System.out.print("\n");
        detA1 = ((yt * x2t * x4t) + (xt * x3t * x2yt) + (x2t * xyt * x3t)) - ((xt * xyt * x4t) + (yt * x3t * x3t) + (x2t * x2t * x2yt));
        System.out.print("Determinan A1 \t= ");
        System.out.print(detA1);
        System.out.print("\n");
        detA2 = ((8 * xyt * x4t) + (yt * x3t * x2t) + (x2t * xt * x2yt)) - ((yt * xt * x4t) + (8 * x3t * x2yt) + (x2t * xyt * x2t));
        System.out.print("Determinan A2 \t= ");
        System.out.print(detA2);
        System.out.print("\n");
        detA3 = ((8 * x2t * x2yt) + (xt * xyt * x2t) + (yt * xt * x3t)) - ((xt * xt * x2yt) + (8 * xyt * x3t) + (yt * x2t * x2t));
        System.out.print("Determinan A3 \t= ");
        System.out.print(detA3);
        System.out.print("\n");
        A0 = detA1 / det;
        System.out.print("\tA0 \t= ");
        System.out.print(A0);
        System.out.print("\n");
        A1 = detA2 / det;
        System.out.print("\tA1 \t= ");
        System.out.print(A1);
        System.out.print("\n");
        A2 = detA3 / det;
        System.out.print("\tA2 \t= ");
        System.out.print(A2);
        System.out.print("\n");
        System.out.print("Rumus Fungsi Polinomial = ");
        System.out.print(A0);
        System.out.print("(x^2) + ");
        System.out.print(A1);
        System.out.print("x + ");
        System.out.print(A2);
        System.out.print("\n");
        System.out.print("Masukkan jumlah x = ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        double[] X = new double[20];
        double Yh;
        for (int i = 1; i <= a; i++) {
            X[i] = i;
            System.out.print("x ke-");
            System.out.print(i);
            System.out.print(" = ");
            System.out.print(X[i]);
            System.out.print("\n");
        }
        System.out.print("\n\t________________________");
        System.out.print("\n");
        System.out.print("\t|  x  |        y       |");
        System.out.print("\n");
        System.out.print("\t------------------------");
        System.out.print("\n");
        for (int i = 1; i <= a; i++) {
            Yh = A0 + (A1 * X[i]) + A2 * X[i] * X[i];
            System.out.print("\t|  ");
            System.out.print(X[i]);
            System.out.print("  |  ");
            System.out.printf("%12f", Yh);
            System.out.printf("%s", "  |");
            System.out.printf("%s", "\n");
        }
        System.out.printf("%s", "\t------------------------");
        System.out.printf("%s", "\n");
    }


}
