import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
public class way8sym {


    public static void main(String[] args) {
        midPoint(6, 3,12,6);
    }
//    int dx;
//    int dy;
//    int  zone;
//    public int FindZone(x1, y1, x2, y2){
//    dx= x2 - x1 ;
//    dy = y2 - y1 ;
//
//    if(|dx| > |dy|){
//        if(dx>0 && dy>0) zone = 0;
//        else if(dx<0 && dy>0) zone =3;
//        else if (? ?) zone = ? ;
//        else if (? ?) zone = ?
//    }
//        else{
//        if(dx>0 && dy>0) zone = 1;
//        else if(dx<0 && dy>0) zone =2;
//        else if (? ?) zone = ? ;
//        else if (? ?) zone = ?
//    }
//
//}

    static void midPoint(int x0, int y0, int x1, int y1){
        int dx, dy, incrE, incrNE, d, x, y;
        int zone = 0;
        dx = x1 - x0;
        dy = y1 - y0;

//        if(Math.abs(dx) > Math.abs(dy)){
//            if(dx>0 && dy>0) {zone = 0;}
//            else if(dx<0 && dy>0) {zone =3;}
//            else if (dx<0 && dy<0) {zone = 4 ;}
//            else if (dx>0 && dy<0) {zone = 7;}
//        }
//        else {
//            if(dx>0 && dy>0) zone = 1;
//            else if(dx<0 && dy>0) zone =2;
//            else if (dx<0 && dy<0) zone = 5 ;
//            else if (dx>0 && dy<0) zone = 6;
//    }
        zone = 2;

        System.out.println("Zone is "+ zone);
        d = 2 * dy - dx;
        System.out.println("The 0th d is "+d);
        incrE = 2 * dy;
        incrNE = 2 * (dy - dx);
        int i = 1;
        x = x0;
        y = y0;
        int NE = 1;
        int E = 1;
        int newX = 0;
        int newY= 0;
        System.out.println(  "1th pixel is "+x+","+y); //should be changed accordingly
        while (x < x1) {

            x = x + 1;

            if (d <= 0) {
                //choose E
                d = d + incrE;
                System.out.println("E is chosen for "+E+"th time AND IN TOTAL FOR THE "+i+"th time with Dnew "+d);

            }
            else {
                //choose NE
                d = d + incrNE;
                y = y + 1;
                System.out.println("E is chosen for "+NE+"th time AND IN TOTAL FOR THE "+i+"th time with Dnew "+d);

            }

            if (zone == 1){
                newX = x;
                newY = y;
            }
            else if(zone == 2){
                newX = -y;
                newY = x;
            }
            else if (zone ==3){
                newX = -x ;
                newY = y;
            }
            else if (zone == 4){
                newX = -x ;
                newY = -y;
            }
            else if (zone == 5){
                newX = -y ;
                newY = -x;
            }
            else if (zone == 6){
                newX = y ;
                newY = -x;
            }
            else if (zone == 7){
                newX = x ;
                newY = -y;
            }

            i++;
            System.out.println(i+"th pixel is "+newX+","+newY); //The selected pixel closest to the line
        }
    }
}
