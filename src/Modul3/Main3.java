package Modul3;

import java.util.Scanner;

public class Main3 {
    static double[] x = {1, 2, 3, 4, 5, 6, 7, 8};
    static double[] y = {1.5577, 1.2131, 0.9447, 0.7358, 0.5730, 0.4462, 0.3476, 0.2706};
    static double[] X = new double[8], fx = new double[8], Y = new double[8], X2 = new double[8], XY = new double[8], yy = new double[8];
    static double[][] mat = new double[2][2];
    static double[] b = new double[2], hasil = new double[2];
    static double art1 = 0, art2 = 0, art3 = 0, art4 = 0, art6 = 0;

    static void Tot1() {
        for (int i = 0; i < 8; i++) {
            if (x[i] == 0) {
                X[i] = 0;
            } else {
                X[i] = Math.log(x[i]);
            }
            Y[i] = Math.log(y[i]);
            X2[i] = X[i] * X[i];
            XY[i] = X[i] * Y[i];
            art1 = art1 + X[i];
            art2 = art2 + Y[i];
            art3 = art3 + X2[i];
            art4 = art4 + XY[i];
        }
    }

    static void Matriks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elemen Matriks A: ");
        System.out.print("\n");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mat[i][j] = scanner.nextDouble();
            }
        }
        System.out.print("\nElemen Vektor B: ");
        System.out.print("\n");
        for (int i = 0; i < 2; i++) {
            b[i] = scanner.nextDouble();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 2; j++) {
                double temp = mat[j][i] / mat[i][i];
                for (int k = 0; k < 2; k++) {
                    mat[j][k] = mat[j][k] - (temp * mat[i][k]);
                }
                b[j] = b[j] - (temp * b[i]);
            }
        }
        for (int i = 2 - 1; i >= 0; i--) {
            hasil[i] = b[i];
            int tmp = 2 - 1;
            for (int j = 2 - 1; j > i; j--) {
                hasil[i] = hasil[i] - (hasil[tmp] * mat[i][tmp]);
                tmp--;
            }
            hasil[i] = hasil[i] / mat[i][i];
        }
    }

    static void Tot2() {
        for (int i = 0; i < 6; i++) {
            fx[i] = hasil[1] + (Math.pow(x[i], hasil[0]));
        }
        for (int i = 0; i < 6; i++) {
            yy[i] = (y[i] - fx[i]) * (y[i] - fx[i]);
            art6 += yy[i];
        }
    }

    public static void main(String[] args) {
        System.out.print("[[Model y=ax^b]]");
        System.out.print("\n");
        System.out.print("___________________________________________________________________________________");
        System.out.print("\n");
        System.out.print("|  x  |     y     |       X       |       Y       |      X^2      |       XY      |");
        System.out.print("\n");
        System.out.print("-----------------------------------------------------------------------------------");
        System.out.print("\n");
        Tot1();
        for (int i = 0; i < 8; i++) {
            System.out.print("|  ");
            System.out.print(x[i]);
            System.out.print("  |  ");
            System.out.printf("%7f", y[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", X[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", Y[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", X2[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", XY[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%s", "\n");
        }
        System.out.printf("%s", "___________________________________________________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "|        ");
        System.out.printf("%12s", " |  ");
        System.out.printf("%11f", art1);
        System.out.printf("%s", "  |  ");
        System.out.printf("%11f", art2);
        System.out.printf("%s", "  |  ");
        System.out.printf("%11f", art3);
        System.out.printf("%s", "  |  ");
        System.out.printf("%11f", art4);
        System.out.printf("%s", "  |  ");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "-----------------------------------------------------------------------------------");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "   8 a0   ");
        System.out.printf("%s", "  +  ");
        System.out.printf("%7f", art1);
        System.out.printf("%s", " a1 = ");
        System.out.printf("%s", art2);
        System.out.printf("%s", "\n");
        System.out.printf("%s", art1);
        System.out.printf("%s", " a0");
        System.out.printf("%s", "  +  ");
        System.out.printf("%7f", art3);
        System.out.printf("%s", " a1 = ");
        System.out.printf("%s", art4);
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\nInput Nilai Matriks");
        System.out.printf("%s", "\n");
        Matriks();
        System.out.printf("%s", "\nMaka, ");
        for (int i = 0; i < 2; i++) {
            System.out.printf("%s", "a");
            System.out.printf("%d", i);
            System.out.printf("%s", ": ");
            System.out.printf("%f", hasil[i]);
            System.out.printf("%s", " ");
        }
        double b = hasil[1];
        double c = Math.exp(hasil[0]);
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\nf(x)= ");
        System.out.printf("%f", c);
        System.out.printf("%s", "x^");
        System.out.printf("%f", b);
        System.out.printf("%s", "\n");
        Tot2();
        System.out.printf("%s", "_______________________________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "|      x      |       y       |      y'       |   (y-y')^2    |");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "---------------------------------------------------------------");
        System.out.printf("%s", "\n");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%s", "|  ");
            System.out.printf("%9f", X[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", Y[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", fx[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", yy[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%s", "\n");

        }
        System.out.printf("%s", "_______________________________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "                                              |    ");
        System.out.printf("%s", art6);
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "---------------------------------------------------------------");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "\nError=");
        System.out.printf("%f", Math.sqrt((art6 / 8)));
    }

}
