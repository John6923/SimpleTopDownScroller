package stds.mech;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public abstract class Input extends Display{
	
	protected class KeyHandler extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent arg0) {
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_UP:
				upArrow = true;
				break;
			case KeyEvent.VK_DOWN:
				downArrow = true;
				break;
			case KeyEvent.VK_LEFT:
				leftArrow = true;
				break;
			case KeyEvent.VK_RIGHT:
				rightArrow = true;
				break;
			}
		}
		
	}

}
