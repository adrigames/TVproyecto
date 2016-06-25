package mapa;

import logica.*;
import org.newdawn.slick.*;
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
