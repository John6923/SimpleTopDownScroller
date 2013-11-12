package stds.gfx;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import stds.Game;

public class GFX {
	
	public static Image getImage(String src){
		return (new ImageIcon(Game.class.getResource(src))).getImage();
	}
	
	public static Image getImage(Image img, Image base, int i){
		BufferedImage toWriteTo = new BufferedImage(20,20,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = (Graphics2D) toWriteTo.getGraphics();
		g.drawImage(base, 0, 0, null);
		g.drawImage(img, 0, 0, 20, 20, (i%2) * 20, (i/2) * 20, ((i%2) * 20) + 20, ((i/2) * 20) + 20, null);
		g.dispose();
		return toWriteTo;
	}
	
	public static Image reverseImage(Image img){
		BufferedImage toWriteTo = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = (Graphics2D) toWriteTo.getGraphics();
		for(int i = 0; i < img.getWidth(null); i++)	{
			g.drawImage(img, i, 0, i+1, img.getHeight(null), img.getWidth(null) - 1 - i, 0, img.getWidth(null) - i, img.getHeight(null), null);
		}
		return toWriteTo;
	}
	
}
