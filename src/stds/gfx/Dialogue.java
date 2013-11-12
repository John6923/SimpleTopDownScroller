package stds.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import stds.constants.Constants;

public abstract class Dialogue {
	
	private static final Color BACKGROUND_COLOR = new Color(255,127,39);
	private static final Color TEXT_COLOR = new Color(0,0,0);
	
	private static final String[] DRAGON_TEXT = {"You need a SWORD to kill the dragon and rescue" , "the PRINCESS!" , "There is a SWORD behind the DOOR"};
	private static final String[] DRAGON_SLAIN_TEXT = {"You have slain the Dragon, go talk to the PRINCESS!"};
	private static final String[] DOOR_TEXT = {"There is a SWORD hidden behind this DOOR", "you need a KEY to unlock me"};
	private static final String[] DOOR_OPENED_TEXT = {"You have opened the door, go get the SWORD!"};
	private static final String[] PRINCESS_TEXT = {"Thank you for rescuing me!"};
	private static final String[] KEY_TEXT = {"You have gotten the KEY.", "You can now go through the DOOR"};
	private static final String[] SWORD_TEXT = {"You have gotten the SWORD", "you can now kill the DRAGON and rescue the PRINCESS"};
	private static final String[] GENERAL_TEXT = {"You need to rescue the PRINCESS!"};
	private static final String[][] TEXT = {GENERAL_TEXT, KEY_TEXT, DOOR_TEXT, SWORD_TEXT, DRAGON_TEXT, PRINCESS_TEXT, DRAGON_SLAIN_TEXT, DOOR_OPENED_TEXT};
	
	private static final Font FONT = new Font("Helvetica", Font.PLAIN, 18);
	private static final int FONT_HEIGHT = 20;
	private static final int FONT_X_OFFSET = 5;
	private static final int FONT_Y_OFFSET = 20;
	
	private static BufferedImage[] dialogues = {
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR),
		new BufferedImage(Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR)
		};
	
	private static BufferedImage winScreen = new BufferedImage(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
	private static final Color WIN_SCREEN_BACKGROUND_COLOR = new Color(255,127,0);
	private static final Color WIN_SCREEN_TEXT_COLOR = new Color(0,0,0);
	private static final Font WIN_SCREEN_TITLE_FONT = new Font("Helvetica", Font.BOLD, 72);
	private static final String WIN_SCREEN_TITLE = "YOU WIN!";
	private static final Font WIN_SCREEN_SUBTITLE_FONT = new Font("Helvetica", Font.BOLD, 32);
	private static final String WIN_SCREEN_SUBTITLE = "You have completed the game";
	private static final Font WIN_SCREEN_BODY_FONT = new Font("Helvetica", Font.PLAIN, 16);
	private static final String WIN_SCREEN_BODY = "The princess is saved, the dragon slain, what will you do next?";
	private static final int WIN_SCREEN_TITLE_Y_OFFSET = 55;
	private static final int WIN_SCREEN_SUBTITLE_Y_OFFSET = 100;
	private static final int WIN_SCREEN_BODY_Y_OFFSET = 150;
	
	private static BufferedImage startMenu = new BufferedImage(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
	private static final Color START_MENU_BACKGROUND_COLOR = new Color(0,200,100);
	private static final Color START_MENU_TEXT_COLOR = new Color(0,0,0);
	private static final Font START_MENU_TITLE_FONT = new Font("Helvetica", Font.BOLD, 72);
	private static final String START_MENU_TITLE = "Maze Game!";
	private static final Font START_MENU_SUBTITLE_FONT = new Font("Helvetica", Font.BOLD, 32);
	private static final String START_MENU_SUBTITLE = "Rescue the Princess";
	private static final Font START_MENU_BODY_FONT = new Font("Helvetica", Font.PLAIN, 16);
	private static final String START_MENU_BODY = "The princess has been captured by an evil dragon";
	private static final String START_MENU_BODY_TWO = "Slay it and be rewarded graciously";
	private static final int START_MENU_TITLE_Y_OFFSET = 55;
	private static final int START_MENU_SUBTITLE_Y_OFFSET = 100;
	private static final int START_MENU_BODY_Y_OFFSET = 150;
	private static final int START_MENU_BODY_TWO_Y_OFFSET = 180;
	
	public static final int GENERAL = 0;
	public static final int KEY = 1;
	public static final int DOOR = 2;
	public static final int SWORD = 3;
	public static final int DRAGON = 4;
	public static final int PRINCESS = 5;
	public static final int DRAGON_SLAIN = 6;
	public static final int DOOR_OPENED = 7;
	static {
		for(int i = 0; i < TEXT.length; i++){
			try{
				drawText(dialogues[i], TEXT[i]);
			}
			catch(NullPointerException e){
				System.out.println(e.getMessage());
			}
		}
		//Win Screen
		Graphics2D g = (Graphics2D) winScreen.getGraphics();
		g.setColor(WIN_SCREEN_BACKGROUND_COLOR);
		g.fillRect(0, 0, Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT);
		g.setColor(WIN_SCREEN_TEXT_COLOR);
		g.setFont(WIN_SCREEN_TITLE_FONT);
		g.drawString(WIN_SCREEN_TITLE, FONT_X_OFFSET, WIN_SCREEN_TITLE_Y_OFFSET);
		g.setFont(WIN_SCREEN_SUBTITLE_FONT);
		g.drawString(WIN_SCREEN_SUBTITLE, FONT_X_OFFSET, WIN_SCREEN_SUBTITLE_Y_OFFSET);
		g.setFont(WIN_SCREEN_BODY_FONT);
		g.drawString(WIN_SCREEN_BODY, FONT_X_OFFSET, WIN_SCREEN_BODY_Y_OFFSET);
		//Start Menu
		g = null;
		g = (Graphics2D) startMenu.getGraphics();
		g.setColor(START_MENU_BACKGROUND_COLOR);
		g.fillRect(0, 0, Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT);
		g.setColor(START_MENU_TEXT_COLOR);
		g.setFont(START_MENU_TITLE_FONT);
		g.drawString(START_MENU_TITLE, FONT_X_OFFSET, START_MENU_TITLE_Y_OFFSET);
		g.setFont(START_MENU_SUBTITLE_FONT);
		g.drawString(START_MENU_SUBTITLE, FONT_X_OFFSET, START_MENU_SUBTITLE_Y_OFFSET);
		g.setFont(START_MENU_BODY_FONT);
		g.drawString(START_MENU_BODY, FONT_X_OFFSET, START_MENU_BODY_Y_OFFSET);
		g.drawString(START_MENU_BODY_TWO, FONT_X_OFFSET, START_MENU_BODY_TWO_Y_OFFSET);
		
	}
	
	private static void drawText(Image i, String[] text) throws NullPointerException{
		if(i == null) throw new NullPointerException("Image cannot be null");
		if(text == null) throw new NullPointerException("Text cannot be null");
		Graphics2D g = (Graphics2D)i.getGraphics();
		g.setFont(FONT);
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, Constants.APPLET_WIDTH, Constants.DIALOGUE_HEIGHT);
		g.setColor(TEXT_COLOR);
		for(int j = 0; j<text.length ; j++){
			g.drawString(text[j], FONT_X_OFFSET, FONT_HEIGHT * j + FONT_Y_OFFSET);
		}
		g.dispose();
	}
	
	public static BufferedImage get(int what){
		return dialogues[what];
	}
	
	
	public static BufferedImage getWinScreen(){
		return winScreen;
	}
	
	public static BufferedImage getStartMenu(){
		return startMenu;
	}

}
