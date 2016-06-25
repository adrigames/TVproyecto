package mapa;

import logica.GestorColisiones;
import objetos.Puerta;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import personajes.Heroe;

public class PuebloInicio extends Mapa {
    private Heroe heroe;
    private Puerta salidaPueblo;
    private GestorColisiones gestor;
    
    
    public PuebloInicio() throws SlickException {
        mapa = new TiledMap("testdata/mapasJuego/Pueblo inicio.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
    
}
