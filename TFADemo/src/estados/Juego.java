package estados;

/**
 * CLASE JUEGO DE PRUEBA PARA QUE FUNCIONEN LOS MENÚS
 * EN CUANTO ESTÉ EL JUEGO CASI TERMINADO, SE MODIFICA EN FUNCIÓN A LO QUE TENEMOS
 */

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Juego extends BasicGameState{
    
    private Image sprite;

    @Override
    public int getID() {
        return 2;
    }

    /**
     * Inicializa 
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
        sprite = new Image("res/MHU.png");
        
    }

    /**
     * Dibuja
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        
        g.drawString("Hola, Slick", 100, 200);
        g.drawLine(50, 60, 100, 90);
        g.fillRect(250, 100, 100, 20);
        g.fillOval(60, 90, 100, 100);
        
        sprite.draw(300, 250);
        
    }

    /**
     * Actualiza 
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
}
