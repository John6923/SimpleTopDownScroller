package stds;

import stds.constants.Constants;

public class Player {

	private double y = Constants.PLAYER_Y;
	private double x = Constants.PLAYER_X;
	private boolean sword = false;
	private boolean key = false;
	private int direction = Constants.LEFT;
	
	public int getX(){
		return (int)x;
	}
	
	public int getY(){
		return (int)y;
	}
	
	public void addX(int i){
		x += i;
	}
	
	public void addY(int i){
		y += i;
	}
	
	public boolean hasKey(){
		return key;
	}
	
	public boolean hasSword(){
		return sword;
	}
	
	public void getSword(){
		sword = true;
	}
	
	public void getKey(){
		key = true;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
