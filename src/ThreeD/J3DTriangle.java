package ThreeD;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;
  
public class J3DTriangle implements GLEventListener {  
  
private GLU glu = new GLU();  
private float rotation = 0.0f;  
  
   @Override  
public void display(GLAutoDrawable drawable) {  
final GL2 gl = drawable.getGL().getGL2();  
  
  
gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );  
gl.glLoadIdentity();   
      // Move triangle  
gl.glTranslatef( -0.5f, 0.0f, -6.0f );   
gl.glRotatef( rotation, 0.0f, 1.0f, 0.0f );  
gl.glBegin( GL2.GL_TRIANGLES );   
  
  
      // Front  
gl.glColor3f( 1.0f, 1.0f, 0.0f ); 
gl.glVertex3f( 1.5f, 2f, 0.0f ); 
          
gl.glColor3f( 0.0f, 1.5f, 0.0f ); 
gl.glVertex3f( -1.5f, -1.5f, 1.5f );
          
gl.glColor3f( 1.0f, 0.0f, 1.0f );  
gl.glVertex3f( 1.5f, -1.5f, 1.5f );    
  
      // Right  
gl.glColor3f( 1.0f, 1.0f, 0.0f );  
gl.glVertex3f( 1.5f, 2.0f, 0.0f );   
          
gl.glColor3f( 1.0f, 0.0f, 1.0f );   
gl.glVertex3f( 1.5f, -1.5f, 1.5f );    
          
gl.glColor3f( 0.0f, 1.0f, 0.0f );   
gl.glVertex3f( 1.5f, -1.5f, -1.5f );    
  
      // Back  
gl.glColor3f( 1.0f, 1.0f, 0.0f );  
gl.glVertex3f( 1.5f, 2.0f, 0.0f );   
          
gl.glColor3f( 0.0f, 1.0f, 0.0f );   
gl.glVertex3f( 1.5f, -1.5f, -1.5f );    
          
gl.glColor3f( 1.0f, 0.0f, 1.0f );   
gl.glVertex3f( -1.5f, -1.5f, -1.5f );   
  
      //left  
gl.glColor3f( 1.0f, 1.0f, 0.0f );   
gl.glVertex3f( 1.5f, 2.0f, 0.0f );    
          
gl.glColor3f( 1.0f, 0.0f, 1.0f );   
gl.glVertex3f( -1.5f, -1.5f, -1.5f );    
          
gl.glColor3f( 0.0f, 1.0f, 0.0f );   
gl.glVertex3f( -1.5f, -1.5f, 1.5f );
          
gl.glEnd();   
gl.glFlush();  
rotation += 0.6f;  
   }  
  
   @Override  
public void dispose( GLAutoDrawable drawable ) {  
   }  
  
   @Override  
public void init( GLAutoDrawable drawable ) {  
   }  
  
   @Override  
public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {  
  
final GL2 gl = drawable.getGL().getGL2();  
if(height<=0)  
height = 1;  
              
final float h = ( float ) width / ( float ) height;  
gl.glViewport( 0, 0, width, height );  
gl.glMatrixMode( GL2.GL_PROJECTION );  
gl.glLoadIdentity();  
          
glu.gluPerspective( 45.0f, h, 1.0, 20.0 );  
gl.glMatrixMode( GL2.GL_MODELVIEW );  
gl.glLoadIdentity();  
   }  
  
public static void main( String[] args ) {  
  
final GLProfile gp = GLProfile.get( GLProfile.GL2 );  
GLCapabilities cap = new GLCapabilities(gp );  
  
final GLCanvas gc = new GLCanvas( cap );  
      J3DTriangle triangle = new J3DTriangle();  
          
gc.addGLEventListener( triangle );  
gc.setSize( 400, 400 );  
          
final JFrame frame = new JFrame( "3D Triangle" );  
          
frame.add(gc);  
frame.setSize(500,400);  
frame.setVisible(true);    
  
          
final FPSAnimator animator = new FPSAnimator(gc,400,true);  
animator.start();  
   }  
      
}  