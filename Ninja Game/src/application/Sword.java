package application;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Sword extends GameObject {

	private Image[] state;
	private BlockDir blockDirection;

	public Sword() {
		super(new ImageView());
		setX(263);
		setY(347);

		this.state = new Image[2];
		state[0] = new Image("Sword.png", 40, 5, true, false);
		state[1] = new Image("Sword2.png", 40, 5, true, false);
	}
	
	public BlockDir getBlockDir() {
		return blockDirection;
	}


	public void setBlockDir(BlockDir b) {
		blockDirection = b;
	}

	
	public void switchState(){
		switch(blockDirection){
		case left:
			getView().setImage(state[0]);
			getView().setRotate(0);
			setX(263);
			setY(347);
			break;
		case right:
			getView().setImage(state[1]);
			getView().setRotate(0);
			setX(370);
			setY(347);
			break;
		case upLeft:
			getView().setImage(state[0]);
			getView().setRotate(25);
			setX(263);
			setY(322);
			break;
		case upRight:
			getView().setImage(state[1]);
			getView().setRotate(-25);
			setX(369);
			setY(322);
			break;
		case downLeft:
			getView().setImage(state[0]);
			getView().setRotate(-30);
			setX(266);
			setY(355);
			break;
		case downRight:
			getView().setImage(state[1]);
			getView().setRotate(30);
			setX(369);
			setY(355);
			break;
		case up:
			getView().setImage(state[1]);
			getView().setRotate(-25);
			setX(331);
			setY(330);
			break;
		case rest:
			getView().setImage(state[0]);
			getView().setRotate(7);
			setX(267);
			setY(347);
			break;
		}
		
		
	}
	
	
	public void test(GraphicsContext gc){
		Bounds n = getView().getBoundsInParent();
		int x1 = (int) n.getMinX();
		int y1 = (int) n.getMinY();
		int x2 = (int) n.getMaxX();
		int y2 = (int) n.getMaxY();
		double m = (double)((double)(y2 - y1)/(double)(x2-x1));
		double b = y1 - m * x1;
		
		gc.setFill(Color.RED);
		for(double i = x1; i <= x2; i++){
			double j = m * i + b;
			gc.fillOval(i, j, 1, 1);
		}
	}
}



