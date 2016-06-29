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
    private Mapa camino;
    private Mapa castilloPrincipe1;
    private Mapa castilloPrincipe2;
    private Mapa castilloReal1;
    private Mapa castilloReal2;
    private Mapa ciudad;
    private Mapa habitacionPrincipe;
    private Mapa habitacionRey;
    private Mapa pasilloFinal;
    private Mapa puebloInicio;
    private Heroe prota;
    private String mapaActual;
    private Sound musicaFondo;
    

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
        puebloInicio = new PuebloInicio();
        camino = new Camino();
        mapa = puebloInicio;
        mapaActual = "puebloInicio";
        prota = new Heroe(container, gestor);
        camara = new Camara(container, mapa.getMapa(), prota);
        musicaFondo = new Sound ("testdata/musicaPueblo.ogg");
    }

    /**
     * Dibuja
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        mapa.getMapa().render(-32,-10);
        g.translate(camara.getCamX(),camara.getCamY());
        prota.getJugador().draw(prota.getJugadorX(),prota.getJugadorY());
        musicaFondo.loop();
        
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
        if(entrada.isKeyPressed(Input.KEY_B)){
            //prota.cambiarMapa(); //Prueba
            cambioMapa();
        }
        if(entrada.isKeyPressed(Input.KEY_F) && prota.getCambioDeMapa()){
            cambioMapa();
        }
        
    }
    
    public void cambioMapa() throws SlickException{
        switch(mapaActual){
            case "puebloInicio":
                mapa = camino;
                mapaActual = "camino";
                prota.cambiarMapa(mapaActual);
                break;
            case "camino":
                mapa = castilloPrincipe1;
                mapaActual = "castilloPrincipe1";
                break;
            case "habitacionPrincipe":
                mapa = ciudad;
                mapaActual = "ciudad";
                break;
            case "castilloPrincipe1":
                mapa = castilloPrincipe2;
                mapaActual = "castilloPrincipe2";
                break;
            case "castilloPrincipe2":
                mapa = habitacionPrincipe;
                mapaActual = "habitacionPrincipe";
                break;
            /*case "habitacionPrincipe":
                mapa = camino;
                mapaActual = "camino";
                break;
            */
            case "ciudad":
                mapa = castilloReal1;
                mapaActual = "castilloReal1";
                break;
            case "castilloReal1":
                mapa = castilloReal2;
                mapaActual = "castilloReal2";
                break;
            case "castilloReal2":
                mapa = pasilloFinal;
                mapaActual = "pasillo";
                break;
            case "pasillo":
                mapa = habitacionRey;
                mapaActual = "habitacionRey";
                break;
        }
    }
    
}
