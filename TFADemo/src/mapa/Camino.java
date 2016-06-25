package mapa;

import logica.GestorColisiones;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Camino extends Mapa{
    private GestorColisiones gestor;
    
    public Camino() throws SlickException{
        mapa= new TiledMap("/testdata/mapasJuego/Camino.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
    
}
