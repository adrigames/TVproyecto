package estados;

/**
 * CLASE JUEGO DE PRUEBA PARA QUE FUNCIONEN LOS MENÚS
 * EN CUANTO ESTÉ EL JUEGO CASI TERMINADO, SE MODIFICA EN FUNCIÓN A LO QUE TENEMOS
 */

import logica.Camara;
import logica.Collidable;
import logica.GestorColisiones;
import mapa.*;
import objetos.Puerta;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import personajes.*;

public class Juego extends BasicGameState{
    private GameContainer container;
    private Collidable colisiones;
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
    private Rey rey;
    private Principe principe;
    private Orco orco;
    private Enemigo enemigo;
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
        gestor = new GestorColisiones();
        puebloInicio = new PuebloInicio(container,game);
        camino = new Camino();
        mapa = puebloInicio;
        mapaActual = "puebloInicio";
        prota = new Heroe(container,game,colisiones, gestor);
        camara = new Camara(container, mapa.getMapa(), prota);
        musicaFondo = new Sound("testdata/musicaPueblo.wav");
    }

    /**
     * Dibuja
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //mapa.getMapa().render(-32,-10);
        //mapa.getMapa().render((int)(prota.getJugadorX()*-1),(int) (prota.getJugadorY()*-1));
        mapa.getMapa().render(0, 0);
        g.translate(camara.getCamX(),camara.getCamY());
        prota.getJugador().draw(prota.getJugadorX(),prota.getJugadorY());
        musicaFondo.loop(1f, 0.50f);
        
    }

    /**
     * Actualiza
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        prota.movement(delta);
        camara.moverCamara();
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
                musicaFondo = new Sound("testdata/musicaPueblo.wav");
                break;
            case "camino":
                mapa = castilloPrincipe1;
                mapaActual = "castilloPrincipe1";
                musicaFondo = new Sound("testdata/musicaPrincipe.wav");
                break;
            case "habitacionPrincipe":
                mapa = ciudad;
                mapaActual = "ciudad";
                musicaFondo = new Sound("testdata/musicaPrincipe.wav");
                break;
            case "castilloPrincipe1":
                mapa = castilloPrincipe2;
                mapaActual = "castilloPrincipe2";
                musicaFondo = new Sound("testdata/musicaCastillo.wav");
                break;
            case "castilloPrincipe2":
                mapa = habitacionPrincipe;
                mapaActual = "habitacionPrincipe";
                musicaFondo = new Sound("testdata/musicaCastillo.wav");
                break;
            /*case "habitacionPrincipe":
                mapa = camino;
                mapaActual = "camino";
                break;
            */
            case "ciudad":
                mapa = castilloReal1;
                mapaActual = "castilloReal1";
                musicaFondo = new Sound("testdata/musicaCastillo.wav");
                break;
            case "castilloReal1":
                mapa = castilloReal2;
                mapaActual = "castilloReal2";
                musicaFondo = new Sound("testdata/musicaCastillo.wav");
                break;
            case "castilloReal2":
                mapa = pasilloFinal;
                mapaActual = "pasillo";
                musicaFondo = new Sound("testdata/musicaCastillo.wav");
                break;
            case "pasillo":
                mapa = habitacionRey;
                mapaActual = "habitacionRey";
                musicaFondo = new Sound("testdata/musicaRey.wav");
                break;
        }
    }
    
}
