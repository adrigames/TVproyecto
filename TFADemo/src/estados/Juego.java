package estados;

/**
 * CLASE JUEGO DE PRUEBA PARA QUE FUNCIONEN LOS MENÚS
 * EN CUANTO ESTÉ EL JUEGO CASI TERMINADO, SE MODIFICA EN FUNCIÓN A LO QUE TENEMOS
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import personajes.*;

public class Juego extends BasicGameState{
    
    private Image sprite;
    private Heroe prota;

    @Override
    public int getID() {
        return 2;
    }

    /**
     * Inicializa 
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
        sprite = new Image("testdata/ImagenMenu.png");
        
    }

    /**
     * Dibuja
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
                
        this.prota.dibujar(g);
        
    }

    /**
     * Actualiza
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //this.prota.update(/*delta*/);
        
        Input entrada = container.getInput();
        if (entrada.isKeyPressed(Input.KEY_P)) {
            game.enterState(4);     //Al menú de pausa
        }
        if(entrada.isKeyPressed(Input.KEY_ESCAPE)){
            game.enterState(6);     //Al menú de final de partida
        }
        
    }
    
}
