import javax.swing.*;

public class PongFrame extends JFrame {

    private PongModel model;
    
    public PongFrame() {

	model = new PongModel();
	setTitle("Pong");
	setSize(1000,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(new PongPanel(this));
	setVisible(true);
    }

    public PongModel getModel() {
	return model;
    }
}
