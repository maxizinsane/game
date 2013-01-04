package State;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class IsometricPlay extends BasicGameState {
	
	public static final int ID = 1;
	int stateID = -1;
	private Image FondEcran;

	public IsometricPlay(int id) {
		 this.stateID = id;
	}
	
	public void init(GameContainer gc, StateBasedGame sgb) throws SlickException {
		FondEcran = new Image("graphics/interfaces/menu/menu.jpg");
	}
	
	public void render(GameContainer gc, StateBasedGame sgb, Graphics g) throws SlickException {
		FondEcran.draw();
		g.drawString("testttt", 200, 200);
	}
	
	public void update(GameContainer gc, StateBasedGame sgb, int delta) throws SlickException {
		
	}
	
	public int getID(){
		return ID;
	}
}
