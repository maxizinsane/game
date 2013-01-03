package game;

/** 
 **cette classe est le point d'entrée du jeu ! 
 */  
import org.newdawn.slick.AppGameContainer;  
import org.newdawn.slick.GameContainer;  
import org.newdawn.slick.SlickException;  
import org.newdawn.slick.state.StateBasedGame;  
import State.TestJeu;

public class Game extends StateBasedGame  {

	private TestJeu testJeu; // le premier état du jeu (voir Menu.java)  
	private AppGameContainer container; // le conteneur du jeu  
	public Game() {super("Xenobongo");} // le constructeur de la classe  
	@Override  
	public void initStatesList(GameContainer container) throws SlickException   
	{  
		if (container instanceof AppGameContainer) {  
			this.container = (AppGameContainer) container;// on stocke le conteneur du jeu !  
		}  
		testJeu = new TestJeu();//le jeu en lui même !!  
		container.setShowFPS(true);//on ne veut pas voir le FPS ?? mettre alors "false" !  
		addState(testJeu);    //on ajoute le GameState au conteneur !  
		
	}  
	public static void main(String[] args)   
	{  
		try  
		{  
			AppGameContainer container = new AppGameContainer(new Game());  
			container.setDisplayMode(1280, 1000, false);// fenêtre de 1280*768 fullscreen =false !!  
			container.setTargetFrameRate(60);// on règle le FrameRate  
			container.start();//on démarre le container  
		}                         
		catch (SlickException e) {e.printStackTrace();}  // l'exception de base de slick !!  
	}  
}  // fin de classe  