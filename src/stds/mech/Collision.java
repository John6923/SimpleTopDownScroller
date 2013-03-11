package stds.mech;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import stds.constants.Constants;
import stds.constants.GameStage;
import stds.gfx.Dialogue;

@SuppressWarnings("serial")
public abstract class Collision extends Input {
	
	protected void handleKeyPress(){
		int xvel = 0;
		int yvel = 0;
		xvel += rightArrow ? 1 : 0;
		xvel -= leftArrow ? 1 : 0;
		yvel += downArrow ? 1 : 0;
		yvel -= upArrow ? 1 : 0;
		bump(player.getX() + xvel, player.getY() + yvel);
		if(isOpen(player.getX() + xvel, player.getY())){
			player.addX(xvel);
		}
		if(isOpen(player.getX(), player.getY() + yvel)){
			player.addY(yvel);
		}
		rightArrow = leftArrow = downArrow = upArrow = false;
	}
	
	private boolean isOpen(int x, int y){
		int[] goodvals = {0, 2, 3, 4, 5, 10, 11, 12, 13};
		for(int i : goodvals) {
			if(terrain[x][y] == i) {
				return true;
			}
		}
		return false;
	}
	
	private void bump(int x, int y){
		int[][] bumpvals = {new int[] {2,3,4,5}, new int[] {6, 7, 8, 9}, new int[] {10,11,12,13}, new int[] {14,15,16,17}, new int[] {18,19,20,21}};
		for(int i = 0 ; i< bumpvals.length; i++){
			for(int j : bumpvals[i]){
				if(j == terrain[x][y]){
					switch(i){
					case 0:
						bumpKey();
						break;
					case 1:
						bumpDoor();
						break;
					case 2:
						bumpSword();
						break;
					case 3:
						bumpDragon();
						break;
					case 4:
						bumpPrincess();
						break;
					}
				}
			}
		}
	}
	
	private void bumpPrincess() {
		dialogueTimeout = Constants.DIALOGUE_TIMEOUT;
		dialogue = Dialogue.PRINCESS;
		customDialogue = true;
		Timer t = new Timer(Constants.DIALOGUE_TIMEOUT * Constants.TIMER, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				gameStage = GameStage.WIN_SCREEN;
			}
		});
		t.setRepeats(false);
		t.start();
	}

	private void bumpDragon() {
		if(player.hasSword()){
			removeDragon();
		}
		dialogueTimeout = Constants.DIALOGUE_TIMEOUT;
		dialogue = Dialogue.DRAGON;
		customDialogue = true;
		
	}

	private void bumpSword() {
		dialogueTimeout = Constants.DIALOGUE_TIMEOUT;
		dialogue = Dialogue.SWORD;
		customDialogue = true;
	}

	private void bumpDoor() {
		if(player.hasKey()){
			removeDoor();
		}
		dialogueTimeout = Constants.DIALOGUE_TIMEOUT;
		dialogue = Dialogue.DOOR;
		customDialogue = true;
	}

	private void bumpKey() {
		dialogueTimeout = Constants.DIALOGUE_TIMEOUT;
		dialogue = Dialogue.KEY;
		customDialogue = true;
	}

	protected void checkUnlock(){
		checkKey();
		checkSword();
	}
	
	private boolean isOn(int[] goodvals){
		for(int i : goodvals) {
			if(terrain[player.getX()][player.getY()] == i) {
				return true;
			}
		}
		return false;
	}

	private void checkKey() {
		int[] keyvals = {2, 3, 4, 5};
		if(isOn(keyvals)){
			removeKey();
			getKey();
		}
	}
	
	private void checkSword() {
		int[] swordvals = {10,11,12,13};
		if(isOn(swordvals)){
			getSword();
			removeSword();
		}
	}
	
	private void getKey(){
		removeKey();
		player.getKey();
	}

	private void getSword() {
		player.getSword();
	}
	
	private void removeKey() {
		int[] goawayvals = {2,3,4,5};
		remove(goawayvals);
	}

	private void removeSword() {
		int[] goawayvals = {10,11,12,13};
		remove(goawayvals);
	}
	
	private void removeDoor() {
		int[] goawayvals = {6,7,8,9};
		remove(goawayvals);
	}
	
	private void removeDragon() {
		int[] goawayvals = {14,15,16,17};
		remove(goawayvals);
	}
	
	private void remove(int[] goawayvals){
		for(int i = 0; i < terrain.length; i++){
			for(int j = 0; j < terrain[0].length; j++){
				for(int k : goawayvals){
					if(terrain[i][j] == k){
						terrain[i][j] = 0;
					}
				}
			}
		}
	}

}
