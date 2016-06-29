package mapa;

import logica.GestorColisiones;
import objetos.Puerta;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import personajes.Heroe;

public class PuebloInicio extends Mapa {
    private Heroe heroe;
    private Puerta salidaPueblo;
    private GestorColisiones gestor;
    
    public PuebloInicio(GameContainer container, StateBasedGame game) throws SlickException {
        
        gestor = new GestorColisiones();
        mapa = new TiledMap("testdata/mapasJuego/Pueblo inicio.tmx");
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        //heroe = new Heroe(container, game,colisiones, gestor);
        salidaPueblo = new Puerta(385, 31, gestor);
        setBlocked(mapa);
    }
    
    
    
}
