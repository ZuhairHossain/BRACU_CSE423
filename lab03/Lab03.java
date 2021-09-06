import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;

public class Lab03 implements GLEventListener {

    private GLU glu;

    public void init(GLAutoDrawable gld) {

        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        gl.glPushMatrix();
        
        drawCircle(gl, 0, 0, 10);
        drawCircle(gl, 50, 50, 10);
        drawCircle(gl, 120, 0, 10);
        drawCircle(gl, 100, -50, 10);
        drawCircle(gl, 50, -50, 10);
        drawCircle(gl, 120, -100, 10);
        drawCircle(gl, 0, -100, 10);
        drawCircle(gl, 50, -120, 10);

        // drawCircle(gl, 0 , 0, 100);
        // drawCircle(gl, 50 , 0, 50);
        // drawCircle(gl, 0 , 50, 50);
        // drawCircle(gl, -50 , 0, 50);
        // drawCircle(gl, 0 , -50, 50);

        //drawCircle(gl, 35 , 35, 50);
        //drawCircle(gl, -35 , 35, 50); 
        //drawCircle(gl, -35 , -35, 50);       
        //drawCircle(gl, 35 , -35, 50);
    }

    private void drawCircle(GL2 gl, int x1 , int y1 ,int r) {

        gl.glPointSize(2.5f);
        gl.glColor3d(1, 1, 1);

        int x = r;
        int y = 0;
        int d = 5 - (4 * r);

        
        draw8Way(gl , x , y , x1 , y1);
        
        while (y <= x) {
            if (d < 0) {
                d = d + ((2 * y + 3) * 4);
                y++;
            }
            
            else {
                d = d + ((2 * y - 2 * x + 5) * 4);
                x--;
                y++;
            }
        
            draw8Way(gl , x , y , x1 , y1);
            
            
        }
    }
    
    
    
    private void draw8Way(GL2 gl, int x, int y, int x1, int y1) {
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2d(x+x1, y+y1);
        gl.glVertex2d(y+x1, x+y1);

        gl.glVertex2d(-x+x1, y+y1);
        gl.glVertex2d(-y+x1, x+y1);

        gl.glVertex2d(-x+x1, -y+y1);
        gl.glVertex2d(-y+x1, -x+y1);


        gl.glVertex2d(x+x1, -y+y1);
        gl.glVertex2d(y+x1, -x+y1);
        gl.glEnd();

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
    }

    public void dispose(GLAutoDrawable arg0) {

    }

    public static void main(String[] args) {
        // TODO code application logic here
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Lab03 l = new Lab03();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 600);
        //creating frame
        final JFrame frame = new JFrame("Circle Draw using Eight Way Symmetry");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(800, 480);
        frame.setVisible(true);
    }

}
