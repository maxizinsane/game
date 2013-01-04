package State;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

import java.awt.Shape;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;  
import org.newdawn.slick.Graphics;  
import org.newdawn.slick.SlickException;  
import org.newdawn.slick.state.BasicGameState;  
import org.newdawn.slick.state.StateBasedGame;  

/*les classes GUI de slick2D*/
import org.newdawn.slick.gui.AbstractComponent;
//import org.newdawn.slick.gui.BasicComponent; //deprecated
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class Menu extends BasicGameState implements ComponentListener {

	public static final int ID = 0; // l'identifiant de l'état
	
	private StateBasedGame sgb;
	private GameContainer gc;
	
	private Image FondEcran;
	private Image joueur;// le joueur
	public int x = 0;// les coordonnées initiales du message
	public int y = 300;
	public int xJoueur = 200;
	public int yJoueur = 200;
	private Input input; /** Instance du gestionnaire Input */
	private String message="";

	//boutton
	private MouseOverArea quit;
	private MouseOverArea play;

	//test font
	private String fontPath ;  
	private UnicodeFont uFont; 

	public Menu() {
		super();
	}

	public void init(GameContainer gc, StateBasedGame sgb) throws SlickException {
		FondEcran = new Image("graphics/interfaces/menu/menu.jpg");
		joueur = new Image("graphics/interfaces/menu/astro1.png");

		// On récupère l'instance du gestionnaire d'entrées
		input = gc.getInput();
		input.enableKeyRepeat(300,200);
		fontPath = "/graphics/font/Mecha.ttf";  
		uFont = new UnicodeFont(fontPath , 40, false, false);  
		uFont.addAsciiGlyphs();  
		uFont.addGlyphs(400, 600);  
		uFont.getEffects().add(new ColorEffect(java.awt.Color.BLUE));   
		uFont.loadGlyphs();  

		quit = new MouseOverArea(gc,new Image("graphics/interfaces/menu/quit3.png"), 350, 620,this);
		quit.setNormalColor(new Color(0.7f,0.7f,0.7f,1f));
		quit.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));

		play = new MouseOverArea(gc,new Image("graphics/interfaces/menu/play3.png"), 350, 430, this);
		play.setNormalColor(new Color(0.7f,0.7f,0.7f,1f));
		play.setMouseOverColor(new Color(0.9f,0.9f,0.9f,1f));
	}

	public void render(GameContainer gc, StateBasedGame sgb, Graphics g) throws SlickException {

		g.setColor(Color.blue);
		FondEcran.draw();
		joueur.draw(xJoueur,yJoueur);
		uFont.drawString( x , y, message );

		quit.render(gc, g);
		play.render(gc, g);

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

		//Deplacement personnage
		if ( input.isKeyPressed(Input.KEY_UP)) {
			yJoueur -= 5; // on enlève 10 pixels, À chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}
		if ( input.isKeyPressed(Input.KEY_DOWN)) {
			yJoueur += 5; // on enlève 10 pixels, À chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}
		if ( input.isKeyPressed(Input.KEY_LEFT)) {
			xJoueur -= 5; // on enlève 10 pixels, À chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}
		if ( input.isKeyPressed(Input.KEY_RIGHT)) {
			xJoueur += 5; // on enlève 10 pixels, À chaque pression, sur sa position, selon l'axe des y pour le faire monter
		}

		//exit correct
		if ( input.isKeyPressed(Input.KEY_ESCAPE))
		{
			System.exit(0); //on sort proprement du jeu
		}

		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
		{
			if (gc.getInput().getAbsoluteMouseX()> 300) {
				message ="bouton gauche pressé";
			}

		}
		else if(input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON))
		{
			message ="bouton droit pressé";
		}
	}

	public int getID(){
		return ID;
	}

	@Override
	public void componentActivated(AbstractComponent source) {

		if (source == quit) {

			this.gc.exit();

		}
		if (source == play) {

			sgb.enterState(0);

		}
	}
}
