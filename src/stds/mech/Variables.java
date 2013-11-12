package stds.mech;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import stds.Player;
import stds.constants.Constants;
import stds.gfx.Dialogue;
import stds.gfx.GFX;


@SuppressWarnings(value = { "serial" })
public abstract class Variables extends JPanel implements ActionListener {

	protected int[][] terrain = new int[30][30];
	
	protected Timer timer;
	
	protected boolean upArrow = false;
	protected boolean downArrow = false;
	protected boolean leftArrow = false;
	protected boolean rightArrow = false;
	
	protected final Image[] ground = new Image[22];
	protected final Image[] hero = {GFX.getImage(Constants.PLAYER), null, GFX.getImage(Constants.PLAYER_BACK), GFX.getImage(Constants.PLAYER_FRONT)};
	
	protected Player player = new Player();
	
	protected int dialogueTimeout = 0;
	protected int dialogue = Dialogue.GENERAL;
	protected boolean customDialogue = false;
	
	protected int gameStage;

}
