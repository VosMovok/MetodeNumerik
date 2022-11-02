package Modul3;


public class Main {
    static int q = 8;
    static double[] x = {1, 2, 3, 4, 5, 6, 7, 8};
    static double[] y = {1.5576, 1.2131, 0.9447, 0.7358, 0.5730, 0.4462, 0.3476, 0.2707};
    static double xy;
    static double x2;
    static double akhirx2 = 0;
    static double akhirxy = 0;
    static double akhirx = 0;
    static double akhiry = 0;
    static double fx;
    static double fx2;
    static double akhirfx = 0;
    static double akhirfx2 = 0;
    static double[][] mat = new double[2][2];
    static double[] b = new double[2];
    static double[] hasil = new double[2];

    private static void spl() {
        System.out.print("Elemen Matriks A: ");
        System.out.print("\n");
        mat[0][0] = q;
        mat[0][1] = akhirx;
        mat[1][0] = akhirx;
        mat[1][1] = akhirx2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(mat[i][j]);
                System.out.print("\n");
            }
        }
        System.out.print("\nElemen Vektor B: ");
        System.out.print("\n");
        b[0] = akhiry;
        b[1] = akhirxy;
        for (int i = 0; i < 2; i++) {
            System.out.print(b[i]);
            System.out.print("\n");
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
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        System.out.print("[[Model y = a0+a1x]]");
        System.out.print("\n");
        System.out.print("___________________");
        System.out.print("\n");
        System.out.print("|  x  |     y     |");
        System.out.print("\n");
        System.out.print("-------------------");
        System.out.print("\n");
        for (int i = 0;i < 8;i++)
        {
            System.out.print("|  ");
            System.out.print(x[i]);
            System.out.print("  |  ");
            System.out.printf("%-7f", y[i]);
            System.out.printf("%s", "  |");
            System.out.printf("%s", "\n");
        }

        System.out.printf("%s", "__________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "|  x   |     y     |   X^2   |     XY    |");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "------------------------------------------");
        System.out.printf("%s", "\n");
        for (int i = 0; i < 8; i++)
        {
            x2 = x[i] * x[i];
            xy = x[i] * y[i];
            System.out.printf("%s", "|  ");
            System.out.printf("%2f", x[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%7f", y[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%5f", x2);
            System.out.printf("%s", "  |  ");
            System.out.printf("%7f", xy);
            System.out.printf("%s", "  |  ");
            System.out.printf("%s", "\n");
            akhirx2 = akhirx2 + x2;
            akhirxy = akhirxy + xy;
            akhirx = akhirx + x[i];
            akhiry = akhiry + y[i];
        }
        System.out.printf("%s", "__________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "|  ");
        System.out.printf("%2f", akhirx);
        System.out.printf("%s", "  |  ");
        System.out.printf("%7f", akhiry);
        System.out.printf("%s", "  |  ");
        System.out.printf("%5f", akhirx2);
        System.out.printf("%s", "  |  ");
        System.out.printf("%7f", akhirxy);
        System.out.printf("%s", "  |  ");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "------------------------------------------");
        System.out.printf("%s", "\n");
        spl();
        for (int i = 0;i < 2;i++)
        {
            System.out.printf("%s", "a");
            System.out.printf("%s", i);
            System.out.printf("%s", ": ");
            System.out.printf("%f", hasil[i]);
            System.out.printf("%s", "\n");
        }
        System.out.printf("%s", "\nf(x)= ");
        System.out.printf("%f", hasil[0]);
        System.out.printf("%s", "+(");
        System.out.printf("%f", hasil[1]);
        System.out.printf("%s", ")x");
        System.out.printf("%s", "\n");

        System.out.printf("%s", "________________________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "|  xi  |     yi     | f(xi)=a0+a1xi |    (y-f(x))^2    |");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "--------------------------------------------------------");
        System.out.printf("%s", "\n");
        for (int i = 0; i < 8; i++)
        {
            fx = hasil[0] + (hasil[1] * x[i]);
            fx2 = (y[i] - fx) * (y[i] - fx);
            System.out.printf("%s", "|  ");
            System.out.printf("%2f", x[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%8f", y[i]);
            System.out.printf("%s", "  |  ");
            System.out.printf("%11f", fx);
            System.out.printf("%s", "  |  ");
            System.out.printf("%14f", fx2);
            System.out.printf("%s", "  |  ");
            System.out.printf("%s", "\n");
            akhirfx = akhirfx + fx;
            akhirfx2 = akhirfx2 + fx2;
        }
        System.out.printf("%s", "________________________________________________________");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "|  ");
        System.out.printf("%36s", "  |  ");
        System.out.printf("%14f", akhirfx2);
        System.out.printf("%s", "  |  ");
        System.out.printf("%s", "\n");
        System.out.printf("%s", "--------------------------------------------------------");
        System.out.printf("%s", "\n");

        double e = Math.sqrt((akhirfx2 / q));
        System.out.printf("%s", "Error=");
        System.out.printf("%s", e);

    }

}
