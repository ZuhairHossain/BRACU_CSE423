import java.lang.Math;

public class DDA {

    public static void main(String[] args) {
        DDA(26, 71,79, 10);

    }
    static void DDA(float x1, float y1, float x2, float y2) {

        float x = x1;
        float y = y1;


        float m = (y2-y1)/(x2-x1);
        int i = 1;
        System.out.println(i+"th pixel is "+x+","+y);

        //plot the first coordinates
        if(-1<=m && m<=1) {
            while(x<=x2) {
                x=x+1;
                y=y+m;
                i++;
                System.out.println(i+"th pixel is "+x+","+y);
            }
        }
        else {
            while(y<=y2) {
                y=y+1;
                x=x+(1/m);
                i++;
                System.out.println(i+"th pixel is "+x+","+y);

            }
        }

    }

}


