package stds.mech;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import stds.constants.Constants;
import stds.constants.GameStage;
import stds.gfx.Dialogue;

@SuppressWarnings("serial")
public abstract class Display extends Variables {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(gameStage == GameStage.START_MENU){
			g.drawImage(Dialogue.getStartMenu(), 0,0,null);
		}
		else if(gameStage == GameStage.IN_GAME){
			Graphics2D g2 = (Graphics2D) g;
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					g2.drawImage(ground[0], j* Constants.PANEL_DIMENSION, i * Constants.PANEL_DIMENSION, Constants.PANEL_DIMENSION, Constants.PANEL_DIMENSION, null);
					g2.drawImage(getTerrain(j - 2 + player.getX(), i - 2 + player.getY() ), j* Constants.PANEL_DIMENSION, i * Constants.PANEL_DIMENSION, Constants.PANEL_DIMENSION, Constants.PANEL_DIMENSION, null);
				}
			}
			g2.drawImage(hero, (Constants.APPLET_WIDTH - Constants.PANEL_DIMENSION) / 2, (Constants.APPLET_WIDTH - Constants.PANEL_DIMENSION) / 2, Constants.PANEL_DIMENSION, Constants.PANEL_DIMENSION, null);
			dialogue();
			g2.drawImage(Dialogue.get(dialogue), 0, Constants.APPLET_WIDTH, null);
			g2.dispose();
		}
		else{
			g.drawImage(Dialogue.getWinScreen(),0,0,null);
		}
	}
	
	private Image getTerrain(int x, int y){
		try{
			return ground[terrain[x][y]];
		}
		catch(ArrayIndexOutOfBoundsException e){
			//e.printStackTrace();
		}
		return ground[1];
	}
	
	protected void dialogue(){
		if(customDialogue){
			dialogueTimeout--;
			if(dialogueTimeout < 0){
				dialogue = Dialogue.GENERAL;
				customDialogue = false;
			}
		}
	}
}