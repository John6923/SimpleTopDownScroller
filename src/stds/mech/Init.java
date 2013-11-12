package stds.mech;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.Timer;

import stds.constants.Constants;
import stds.gfx.GFX;

@SuppressWarnings("serial")
public abstract class Init extends Collision {
	protected void init(){
		addKeyListener(new KeyHandler());
		setMinimumSize(new Dimension(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT));
		setPreferredSize(new Dimension(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT));
		setMaximumSize(new Dimension(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setFocusable(true);
		timer = new Timer(Constants.TIMER, this);
		initArray();
		initPictures();
		gameStage = 0;
	}
	
	private void initArray(){
		Scanner reader = new Scanner(this.getClass().getResourceAsStream("res/terrain.txt"));
		for(int i = 0; i < 30; i++){
			for(int j = 0; j < 30; j++){
				terrain[j][i] = reader.nextInt();
			}
		}
		reader.close();
	}
	
	private void initPictures(){
		hero[1] = GFX.reverseImage(hero[0]);
		ground[0] = GFX.getImage(Constants.IMAGE_NAMES[0]);
		ground[1] = GFX.getImage(Constants.IMAGE_NAMES[1]);
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 4; j++){
				ground[i*4 + j + 2] = GFX.getImage(GFX.getImage(Constants.IMAGE_NAMES[i*4 + j + 2]), ground[0], j);
			}
		}
	}

}
