import static java.lang.Math.abs;
import java.util.Scanner;

public class MidpointLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Starting Co-ordinates (X1,Y1)");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println("Enter End Co-ordinates (X2,Y2)");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        //Find Zone
        int zone = findZone(x1, y1, x2, y2);

        //Current Pixel
        int Xc = convertX_0(x1, y1, zone);
        int Yc = convertY_0(x1, y1, zone);

        //End Pixel
        int Xe = convertX_0(x2, y2, zone);
        int Ye = convertY_0(x2, y2, zone);

        int dy = Ye - Yc;
        int dx = Xe - Xc;
        int b = (2 * dy) - dx;

        System.out.println();
        System.out.println("Zone: "+zone);
        System.out.println();
        System.out.println("Outputs:");
        if (b > 0) {
            System.out.println(Xc + "        " + Yc + "        " + b + "        " + "NE" + "        " + x1 + "        " + y1);
        } else {
            System.out.println(Xc + "        " + Yc + "        " + b + "        " + "E" + "        " + x1 + "        " + y1);
        }

        int n = 0;
        while ((Xc < Xe && Yc < Ye) && n < 10) {
            if (b > 0) {
                Xc = Xc + 1;
                Yc = Yc + 1;
                b = b + (2 * dy) - (2 * dx);

                //Convert to Actual Zone
                int Xp = convertX_M(Xc, Yc, zone);
                int Yp = convertY_M(Xc, Yc, zone);
                if (b > 0) {
                    System.out.println(Xc + "        " + Yc + "        " + b + "        " + "NE" + "        " + Xp + "        " + Yp);
                } else {
                    System.out.println(Xc + "        " + Yc + "        " + b + "        " + "E" + "        " + Xp + "        " + Yp);
                }

            } else {
                Xc = Xc + 1;
                b = b + (2 * dy);

                //Convert to Actual Zone
                int Xp = convertX_M(Xc, Yc, zone);
                int Yp = convertY_M(Xc, Yc, zone);
                if (b > 0) {
                    System.out.println(Xc + "        " + Yc + "        " + b + "        " + "NE" + "        " + Xp + "        " + Yp);
                } else {
                    System.out.println(Xc + "        " + Yc + "        " + b + "        " + "E" + "        " + Xp + "        " + Yp);
                }

            }
            n++;
        }
    }

    static int findZone(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int zone = 0;
        if (dx > 0 && dy > 0 && abs(dy) > abs(dx)) {
            zone = 1;
        } else if (dx < 0 && dy > 0 && abs(dy) > abs(dx)) {
            zone = 2;
        } else if (dx < 0 && dy > 0 && abs(dx) > abs(dy)) {
            zone = 3;
        } else if (dx < 0 && dy < 0 && abs(dx) > abs(dy)) {
            zone = 4;
        } else if (dx < 0 && dy < 0 && abs(dy) > abs(dx)) {
            zone = 5;
        } else if (dx > 0 && dy < 0 && abs(dy) > abs(dx)) {
            zone = 6;
        } else if (dx > 0 && dy < 0 && abs(dx) > abs(dy)) {
            zone = 7;
        }
        return zone;
    }

    static int convertX_0(int x, int y, int zone) {
        int convertedX = x;
        switch (zone) {
            case 1:
                convertedX = y;
                break;
            case 2:
                convertedX = y;
                break;
            case 3:
                convertedX = -x;
                break;
            case 4:
                convertedX = -x;
                break;
            case 5:
                convertedX = -y;
                break;
            case 6:
                convertedX = -y;
                break;
            case 7:
                convertedX = x;
                break;
            default:
                break;
        }
        return convertedX;
    }

    static int convertY_0(int x, int y, int zone) {
        int convertedY = y;
        switch (zone) {
            case 1:
                convertedY = x;
                break;
            case 2:
                convertedY = -x;
                break;
            case 3:
                convertedY = y;
                break;
            case 4:
                convertedY = -y;
                break;
            case 5:
                convertedY = -x;
                break;
            case 6:
                convertedY = x;
                break;
            case 7:
                convertedY = -y;
                break;
            default:
                break;
        }
        return convertedY;
    }
    static int convertX_M(int x, int y, int zone) {
        int convertedX = x;
        switch (zone) {
            case 1:
                convertedX = y;
                break;
            case 2:
                convertedX = -y;
                break;
            case 3:
                convertedX = -x;
                break;
            case 4:
                convertedX = -x;
                break;
            case 5:
                convertedX = -y;
                break;
            case 6:
                convertedX = y;
                break;
            case 7:
                convertedX = x;
                break;
            default:
                break;
        }
        return convertedX;
    }

    static int convertY_M(int x, int y, int zone) {
        int convertedY = y;
        switch (zone) {
            case 1:
                convertedY = x;
                break;
            case 2:
                convertedY = x;
                break;
            case 3:
                convertedY = y;
                break;
            case 4:
                convertedY = -y;
                break;
            case 5:
                convertedY = -x;
                break;
            case 6:
                convertedY = -x;
                break;
            case 7:
                convertedY = -y;
                break;
            default:
                break;
        }
        return convertedY;
    }
}
