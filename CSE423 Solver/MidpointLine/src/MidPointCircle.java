import java.io.*;
import java.util.*;
import java.util.Scanner;

public class MidPointCircle {

    public static void main(String[] args) {
        MidpointCircle(0,34);
    }

    public static void MidpointCircle(int value, int radius){
        int x, y, d;
        d = 1 - radius;
        x = 0;
        y = radius;
        int time = 1;
        int n = 1;
        int E =1;
        int SE =1 ;
        int count = 3;
        //Circlepoints(x+30, y+20, time);
        while (x < y) {
            Circlepoints(x, y, time);
            time ++;
            if (d < 0) {
                //choose E
                d = d + 2*x + 3;
                x = x + 1;
                //1st d is d3 acc to quiz2
                System.out.println("E is chosen for "+E+"th time AND IN TOTAL FOR THE "+n+"th time with Dnew "+d+" called d"+count);
                E++;
                n++;
                count++;
            }
            else {
                //choose SE
                d = d + (2*x)-(2*y)+5;
                x = x + 1;
                y = y - 1;
                System.out.println("SE is chosen for "+SE+"th time AND IN TOTAL FOR THE "+n+"th time with Dnew "+d+" called d"+count);
                SE++;
                n++;
                count++;
            }
            //Circlepoints(x,y,time) ;
            // System.out.println();
            //System.out.println("Total SE IS "+SE+" And total E is "+E );
            //System.out.println();
        }
    }

    public static void Circlepoints(int x, int y, int i){
        System.out.println("for " +i+"th time in zone 1 pixels & x,y are "+ x +", "+ y);
        System.out.println("for " +i+"th time in zone 0 pixels & x,y are "+y+", "+x);
        System.out.println("for " +i+"th time in zone 7 pixels & x,y are "+y+", "+(-x));
        System.out.println("for " +i+"th time in zone 6 pixels & x,y are "+x+", "+( -y));
        System.out.println("for " +i+"th time in zone 5 pixels & x,y are "+(-x)+", "+(-y));
        System.out.println("for " +i+"th time in zone 4 pixels & x,y are "+(-y)+", "+(-x));
        System.out.println("for " +i+"th time in zone 3 pixels & x,y are "+(-y)+", "+( x));
        System.out.println("for " +i+"th time in zone 2 pixels & x,y are "+(-x)+", "+ y);
        System.out.println();

    }


}

