import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class BounceBall extends JComponent implements ActionListener, MouseMotionListener, KeyListener {

    private int ballx = 150;
    private int bally = 30;
    private int paddlex = 0;
    private int ballySpeed = 12;
    private int ballxSpeed = 12;
    public boolean gameOver, started;

    public static void main(String[] args) {

        JFrame view = new JFrame("BounceBall");
        BounceBall g = new BounceBall();
        view.add(g);
        view.pack();
        view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.addMouseMotionListener(g);

        Timer tt = new Timer(17, g);
        tt.start();
    }

    public Dimension getPreferredSize() {

        return new Dimension(800, 600);
    }
    
    protected void paintComponent(Graphics g) {

        //draw the sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.GREEN);
        g.fillRect(0, 550, 800, 100);
        
        g.setColor(Color.white);
        g.fillOval(0, 0, 500, 100);
        
        g.setColor(Color.gray);
        g.fillOval(250, 0, 500, 100);
        
        g.setColor(Color.white);
        g.fillOval(500, 10, 350, 75);
        
        g.setColor(Color.yellow);
        g.fillRoundRect(25, 25, 150, 150, 200,200);
        
        g.setColor(Color.black);
        g.fillRect(paddlex, 500, 100, 20);

        g.setColor(Color.RED);
        g.fillOval(ballx, bally, 30, 30);
        
        }

    public void actionPerformed(ActionEvent e) {

        ballx = ballx + ballxSpeed;
        bally = bally + ballySpeed;

        // Window Down 
        if (ballx >= paddlex && ballx <= paddlex + 100 && bally >= 475) {

            ballySpeed = -7;
        }

        if (bally >= 700 ) {

            bally = 30;
        }
        // Window up
        if (bally <= 0) {

            ballySpeed = 7;
        }
        // Window right
        if (ballx >= 775) {

            ballxSpeed = -5;
        }
        // Window left
        if (ballx <= 0) {

            ballxSpeed = 5;
        }
   
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        paddlex = e.getX() - 50;
        repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}