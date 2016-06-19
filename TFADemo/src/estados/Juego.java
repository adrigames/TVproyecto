package estados;

/**
 * CLASE JUEGO DE PRUEBA PARA QUE FUNCIONEN LOS MENÚS
 * EN CUANTO ESTÉ EL JUEGO CASI TERMINADO, SE MODIFICA EN FUNCIÓN A LO QUE TENEMOS
 */

import logica.Camara;
import logica.GestorColisiones;
import mapa.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import personajes.*;

public class Juego extends BasicGameState{
    private GameContainer container;
    private StateBasedGame game;
    private GestorColisiones gestor;
    private Camara camara;
    private Mapa mapa;
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
        this.game = game;
        this.container = container;
        mapa = new PuebloInicio();
        prota = new Heroe(container);
        camara = new Camara(container, mapa.getMapa(), prota);
        
    }

    /**
     * Dibuja
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        mapa.getMapa().render(-32,-17);
        g.translate(camara.getCamX(),camara.getCamY());
        prota.getJugador().draw(prota.getJugadorX(),prota.getJugadorY());
        
        
        
    }

    /**
     * Actualiza
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        prota.movement(delta);
        //camara.moverCamara();
        Input entrada = container.getInput();
        if (entrada.isKeyPressed(Input.KEY_P)) {
            game.enterState(4);     //Al menú de pausa
        }
        if(entrada.isKeyPressed(Input.KEY_ESCAPE)){
            game.enterState(6);     //Al menú de final de partida
        }
        
    }
    
}
