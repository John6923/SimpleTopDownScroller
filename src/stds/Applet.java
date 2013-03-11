package stds;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JFrame;

import stds.constants.Constants;

@SuppressWarnings("serial")
public class Applet extends JApplet {
	private Game game;
	
	public void init(){
		setSize(new Dimension(Constants.APPLET_WIDTH, Constants.APPLET_HEIGHT));
		setLayout(new BorderLayout());
		game = new Game();
		add(new Game());
	}
	
	public void start(){
		game.start();
	}
	
	public void stop(){
		game.stop();
	}
	
	
	public static void main(String[] args){
		new Frame();
	}
	
	private static class Frame extends JFrame{
		
		public Frame(){
			Game game = new Game();
			setTitle(Constants.GAME_NAME);
			setLayout(new BorderLayout());
			add(game, BorderLayout.CENTER);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setLocation(0, 0);
			setResizable(false);
			pack();
			setVisible(true);
			game.start();
		}
	}

}
