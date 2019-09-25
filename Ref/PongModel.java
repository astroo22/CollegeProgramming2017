public class PongModel {

    private double ball_x;
    private double ball_y;
    private double vx;
    private double vy;
    private double paddle_y;
    
    public PongModel() {
	ball_x = 0.5;
	ball_y = 0.5;
	paddle_y = 0.5;
	vx = 0.02;
	vy = 0.01;
    }

    public void timeStep() {
	ball_x += vx;
	ball_y += vy;
	if (ball_x >= 1.0) {
	    vx = -vx + (Math.random() * 0.005 - 0.0025);
	}
	if ((ball_y >= 1.0) || (ball_y <= 0)) {
	    vy = -vy + (Math.random() * 0.005 - 0.0025);
	}
    }
    
    public double get_ball_x() {
	return ball_x;
    }

    public double get_ball_y() {
	return ball_y;
    }

    public double get_paddle_y() {
	return paddle_y;
    }

    public void movePaddle(double y) {
	paddle_y = y;
    }
}
