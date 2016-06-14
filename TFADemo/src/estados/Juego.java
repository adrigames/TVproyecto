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
    
<<<<<<< HEAD
=======
    private Image sprite;
    private Heroe prota;
>>>>>>> origin/master

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
        gestor = new GestorColisiones();
        mapa = new PuebloInicio();
        gestor.blockMap(mapa);
        prota = new Heroe(container);
        camara = new Camara(container, mapa.getMapa(), prota);
        
    }

    /**
     * Dibuja
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
<<<<<<< HEAD
        mapa.getMapa().render(0, 0);
        g.translate(camara.getCamX(),camara.getCamY());
        prota.getJugador().draw(prota.getJugadorX(),prota.getJugadorY());
        
        
=======
                
        this.prota.dibujar(g);
>>>>>>> origin/master
        
    }

    /**
     * Actualiza
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //this.prota.update(/*delta*/);
<<<<<<< HEAD
        prota.movement(delta);
=======
        
>>>>>>> origin/master
        Input entrada = container.getInput();
        if (entrada.isKeyPressed(Input.KEY_P)) {
            game.enterState(4);     //Al menú de pausa
        }
        if(entrada.isKeyPressed(Input.KEY_ESCAPE)){
            game.enterState(6);     //Al menú de final de partida
        }
        
    }
    
}
