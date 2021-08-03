
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class CyrusBeck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        NumberFormat df = DecimalFormat.getInstance();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);

        //Range of Window
        System.out.println("Enter Xmin & Ymin (Starting Point)");
        int Xmin = sc.nextInt();
        int Ymin = sc.nextInt();

        System.out.println("Enter Xmax & Ymax (Ending Point)");
        int Xmax = sc.nextInt();
        int Ymax = sc.nextInt();

        //Point of Line Given
        System.out.println("Enter X1 & Y1 of Your Point");
        float X1 = sc.nextFloat();
        float Y1 = sc.nextFloat();

        System.out.println("Enter X2 & Y2 of Your Point");
        float X2 = sc.nextFloat();
        float Y2 = sc.nextFloat();

        //D
        int Dx = Math.round(X2 - X1);
        int Dy = Math.round(Y2 - Y1);

        //Ni
        int N1 = 1;
        int N2 = -1;

        float te = 0;
        float tl = 1;

        float ND, t;
        String s = "";

        //Print D
        System.out.println();
        System.out.println("D = (" + Dx + ", " + Dy + ")");

        //Left
        ND = N2 * Dx;
        t = (-(X1 - Xmin)) / (X2 - X1);
        t = Float.parseFloat(df.format(t));
        if (ND < 0) {
            if (t > te) {
                te = t;
            }
            s = "PE";
        } else {
            if (t < tl) {
                tl = t;
            }
            s = "PL";
        }
        System.out.println();
        System.out.println("Left Edge");
        System.out.println("Ni.D = " + ND + ",  t = " + t + ", [" + s + "] " + ",  te = " + te + ",  tl = " + tl);

        //Right
        ND = N1 * Dx;
        t = (-(X1 - Xmax)) / (X2 - X1);
        t = Float.parseFloat(df.format(t));
        if (ND < 0) {
            if (t > te) {
                te = t;
            }
            s = "PE";
        } else {
            if (t < tl) {
                tl = t;
            }
            s = "PL";
        }
        System.out.println();
        System.out.println("Right Edge");
        System.out.println("Ni.D = " + ND + ",  t = " + t + ", [" + s + "] " + ",  te = " + te + ",  tl = " + tl);

        //Bottom
        ND = N2 * Dy;
        t = (-(Y1 - Ymin)) / (Y2 - Y1);
        t = Float.parseFloat(df.format(t));
        if (ND < 0) {
            if (t > te) {
                te = t;
            }
            s = "PE";
        } else {
            if (t < tl) {
                tl = t;
            }
            s = "PL";
        }
        System.out.println();
        System.out.println("Bottom Edge");
        System.out.println("Ni.D = " + ND + ",  t = " + t + ", [" + s + "] " + ",  te = " + te + ",  tl = " + tl);

        //Top
        ND = N1 * Dy;
        t = (-(Y1 - Ymax)) / (Y2 - Y1);
        t = Float.parseFloat(df.format(t));
        if (ND < 0) {
            if (t > te) {
                te = t;
            }
            s = "PE";
        } else {
            if (t < tl) {
                tl = t;
            }
            s = "PL";
        }
        System.out.println();
        System.out.println("Top Edge");
        System.out.println("Ni.D = " + ND + ",  t = " + t + ", [" + s + "] " + ",  te = " + te + ",  tl = " + tl);

        //Find Points
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        if (te > tl) {
            System.out.println();
            System.out.println("Line Outside");
        } else {
            if (te == 0 && tl == 1) {
                x1 = Math.round(X1);
                y1 = Math.round(Y1);
                x2 = Math.round(X2);
                y2 = Math.round(Y2);
            } else if (te == 0) {
                x1 = Math.round(X1);
                y1 = Math.round(Y1);
                x2 = Math.round(X1 + (tl * (X2 - X1)));
                y2 = Math.round(Y1 + (tl * (Y2 - Y1)));
            } else if (tl == 1) {
                x2 = Math.round(X2);
                y2 = Math.round(Y2);
                x1 = Math.round(X1 + (te * (X2 - X1)));
                y1 = Math.round(Y1 + (te * (Y2 - Y1)));
            } else {
                x1 = Math.round(X1 + (te * (X2 - X1)));
                y1 = Math.round(Y1 + (te * (Y2 - Y1)));
                x2 = Math.round(X1 + (tl * (X2 - X1)));
                y2 = Math.round(Y1 + (tl * (Y2 - Y1)));
            }
            //Print
            System.out.println();
            System.out.println("Cliped Value of (X,Y) for tE");
            System.out.println("(X,Y) = (" + x1 + ", " + y1 + ")");
            System.out.println("Cliped Value of (X,Y) for tL");
            System.out.println("(X,Y) = (" + x2 + ", " + y2 + ")");
        }

    }

}
