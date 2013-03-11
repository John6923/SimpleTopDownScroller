package stds;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import stds.constants.Constants;
import stds.constants.GameStage;
import stds.mech.Init;

@SuppressWarnings("serial")
public class Game extends Init{
	
	public Game(){
		init();
	}
	
	public void start(){
		if(gameStage == GameStage.START_MENU){
			Timer t = new Timer(Constants.TIMER * Constants.DIALOGUE_TIMEOUT, new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					gameStage = GameStage.IN_GAME;
				}
			});
			t.setRepeats(false);
			t.start();
		}
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}

	public void actionPerformed(ActionEvent arg0) {
		event();
		repaint();
	}
	
	private void event(){
		handleKeyPress();
		checkUnlock();
	}
	
}
