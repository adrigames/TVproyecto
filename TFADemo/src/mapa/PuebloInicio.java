package mapa;

import logica.Collidable;
import logica.GestorColisiones;
import objetos.Puerta;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import personajes.Enemigo;
import personajes.Heroe;
import personajes.Orco;
import personajes.Principe;
import personajes.Rey;

public class PuebloInicio extends Mapa {
    private Heroe heroe;
    private Collidable colisiones;
    private Rey rey;
    private Principe principe;
    private Orco orco;
    private Enemigo enemigo;
    private Puerta salidaPueblo;
    private GestorColisiones gestor;
    
    public PuebloInicio(GameContainer container, StateBasedGame game) throws SlickException {
        
        gestor = new GestorColisiones();
        mapa = new TiledMap("testdata/mapasJuego/Pueblo inicio.tmx");
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        //heroe = new Heroe(container, game,colisiones, gestor);
        principe = new Principe(container,colisiones, gestor);
        rey = new Rey(container,colisiones, gestor);
        orco = new Orco(container,colisiones, gestor);
        enemigo = new Enemigo(container,colisiones, gestor);
        //salidaPueblo = new Puerta(385, 31, gestor);
        setBlocked(mapa);
    }
    
    
    
}
