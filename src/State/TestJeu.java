package State;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

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

public class TestJeu extends BasicGameState {

	public static final int ID = 0; // l'identifiant de l'Ã©tat
	private Image FondEcran;
	private Image joueur;// le joueur
	public int x = 0;// les coordonnées initiales du message
	public int y = 300;
	public int xJoueur = 200;
	public int yJoueur = 200;
	private Input input; /** Instance du gestionnaire Input */
	private String message="";


	public TestJeu() {
		super();
	}

	public void init(GameContainer gc, StateBasedGame sgb) throws SlickException {
		FondEcran = new Image("C:\\Data\\Game\\game-menu3.jpg");
		joueur = new Image("C:\\Data\\Game\\pics\\astro1.png");

		// On rÃ©cupÃ¨re l'instance du gestionnaire d'entrÃ©es
		input = gc.getInput();
		input.enableKeyRepeat(300,200);
	}

	public void render(GameContainer gc, StateBasedGame sgb, Graphics g) throws SlickException {

		g.setColor(Color.blue);
		FondEcran.draw();
		joueur.draw(xJoueur,yJoueur);
		g.drawString(message, x , y );

	}

	public void update(GameContainer gc, StateBasedGame sgb, int delta) throws SlickException {
		// Defilement du message
		if (x<800 && y< 600) {
			x = x + 1;
			//y = y +10;
		}
		else
		{
			x=0;
			//y=0;
		}

		//Deplacement perso
		if ( input.isKeyPressed(Input.KEY_UP))
		{
			yJoueur -= 10; // on enlÃ¨ve 10 pixels, Ã  chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}
		if ( input.isKeyPressed(Input.KEY_DOWN))
		{
			yJoueur += 10; // on enlÃ¨ve 10 pixels, Ã  chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}
		if ( input.isKeyPressed(Input.KEY_LEFT))
		{
			xJoueur -= 10; // on enlÃ¨ve 10 pixels, Ã  chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}
		if ( input.isKeyPressed(Input.KEY_RIGHT))
		{
			xJoueur += 10; // on enlÃ¨ve 10 pixels, Ã  chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}

		//exit correct
		if ( input.isKeyPressed(Input.KEY_ESCAPE))
		{
			System.exit(0); //on sort proprement du jeu
		}

		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
		{
			if (gc.getInput().getAbsoluteMouseX()> 300) {
				message ="bouton gauche pressÃ©";
			}
			
		}
		else if(input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON))
		{
			message ="bouton droit press�";
		}
	}

	public int getID(){
		return ID;
	}
}
