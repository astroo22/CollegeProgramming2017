import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongPanel extends JPanel {

    public static final int BALL_SIZE = 10;
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 100;
    private PongFrame frame;
    private Toolkit kit;
    
    public PongPanel(PongFrame f) {
	frame = f;
	kit = Toolkit.getDefaultToolkit();
	Timer timer = new Timer(100, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    frame.getModel().timeStep();
		    repaint();
		    kit.sync();
		}
	    });
	timer.start();
	addMouseMotionListener(new MouseHandler());
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	int ball_x = (int)(frame.getModel().get_ball_x() * getWidth());
	int ball_y = (int)(frame.getModel().get_ball_y() * getHeight());
	int paddle_y = (int)(frame.getModel().get_paddle_y() * getHeight());
	g.fillOval(ball_x,ball_y,BALL_SIZE,BALL_SIZE);
	g.fillRect(100, paddle_y,PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    private class MouseHandler extends MouseMotionAdapter {
	public void mouseMoved(MouseEvent e) {
	    int y = e.getY();
	    double y_d = (double)y / getHeight();
	    frame.getModel().movePaddle(y_d);
	    repaint();
	}
    }
}
