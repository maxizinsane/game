package State;

import java.awt.Shape;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;  
import org.newdawn.slick.Graphics;  
import org.newdawn.slick.SlickException;  
import org.newdawn.slick.state.BasicGameState;  
import org.newdawn.slick.state.StateBasedGame;  

public class Menu extends BasicGameState {

	public int x = 0;// les coordonnées initiales du message
    public int y = 0;
    private Image rectangle;
    
	public Menu() {
		super();
	}
	
	public void init(GameContainer gc, StateBasedGame sgb) throws SlickException {
		rectangle = new Image("graphics/interfaces/menu/menu.jpg");
	}
	
	public void render(GameContainer gc, StateBasedGame sgb, Graphics g) throws SlickException {
		
		g.setColor(Color.blue);
		rectangle.draw();g.drawString("mon premier programme en Slick2D", x , 300 );
		g.drawOval(50, 50, 100, 100);
	}
	
	public void update(GameContainer gc, StateBasedGame sgb, int delta) throws SlickException {
		
		if (x<800 && y< 600) {
			x = x + 1;
			//y = y +10;
		}
		else
		{
			x=0;
			//y=0;
		}
	}
	
	public int getID(){
		return 0;
	}
}
